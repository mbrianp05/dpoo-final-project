package gui;

import gui.event.OnAuthenticate;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

@SuppressWarnings("serial")
public class MainScreen extends JFrame {
	private JPanel contentPane;
	private AuthenticationPanel authenticationPanel;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{237, 270, 0};
		gbl_contentPane.rowHeights = new int[]{133, 210, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		GridBagConstraints gbc_authenticationPanel = new GridBagConstraints();
		gbc_authenticationPanel.fill = GridBagConstraints.BOTH;
		gbc_authenticationPanel.gridx = 1;
		gbc_authenticationPanel.gridy = 1;
		contentPane.add(getAuthenticationPanel(), gbc_authenticationPanel);
	}
	
	private AuthenticationPanel getAuthenticationPanel() {
		if (authenticationPanel == null) {
			authenticationPanel = new AuthenticationPanel();
			
			authenticationPanel.listenTo(new OnAuthenticate() {
				@Override
				public void exec() {
					authenticationPanel.setVisible(false);
				}
			});
		}
		
		return authenticationPanel;
	}
}
