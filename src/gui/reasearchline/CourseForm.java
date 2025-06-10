package gui.reasearchline;

import gui.event.OnCoursesFormActionTriggered;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BoxLayout;

import schooling.Degree;
import schooling.Faculty;
import schooling.Profesor;
import schooling.ResearchLine;
import utils.Validation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CourseForm extends JPanel {

	
	private static final long serialVersionUID = 1L;
	private JLabel lblName;
	private JTextField txtName;
	private JLabel lblInstructor;
	private JComboBox<String> cmboxInstruct;
	private JLabel lblCredits;
	private JSpinner spinner;
	private JLabel lblDescripcin;
	private JTextField txtDescr;
	private JButton btnSave;
	private JPanel panel;

	private int[] profIDs;

	private OnCoursesFormActionTriggered listener;
	private CourseFormData course;
	private Faculty faculty;
	private JLabel errorLbl;

	public void listenTo(OnCoursesFormActionTriggered listener) {
		this.listener = listener;
	}

	private void fetchInstructors() {
		
		ResearchLine line = faculty.findLineByCourse();
		
		ArrayList<Profesor> profs = faculty.getDoctorsSelectedLine(line);
		String[] names = new String[profs.size()];
		profIDs = new int[profs.size()];

		for(int i = 0; i < profs.size(); i++){
			System.out.println(profs.get(i).getName());
			
			names[i] = profs.get(i).getName();
			profIDs[i] = profs.get(i).getID();
		}

		cmboxInstruct.setModel(new DefaultComboBoxModel<>(names));
	}

	public CourseForm(CourseFormData data) {
		faculty = Faculty.newInstance();
		
		this.course = data;
		
		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(getPanel());
	}
	
	private void resetForm() {
		errorLbl.setText("");
		txtName.setText("");
		
		if(cmboxInstruct.getModel().getSize() >= 0) {
			cmboxInstruct.setSelectedIndex(0);
		} else {
			cmboxInstruct.setSelectedIndex(-1);
		}
		
		spinner.setValue(0);
		txtDescr.setText("");
	}
	
	private void updateCourse() {
		if(Validation.notEmpty(txtName.getText())) {
			if(Validation.notEmpty(txtDescr.getText())) {
				if((int)spinner.getValue() != 0) {

					int index = cmboxInstruct.getSelectedIndex();

					String name = txtName.getText();
					String description = txtDescr.getText();			
					Profesor instructor = (Profesor) faculty.findResearcher(profIDs[index]);
					int creds = (int)spinner.getValue();
					
					if(course == null) {
						resetForm();
					}
					
					if(listener != null) {
						listener.actionPerformed(new CourseFormData(name, description, instructor, creds));
					}
				}
				else {
					errorLbl.setText("Los créditos otorgados por el curso no pueden ser 0");
				}
			}
			else {
				errorLbl.setText("Ingrese una descripción para el curso");
			}
		}
		else {
			errorLbl.setText("Se requiere un nombre para el curso");
		}
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Nombre");
			lblName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblName;
	}
	private JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			txtName.setColumns(10);
			
			if(course != null) {
				txtName.setText(course.getName());
			}
		}
		return txtName;
	}
	private JLabel getLblInstructor() {
		if (lblInstructor == null) {
			lblInstructor = new JLabel("Instructor");
			lblInstructor.setFont(new Font("Segoe UI", Font.PLAIN, 15));				
		}
		return lblInstructor;
	}
	private JComboBox<String> getCmboxInstruct() {
		if (cmboxInstruct == null) {
			cmboxInstruct = new JComboBox<String>();
			cmboxInstruct.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));

			if(course != null) {
				cmboxInstruct.setSelectedItem(course.getInstructor());
			}
			
			fetchInstructors();
		}
		return cmboxInstruct;
	}
	private JLabel getLblCredits() {
		if (lblCredits == null) {
			lblCredits = new JLabel("Cr\u00E9ditos");
			lblCredits.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblCredits;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			
			if(course != null) {
				spinner.setValue(course.getCredits());
			}
		}
		return spinner;
	}
	private JLabel getLblDescripcin() {
		if (lblDescripcin == null) {
			lblDescripcin = new JLabel("Descripci\u00F3n");
			lblDescripcin.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblDescripcin;
	}
	private JTextField getTxtDescr() {
		if (txtDescr == null) {
			txtDescr = new JTextField();
			txtDescr.setColumns(10);
			
			if(course != null) {
				txtDescr.setText(course.getDescription());
			}
		}
		return txtDescr;
	}
	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Guardar");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					updateCourse();
				}
			});
			btnSave.setFont(new Font("Segoe UI", Font.BOLD, 15));
		}
		return btnSave;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{70, 0, 311, 70, 0};
			gbl_panel.rowHeights = new int[]{40, 21, 27, 30, 21, 27, 30, 16, 30, 16, 90, 45, 40, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.gridwidth = 2;
			gbc_lblName.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 1;
			gbc_lblName.gridy = 1;
			panel.add(getLblName(), gbc_lblName);
			GridBagConstraints gbc_txtName = new GridBagConstraints();
			gbc_txtName.anchor = GridBagConstraints.NORTH;
			gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtName.insets = new Insets(0, 0, 5, 5);
			gbc_txtName.gridwidth = 2;
			gbc_txtName.gridx = 1;
			gbc_txtName.gridy = 2;
			panel.add(getTxtName(), gbc_txtName);
			GridBagConstraints gbc_lblInstructor = new GridBagConstraints();
			gbc_lblInstructor.gridwidth = 2;
			gbc_lblInstructor.anchor = GridBagConstraints.NORTHWEST;
			gbc_lblInstructor.insets = new Insets(0, 0, 5, 5);
			gbc_lblInstructor.gridx = 1;
			gbc_lblInstructor.gridy = 4;
			panel.add(getLblInstructor(), gbc_lblInstructor);
			GridBagConstraints gbc_cmboxInstruct = new GridBagConstraints();
			gbc_cmboxInstruct.anchor = GridBagConstraints.NORTH;
			gbc_cmboxInstruct.fill = GridBagConstraints.HORIZONTAL;
			gbc_cmboxInstruct.insets = new Insets(0, 0, 5, 5);
			gbc_cmboxInstruct.gridwidth = 2;
			gbc_cmboxInstruct.gridx = 1;
			gbc_cmboxInstruct.gridy = 5;
			panel.add(getCmboxInstruct(), gbc_cmboxInstruct);
			GridBagConstraints gbc_lblCredits = new GridBagConstraints();
			gbc_lblCredits.anchor = GridBagConstraints.WEST;
			gbc_lblCredits.fill = GridBagConstraints.VERTICAL;
			gbc_lblCredits.insets = new Insets(0, 0, 5, 5);
			gbc_lblCredits.gridx = 1;
			gbc_lblCredits.gridy = 7;
			panel.add(getLblCredits(), gbc_lblCredits);
			GridBagConstraints gbc_spinner = new GridBagConstraints();
			gbc_spinner.anchor = GridBagConstraints.WEST;
			gbc_spinner.fill = GridBagConstraints.VERTICAL;
			gbc_spinner.insets = new Insets(0, 0, 5, 5);
			gbc_spinner.gridx = 2;
			gbc_spinner.gridy = 7;
			panel.add(getSpinner(), gbc_spinner);
			GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
			gbc_lblDescripcin.gridwidth = 2;
			gbc_lblDescripcin.anchor = GridBagConstraints.WEST;
			gbc_lblDescripcin.fill = GridBagConstraints.VERTICAL;
			gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
			gbc_lblDescripcin.gridx = 1;
			gbc_lblDescripcin.gridy = 9;
			panel.add(getLblDescripcin(), gbc_lblDescripcin);
			GridBagConstraints gbc_txtDescr = new GridBagConstraints();
			gbc_txtDescr.fill = GridBagConstraints.BOTH;
			gbc_txtDescr.insets = new Insets(0, 0, 5, 5);
			gbc_txtDescr.gridwidth = 2;
			gbc_txtDescr.gridx = 1;
			gbc_txtDescr.gridy = 10;
			panel.add(getTxtDescr(), gbc_txtDescr);
			GridBagConstraints gbc_errorLbl = new GridBagConstraints();
			gbc_errorLbl.gridwidth = 2;
			gbc_errorLbl.anchor = GridBagConstraints.WEST;
			gbc_errorLbl.insets = new Insets(0, 0, 5, 5);
			gbc_errorLbl.gridx = 1;
			gbc_errorLbl.gridy = 11;
			panel.add(getErrorLbl(), gbc_errorLbl);
			GridBagConstraints gbc_btnSave = new GridBagConstraints();
			gbc_btnSave.anchor = GridBagConstraints.WEST;
			gbc_btnSave.gridwidth = 2;
			gbc_btnSave.insets = new Insets(0, 0, 0, 5);
			gbc_btnSave.fill = GridBagConstraints.VERTICAL;
			gbc_btnSave.gridx = 1;
			gbc_btnSave.gridy = 12;
			panel.add(getBtnSave(), gbc_btnSave);
		}
		return panel;
	}
	private JLabel getErrorLbl() {
		if (errorLbl == null) {
			errorLbl = new JLabel("");
			errorLbl.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return errorLbl;
	}
}
