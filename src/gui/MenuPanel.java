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

public class MenuPanel extends JPanel {
	private JButton researchers;
	private JButton masteryPlans;
	private JButton researchLines;
	private JButton popularMatters;
	private JButton bestResearchers;
	private JButton bremainingAprovals;
	private SelectionPanel selectionPanel;
	
	private Faculty faculty;
	
	public MenuPanel(Faculty faculty) {
		this.faculty = faculty;

		setBackground(Color.WHITE);
		setLayout(null);
		add(getResearchers());
		add(getMasteryPlans());
		add(getResearchLines());
		add(getPopularMatters());
		add(getBestResearchers());
		add(getBremainingAprovals());
		add(getSelectionPanel());
	}
	private JButton getResearchers() {
		if (researchers == null) {
			researchers = new JButton("Investigadores");
			researchers.setBackground(Color.WHITE);
			researchers.setForeground(Color.DARK_GRAY);
			researchers.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
			researchers.setBounds(12, 13, 210, 30);
		}
		return researchers;
	}
	private JButton getMasteryPlans() {
		if (masteryPlans == null) {
			masteryPlans = new JButton("Maestr\u00EDas");
			masteryPlans.setBackground(Color.WHITE);
			masteryPlans.setForeground(Color.DARK_GRAY);
			masteryPlans.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
			masteryPlans.setBounds(12, 41, 210, 30);
		}
		return masteryPlans;
	}
	private JButton getResearchLines() {
		if (researchLines == null) {
			researchLines = new JButton("L\u00EDneas de investigaci\u00F3n");
			researchLines.setBackground(Color.WHITE);
			researchLines.setForeground(Color.DARK_GRAY);
			researchLines.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
			researchLines.setBounds(12, 69, 210, 30);
		}
		return researchLines;
	}
	private JButton getPopularMatters() {
		if (popularMatters == null) {
			popularMatters = new JButton("Investigaciones populares");
			popularMatters.setBackground(Color.WHITE);
			popularMatters.setForeground(Color.DARK_GRAY);
			popularMatters.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
			popularMatters.setBounds(12, 97, 210, 30);
		}
		return popularMatters;
	}
	private JButton getBestResearchers() {
		if (bestResearchers == null) {
			bestResearchers = new JButton("Mejores investigadores");
			bestResearchers.setBackground(Color.WHITE);
			bestResearchers.setForeground(Color.DARK_GRAY);
			bestResearchers.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
			bestResearchers.setBounds(12, 125, 210, 30);
		}
		return bestResearchers;
	}
	private JButton getBremainingAprovals() {
		if (bremainingAprovals == null) {
			bremainingAprovals = new JButton("Maestr\u00EDas por aprobar");
			bremainingAprovals.setBackground(Color.WHITE);
			bremainingAprovals.setForeground(Color.DARK_GRAY);
			bremainingAprovals.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
			bremainingAprovals.setBounds(12, 153, 210, 30);
		}
		return bremainingAprovals;
	}
	private SelectionPanel getSelectionPanel() {
		if (selectionPanel == null) {
			selectionPanel = new SelectionPanel(faculty);
			selectionPanel.setBounds(234, 0, 832, 614);
		}
		return selectionPanel;
	}
}
