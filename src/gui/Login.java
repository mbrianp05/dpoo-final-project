package gui;

import java.awt.Image;

import gui.event.OnAuthenticate;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {
	private static final long serialVersionUID = 3183133678992381435L;
	private JPanel contentPane;
	private AuthenticationPanel authenticationPanel;
	private JLabel lblNewLabel;
	
	/**
	 * Create the frame.
	 */
	public Login() {
		setSize(618, 458);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getAuthenticationPanel());
		contentPane.add(getLblNewLabel());
	}
	
	public void listenTo(OnAuthenticate listener) {
		authenticationPanel.listenTo(listener);
	}
	
	private AuthenticationPanel getAuthenticationPanel() {
		if (authenticationPanel == null) {
			authenticationPanel = new AuthenticationPanel();
			authenticationPanel.setBounds(5, 5, 613, 448);
		}
		
		return authenticationPanel;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			ImageIcon icon = new ImageIcon(AuthenticationPanel.class.getResource("/resources/images/login-background.jpg"));
			icon = new ImageIcon(icon.getImage().getScaledInstance(613, 458, Image.SCALE_SMOOTH));
			
			lblNewLabel.setIcon(icon);
			lblNewLabel.setBounds(0, 0, 618, 458);
		}
		return lblNewLabel;
	}
}
