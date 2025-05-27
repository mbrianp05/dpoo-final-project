package gui;

import javax.swing.JPanel;

import schooling.Faculty;

import java.awt.Color;

import gui.views.Researchers;

public class SelectionPanel extends JPanel {
	private Researchers researchers;
	private Faculty faculty;
	
	public SelectionPanel(Faculty faculty) {
		this.faculty = faculty;
		
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		add(getResearchers());
	}
	
	private Researchers getResearchers() {
		if (researchers == null) {
			researchers = new Researchers(faculty);
			researchers.setBounds(0, 0, 1066, 739);
		}
		return researchers;
	}
}
