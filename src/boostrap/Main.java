package boostrap;

import gui.Login;
import gui.MainScreen;
import gui.event.OnAuthenticate;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.UIManager;

import utils.Constants;
import utils.Mock;
import auth.Authentication;

public class Main {
	private static void setDefaults() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.put("Button.font", Constants.getLabelFont());
			UIManager.put("MenuItem.font", Constants.getLabelFont().deriveFont(12));
			UIManager.put("Label.font", Constants.getLabelFont());
			UIManager.put("Panel.background", new Color(255, 255, 255));
			UIManager.put("CheckBox.background", new Color(255, 255, 255));
			UIManager.put("RadioButton.background", new Color(255, 255, 255));
			UIManager.put("RadioButton.foreground", new Color(14, 44, 90));
			UIManager.put("ScrollPane.border", BorderFactory.createEmptyBorder());
			UIManager.put("ScrollPanel.border", BorderFactory.createEmptyBorder());
			UIManager.put("Table.gridColor", new Color(50, 50, 50));
			UIManager.put("TableHeader.showGrid", false);
			UIManager.put("TableHeader.border", BorderFactory.createEmptyBorder(0, 0, 0, 0));
			UIManager.put("TableHeader.font", Constants.getLabelFont());
			UIManager.put("OptionPane.background", new Color(255, 255, 255));
			UIManager.put("OptionPane.messageFont", Constants.getLabelFont());
			UIManager.put("TextField.margin", new Insets(0, 6, 0, 6));
			UIManager.put("PasswordField.margin", new Insets(0, 6, 0, 6));
			UIManager.put("TextField.font", Constants.getLabelFont());
			UIManager.put("ComboBox.font", Constants.getLabelFont());
			UIManager.put("ComboBox.font", Constants.getLabelFont());
			UIManager.put("RadioButton.font", Constants.getLabelFont());
			UIManager.put("Table.gridColor", new Color(220, 220, 220));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		setDefaults();

		if (!Authentication.hasAccess() || !Authentication.hasSource()) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						final Login frame = new Login();

						frame.setLocationRelativeTo(null);
						frame.listenTo(new OnAuthenticate() {
							@Override
							public void granted() {
								openMainScreen();

								frame.setVisible(false);
							}
						});
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} else {
			openMainScreen();
		}
	}

	private static void openMainScreen() {
		Mock.mockFacultyData();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen ms = new MainScreen();
					ms.setSize(Toolkit.getDefaultToolkit().getScreenSize());
					ms.setUndecorated(true);
					ms.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
