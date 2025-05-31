package gui;

import gui.event.OnAddedResearcher;

import javax.swing.JPanel;

import schooling.Degree;
import schooling.Faculty;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import schooling.ProfesorCategory;
import utils.Validation;

import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfesorForm extends JPanel {
	private static final long serialVersionUID = 5814578189776579606L;

	private Faculty faculty;
	private JLabel lblName;
	private JLabel lblProfesorCategory;
	private JLabel lblCategoraCientfica;
	private JLabel lblTemaDeInvestigacin;
	private JComboBox<String> comboBoxProfesorCategory;
	private JComboBox<String> comboBoxDegree;
	private JButton btnSubmit;
	private ResearchMatterComboBox researchMatterComboBox;
	private JPanel panel;
	private JTextField textFieldName;
	private ErrorLabel errorLabel;
	private OnAddedResearcher listener;

	public ProfesorForm(Faculty faculty) {
		this.faculty = faculty;

		setBackground(Color.WHITE);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(getPanel());
	}

	public void addListener(OnAddedResearcher listener) {
		this.listener = listener;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Nombre");
			lblName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblName;
	}
	private JLabel getLblProfesorCategory() {
		if (lblProfesorCategory == null) {
			lblProfesorCategory = new JLabel("Categor\u00EDa");
			lblProfesorCategory.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblProfesorCategory;
	}
	private JLabel getLblCategoraCientfica() {
		if (lblCategoraCientfica == null) {
			lblCategoraCientfica = new JLabel("Categor\u00EDa cient\u00EDfica");
			lblCategoraCientfica.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblCategoraCientfica;
	}
	private JLabel getLblTemaDeInvestigacin() {
		if (lblTemaDeInvestigacin == null) {
			lblTemaDeInvestigacin = new JLabel("Tema de investigaci\u00F3n");
			lblTemaDeInvestigacin.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblTemaDeInvestigacin;
	}
	private JComboBox<String> getComboBoxProfesorCategory() {
		if (comboBoxProfesorCategory == null) {
			comboBoxProfesorCategory = new JComboBox<>();
			comboBoxProfesorCategory.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			comboBoxProfesorCategory.setBackground(Color.WHITE);
			comboBoxProfesorCategory.setModel(new DefaultComboBoxModel<>(new String[] {"Instructor", "Asistente", "Auxiliar", "Titular"}));
			comboBoxProfesorCategory.setSelectedIndex(0);
		}
		return comboBoxProfesorCategory;
	}
	private JComboBox<String> getComboBoxDegree() {
		if (comboBoxDegree == null) {
			comboBoxDegree = new JComboBox<>();
			comboBoxDegree.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			comboBoxDegree.setBackground(Color.WHITE);
			comboBoxDegree.setModel(new DefaultComboBoxModel<>(new String[] {"Ninguna", "M\u00E1ster", "Doctor"}));
			comboBoxDegree.setSelectedIndex(0);
		}
		return comboBoxDegree;
	}

	private Degree getDegree() {
		Degree degree;

		switch (comboBoxDegree.getSelectedIndex()) {
		case 1:
			degree = Degree.Master;
			break;
		case 2:
			degree = Degree.Doctor;
		case 0:
		default:
			degree = null;
		}

		return degree;
	}
	
	private ProfesorCategory getCategory() {
		ProfesorCategory category;

		switch (comboBoxProfesorCategory.getSelectedIndex()) {
		case 0:
			category = ProfesorCategory.Instructor;
			break;
		case 1:
			category = ProfesorCategory.Assistant;
			break;
		case 2:
			category = ProfesorCategory.Auxiliar;
			break;
		case 3:
		default:
			category = ProfesorCategory.Permanent;
		}

		return category;
	}
	
	private String getMatter() {
		int index = researchMatterComboBox.getSelectedIndex();
		
		return (String)researchMatterComboBox.getModel().getElementAt(index);
	}

	private void resetForm() {
		errorLabel.setText("");
		textFieldName.setText("");
		
		if (researchMatterComboBox.getModel().getSize() >= 0) {
			researchMatterComboBox.setSelectedIndex(0);
		} else {
			researchMatterComboBox.setSelectedIndex(-1);
		}
		
		comboBoxProfesorCategory.setSelectedIndex(0);
		comboBoxDegree.setSelectedIndex(0);
	}
	
	private JButton getBtnSubmit() {
		if (btnSubmit == null) {
			btnSubmit = new JButton("Insertar  profesor");
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (Validation.notEmpty(textFieldName.getText())) {
						int id = faculty.addProfesor(textFieldName.getText(), getDegree(), getCategory(), getMatter());
						resetForm();
						
						if (listener != null) {
							listener.added(id);
						}
					} else {
						errorLabel.setText("El nombre no puede estar vacío");
					}
				}
			});
			btnSubmit.setBackground(new Color(255, 0, 51));
			btnSubmit.setForeground(Color.WHITE);
			btnSubmit.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return btnSubmit;
	}
	private ResearchMatterComboBox getResearchMatterComboBox() {
		if (researchMatterComboBox == null) {
			researchMatterComboBox = new ResearchMatterComboBox(faculty);
			researchMatterComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return researchMatterComboBox;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{50, 383, 50, 0};
			gbl_panel.rowHeights = new int[]{0, 29, 0, 31, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.anchor = GridBagConstraints.WEST;
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 1;
			gbc_lblName.gridy = 1;
			panel.add(getLblName(), gbc_lblName);
			GridBagConstraints gbc_textFieldName = new GridBagConstraints();
			gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldName.fill = GridBagConstraints.HORIZONTAL;
			gbc_textFieldName.gridx = 1;
			gbc_textFieldName.gridy = 2;
			panel.add(getTextFieldName(), gbc_textFieldName);
			GridBagConstraints gbc_errorLabel = new GridBagConstraints();
			gbc_errorLabel.fill = GridBagConstraints.BOTH;
			gbc_errorLabel.insets = new Insets(0, 0, 5, 5);
			gbc_errorLabel.gridx = 1;
			gbc_errorLabel.gridy = 3;
			panel.add(getErrorLabel(), gbc_errorLabel);
			GridBagConstraints gbc_lblProfesorCategory = new GridBagConstraints();
			gbc_lblProfesorCategory.anchor = GridBagConstraints.WEST;
			gbc_lblProfesorCategory.insets = new Insets(0, 0, 5, 5);
			gbc_lblProfesorCategory.gridx = 1;
			gbc_lblProfesorCategory.gridy = 4;
			panel.add(getLblProfesorCategory(), gbc_lblProfesorCategory);
			GridBagConstraints gbc_comboBoxProfesorCategory = new GridBagConstraints();
			gbc_comboBoxProfesorCategory.fill = GridBagConstraints.BOTH;
			gbc_comboBoxProfesorCategory.anchor = GridBagConstraints.WEST;
			gbc_comboBoxProfesorCategory.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxProfesorCategory.gridx = 1;
			gbc_comboBoxProfesorCategory.gridy = 5;
			panel.add(getComboBoxProfesorCategory(), gbc_comboBoxProfesorCategory);
			GridBagConstraints gbc_lblCategoraCientfica = new GridBagConstraints();
			gbc_lblCategoraCientfica.anchor = GridBagConstraints.WEST;
			gbc_lblCategoraCientfica.insets = new Insets(0, 0, 5, 5);
			gbc_lblCategoraCientfica.gridx = 1;
			gbc_lblCategoraCientfica.gridy = 7;
			panel.add(getLblCategoraCientfica(), gbc_lblCategoraCientfica);
			GridBagConstraints gbc_comboBoxDegree = new GridBagConstraints();
			gbc_comboBoxDegree.fill = GridBagConstraints.BOTH;
			gbc_comboBoxDegree.anchor = GridBagConstraints.WEST;
			gbc_comboBoxDegree.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxDegree.gridx = 1;
			gbc_comboBoxDegree.gridy = 8;
			panel.add(getComboBoxDegree(), gbc_comboBoxDegree);
			GridBagConstraints gbc_lblTemaDeInvestigacin = new GridBagConstraints();
			gbc_lblTemaDeInvestigacin.anchor = GridBagConstraints.WEST;
			gbc_lblTemaDeInvestigacin.insets = new Insets(0, 0, 5, 5);
			gbc_lblTemaDeInvestigacin.gridx = 1;
			gbc_lblTemaDeInvestigacin.gridy = 10;
			panel.add(getLblTemaDeInvestigacin(), gbc_lblTemaDeInvestigacin);
			GridBagConstraints gbc_researchMatterComboBox = new GridBagConstraints();
			gbc_researchMatterComboBox.anchor = GridBagConstraints.WEST;
			gbc_researchMatterComboBox.fill = GridBagConstraints.BOTH;
			gbc_researchMatterComboBox.insets = new Insets(0, 0, 5, 5);
			gbc_researchMatterComboBox.gridx = 1;
			gbc_researchMatterComboBox.gridy = 11;
			panel.add(getResearchMatterComboBox(), gbc_researchMatterComboBox);
			GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
			gbc_btnSubmit.insets = new Insets(0, 0, 5, 5);
			gbc_btnSubmit.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnSubmit.gridx = 1;
			gbc_btnSubmit.gridy = 13;
			panel.add(getBtnSubmit(), gbc_btnSubmit);
		}
		return panel;
	}
	private JTextField getTextFieldName() {
		if (textFieldName == null) {
			textFieldName = new JTextField();
			textFieldName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textFieldName.setColumns(10);
		}
		return textFieldName;
	}
	private ErrorLabel getErrorLabel() {
		if (errorLabel == null) {
			errorLabel = new ErrorLabel();
		}
		return errorLabel;
	}
}
