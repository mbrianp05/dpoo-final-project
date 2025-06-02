package gui.views;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import schooling.Faculty;
import schooling.Profesor;
import schooling.ResearchLine;
import utils.ArrayLib;
import utils.Validation;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import gui.component.ErrorLabel;
import gui.event.OnAddedResearchLine;
import gui.component.TemporaryMessage;

public class ResearchLinesFormView extends JPanel {
	private static final long serialVersionUID = 3971105665570208468L;
	private Faculty faculty;
	private OnAddedResearchLine listener;
	
	private JLabel lblAgregarLneaDe;
	private JLabel lblNombre;
	private JTextField textFieldName;
	private JLabel lblProfesor;
	private JComboBox<String> chiefCombox;
	private JLabel lblMaestra;
	private JLabel lblCrditoNecesario;
	private JSpinner minCreditsSpinner;
	private JLabel lblTemas;
	private JLabel lblAgregarTema;
	private JTextField textFieldMatterName;
	private JButton button;
	private JButton btnNewButton;
	private JLabel lblMatterNames;
	
	private ArrayList<String> matters;
	private ErrorLabel errorLabel;
	private ErrorLabel errorName;
	private TemporaryMessage temporaryMessage;
	
	public ResearchLinesFormView(Faculty faculty) {
		this.faculty = faculty;
		matters = new ArrayList<>();
		
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 50, 288, 50, 0, 0};
		gridBagLayout.rowHeights = new int[]{30, 45, 50, 0, 30, 50, 0, 30, 50, 30, 30, 50, 0, 30, 50, 30, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_temporaryMessage = new GridBagConstraints();
		gbc_temporaryMessage.fill = GridBagConstraints.HORIZONTAL;
		gbc_temporaryMessage.gridwidth = 4;
		gbc_temporaryMessage.insets = new Insets(0, 0, 5, 5);
		gbc_temporaryMessage.gridx = 1;
		gbc_temporaryMessage.gridy = 0;
		add(getTemporaryMessage(), gbc_temporaryMessage);
		GridBagConstraints gbc_lblAgregarLneaDe = new GridBagConstraints();
		gbc_lblAgregarLneaDe.gridwidth = 4;
		gbc_lblAgregarLneaDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblAgregarLneaDe.fill = GridBagConstraints.BOTH;
		gbc_lblAgregarLneaDe.gridx = 1;
		gbc_lblAgregarLneaDe.gridy = 1;
		add(getLblAgregarLneaDe(), gbc_lblAgregarLneaDe);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.gridwidth = 4;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		add(getLblNombre(), gbc_lblNombre);
		GridBagConstraints gbc_textFieldName = new GridBagConstraints();
		gbc_textFieldName.gridwidth = 4;
		gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldName.fill = GridBagConstraints.BOTH;
		gbc_textFieldName.gridx = 1;
		gbc_textFieldName.gridy = 4;
		add(getTextFieldName(), gbc_textFieldName);
		GridBagConstraints gbc_errorName = new GridBagConstraints();
		gbc_errorName.anchor = GridBagConstraints.NORTHWEST;
		gbc_errorName.gridwidth = 3;
		gbc_errorName.insets = new Insets(0, 0, 5, 5);
		gbc_errorName.gridx = 1;
		gbc_errorName.gridy = 5;
		add(getErrorName(), gbc_errorName);
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.gridwidth = 4;
		gbc_lblProfesor.fill = GridBagConstraints.BOTH;
		gbc_lblProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesor.gridx = 1;
		gbc_lblProfesor.gridy = 6;
		add(getLblProfesor(), gbc_lblProfesor);
		GridBagConstraints gbc_chiefCombox = new GridBagConstraints();
		gbc_chiefCombox.gridwidth = 4;
		gbc_chiefCombox.insets = new Insets(0, 0, 5, 5);
		gbc_chiefCombox.fill = GridBagConstraints.BOTH;
		gbc_chiefCombox.gridx = 1;
		gbc_chiefCombox.gridy = 7;
		add(getChiefCombox(), gbc_chiefCombox);
		GridBagConstraints gbc_lblTemas = new GridBagConstraints();
		gbc_lblTemas.fill = GridBagConstraints.BOTH;
		gbc_lblTemas.insets = new Insets(0, 0, 5, 5);
		gbc_lblTemas.gridx = 1;
		gbc_lblTemas.gridy = 9;
		add(getLblTemas(), gbc_lblTemas);
		GridBagConstraints gbc_lblMatterNames = new GridBagConstraints();
		gbc_lblMatterNames.fill = GridBagConstraints.BOTH;
		gbc_lblMatterNames.gridwidth = 2;
		gbc_lblMatterNames.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatterNames.gridx = 2;
		gbc_lblMatterNames.gridy = 9;
		add(getLblMatterNames(), gbc_lblMatterNames);
		GridBagConstraints gbc_lblAgregarTema = new GridBagConstraints();
		gbc_lblAgregarTema.anchor = GridBagConstraints.EAST;
		gbc_lblAgregarTema.fill = GridBagConstraints.BOTH;
		gbc_lblAgregarTema.insets = new Insets(0, 0, 5, 5);
		gbc_lblAgregarTema.gridx = 1;
		gbc_lblAgregarTema.gridy = 10;
		add(getLblAgregarTema(), gbc_lblAgregarTema);
		GridBagConstraints gbc_textFieldMatterName = new GridBagConstraints();
		gbc_textFieldMatterName.gridwidth = 2;
		gbc_textFieldMatterName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMatterName.fill = GridBagConstraints.BOTH;
		gbc_textFieldMatterName.gridx = 2;
		gbc_textFieldMatterName.gridy = 10;
		add(getTextFieldMatterName(), gbc_textFieldMatterName);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 10;
		add(getButton(), gbc_button);
		GridBagConstraints gbc_errorLabel = new GridBagConstraints();
		gbc_errorLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_errorLabel.gridwidth = 2;
		gbc_errorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_errorLabel.gridx = 2;
		gbc_errorLabel.gridy = 11;
		add(getErrorLabel(), gbc_errorLabel);
		GridBagConstraints gbc_lblMaestra = new GridBagConstraints();
		gbc_lblMaestra.gridwidth = 4;
		gbc_lblMaestra.fill = GridBagConstraints.BOTH;
		gbc_lblMaestra.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaestra.gridx = 1;
		gbc_lblMaestra.gridy = 12;
		add(getLblMaestra(), gbc_lblMaestra);
		GridBagConstraints gbc_lblCrditoNecesario = new GridBagConstraints();
		gbc_lblCrditoNecesario.fill = GridBagConstraints.BOTH;
		gbc_lblCrditoNecesario.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrditoNecesario.gridx = 1;
		gbc_lblCrditoNecesario.gridy = 13;
		add(getLblCrditoNecesario(), gbc_lblCrditoNecesario);
		GridBagConstraints gbc_minCreditsSpinner = new GridBagConstraints();
		gbc_minCreditsSpinner.fill = GridBagConstraints.BOTH;
		gbc_minCreditsSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_minCreditsSpinner.gridx = 2;
		gbc_minCreditsSpinner.gridy = 13;
		add(getMinCreditsSpinner(), gbc_minCreditsSpinner);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 15;
		add(getBtnNewButton(), gbc_btnNewButton);
	}

