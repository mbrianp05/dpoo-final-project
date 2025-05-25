package gui;

import gui.event.OnAuthenticate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
<<<<<<< HEAD
import java.awt.Color;

public class MainScreen extends JFrame {
	private JPanel contentPane;
	private AuthenticationPanel authenticationPanel;
	private MenuPanel menu;
=======
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

@SuppressWarnings("serial")
public class MainScreen extends JFrame {
	private JPanel contentPane;
	private AuthenticationPanel authenticationPanel;
>>>>>>> 3d780a243ec7a570a128a591a7d51b99a413bfb8

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
<<<<<<< HEAD
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		contentPane.add(getAuthenticationPanel());
		contentPane.add(getMenu());
=======
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 237, 270, 0 };
		gbl_contentPane.rowHeights = new int[] { 133, 210, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		GridBagConstraints gbc_authenticationPanel = new GridBagConstraints();
		gbc_authenticationPanel.fill = GridBagConstraints.BOTH;
		gbc_authenticationPanel.gridx = 1;
		gbc_authenticationPanel.gridy = 1;
		contentPane.add(getAuthenticationPanel(), gbc_authenticationPanel);
>>>>>>> 3d780a243ec7a570a128a591a7d51b99a413bfb8
	}

	private AuthenticationPanel getAuthenticationPanel() {
		if (authenticationPanel == null) {
			authenticationPanel = new AuthenticationPanel();
<<<<<<< HEAD
			authenticationPanel.setBounds(242, 138, 270, 210);
=======
>>>>>>> 3d780a243ec7a570a128a591a7d51b99a413bfb8

			authenticationPanel.listenTo(new OnAuthenticate() {
				@Override
				public void exec() {
					authenticationPanel.setVisible(false);
<<<<<<< HEAD
					menu.setVisible(true);
=======
>>>>>>> 3d780a243ec7a570a128a591a7d51b99a413bfb8
				}
			});
		}

		return authenticationPanel;
	}
<<<<<<< HEAD

	private MenuPanel getMenu() {
		if (menu == null) {
			menu = new MenuPanel();
			menu.setBounds(0, 0, 759, 544);
			menu.setVisible(false);
		}
		return menu;
	}
=======
>>>>>>> 3d780a243ec7a570a128a591a7d51b99a413bfb8
}
