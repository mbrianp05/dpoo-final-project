package gui.views;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;

import java.awt.Font;

import schooling.Faculty;
import schooling.ResearchMatter;
import javax.swing.SwingConstants;

public class ResearchLinesFormView extends JPanel {
	private static final long serialVersionUID = 3971105665570208468L;
	private JPanel panel;
	private JLabel lblTemasPopulares;
	private JLabel lblMatters;
	private Faculty faculty;
	
	public ResearchLinesFormView(Faculty faculty) {
		this.faculty = faculty;
		
		setBackground(Color.WHITE);
		setLayout(null);
		
		add(getPanel());
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBorder(new LineBorder(new Color(255, 0, 102)));
			panel.setBounds(12, 13, 231, 195);
			panel.setLayout(null);
			panel.add(getLblTemasPopulares());
			panel.add(getLblMatters());
		}
		
		return panel;
	}
	private JLabel getLblTemasPopulares() {
		if (lblTemasPopulares == null) {
			lblTemasPopulares = new JLabel("Temas populares");
			lblTemasPopulares.setBackground(Color.WHITE);
			lblTemasPopulares.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 24));
			lblTemasPopulares.setBounds(12, 13, 207, 27);
		}
		return lblTemasPopulares;
	}
	private JLabel getLblMatters() {
		if (lblMatters == null) {
			lblMatters = new JLabel("");
			lblMatters.setVerticalAlignment(SwingConstants.TOP);
			lblMatters.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			lblMatters.setBackground(Color.WHITE);
			lblMatters.setBounds(12, 53, 207, 124);
			
			calculateTrendings();
		}
		return lblMatters;
	}

	public void calculateTrendings() {
		String text = "<html>";
		
		for (ResearchMatter matter: faculty.trendingMatters()) {
			text += matter.getName() + "<br>";
		}
		
		text += "</html>";
		
		lblMatters.setText(text);
	}
}
