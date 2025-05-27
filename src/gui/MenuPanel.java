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
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	
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
			menuBar.setBounds(0, 0, 1074, 60);
			menuBar.setBackground(Color.WHITE);
			menuBar.add(getMntmNewMenuItem());
			menuBar.add(getMntmNewMenuItem_2());
			menuBar.add(getMntmNewMenuItem_1());
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
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("Maestr\u00EDas");
		}
		return mntmNewMenuItem_1;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("L\u00EDneas de investigaci\u00F3n");
		}
		return mntmNewMenuItem_2;
	}
}
