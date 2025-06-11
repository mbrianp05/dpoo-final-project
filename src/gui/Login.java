package gui;

import gui.event.OnAuthenticate;
import gui.event.OnCloseApp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {
	private static final long serialVersionUID = 3183133678992381435L;
	private JPanel contentPane;
	private AuthenticationPanel authenticationPanel;
	
	public Login() {
		setSize(600, 440);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getAuthenticationPanel());
	}
	
	public void listenTo(OnAuthenticate listener) {
		authenticationPanel.listenTo(listener);
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
}
