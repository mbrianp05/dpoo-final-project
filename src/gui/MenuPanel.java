package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JToggleButton;
import javax.swing.JLayeredPane;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;

public class MenuPanel extends JPanel {
	private JButton researchers;
	private JButton masteryPlans;
	private JButton researchLines;
	private JButton popularMatters;
	private JButton bestResearchers;
	private JButton bremainingAprovals;
	
	public MenuPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		add(getResearchers());
		add(getMasteryPlans());
		add(getResearchLines());
		add(getPopularMatters());
		add(getBestResearchers());
		add(getBremainingAprovals());
	}
	private JButton getResearchers() {
		if (researchers == null) {
			researchers = new JButton("Investigadores");
			researchers.setBounds(12, 13, 200, 30);
		}
		return researchers;
	}
	private JButton getMasteryPlans() {
		if (masteryPlans == null) {
			masteryPlans = new JButton("Maestr\u00EDas");
			masteryPlans.setBounds(12, 41, 200, 30);
		}
		return masteryPlans;
	}
	private JButton getResearchLines() {
		if (researchLines == null) {
			researchLines = new JButton("L\u00EDneas de investigaci\u00F3n");
			researchLines.setBounds(12, 69, 200, 30);
		}
		return researchLines;
	}
	private JButton getPopularMatters() {
		if (popularMatters == null) {
			popularMatters = new JButton("Investigaciones populares");
			popularMatters.setBounds(12, 97, 200, 30);
		}
		return popularMatters;
	}
	private JButton getBestResearchers() {
		if (bestResearchers == null) {
			bestResearchers = new JButton("Mejores investigadores");
			bestResearchers.setBounds(12, 125, 200, 30);
		}
		return bestResearchers;
	}
	private JButton getBremainingAprovals() {
		if (bremainingAprovals == null) {
			bremainingAprovals = new JButton("Maestr\u00EDas por aprobar");
			bremainingAprovals.setBounds(12, 153, 200, 30);
		}
		return bremainingAprovals;
	}
}
