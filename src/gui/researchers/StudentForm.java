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
import utils.Validation;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

import javax.swing.SwingConstants;
import gui.component.TemporaryMessage;

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
	private TemporaryMessage temporaryMessage;

	/**
	 * @wbp.parser.constructor
	 */
	public StudentForm(Faculty faculty) {
		this.faculty = faculty;
		editing = false;

		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		add(getPanel());
	}

	public StudentForm(Faculty faculty, Student student) {
		this.faculty = faculty;
		this.student = student;
		this.editing = true;

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
			lblName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblName;
	}
	private JLabel getLblTemaDeInvestigacin() {
		if (lblTemaDeInvestigacin == null) {
			lblTemaDeInvestigacin = new JLabel("Tema de investigaci\u00F3n");
			lblTemaDeInvestigacin.setFont(new Font("Segoe UI", Font.PLAIN, 15));
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

	private void sendFeedback() {
		temporaryMessage.appear();
		temporaryMessage.setText(editing ? "Se ha actualizado correctamente" : "Se ha registrado el investigador correctamente");
	}

	private void insert() {
		if (Validation.notEmpty(textFieldName.getText())) {
			int id = faculty.addStudent(textFieldName.getText(), getMatter());

			if (listener != null) {
				listener.added(id);
			}

			resetForm();
			sendFeedback();
		} else {
			errorLabel.setText("El nombre es requerido");
		}
	}
	
	private void update() {
		if (Validation.notEmpty(textFieldName.getText())) {
			Student r = (Student)faculty.findResearcher(student.getID());

			r.setName(textFieldName.getText());
			
			faculty.moveToOtherMatter(r.getID(), getMatter());
			
			if (listener != null) {
				listener.added(r.getID());
			}

			sendFeedback();
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

			if (editing) {
				ResearchMatter matter = faculty.findMatterOf(student.getID());

				if (matter != null) {
					ComboBoxModel<Object> model = researchMatterComboBox.getModel();
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
			gbl_panel.columnWidths = new int[]{50, 383, 50, 0};
			gbl_panel.rowHeights = new int[]{0, 30, 50, 29, 30, 50, 0, 30, 28, 0, 28, 0};
			gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_temporaryMessage = new GridBagConstraints();
			gbc_temporaryMessage.insets = new Insets(0, 0, 5, 5);
			gbc_temporaryMessage.fill = GridBagConstraints.BOTH;
			gbc_temporaryMessage.gridx = 1;
			gbc_temporaryMessage.gridy = 2;
			panel.add(getTemporaryMessage(), gbc_temporaryMessage);
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.anchor = GridBagConstraints.WEST;
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 1;
			gbc_lblName.gridy = 3;
			panel.add(getLblName(), gbc_lblName);
			GridBagConstraints gbc_textFieldName = new GridBagConstraints();
			gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
			gbc_textFieldName.fill = GridBagConstraints.BOTH;
			gbc_textFieldName.gridx = 1;
			gbc_textFieldName.gridy = 4;
			panel.add(getTextFieldName(), gbc_textFieldName);
			GridBagConstraints gbc_errorLabel = new GridBagConstraints();
			gbc_errorLabel.fill = GridBagConstraints.BOTH;
			gbc_errorLabel.insets = new Insets(0, 0, 5, 5);
			gbc_errorLabel.gridx = 1;
			gbc_errorLabel.gridy = 5;
			panel.add(getErrorLabel(), gbc_errorLabel);
			GridBagConstraints gbc_lblTemaDeInvestigacin = new GridBagConstraints();
			gbc_lblTemaDeInvestigacin.anchor = GridBagConstraints.WEST;
			gbc_lblTemaDeInvestigacin.insets = new Insets(0, 0, 5, 5);
			gbc_lblTemaDeInvestigacin.gridx = 1;
			gbc_lblTemaDeInvestigacin.gridy = 6;
			panel.add(getLblTemaDeInvestigacin(), gbc_lblTemaDeInvestigacin);
			GridBagConstraints gbc_researchMatterComboBox = new GridBagConstraints();
			gbc_researchMatterComboBox.fill = GridBagConstraints.BOTH;
			gbc_researchMatterComboBox.insets = new Insets(0, 0, 5, 5);
			gbc_researchMatterComboBox.gridx = 1;
			gbc_researchMatterComboBox.gridy = 7;
			panel.add(getResearchMatterComboBox(), gbc_researchMatterComboBox);
			GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
			gbc_btnSubmit.insets = new Insets(0, 0, 5, 5);
			gbc_btnSubmit.anchor = GridBagConstraints.NORTHWEST;
			gbc_btnSubmit.gridx = 1;
			gbc_btnSubmit.gridy = 9;
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
	private TemporaryMessage getTemporaryMessage() {
		if (temporaryMessage == null) {
			temporaryMessage = new TemporaryMessage();
		}
		return temporaryMessage;
	}
}
