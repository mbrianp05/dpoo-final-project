package gui;

import gui.event.OnAuthenticate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class MainScreen extends JFrame {
	private JPanel contentPane;
	private AuthenticationPanel authenticationPanel;
	private MenuPanel menu;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainScreen() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1043, 455);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getAuthenticationPanel());
		contentPane.add(getMenu());
	}

	private AuthenticationPanel getAuthenticationPanel() {
		if (authenticationPanel == null) {
			authenticationPanel = new AuthenticationPanel();
			authenticationPanel.setBounds(400, 100, 270, 210);
			authenticationPanel.listenTo(new OnAuthenticate() {
				@Override
				public void granted() {
					authenticationPanel.setVisible(false);
					menu.setVisible(true);
				}
			});
		}

		return authenticationPanel;
	}

	private MenuPanel getMenu() {
		if (menu == null) {
			menu = new MenuPanel();
			menu.setBounds(0, 0, 1037, 423);
			menu.setVisible(false);
		}
		return menu;
	}
}
