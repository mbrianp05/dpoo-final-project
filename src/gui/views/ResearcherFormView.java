package gui.views;

import gui.ProfesorForm;
import gui.StudentForm;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JTabbedPane;

import schooling.Faculty;

import java.awt.BorderLayout;

public class ResearcherFormView extends JPanel {
	private static final long serialVersionUID = 1751242066126705510L;
	private JTabbedPane tabbedPane;
	private Faculty faculty;
	private ProfesorForm profesorForm;
	private StudentForm studentForm;
	
	public ResearcherFormView(Faculty faculty) {
		this.faculty = faculty;
		
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		add(getTabbedPane());
	}

	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBackground(Color.WHITE);
			tabbedPane.addTab("Profesor", null, getProfesorForm(), null);
			tabbedPane.addTab("Estudiante", null, getStudentForm(), null);
		}
		return tabbedPane;
	}
	private ProfesorForm getProfesorForm() {
		if (profesorForm == null) {
			profesorForm = new ProfesorForm(faculty);
			profesorForm.setBackground(Color.WHITE);
		}
		return profesorForm;
	}
	private StudentForm getStudentForm() {
		if (studentForm == null) {
			studentForm = new StudentForm();
			studentForm.setBackground(Color.WHITE);
		}
		return studentForm;
	}
}
