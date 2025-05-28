package gui;

import gui.views.View;

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
import javax.swing.JPopupMenu;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
			menuBar.setBounds(0, 0, 887, 60);
			menuBar.setBackground(Color.WHITE);
			menuBar.add(getMntmNewMenuItem());
			menuBar.add(getMntmNewMenuItem_1());
			menuBar.add(getMntmNewMenuItem_2());
		}
		return menuBar;
	}
	private JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("Investigadores");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mntmNewMenuItem.setSelected(true);
					mntmNewMenuItem_2.setSelected(false);
					mntmNewMenuItem_1.setSelected(false);
					selectionPanel.switchViews(View.Researchers);
				}
			});			
			mntmNewMenuItem.setBackground(Color.WHITE);
			mntmNewMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		}
		return mntmNewMenuItem;
	}
	private JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("Maestr\u00EDas");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {	
				public void actionPerformed(ActionEvent arg0) {
					mntmNewMenuItem.setSelected(false);
					mntmNewMenuItem_2.setSelected(false);
					mntmNewMenuItem_1.setSelected(true);
					selectionPanel.switchViews(View.Masters);
					
				}
			});
			mntmNewMenuItem_1.setBackground(Color.WHITE);
			mntmNewMenuItem_1.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		}
		return mntmNewMenuItem_1;
	}
	private JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("L\u00EDneas de investigaci\u00F3n");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mntmNewMenuItem_2.setSelected(true);
					mntmNewMenuItem_1.setSelected(false);
					mntmNewMenuItem.setSelected(false);
					selectionPanel.switchViews(View.ResearchLines);
				}
			});
			mntmNewMenuItem_2.setBackground(Color.WHITE);
			mntmNewMenuItem_2.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		}
		return mntmNewMenuItem_2;
	}
}
