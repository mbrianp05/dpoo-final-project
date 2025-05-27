package gui;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JLayeredPane;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;

import schooling.Faculty;

import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPanel extends JPanel {
	private SelectionPanel selectionPanel;
	
	private Faculty faculty;
	private JMenuBar menuBar;
	private JMenuItem mntmNewMenuItem;
	
	public MenuPanel(Faculty faculty) {
		this.faculty = faculty;

		setBackground(Color.WHITE);
		setLayout(null);
		add(getSelectionPanel());
		add(getMenuBar());
	}
	private SelectionPanel getSelectionPanel() {
		if (selectionPanel == null) {
			selectionPanel = new SelectionPanel(faculty);
			selectionPanel.setBounds(0, 60, 1074, 770);
		}
		return selectionPanel;
	}
	private JMenuBar getMenuBar() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBackground(Color.WHITE);
			menuBar.setBounds(0, 0, 1066, 60);
			menuBar.add(getMntmNewMenuItem());
		}
		return menuBar;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("Investigadores");
			mntmNewMenuItem.setBackground(Color.WHITE);
			mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		}
		return mntmNewMenuItem;
	}
}
