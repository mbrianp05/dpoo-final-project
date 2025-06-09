package gui.researchers;

import gui.component.ErrorLabel;
import gui.component.ResearchMatterComboBox;
import gui.event.OnAddedResearcher;

import javax.swing.JPanel;

import schooling.Faculty;
import schooling.ResearchMatter;
import schooling.Student;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ComboBoxModel;
import javax.swing.JTextField;

import utils.Constants;
import utils.Validation;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

import javax.swing.SwingConstants;

public class StudentForm extends JPanel {
	private static final long serialVersionUID = 5814578189776579606L;

	private Faculty faculty;
	private Student student;
	private boolean editing;

	private JLabel lblName;
	private JLabel lblTemaDeInvestigacin;
	private JButton btnSubmit;
	private ResearchMatterComboBox researchMatterComboBox;
	private JPanel panel;
	private JTextField textFieldName;
	private OnAddedResearcher listener;
	private ErrorLabel errorLabel;

	public StudentForm() {
		this(null);
	}

	public StudentForm(Student student) {
		this.faculty = Faculty.newInstance();
		this.student = student;
		this.editing = student != null;

		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		add(getPanel());
	}

	public void listenTo(OnAddedResearcher listener) {
		this.listener = listener;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Nombre");
			lblName.setFont(Constants.getLabelFont());
		}
		return lblName;
	}
	private JLabel getLblTemaDeInvestigacin() {
		if (lblTemaDeInvestigacin == null) {
			lblTemaDeInvestigacin = new JLabel("Tema de investigaci\u00F3n");
			lblTemaDeInvestigacin.setFont(Constants.getLabelFont());
		}
		return lblTemaDeInvestigacin;
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
	}

	private void insert() {
		if (Validation.notEmpty(textFieldName.getText())) {
			int id = faculty.addStudent(textFieldName.getText(), getMatter());

			if (listener != null) {
				listener.newResearcher(id);
			}

			resetForm();
		} else {
			errorLabel.setText("El nombre es requerido");
		}
	}

	private void update() {
		if (Validation.notEmpty(textFieldName.getText())) {
			student.setName(textFieldName.getText());

			faculty.moveToOtherMatter(student.getID(), getMatter());

			if (listener != null) {
				listener.newResearcher(student.getID());
			}
		} else {
			errorLabel.setText("El nombre es requerido");
		}
	}

	private JButton getBtnSubmit() {
		if (btnSubmit == null) {
			btnSubmit = new JButton(editing ? "Actualizar" : "Registrar estudiante");
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!editing) insert();
					else update();
				}
			});
			btnSubmit.setBackground(Constants.getInsertionBtnColor());
			btnSubmit.setForeground(Color.WHITE);
			btnSubmit.setFont(new Font("Segoe UI", Font.BOLD, 15));
		}
		return btnSubmit;
	}

	public void fetchData() {
		researchMatterComboBox.setData();
	}

	private ResearchMatterComboBox getResearchMatterComboBox() {
		if (researchMatterComboBox == null) {
			researchMatterComboBox = new ResearchMatterComboBox(faculty);
			researchMatterComboBox.setBackground(Color.WHITE);
			researchMatterComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 15));

			if (editing) {
				ResearchMatter matter = faculty.findMatterOf(student.getID());

				if (matter != null) {
					ComboBoxModel<String> model = researchMatterComboBox.getModel();
					int index = -1;
					int i = 0;

					while (i < researchMatterComboBox.getModel().getSize() && index == -1) {
						String current = (String)model.getElementAt(i);
						if (current.equals(matter.getName())) index = i;

						i++;
					}

					researchMatterComboBox.setSelectedIndex(index);
				}
			}
		}
		return researchMatterComboBox;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{383, 0};
			gbl_panel.rowHeights = new int[]{29, 35, 50, 0, 35, 50, 35, 0};
			gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.anchor = GridBagConstraints.WEST;
			gbc_lblName.insets = new Insets(0, 0, 5, 0);
			gbc_lblName.gridx = 0;
			gbc_lblName.gridy = 0;
			panel.add(getLblName(), gbc_lblName);
			GridBagConstraints gbc_textFieldName = new GridBagConstraints();
			gbc_textFieldName.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldName.fill = GridBagConstraints.BOTH;
			gbc_textFieldName.gridx = 0;
			gbc_textFieldName.gridy = 1;
			panel.add(getTextFieldName(), gbc_textFieldName);
			GridBagConstraints gbc_errorLabel = new GridBagConstraints();
			gbc_errorLabel.fill = GridBagConstraints.BOTH;
			gbc_errorLabel.insets = new Insets(0, 0, 5, 0);
			gbc_errorLabel.gridx = 0;
			gbc_errorLabel.gridy = 2;
			panel.add(getErrorLabel(), gbc_errorLabel);
			GridBagConstraints gbc_lblTemaDeInvestigacin = new GridBagConstraints();
			gbc_lblTemaDeInvestigacin.anchor = GridBagConstraints.WEST;
			gbc_lblTemaDeInvestigacin.insets = new Insets(0, 0, 5, 0);
			gbc_lblTemaDeInvestigacin.gridx = 0;
			gbc_lblTemaDeInvestigacin.gridy = 3;
			panel.add(getLblTemaDeInvestigacin(), gbc_lblTemaDeInvestigacin);
			GridBagConstraints gbc_researchMatterComboBox = new GridBagConstraints();
			gbc_researchMatterComboBox.fill = GridBagConstraints.BOTH;
			gbc_researchMatterComboBox.insets = new Insets(0, 0, 5, 0);
			gbc_researchMatterComboBox.gridx = 0;
			gbc_researchMatterComboBox.gridy = 4;
			panel.add(getResearchMatterComboBox(), gbc_researchMatterComboBox);
			GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
			gbc_btnSubmit.fill = GridBagConstraints.VERTICAL;
			gbc_btnSubmit.anchor = GridBagConstraints.NORTHEAST;
			gbc_btnSubmit.gridx = 0;
			gbc_btnSubmit.gridy = 6;
			panel.add(getBtnSubmit(), gbc_btnSubmit);
		}
		return panel;
	}
	private JTextField getTextFieldName() {
		if (textFieldName == null) {
			textFieldName = new JTextField();
			textFieldName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textFieldName.setColumns(10);

			if (editing) {
				textFieldName.setText(student.getName());
			}
		}
		return textFieldName;
	}
	private ErrorLabel getErrorLabel() {
		if (errorLabel == null) {
			errorLabel = new ErrorLabel();
			errorLabel.setVerticalAlignment(SwingConstants.TOP);
			errorLabel.setText("");
		}
		return errorLabel;
	}
}
