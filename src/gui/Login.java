package gui;

import gui.event.OnAuthenticate;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {
	private static final long serialVersionUID = 3183133678992381435L;
	private JPanel contentPane;
	private AuthenticationPanel authenticationPanel;
	
	/**
	 * Create the frame.
	 */
	public Login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(623, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getAuthenticationPanel(), BorderLayout.CENTER);
	}
	
	public void listenTo(OnAuthenticate listener) {
		authenticationPanel.listenTo(listener);
	}
	
	private AuthenticationPanel getAuthenticationPanel() {
		if (authenticationPanel == null) {
			authenticationPanel = new AuthenticationPanel();
		}
		
		return authenticationPanel;
	}
}
