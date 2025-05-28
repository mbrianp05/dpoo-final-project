package gui;

import javax.swing.JPanel;

import schooling.Faculty;

import java.awt.Color;

import gui.views.Researchers;
import gui.views.ResearchLinesView;
import gui.views.View;

public class SelectionPanel extends JPanel {
	private Researchers researchers;
	private Faculty faculty;
	private ResearchLinesView researchLinesView;
	
	public SelectionPanel(Faculty faculty) {
		this.faculty = faculty;
		
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		add(getResearchers());
		add(getResearchLinesView());
	}
	
	public void switchViews(View view) {
		researchers.setVisible(false);
		researchLinesView.setVisible(false);
		
		switch (view) {
		case Researchers:
			researchers.setVisible(true);
			break;
		case ResearchLines:
			researchLinesView.setVisible(true);
			break;
		}
	}
	
	private Researchers getResearchers() {
		if (researchers == null) {
			researchers = new Researchers(faculty);
			researchers.setBounds(0, 0, 1066, 739);
		}
		return researchers;
	}
	private ResearchLinesView getResearchLinesView() {
		if (researchLinesView == null) {
			researchLinesView = new ResearchLinesView(faculty);
			researchLinesView.setBounds(0, 0, 973, 739);
		}
		return researchLinesView;
	}
}
