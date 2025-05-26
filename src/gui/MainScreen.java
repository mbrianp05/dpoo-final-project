package gui;

import gui.event.OnAuthenticate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 591);
		
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
			authenticationPanel.setBounds(242, 138, 270, 210);
			authenticationPanel.listenTo(new OnAuthenticate() {
				@Override
				public void exec() {
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
			menu.setBounds(0, 0, 759, 544);
			menu.setVisible(false);
		}
		return menu;
	}
}
