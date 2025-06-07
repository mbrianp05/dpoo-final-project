package gui;

import gui.event.OnAuthenticate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLayeredPane;

import auth.Authentication;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

public class MainScreen extends JFrame {
	private static final long serialVersionUID = -5078546845004098026L;

	private JPanel contentPane;
	
	private JLayeredPane layeredPane;
	private MenuPanel menuPanel;
	private AuthenticationPanel authenticationPanel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainScreen() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("Gestión de datos de la facultad");

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1029, 930);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 900, 0, 0};
		gbl_contentPane.rowHeights = new int[]{730, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		resolveView();
	}
	
	private void resolveView() {
		if (Authentication.hasAccess()) {
			if (authenticationPanel != null)
				authenticationPanel.setVisible(false);
			
			contentPane.setLayout(new BorderLayout(0, 0));
			contentPane.add(getLayeredPane_1());
		} else {
			GridBagConstraints gbc_authenticationPanel = new GridBagConstraints();
			gbc_authenticationPanel.insets = new Insets(200, 200, 200, 200);
			gbc_authenticationPanel.fill = GridBagConstraints.BOTH;
			gbc_authenticationPanel.gridx = 1;
			gbc_authenticationPanel.gridy = 0;
			
			contentPane.add(getAuthenticationPanel(), gbc_authenticationPanel);
		}
	}
	
	private JLayeredPane getLayeredPane_1() {
		if (layeredPane == null) {
			layeredPane = new JLayeredPane();
			layeredPane.setLayout(new BorderLayout(0, 0));
			layeredPane.add(getMenuPanel());
		}
		return layeredPane;
	}
	private MenuPanel getMenuPanel() {
		if (menuPanel == null) {
			menuPanel = new MenuPanel();
		}
		return menuPanel;
	}
	private AuthenticationPanel getAuthenticationPanel() {
		if (authenticationPanel == null) {
			authenticationPanel = new AuthenticationPanel();
			authenticationPanel.listenTo(new OnAuthenticate() {
				@Override
				public void granted() {
					resolveView();
				}
			});
		}
		return authenticationPanel;
	}
}
