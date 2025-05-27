package gui;

import javax.swing.JPanel;
import java.awt.Color;
import gui.views.Researchers;

public class SelectionPanel extends JPanel {
	private Researchers researchers;
	public SelectionPanel() {
		setBackground(new Color(245, 245, 245));
		setLayout(null);
		add(getResearchers());
	}
	
	private Researchers getResearchers() {
		if (researchers == null) {
			researchers = new Researchers();
			researchers.setBounds(0, 0, 799, 426);
		}
		return researchers;
	}
}
