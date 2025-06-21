package gui.researchers;

import gui.component.ErrorLabel;
import gui.event.OnProfesorFormActionTriggered;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import schooling.Degree;
import schooling.ProfesorCategory;
import utils.Constants;
import utils.Validation;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProfesorForm extends JPanel {
	private static final long serialVersionUID = 5814578189776579606L;

	private ProfesorFormData profesor;

	private JLabel lblName;
	private JLabel lblProfesorCategory;
	private JLabel lblCategoraCientfica;
	private JLabel lblTemaDeInvestigacin;
	private JComboBox<String> comboBoxProfesorCategory;
	private JComboBox<String> comboBoxDegree;
	private JComboBox<String> researchMatterComboBox;
	private JPanel panel;
	private JTextField textFieldName;
	private JButton btnSubmit;
	private ErrorLabel errorLabel;

	private OnProfesorFormActionTriggered listener;

	private String[] researchMatters;
	
	/**
	 * @wbp.parser.constructor
	 */
	public ProfesorForm(String[] researchMatters) {
		this(researchMatters, null);
	}

	public ProfesorForm(String[] researchMatters, ProfesorFormData data) {
		this.profesor = data;
		this.researchMatters = researchMatters;

		setLayout(new BorderLayout(0, 0));
		add(getPanel());
	}

	public void listenTo(OnProfesorFormActionTriggered listener) {
		this.listener = listener;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Nombre");
			lblName.setFont(Constants.getLabelFont());
		}

		return lblName;
	}

	private JLabel getLblProfesorCategory() {
		if (lblProfesorCategory == null) {
			lblProfesorCategory = new JLabel("Categor\u00EDa");
			lblProfesorCategory.setFont(Constants.getLabelFont());
		}
		return lblProfesorCategory;
	}

	private JLabel getLblCategoraCientfica() {
		if (lblCategoraCientfica == null) {
			lblCategoraCientfica = new JLabel("Categor\u00EDa cient\u00EDfica");
			lblCategoraCientfica.setFont(Constants.getLabelFont());
		}
		return lblCategoraCientfica;
	}

	private JLabel getLblTemaDeInvestigacin() {
		if (lblTemaDeInvestigacin == null) {
			lblTemaDeInvestigacin = new JLabel("Tema de investigaci\u00F3n");
			lblTemaDeInvestigacin.setFont(Constants.getLabelFont());
		}
		return lblTemaDeInvestigacin;
	}

	private JComboBox<String> getComboBoxProfesorCategory() {
		if (comboBoxProfesorCategory == null) {
			comboBoxProfesorCategory = new JComboBox<>();
			comboBoxProfesorCategory.setFont(Constants.getLabelFont());
			comboBoxProfesorCategory.setModel(new DefaultComboBoxModel<>(new String[] {"Instructor", "Asistente", "Auxiliar", "Titular"}));
			comboBoxProfesorCategory.setSelectedIndex(0);

			if (profesor != null) {
				int index;

				switch (profesor.getCategory()) {
				case Instructor:
					index = 0;
					break;
				case Assistant:
					index = 1;
					break;
				case Auxiliar:
					index = 2;
					break;
				case Permanent:
				default:
					index = 3;
					break;
				}

				comboBoxProfesorCategory.setSelectedIndex(index);
			}
		}
		return comboBoxProfesorCategory;
	}

	private JComboBox<String> getComboBoxDegree() {
		if (comboBoxDegree == null) {
			comboBoxDegree = new JComboBox<>();
			comboBoxDegree.setFont(Constants.getLabelFont());
			comboBoxDegree.setModel(new DefaultComboBoxModel<>(new String[] {"Ninguna", "M\u00E1ster", "Doctor"}));
			comboBoxDegree.setSelectedIndex(0);

			if (profesor != null) {
				int index;

				if (profesor.getDegree() == null) {
					index = 0;
				} else {
					switch (profesor.getDegree()) {
					case Master:
						index = 1;
						break;
					case Doctor:
					default:
						index = 2;
						break;
					}
				}

				comboBoxDegree.setSelectedIndex(index);
			}
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
			break;
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
		errorLabel.setVisible(false);
		textFieldName.setText("");

		if (researchMatterComboBox.getModel().getSize() >= 0) {
			researchMatterComboBox.setSelectedIndex(0);
		} else {
			researchMatterComboBox.setSelectedIndex(-1);
		}

		comboBoxProfesorCategory.setSelectedIndex(0);
		comboBoxDegree.setSelectedIndex(0);
	}

	private void submit() {
		if (Validation.notEmpty(textFieldName.getText())) {
			String name = textFieldName.getText();
			Degree degree = getDegree();
			ProfesorCategory category = getCategory();
			String matter = getMatter();

			if (profesor == null) {	
				resetForm();
			}

			if (listener != null) {
				listener.actionPerformed(new ProfesorFormData(name, matter, degree, category));
			}

			errorLabel.setVisible(false);
		} else {
			errorLabel.setVisible(true);
		}
	}

	private void hasChanges() {		
		
		btnSubmit.setEnabled(true);
		
	}

	private JButton getBtnSubmit() {
		if (btnSubmit == null) {
			btnSubmit = new JButton(profesor != null ? "Actualizar" : "Registrar  profesor");
			btnSubmit.setForeground(Constants.getFormBtnForeground());
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					submit();
				}
			});
			btnSubmit.setBackground(Constants.getInsertionBtnColor());
			btnSubmit.setFont(new Font("Segoe UI", Font.BOLD, 15));
		}

		return btnSubmit;
	}

	public void setResearchMatters(String[] matters) {
		this.researchMatters = matters;
		researchMatterComboBox.setModel(new DefaultComboBoxModel<>(matters));

		if (profesor != null) {
			researchMatterComboBox.setSelectedItem(profesor.getMatter());
		}
	}

	private JComboBox<String> getResearchMatterComboBox() {
		if (researchMatterComboBox == null) {
			researchMatterComboBox = new JComboBox<>();
			researchMatterComboBox.setFont(Constants.getLabelFont());

			setResearchMatters(researchMatters);
		}

		return researchMatterComboBox;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{400, 0};
			gbl_panel.rowHeights = new int[]{29, 35, 50, 0, 35, 50, 0, 35, 50, 0, 35, 50, 35, 0};
			gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};

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

			GridBagConstraints gbc_lblProfesorCategory = new GridBagConstraints();
			gbc_lblProfesorCategory.anchor = GridBagConstraints.WEST;
			gbc_lblProfesorCategory.insets = new Insets(0, 0, 5, 0);
			gbc_lblProfesorCategory.gridx = 0;
			gbc_lblProfesorCategory.gridy = 3;

			panel.add(getLblProfesorCategory(), gbc_lblProfesorCategory);

			GridBagConstraints gbc_comboBoxProfesorCategory = new GridBagConstraints();
			gbc_comboBoxProfesorCategory.fill = GridBagConstraints.BOTH;
			gbc_comboBoxProfesorCategory.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxProfesorCategory.gridx = 0;
			gbc_comboBoxProfesorCategory.gridy = 4;

			panel.add(getComboBoxProfesorCategory(), gbc_comboBoxProfesorCategory);

			GridBagConstraints gbc_lblCategoraCientfica = new GridBagConstraints();
			gbc_lblCategoraCientfica.anchor = GridBagConstraints.WEST;
			gbc_lblCategoraCientfica.insets = new Insets(0, 0, 5, 0);
			gbc_lblCategoraCientfica.gridx = 0;
			gbc_lblCategoraCientfica.gridy = 6;

			panel.add(getLblCategoraCientfica(), gbc_lblCategoraCientfica);

			GridBagConstraints gbc_comboBoxDegree = new GridBagConstraints();
			gbc_comboBoxDegree.fill = GridBagConstraints.BOTH;
			gbc_comboBoxDegree.insets = new Insets(0, 0, 5, 0);
			gbc_comboBoxDegree.gridx = 0;
			gbc_comboBoxDegree.gridy = 7;

			panel.add(getComboBoxDegree(), gbc_comboBoxDegree);

			GridBagConstraints gbc_lblTemaDeInvestigacin = new GridBagConstraints();
			gbc_lblTemaDeInvestigacin.anchor = GridBagConstraints.WEST;
			gbc_lblTemaDeInvestigacin.insets = new Insets(0, 0, 5, 0);
			gbc_lblTemaDeInvestigacin.gridx = 0;
			gbc_lblTemaDeInvestigacin.gridy = 9;

			panel.add(getLblTemaDeInvestigacin(), gbc_lblTemaDeInvestigacin);

			GridBagConstraints gbc_researchMatterComboBox = new GridBagConstraints();
			gbc_researchMatterComboBox.fill = GridBagConstraints.BOTH;
			gbc_researchMatterComboBox.insets = new Insets(0, 0, 5, 0);
			gbc_researchMatterComboBox.gridx = 0;
			gbc_researchMatterComboBox.gridy = 10;

			panel.add(getResearchMatterComboBox(), gbc_researchMatterComboBox);

			GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
			gbc_btnSubmit.fill = GridBagConstraints.VERTICAL;
			gbc_btnSubmit.anchor = GridBagConstraints.NORTHEAST;
			gbc_btnSubmit.gridx = 0;
			gbc_btnSubmit.gridy = 12;

			panel.add(getBtnSubmit(), gbc_btnSubmit);
			btnSubmit.setEnabled(false);;			
		}

		return panel;
	}

	private JTextField getTextFieldName() {
		if (textFieldName == null) {
			textFieldName = new JTextField();
			textFieldName.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					hasChanges();
				}
			});
			textFieldName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textFieldName.setColumns(10);

			if (profesor != null) {
				textFieldName.setText(profesor.getName());
			}
		}

		return textFieldName;
	}

	private ErrorLabel getErrorLabel() {
		if (errorLabel == null) {
			errorLabel = new ErrorLabel();
			errorLabel.setVerticalAlignment(SwingConstants.TOP);
			errorLabel.setText("El nombre es requerido");
			errorLabel.setVisible(false);
		}

		return errorLabel;
	}
}
