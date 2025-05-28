package gui.views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import schooling.Faculty;

public class Masters extends JPanel {
	private JPanel panel;
	private Faculty faculty;
	private JLabel lblTotalCourses;
	private JLabel lblTotal;
	
	public Masters (Faculty faculty){
		
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
			panel.add(getLblTotalCourses());
			panel.add(getLblTotal());
		}		
		
		return panel;
	}
	
	private JLabel getLblTotalCourses () {
		
		if (lblTotalCourses == null){
			lblTotalCourses = new JLabel("Total de Cursos");
			lblTotalCourses.setBounds(12, 13, 207, 27);
			lblTotalCourses.setBackground(Color.WHITE);
			lblTotalCourses.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 24));
		}
		
		return lblTotalCourses;
	}
	
	private JLabel getLblTotal () {
		
		if(lblTotal == null){
			int text = 0;
			
			text = faculty.totalPostgradeCourses();
			
			lblTotal = new JLabel(text + "");
			lblTotal.setVerticalAlignment(SwingConstants.TOP);
			lblTotal.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			lblTotal.setBackground(Color.WHITE);
			lblTotal.setBounds(12, 53, 207, 124);			
		}				
		
		return lblTotal;
	}
}
