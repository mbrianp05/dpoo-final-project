package gui.views;

import gui.component.JTextLimited;

import javax.swing.JPanel;

import schooling.Faculty;
import schooling.Profesor;
import schooling.ResearchLine;
import utils.Validation;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.CardLayout;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class CoursesFormView extends JPanel {
	private static final long serialVersionUID = -1419886921835562157L;
	private Faculty faculty;
	private JLabel lblInsertarDatosDe;
	private JLabel lblNewLabel;
	private JComboBox<String> masteryPlans;
	private JLabel lblInstructor;
	private JComboBox<String> selectInstructor;
	private JLabel lblCrditosNecesarios;
	private JLabel lblNombreDelCurso;
	private JTextField txtCourseName;
	private JLabel lblDescripcion;
	private JPanel panel;
	private JPanel courseForm;
	private JTextLimited txtDescrip;
	private JLabel lblMax;
	private JButton btnAgregar;
	private JLabel errorMast;
	private JLabel errorName;
	private JLabel errorInstruct;
	private JLabel errorCreds;
	private JLabel errorDesc;
	private JSpinner spinnerCreds;

	private int[] profIDs = new int[500];

	public CoursesFormView(Faculty faculty) {

		this.faculty = faculty;
		setLayout(null);
		add(getLblInsertarDatosDe());
		add(getPanel());

	}
	private JLabel getLblInsertarDatosDe() {
		if (lblInsertarDatosDe == null) {
			lblInsertarDatosDe = new JLabel("Insertar datos de curso de postgrado");
			lblInsertarDatosDe.setFont(new Font("Segoe UI", Font.PLAIN, 25));
			lblInsertarDatosDe.setBounds(44, 36, 633, 45);
		}
		return lblInsertarDatosDe;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Maestr\u00EDa vinculada");
			lblNewLabel.setBounds(12, 13, 135, 16);
			lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return lblNewLabel;
	}
	private JComboBox<String> getMasteryPlans() {
		if (masteryPlans == null) {
			masteryPlans = new JComboBox<String>();
			masteryPlans.setBounds(153, 13, 154, 22);
			masteryPlans.setBackground(Color.WHITE);
			masteryPlans.setFont(new Font("Tahoma", Font.PLAIN, 13));

			ArrayList<ResearchLine> lines = faculty.getReseachLines();
			String [] names = new String[lines.size()];

			for(int i = 0; i < lines.size(); i++){
				names[i] = lines.get(i).getName();
			}

			masteryPlans.setModel(new DefaultComboBoxModel<String>(names));
		}
		return masteryPlans;
	}
	private JLabel getLblInstructor() {
		if (lblInstructor == null) {
			lblInstructor = new JLabel("Instructor");
			lblInstructor.setBounds(12, 71, 135, 16);
			lblInstructor.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return lblInstructor;
	}
	private JComboBox<String> getSelectInstructor() {
		if (selectInstructor == null) {
			selectInstructor = new JComboBox<String>();
			selectInstructor.setBackground(Color.WHITE);
			selectInstructor.setBounds(153, 71, 154, 22);

			ArrayList<Profesor> profs = new ArrayList<>();
			for(ResearchLine r: faculty.getReseachLines()){
				profs.add(r.getChief());
			}
			String[] names = new String[profs.size()];

			for(int i = 0; i < profs.size(); i++){
				names[i] = profs.get(i).getName();
				profIDs[i] = profs.get(i).getID();
			}

			selectInstructor.setModel(new DefaultComboBoxModel<String>(names));
		}
		return selectInstructor;
	}
	private JLabel getLblCrditosNecesarios() {
		if (lblCrditosNecesarios == null) {
			lblCrditosNecesarios = new JLabel("Cr\u00E9ditos necesarios");
			lblCrditosNecesarios.setBounds(12, 101, 135, 16);
			lblCrditosNecesarios.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return lblCrditosNecesarios;
	}
	private JLabel getLblNombreDelCurso() {
		if (lblNombreDelCurso == null) {
			lblNombreDelCurso = new JLabel("Nombre del curso");
			lblNombreDelCurso.setBounds(12, 42, 135, 16);
			lblNombreDelCurso.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return lblNombreDelCurso;
	}
	private JTextField getTxtCourseName() {
		if (txtCourseName == null) {
			txtCourseName = new JTextField();
			txtCourseName.setBounds(153, 42, 154, 22);
			txtCourseName.setColumns(10);
		}
		return txtCourseName;
	}
	private JLabel getLblDescripcion() {
		if (lblDescripcion == null) {
			lblDescripcion = new JLabel("Descripci\u00F3n");
			lblDescripcion.setBounds(12, 130, 135, 16);
			lblDescripcion.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return lblDescripcion;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(44, 100, 522, 310);
			panel.setLayout(new CardLayout(0, 0));
			panel.add(getCourseForm(), "name_333722481096900");
		}
		return panel;
	}
	private JPanel getCourseForm() {
		if (courseForm == null) {
			courseForm = new JPanel();
			courseForm.setLayout(null);
			courseForm.add(getLblNewLabel());
			courseForm.add(getMasteryPlans());
			courseForm.add(getErrorMast());
			courseForm.add(getLblNombreDelCurso());
			courseForm.add(getTxtCourseName());
			courseForm.add(getErrorName());
			courseForm.add(getLblInstructor());
			courseForm.add(getSelectInstructor());
			courseForm.add(getErrorInstruct());
			courseForm.add(getLblCrditosNecesarios());
			courseForm.add(getSpinnerCreds());
			courseForm.add(getErrorCreds());
			courseForm.add(getLblDescripcion());
			courseForm.add(getLblMax());
			courseForm.add(getTxtDescrip());
			courseForm.add(getErrorDesc());
			courseForm.add(getBtnAgregar());
		}
		return courseForm;
	}
	private JTextLimited getTxtDescrip() {
		if (txtDescrip == null) {
			txtDescrip = new JTextLimited();
			txtDescrip.setBounds(12, 159, 356, 107);

			txtDescrip.setLimite(240);
		}
		return txtDescrip;
	}
	private JLabel getLblMax() {
		if (lblMax == null) {
			lblMax = new JLabel("240 max");
			lblMax.setForeground(Color.LIGHT_GRAY);
			lblMax.setBounds(331, 244, 37, 22);
			lblMax.setBackground(Color.WHITE);
			lblMax.setFont(new Font("Segoe UI Light", Font.PLAIN, 8));
		}
		return lblMax;
	}
	private JButton getBtnAgregar() {
		if (btnAgregar == null) {
			btnAgregar = new JButton("Agregar");
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(masteryPlans != null){
						errorMast.setText("");
						if(Validation.notEmpty(txtCourseName.getText())) {
							errorName.setText("");
							if(selectInstructor!= null) {
								errorInstruct.setText("");
								if((int)spinnerCreds.getValue() != 0) {
									errorCreds.setText("");
									if(Validation.notEmpty(txtDescrip.getText())) {
										errorDesc.setText("");

										try{
											int index = selectInstructor.getSelectedIndex();
											Profesor instructor = (Profesor) faculty.findResearcher(profIDs[index]);
											
											String name = masteryPlans.getSelectedItem().toString();
											ResearchLine line = faculty.findResearchLine(name); 
											
											line.getMasteryPlan().addCourse(txtCourseName.getText(), txtDescrip.getText(), instructor, (int)spinnerCreds.getValue());
											
											resetForm();
										}
										catch (Exception e){}
									} else {
										errorDesc.setText("Agregue una descripción");
									}
								} else {
									errorCreds.setText("Los créditos necesarios deben ser mayores que 0");
								}
							} else {
								errorInstruct.setText("Seleccione un instructor");
							}
						} else {
							errorName.setText("Ingrrese un nombre para el curso");
						}
					} else {
						errorMast.setText("Seleccione una maestría vinculada al curso");
					}
				}
			});
			btnAgregar.setBounds(12, 272, 97, 25);
		}
		return btnAgregar;
	}
	private JLabel getErrorMast() {
		if (errorMast == null) {
			errorMast = new JLabel("");
			errorMast.setForeground(Color.RED);
			errorMast.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			errorMast.setBounds(312, 13, 56, 16);
		}
		return errorMast;
	}
	private JLabel getErrorName() {
		if (errorName == null) {
			errorName = new JLabel("");
			errorName.setForeground(Color.RED);
			errorName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			errorName.setBounds(312, 42, 56, 16);
		}
		return errorName;
	}
	private JLabel getErrorInstruct() {
		if (errorInstruct == null) {
			errorInstruct = new JLabel("");
			errorInstruct.setForeground(Color.RED);
			errorInstruct.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			errorInstruct.setBounds(319, 71, 56, 16);
		}
		return errorInstruct;
	}
	private JLabel getErrorCreds() {
		if (errorCreds == null) {
			errorCreds = new JLabel("");
			errorCreds.setForeground(Color.RED);
			errorCreds.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			errorCreds.setBounds(224, 103, 56, 16);
		}
		return errorCreds;
	}
	private JLabel getErrorDesc() {
		if (errorDesc == null) {
			errorDesc = new JLabel("");
			errorDesc.setForeground(Color.RED);
			errorDesc.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			errorDesc.setBounds(121, 279, 159, 16);
		}
		return errorDesc;
	}
	private JSpinner getSpinnerCreds() {
		if (spinnerCreds == null) {
			spinnerCreds = new JSpinner();
			spinnerCreds.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinnerCreds.setBounds(153, 100, 56, 22);
		}
		return spinnerCreds;
	}
	
	public void resetForm() {
		txtCourseName.setText("");
		txtDescrip.setText("");
		spinnerCreds.setValue(0);
		
	}
}
