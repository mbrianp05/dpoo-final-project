package gui;

import gui.event.OnAuthenticate;
import gui.event.OnCloseApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import utils.Constants;
import auth.Authentication;

public class MainScreen extends JFrame {
	private static final long serialVersionUID = -5078546845004098026L;

	private JPanel contentPane;
	
	private JLayeredPane layeredPane;
	private MenuPanel menuPanel;
	private AuthenticationPanel authenticationPanel;

	private static void setDefaults() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//			
//			UIManager.put("Button.background", new Color(50, 50, 50));
//			UIManager.put("Button.foreground", new Color(240, 240, 240));
//			UIManager.put("Button.border", BorderFactory.createLineBorder(new Color(90, 90, 90)));
//			UIManager.put("Button.margin", new Insets(10, 20, 10, 20));
			
			UIManager.put("Panel.background", new Color(255, 255, 255));
			
//			UIManager.put("MenuBar.background", new Color(50, 50, 50));
//			UIManager.put("Menu.background", new Color(50, 50, 50));
//			UIManager.put("MenuItem.foreground", new Color(240, 240, 240));
//			UIManager.put("MenuItem.background", new Color(50, 50, 50));
//			UIManager.put("Menu.foreground",new Color(240, 240, 240));
//			
//			UIManager.put("MenuBar.border", BorderFactory.createEmptyBorder());
//			UIManager.put("PopMenu.border", BorderFactory.createEmptyBorder());
//			UIManager.put("Menu.border", BorderFactory.createEmptyBorder(0, 0, 0, 0));
//			UIManager.put("MenuItem.border", BorderFactory.createEmptyBorder());
//			
//			UIManager.put("MenuItem.margin", new Insets(10, 10, 10, 10));
//			
			UIManager.put("CheckBox.background", new Color(255, 255, 255));
			UIManager.put("RadioButton.background", new Color(255, 255, 255));
//
//			UIManager.put("Label.foreground", new Color(240, 240, 240));
//			
//			UIManager.put("TextField.border", BorderFactory.createLineBorder(new Color(90, 90, 90)));
//			UIManager.put("TextField.caretForeground", new Color(240, 240, 240));
//			UIManager.put("TextField.background", new Color(70, 70, 70));
//			UIManager.put("TextField.foreground", new Color(240, 240, 240));
//			
//			UIManager.put("TextArea.background", new Color(70, 70, 70));
//			UIManager.put("TextArea.foreground", new Color(240, 240, 240));
//			UIManager.put("TextArea.border", BorderFactory.createLineBorder(new Color(90, 90, 90)));
//
			UIManager.put("ScrollPane.border", BorderFactory.createEmptyBorder());
//
//			UIManager.put("Table.background", new Color(50, 50, 50));
			UIManager.put("Table.gridColor", new Color(50, 50, 50));
			UIManager.put("TableHeader.showGrid", false);
			UIManager.put("TableHeader.border", BorderFactory.createEmptyBorder(0, 0, 0, 0));
//			UIManager.put("Table.foreground", new Color(240, 240, 240));
//			
			UIManager.put("TableHeader.font", Constants.getLabelFont());
//			UIManager.put("TableHeader.background", new Color(50, 50, 50));
//			UIManager.put("TableHeader.foreground", new Color(240, 240, 240));
//
//			UIManager.put("ComboBox.background",  new Color(70, 70, 70));
//			UIManager.put("ComboBox.foreground", new Color(240, 240, 240));
//			
//			UIManager.put("Spinner.background", new Color(90, 90, 90));
//			UIManager.put("Spinner.foreground", new Color(240, 240, 240));
//
			UIManager.put("OptionPane.background", new Color(255, 255, 255));
			UIManager.put("OptionPane.messageFont", Constants.getLabelFont());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				setDefaults();
				
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
			menuPanel.listenTo(new OnCloseApp() {
				@Override
				public void actionPerformed() {
					setVisible(false);
				}
			});
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
