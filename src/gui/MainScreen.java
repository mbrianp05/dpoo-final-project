package gui;

import gui.event.OnCloseApp;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;

public class MainScreen extends JFrame {
	private static final long serialVersionUID = -5078546845004098026L;

	private JPanel contentPane;
	private MenuPanel menuPanel;

	public MainScreen() {
		setTitle("Administraci\u00F3n de la facultad");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainScreen.class.getResource("/resources/images/app-icon.png")));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getMenuPanel(), "name_209251203888700");
	}
	
	private MenuPanel getMenuPanel() {
		if (menuPanel == null) {
			menuPanel = new MenuPanel();
			menuPanel.listenTo(new OnCloseApp() {
				@Override
				public void actionPerformed() {
					dispose();
				}
			});
		}
		return menuPanel;
	}
}
