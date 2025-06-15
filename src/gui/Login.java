package gui;

import gui.event.OnAuthenticate;
import gui.event.OnCloseApp;
import gui.event.OnCodeConfirmed;
import gui.event.OnSetCredentials;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import auth.Authentication;
import javax.swing.BoxLayout;

public class Login extends JFrame {
	private static final long serialVersionUID = 3183133678992381435L;
	private JPanel contentPane;
	private AuthenticationPanel authenticationPanel;
	private SetCredentialsPanel setCredentialsPanel;
	private ConfirmationCodePanel confirmationCodePanel;

	private OnAuthenticate listener;
	
	public Login() {
		setTitle("Login");
		setSize(625, 500);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		if (Authentication.hasSource()) {
			contentPane.add(getAuthenticationPanel());
		} else {
			contentPane.add(getSetCredentialsPanel());
		}
	}

	public void listenTo(OnAuthenticate listener) {
		this.listener = listener;
		
		if (authenticationPanel != null) authenticationPanel.listenTo(listener);
	}

	private AuthenticationPanel getAuthenticationPanel() {
		if (authenticationPanel == null) {
			authenticationPanel = new AuthenticationPanel();
			authenticationPanel.setBounds(5, 5, 613, 448);
			authenticationPanel.listenTo(new OnCloseApp() {
				@Override
				public void actionPerformed() {
					dispose();
				}
			});
		}

		return authenticationPanel;
	}
	private SetCredentialsPanel getSetCredentialsPanel() {
		if (setCredentialsPanel == null) {
			setCredentialsPanel = new SetCredentialsPanel();
			setCredentialsPanel.listenTo(new OnCloseApp() {
				@Override
				public void actionPerformed() {
					dispose();
				}
			});
			setCredentialsPanel.listenTo(new OnSetCredentials() {
				@Override
				public void newCredentials(String username, String password) {
					setCredentialsPanel.setVisible(false);
					contentPane.add(getConfirmationCodePanel(username, password));
				}
			});
			setCredentialsPanel.setBounds(0, 0, 625, 453);
		}
		return setCredentialsPanel;
	}
	private ConfirmationCodePanel getConfirmationCodePanel(final String username, final String password) {
		confirmationCodePanel = new ConfirmationCodePanel(username);
		confirmationCodePanel.listenTo(new OnCodeConfirmed() {
			@Override
			public void confirmed() {
				Authentication.setCredentials(username, password);
				Authentication.authorize(username, password);
				
				if (listener != null) {
					listener.granted();
				}
			}
		});
		confirmationCodePanel.setBounds(0, 0, 625, 459);
		return confirmationCodePanel;
	}
}
