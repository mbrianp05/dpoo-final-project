package gui.views;

import gui.component.JTextLimited;

import javax.swing.JPanel;

import schooling.Faculty;
import schooling.Profesor;
import schooling.ResearchLine;
import utils.Constants;
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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
	private JButton btnAgregar;
	private JLabel errorMast;
	private JLabel errorName;
	private JLabel errorInstruct;
	private JLabel errorCreds;
	private JLabel errorDesc;
	private JSpinner spinnerCreds;

	private int[] profIDs = new int[500];

	public CoursesFormView(Faculty faculty) {
		setBackground(Color.WHITE);

		this.faculty = faculty;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 0, 100, 0};
		gridBagLayout.rowHeights = new int[]{70, 45, 50, 310, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblInsertarDatosDe = new GridBagConstraints();
		gbc_lblInsertarDatosDe.fill = GridBagConstraints.BOTH;
		gbc_lblInsertarDatosDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsertarDatosDe.gridx = 1;
		gbc_lblInsertarDatosDe.gridy = 1;
		add(getLblInsertarDatosDe(), gbc_lblInsertarDatosDe);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		add(getPanel(), gbc_panel);

	}
	private JLabel getLblInsertarDatosDe() {
		if (lblInsertarDatosDe == null) {
			lblInsertarDatosDe = new JLabel("Insertar datos de curso de postgrado");
			lblInsertarDatosDe.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		}
		return lblInsertarDatosDe;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Maestr\u00EDa vinculada");
			lblNewLabel.setFont(Constants.getLabelFont());
		}
		return lblNewLabel;
	}
	private JComboBox<String> getMasteryPlans() {
		if (masteryPlans == null) {
			masteryPlans = new JComboBox<String>();
			masteryPlans.setBackground(Color.WHITE);
			masteryPlans.setFont(Constants.getLabelFont());

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
			lblInstructor.setFont(Constants.getLabelFont());
		}
		return lblInstructor;
	}
	private JComboBox<String> getSelectInstructor() {
		if (selectInstructor == null) {
			selectInstructor = new JComboBox<String>();
			selectInstructor.setBackground(Color.WHITE);

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
			lblCrditosNecesarios = new JLabel("Cr\u00E9ditos");
			lblCrditosNecesarios.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return lblCrditosNecesarios;
	}
	private JLabel getLblNombreDelCurso() {
		if (lblNombreDelCurso == null) {
			lblNombreDelCurso = new JLabel("Nombre del curso");
			lblNombreDelCurso.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return lblNombreDelCurso;
	}
	private JTextField getTxtCourseName() {
		if (txtCourseName == null) {
			txtCourseName = new JTextField();
			txtCourseName.setFont(Constants.getLabelFont());
			txtCourseName.setColumns(10);
		}
		return txtCourseName;
	}
	private JLabel getLblDescripcion() {
		if (lblDescripcion == null) {
			lblDescripcion = new JLabel("Descripci\u00F3n");
			lblDescripcion.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return lblDescripcion;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new CardLayout(0, 0));
			panel.add(getCourseForm(), "name_333722481096900");
		}
		return panel;
	}
	private JPanel getCourseForm() {
		if (courseForm == null) {
			courseForm = new JPanel();
			courseForm.setBackground(Color.WHITE);
			GridBagLayout gbl_courseForm = new GridBagLayout();
			gbl_courseForm.columnWidths = new int[]{97, 56, 83, 0};
			gbl_courseForm.rowHeights = new int[]{35, 30, 35, 30, 35, 30, 35, 30, 35, 107, 32, 40, 0};
			gbl_courseForm.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_courseForm.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			courseForm.setLayout(gbl_courseForm);
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
			gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			courseForm.add(getLblNewLabel(), gbc_lblNewLabel);
			GridBagConstraints gbc_masteryPlans = new GridBagConstraints();
			gbc_masteryPlans.anchor = GridBagConstraints.NORTH;
			gbc_masteryPlans.fill = GridBagConstraints.BOTH;
			gbc_masteryPlans.insets = new Insets(0, 0, 5, 0);
			gbc_masteryPlans.gridwidth = 2;
			gbc_masteryPlans.gridx = 1;
			gbc_masteryPlans.gridy = 0;
			courseForm.add(getMasteryPlans(), gbc_masteryPlans);
			GridBagConstraints gbc_errorMast = new GridBagConstraints();
			gbc_errorMast.gridwidth = 2;
			gbc_errorMast.fill = GridBagConstraints.BOTH;
			gbc_errorMast.insets = new Insets(0, 0, 5, 0);
			gbc_errorMast.gridx = 1;
			gbc_errorMast.gridy = 1;
			courseForm.add(getErrorMast(), gbc_errorMast);
			GridBagConstraints gbc_lblNombreDelCurso = new GridBagConstraints();
			gbc_lblNombreDelCurso.anchor = GridBagConstraints.NORTH;
			gbc_lblNombreDelCurso.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNombreDelCurso.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombreDelCurso.gridx = 0;
			gbc_lblNombreDelCurso.gridy = 2;
			courseForm.add(getLblNombreDelCurso(), gbc_lblNombreDelCurso);
			GridBagConstraints gbc_txtCourseName = new GridBagConstraints();
			gbc_txtCourseName.anchor = GridBagConstraints.NORTH;
			gbc_txtCourseName.fill = GridBagConstraints.BOTH;
			gbc_txtCourseName.insets = new Insets(0, 0, 5, 0);
			gbc_txtCourseName.gridwidth = 2;
			gbc_txtCourseName.gridx = 1;
			gbc_txtCourseName.gridy = 2;
			courseForm.add(getTxtCourseName(), gbc_txtCourseName);
			GridBagConstraints gbc_errorName = new GridBagConstraints();
			gbc_errorName.gridwidth = 2;
			gbc_errorName.fill = GridBagConstraints.BOTH;
			gbc_errorName.insets = new Insets(0, 0, 5, 0);
			gbc_errorName.gridx = 1;
			gbc_errorName.gridy = 3;
			courseForm.add(getErrorName(), gbc_errorName);
			GridBagConstraints gbc_lblInstructor = new GridBagConstraints();
			gbc_lblInstructor.anchor = GridBagConstraints.NORTH;
			gbc_lblInstructor.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblInstructor.insets = new Insets(0, 0, 5, 5);
			gbc_lblInstructor.gridx = 0;
			gbc_lblInstructor.gridy = 4;
			courseForm.add(getLblInstructor(), gbc_lblInstructor);
			GridBagConstraints gbc_selectInstructor = new GridBagConstraints();
			gbc_selectInstructor.anchor = GridBagConstraints.NORTH;
			gbc_selectInstructor.fill = GridBagConstraints.BOTH;
			gbc_selectInstructor.insets = new Insets(0, 0, 5, 0);
			gbc_selectInstructor.gridwidth = 2;
			gbc_selectInstructor.gridx = 1;
			gbc_selectInstructor.gridy = 4;
			courseForm.add(getSelectInstructor(), gbc_selectInstructor);
			GridBagConstraints gbc_errorInstruct = new GridBagConstraints();
			gbc_errorInstruct.gridwidth = 2;
			gbc_errorInstruct.fill = GridBagConstraints.BOTH;
			gbc_errorInstruct.insets = new Insets(0, 0, 5, 0);
			gbc_errorInstruct.gridx = 1;
			gbc_errorInstruct.gridy = 5;
			courseForm.add(getErrorInstruct(), gbc_errorInstruct);
			GridBagConstraints gbc_lblCrditosNecesarios = new GridBagConstraints();
			gbc_lblCrditosNecesarios.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblCrditosNecesarios.insets = new Insets(0, 0, 5, 5);
			gbc_lblCrditosNecesarios.gridx = 0;
			gbc_lblCrditosNecesarios.gridy = 6;
			courseForm.add(getLblCrditosNecesarios(), gbc_lblCrditosNecesarios);
			GridBagConstraints gbc_spinnerCreds = new GridBagConstraints();
			gbc_spinnerCreds.anchor = GridBagConstraints.NORTH;
			gbc_spinnerCreds.fill = GridBagConstraints.BOTH;
			gbc_spinnerCreds.insets = new Insets(0, 0, 5, 5);
			gbc_spinnerCreds.gridx = 1;
			gbc_spinnerCreds.gridy = 6;
			courseForm.add(getSpinnerCreds(), gbc_spinnerCreds);
			GridBagConstraints gbc_errorCreds = new GridBagConstraints();
			gbc_errorCreds.fill = GridBagConstraints.BOTH;
			gbc_errorCreds.insets = new Insets(0, 0, 5, 0);
			gbc_errorCreds.gridx = 2;
			gbc_errorCreds.gridy = 6;
			courseForm.add(getErrorCreds(), gbc_errorCreds);
			GridBagConstraints gbc_lblDescripcion = new GridBagConstraints();
			gbc_lblDescripcion.fill = GridBagConstraints.BOTH;
			gbc_lblDescripcion.insets = new Insets(0, 0, 5, 5);
			gbc_lblDescripcion.gridx = 0;
			gbc_lblDescripcion.gridy = 8;
			courseForm.add(getLblDescripcion(), gbc_lblDescripcion);
			GridBagConstraints gbc_txtDescrip = new GridBagConstraints();
			gbc_txtDescrip.fill = GridBagConstraints.BOTH;
			gbc_txtDescrip.insets = new Insets(0, 0, 5, 0);
			gbc_txtDescrip.gridwidth = 3;
			gbc_txtDescrip.gridx = 0;
			gbc_txtDescrip.gridy = 9;
			courseForm.add(getTxtDescrip(), gbc_txtDescrip);
			GridBagConstraints gbc_errorDesc = new GridBagConstraints();
			gbc_errorDesc.fill = GridBagConstraints.BOTH;
			gbc_errorDesc.insets = new Insets(0, 0, 5, 0);
			gbc_errorDesc.gridwidth = 2;
			gbc_errorDesc.gridx = 1;
			gbc_errorDesc.gridy = 10;
			courseForm.add(getErrorDesc(), gbc_errorDesc);
			GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
			gbc_btnAgregar.gridwidth = 3;
			gbc_btnAgregar.anchor = GridBagConstraints.EAST;
			gbc_btnAgregar.fill = GridBagConstraints.VERTICAL;
			gbc_btnAgregar.gridx = 0;
			gbc_btnAgregar.gridy = 11;
			courseForm.add(getBtnAgregar(), gbc_btnAgregar);
		}
		return courseForm;
	}
	private JTextLimited getTxtDescrip() {
		if (txtDescrip == null) {
			txtDescrip = new JTextLimited();
			txtDescrip.setFont(Constants.getLabelFont());
			txtDescrip.setLimite(240);
		}
		return txtDescrip;
	}
	private JButton getBtnAgregar() {
		if (btnAgregar == null) {
			btnAgregar = new JButton("Agregar");
			btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnAgregar.setForeground(Color.WHITE);
			btnAgregar.setBackground(Constants.getInsertionBtnColor());
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
		}
		return btnAgregar;
	}
	private JLabel getErrorMast() {
		if (errorMast == null) {
			errorMast = new JLabel("");
			errorMast.setForeground(Color.RED);
			errorMast.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		}
		return errorMast;
	}
	private JLabel getErrorName() {
		if (errorName == null) {
			errorName = new JLabel("");
			errorName.setForeground(Color.RED);
			errorName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		}
		return errorName;
	}
	private JLabel getErrorInstruct() {
		if (errorInstruct == null) {
			errorInstruct = new JLabel("");
			errorInstruct.setForeground(Color.RED);
			errorInstruct.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		}
		return errorInstruct;
	}
	private JLabel getErrorCreds() {
		if (errorCreds == null) {
			errorCreds = new JLabel("");
			errorCreds.setForeground(Color.RED);
			errorCreds.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		}
		return errorCreds;
	}
	private JLabel getErrorDesc() {
		if (errorDesc == null) {
			errorDesc = new JLabel("");
			errorDesc.setForeground(Color.RED);
			errorDesc.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		}
		return errorDesc;
	}
	private JSpinner getSpinnerCreds() {
		if (spinnerCreds == null) {
			spinnerCreds = new JSpinner();
			spinnerCreds.setFont(Constants.getLabelFont());
			spinnerCreds.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		}
		return spinnerCreds;
	}
	
	public void resetForm() {
		txtCourseName.setText("");
		txtDescrip.setText("");
		spinnerCreds.setValue(0);
		
	}
}