	public void listenTo(OnAddedResearchLine listener) {
		this.listener = listener;
	}
	
	private JLabel getLblAgregarLneaDe() {
		if (lblAgregarLneaDe == null) {
			lblAgregarLneaDe = new JLabel("Agregar l\u00EDnea de investigaci\u00F3n");
			lblAgregarLneaDe.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		}
		return lblAgregarLneaDe;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblNombre;
	}
	private JTextField getTextFieldName() {
		if (textFieldName == null) {
			textFieldName = new JTextField();
			textFieldName.setColumns(10);
		}
		return textFieldName;
	}
	private JLabel getLblProfesor() {
		if (lblProfesor == null) {
			lblProfesor = new JLabel("Profesor");
			lblProfesor.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblProfesor;
	}

	public void fetchProfesors() {
		ArrayList<Profesor> profesors = faculty.getProfesors();
		String[] names = new String[profesors.size()];
		
		for (int i = 0; i < profesors.size(); i++) {
			names[i] = profesors.get(i).getName();
		}
		
		chiefCombox.setModel(new DefaultComboBoxModel<>(names));
	}
	
	private JComboBox<String> getChiefCombox() {
		if (chiefCombox == null) {
			chiefCombox = new JComboBox<String>();
			fetchProfesors();
		}
		return chiefCombox;
	}
	private JLabel getLblMaestra() {
		if (lblMaestra == null) {
			lblMaestra = new JLabel("Maestr\u00EDa");
			lblMaestra.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblMaestra;
	}
	private JLabel getLblCrditoNecesario() {
		if (lblCrditoNecesario == null) {
			lblCrditoNecesario = new JLabel("Cr\u00E9dito necesario");
			lblCrditoNecesario.setForeground(Color.DARK_GRAY);
			lblCrditoNecesario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		}
		return lblCrditoNecesario;
	}
	private JSpinner getMinCreditsSpinner() {
		if (minCreditsSpinner == null) {
			minCreditsSpinner = new JSpinner();
			minCreditsSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		}
		return minCreditsSpinner;
	}
	private JLabel getLblTemas() {
		if (lblTemas == null) {
			lblTemas = new JLabel("Temas");
			lblTemas.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblTemas;
	}
	private JLabel getLblAgregarTema() {
		if (lblAgregarTema == null) {
			lblAgregarTema = new JLabel("Agregar tema");
			lblAgregarTema.setForeground(Color.DARK_GRAY);
			lblAgregarTema.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		}
		return lblAgregarTema;
	}
	private JTextField getTextFieldMatterName() {
		if (textFieldMatterName == null) {
			textFieldMatterName = new JTextField();
			textFieldMatterName.setColumns(10);
		}
		return textFieldMatterName;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("+");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!textFieldMatterName.getText().trim().isEmpty()) {
						errorLabel.setText("");
						
						matters.add(textFieldMatterName.getText());
						textFieldMatterName.setText("");
						lblMatterNames.setText(ArrayLib.join(matters));
					} else {
						errorLabel.setText("El tema no puede estar vacío");
					}
				}
			});
			button.setBackground(Color.WHITE);
		}
		return button;
	}
	
	public Profesor getChief() {
		int index = chiefCombox.getSelectedIndex();
		
		return faculty.getProfesors().get(index);
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Agregar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (Validation.notEmpty(textFieldName.getText())) {
						errorName.setText("");
						
						if (matters.size() > 0) {
							try {
								String name = faculty.addResearchLine(textFieldName.getText(), getChief(), (int)minCreditsSpinner.getValue());
								ResearchLine line = faculty.findResearchLine(name);
								
								for (String matter : matters) {
									line.addMatter(matter);
								}
								
								if (listener != null) {
									listener.added(textFieldName.getText());
								}
								
								resetForm();
								temporaryMessage.setText("La línea de invetigación se ha registrado correctamente");
								temporaryMessage.appear();
							} catch (Exception e) {
								// TODO: handle exception
							}
						} else {
							errorLabel.setText("Debe existir al menos un tema de investigación");
						}
					} else {
						errorName.setText("El nombre no puede estar vacío");
					}
				}
			});
			btnNewButton.setBackground(Color.WHITE);
		}
		return btnNewButton;
	}
	private JLabel getLblMatterNames() {
		if (lblMatterNames == null) {
			lblMatterNames = new JLabel("");
			lblMatterNames.setForeground(Color.DARK_GRAY);
			lblMatterNames.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		}
		return lblMatterNames;
	}
	private ErrorLabel getErrorLabel() {
		if (errorLabel == null) {
			errorLabel = new ErrorLabel();
			errorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		}
		return errorLabel;
	}
	private ErrorLabel getErrorName() {
		if (errorName == null) {
			errorName = new ErrorLabel();
			errorName.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		}
		return errorName;
	}
	
	private void resetForm() {
		matters.clear();
		minCreditsSpinner.setValue(1);
		textFieldName.setText("");
		lblMatterNames.setText("");
		chiefCombox.setSelectedIndex(-1);
	}
	private TemporaryMessage getTemporaryMessage() {
		if (temporaryMessage == null) {
			temporaryMessage = new TemporaryMessage();
		}
		return temporaryMessage;
	}
}
