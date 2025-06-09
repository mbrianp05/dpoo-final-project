package gui.views;

import gui.component.TitleLabel;
import gui.event.OnAddedResearcher;
import gui.event.OnProfesorFormActionTriggered;
import gui.researchers.ProfesorForm;
import gui.researchers.ProfesorFormData;
import gui.researchers.StudentForm;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import schooling.Faculty;
import utils.ArrayLib;
import utils.Constants;

public class ResearcherFormView extends JPanel {
	private static final long serialVersionUID = 1751242066126705510L;
	private Faculty faculty;
	private TitleLabel lblInsertarInvestigador;
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
		JOptionPane.showMessageDialog(null, "¡Se ha registrado el investigador correctamente!", "Mensaje", JOptionPane.PLAIN_MESSAGE);
	}
	
	public void listenTo(OnAddedResearcher listener) {
		this.listener = listener;
	}
	
	private TitleLabel getLblInsertarInvestigador() {
		if (lblInsertarInvestigador == null) {
			lblInsertarInvestigador = new TitleLabel();
			lblInsertarInvestigador.setText("Insertar datos del investigador");
			lblInsertarInvestigador.setFont(Constants.getTitleFont());
		}
		return lblInsertarInvestigador;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
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
			wrapperPanel.setLayout(new CardLayout(0, 0));
			wrapperPanel.add(getProfesorForm(), "Profesor Form");
			wrapperPanel.add(getStudentForm(), "Student Form");
		}
		return wrapperPanel;
	}
	
	private ProfesorForm getProfesorForm() {
		if (profesorForm == null) {
			profesorForm = new ProfesorForm(getMatters());
			profesorForm.listenTo(new OnProfesorFormActionTriggered() {
				@Override
				public void actionPerformed(ProfesorFormData data) {
					int ID = faculty.addProfesor(data.getName(), data.getDegree(), data.getCategory(), data.getMatter());
					
					if (listener != null) {
						listener.newResearcher(ID);
					}
					
					sendFeedback();
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
					if (listener != null) {
						listener.newResearcher(researcherID);
					}

					sendFeedback();
				}
			});
		}
		return studentForm;
	}
}
