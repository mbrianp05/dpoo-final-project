package gui;

import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import schooling.Faculty;

import java.awt.Color;

import gui.views.Masters;
import gui.views.Researchers;
import gui.views.ResearchLinesView;
import gui.views.View;

public class SelectionPanel extends JPanel {
	private Researchers researchers;
	private Faculty faculty;
	private ResearchLinesView researchLinesView;
	private Masters masters;
	
	public SelectionPanel(Faculty faculty) {
		this.faculty = faculty;
		
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		add(getResearchers());
		add(getMasters());
		add(getResearchLinesView());
	}
	
	public void switchViews(View view) {
		researchers.setVisible(false);
		masters.setVisible(false);
		researchLinesView.setVisible(false);
		
		switch (view) {
		case Researchers:
			researchers.setVisible(true);
			break;
		case Masters:
			masters.setVisible(true);
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
	
	private Masters getMasters(){
		if (masters == null) {
			masters = new Masters(faculty);
			masters.setBounds(0, 0, 1019, 739);
		}
		
		return masters;
	}
	
	private ResearchLinesView getResearchLinesView() {
		if (researchLinesView == null) {
			researchLinesView = new ResearchLinesView(faculty);
			researchLinesView.setBounds(0, 0, 973, 739);
		}
		return researchLinesView;
	}
}
