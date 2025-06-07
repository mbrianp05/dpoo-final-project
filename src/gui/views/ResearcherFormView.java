package gui.views;

import gui.event.OnAddedProfesor;
import gui.event.OnAddedResearcher;
import gui.researchers.ProfesorForm;
import gui.researchers.StudentForm;

import javax.swing.JPanel;

import java.awt.Color;

import schooling.Degree;
import schooling.Faculty;
import schooling.ProfesorCategory;
import utils.ArrayLib;
import utils.Constants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.Insets;

import javax.swing.JRadioButton;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;

import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResearcherFormView extends JPanel {
	private static final long serialVersionUID = 1751242066126705510L;
	private Faculty faculty;
	private JLabel lblInsertarInvestigador;
	private JPanel panel;
	private JRadioButton addStudent;
	private JRadioButton addProfesor;
	private ButtonGroup buttonGroup;
	private JPanel wrapperPanel;
	private ProfesorForm profesorForm;
	private StudentForm studentForm;
	private OnAddedResearcher listener;
	
	public ResearcherFormView() {
		this.faculty = Faculty.newInstance();
		
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 0, 100, 0};
		gridBagLayout.rowHeights = new int[]{70, 45, 40, 20, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 3.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblInsertarInvestigador = new GridBagConstraints();
		gbc_lblInsertarInvestigador.fill = GridBagConstraints.BOTH;
		gbc_lblInsertarInvestigador.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsertarInvestigador.gridx = 1;
		gbc_lblInsertarInvestigador.gridy = 1;
		add(getLblInsertarInvestigador(), gbc_lblInsertarInvestigador);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		add(getPanel(), gbc_panel);
		GridBagConstraints gbc_wrapperPanel = new GridBagConstraints();
		gbc_wrapperPanel.insets = new Insets(0, 0, 5, 5);
		gbc_wrapperPanel.fill = GridBagConstraints.BOTH;
		gbc_wrapperPanel.gridx = 1;
		gbc_wrapperPanel.gridy = 4;
		add(getWrapperPanel(), gbc_wrapperPanel);
	}
	
	private String[] getMatters() {
		return ArrayLib.cast(faculty.getResearchMattersNames());
	}
	
	public void update() {
		studentForm.fetchData();
		profesorForm.setResearchMatters(getMatters());
	}

	private void sendFeedback() {
	}
	
	public void listenTo(OnAddedResearcher listener) {
		this.listener = listener;
	}
	
	private JLabel getLblInsertarInvestigador() {
		if (lblInsertarInvestigador == null) {
			lblInsertarInvestigador = new JLabel("Insertar datos del investigador");
			lblInsertarInvestigador.setFont(Constants.getTitleFont());
		}
		return lblInsertarInvestigador;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getAddStudent());
			panel.add(getAddProfesor(), BorderLayout.WEST);

			getButtonGroup();
		}
		return panel;
	}
	private JRadioButton getAddStudent() {
		if (addStudent == null) {
			addStudent = new JRadioButton("Estudiante");
			addStudent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CardLayout cl = (CardLayout)wrapperPanel.getLayout();
					cl.show(wrapperPanel, "Student Form");
				}
			});
			addStudent.setFont(Constants.getLabelFont());
			addStudent.setBackground(Color.WHITE);
		}
		return addStudent;
	}
	private JRadioButton getAddProfesor() {
		if (addProfesor == null) {
			addProfesor = new JRadioButton("Profesor");
			addProfesor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CardLayout cl = (CardLayout)wrapperPanel.getLayout();
					cl.show(wrapperPanel, "Profesor Form");
				}
			});
			addProfesor.setSelected(true);
			addProfesor.setFont(Constants.getLabelFont());
			addProfesor.setBackground(Color.WHITE);
		}
		return addProfesor;
	}
	
	private ButtonGroup getButtonGroup() {
		if (buttonGroup == null) {
			buttonGroup = new ButtonGroup();
			buttonGroup.add(addProfesor);
			buttonGroup.add(addStudent);
		}
		return buttonGroup;
	}
	
	private JPanel getWrapperPanel() {
		if (wrapperPanel == null) {
			wrapperPanel = new JPanel();
			wrapperPanel.setBackground(Color.WHITE);
			wrapperPanel.setLayout(new CardLayout(0, 0));
			wrapperPanel.add(getProfesorForm(), "Profesor Form");
			wrapperPanel.add(getStudentForm(), "Student Form");
		}
		return wrapperPanel;
	}
	
	private ProfesorForm getProfesorForm() {
		if (profesorForm == null) {
			profesorForm = new ProfesorForm(getMatters());
			profesorForm.listenTo(new OnAddedProfesor() {
				@Override
				public void newProfesor(String name, Degree degree, ProfesorCategory category, String matter) {
					int ID = faculty.addProfesor(name, degree, category, matter);
					
					if (listener != null) {
						listener.newResearcher(ID);
					}
				}
			});
		}
		return profesorForm;
	}
	
	private StudentForm getStudentForm() {
		if (studentForm == null) {
			studentForm = new StudentForm();
			studentForm.listenTo(new OnAddedResearcher() {
				@Override
				public void newResearcher(int researcherID) {
					sendFeedback();
					
					if (listener != null) {
						listener.newResearcher(researcherID);
					}
				}
			});
		}
		return studentForm;
	}
}
