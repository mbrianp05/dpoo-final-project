package gui.views;

import gui.event.OnAddedResearcher;
import gui.researchers.ProfesorForm;
import gui.researchers.StudentForm;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JTabbedPane;

import schooling.Faculty;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.Insets;
import java.awt.Font;

public class ResearcherFormView extends JPanel {
	private static final long serialVersionUID = 1751242066126705510L;
	private JTabbedPane tabbedPane;
	private Faculty faculty;
	private ProfesorForm profesorForm;
	private StudentForm studentForm;
	private JLabel lblInsertarInvestigador;
	
	public ResearcherFormView(Faculty faculty) {
		this.faculty = faculty;
		
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{825, 0};
		gridBagLayout.rowHeights = new int[]{46, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblInsertarInvestigador = new GridBagConstraints();
		gbc_lblInsertarInvestigador.fill = GridBagConstraints.BOTH;
		gbc_lblInsertarInvestigador.insets = new Insets(0, 0, 5, 0);
		gbc_lblInsertarInvestigador.gridx = 0;
		gbc_lblInsertarInvestigador.gridy = 0;
		add(getLblInsertarInvestigador(), gbc_lblInsertarInvestigador);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.anchor = GridBagConstraints.WEST;
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 1;
		add(getTabbedPane(), gbc_tabbedPane);
	}
	
	public void listenTo(OnAddedResearcher listener) {
		profesorForm.listenTo(listener);
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
	private JLabel getLblInsertarInvestigador() {
		if (lblInsertarInvestigador == null) {
			lblInsertarInvestigador = new JLabel("Insertar investigador");
			lblInsertarInvestigador.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		}
		return lblInsertarInvestigador;
	}
}
