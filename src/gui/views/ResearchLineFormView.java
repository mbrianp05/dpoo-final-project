package gui.views;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import schooling.Faculty;
import schooling.Profesor;
import schooling.ResearchLine;
import schooling.ResearchMatter;
import utils.Constants;
import utils.EnumsDictionary;
import utils.Validation;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import gui.component.ErrorLabel;
import gui.event.OnAddedInput;
import gui.event.OnAddedResearchLine;
import gui.event.OnDeletedInput;
import gui.event.OnSetChief;
import gui.reasearchline.AddChiefJDialog;
import gui.researchers.ProfesorFormData;

import java.awt.CardLayout;

import gui.component.MultipleInput;

public class ResearchLineFormView extends JPanel {
	private static final long serialVersionUID = 3971105665570208468L;
	private Faculty faculty;
	private OnAddedResearchLine listener;

	private ProfesorFormData chief;

	private JLabel lblAgregarLneaDe;
	private JLabel lblNombre;
	private JTextField textFieldName;
	private JLabel lblMaestra;
	private JLabel lblCrditoNecesario;
	private JSpinner minCreditsSpinner;
	private JButton btnNewButton;

	private ErrorLabel errorLabel;
	private ErrorLabel errorName;
	private JLabel lblJefeDeLa;
	private JButton btnSetChief;
	private JLabel lblChiefWarning;
	private JPanel panelWrapper;
	private JPanel addChiefForm;
	private JPanel changeChief;
	private ErrorLabel lblNoChiefError;
	private JLabel lblChiefName;
	private JLabel lblChiefDegree;
	private JLabel lblChiefMatter;
	private JLabel lblChiefCat;
	private ErrorLabel lblCreditsError;
	private JLabel lblChiefData;
	private JButton btnEditChief;
	private JLabel lblNombre_1;
	private JLabel lblCategoraCientfica;
	private JLabel lblCategora;
	private JLabel lblMateria;
	private MultipleInput multipleInput;

	public ResearchLineFormView(Faculty faculty) {
		this.faculty = faculty;
		chief = null;

		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 0, 75, 288, 50, 100, 0};
		gridBagLayout.rowHeights = new int[]{70, 45, 60, 0, 35, 35, 0, 35, 0, 35, 35, 0, 35, 50, 40, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
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
		gbc_errorName.gridwidth = 4;
		gbc_errorName.anchor = GridBagConstraints.NORTHWEST;
		gbc_errorName.insets = new Insets(0, 0, 5, 5);
		gbc_errorName.gridx = 1;
		gbc_errorName.gridy = 5;
		add(getErrorName(), gbc_errorName);
		GridBagConstraints gbc_multipleInput = new GridBagConstraints();
		gbc_multipleInput.gridwidth = 4;
		gbc_multipleInput.insets = new Insets(0, 0, 5, 5);
		gbc_multipleInput.fill = GridBagConstraints.BOTH;
		gbc_multipleInput.gridx = 1;
		gbc_multipleInput.gridy = 6;
		add(getMultipleInput(), gbc_multipleInput);
		GridBagConstraints gbc_lblChiefData = new GridBagConstraints();
		gbc_lblChiefData.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblChiefData.anchor = GridBagConstraints.SOUTH;
		gbc_lblChiefData.insets = new Insets(0, 0, 5, 5);
		gbc_lblChiefData.gridx = 1;
		gbc_lblChiefData.gridy = 7;
		add(getLblChiefData(), gbc_lblChiefData);
		GridBagConstraints gbc_errorLabel = new GridBagConstraints();
		gbc_errorLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_errorLabel.gridwidth = 2;
		gbc_errorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_errorLabel.gridx = 2;
		gbc_errorLabel.gridy = 7;
		add(getErrorLabel(), gbc_errorLabel);
		GridBagConstraints gbc_panelWrapper = new GridBagConstraints();
		gbc_panelWrapper.gridwidth = 4;
		gbc_panelWrapper.gridheight = 2;
		gbc_panelWrapper.insets = new Insets(0, 0, 5, 5);
		gbc_panelWrapper.fill = GridBagConstraints.BOTH;
		gbc_panelWrapper.gridx = 1;
		gbc_panelWrapper.gridy = 8;
		add(getPanelWrapper(), gbc_panelWrapper);
		GridBagConstraints gbc_btnEditChief = new GridBagConstraints();
		gbc_btnEditChief.anchor = GridBagConstraints.EAST;
		gbc_btnEditChief.fill = GridBagConstraints.VERTICAL;
		gbc_btnEditChief.gridwidth = 2;
		gbc_btnEditChief.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditChief.gridx = 3;
		gbc_btnEditChief.gridy = 10;
		add(getBtnEditChief(), gbc_btnEditChief);
		GridBagConstraints gbc_lblMaestra = new GridBagConstraints();
		gbc_lblMaestra.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMaestra.anchor = GridBagConstraints.SOUTH;
		gbc_lblMaestra.gridwidth = 2;
		gbc_lblMaestra.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaestra.gridx = 1;
		gbc_lblMaestra.gridy = 11;
		add(getLblMaestra(), gbc_lblMaestra);
		GridBagConstraints gbc_lblCrditoNecesario = new GridBagConstraints();
		gbc_lblCrditoNecesario.fill = GridBagConstraints.BOTH;
		gbc_lblCrditoNecesario.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrditoNecesario.gridx = 1;
		gbc_lblCrditoNecesario.gridy = 12;
		add(getLblCrditoNecesario(), gbc_lblCrditoNecesario);
		GridBagConstraints gbc_minCreditsSpinner = new GridBagConstraints();
		gbc_minCreditsSpinner.fill = GridBagConstraints.BOTH;
		gbc_minCreditsSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_minCreditsSpinner.gridx = 2;
		gbc_minCreditsSpinner.gridy = 12;
		add(getMinCreditsSpinner(), gbc_minCreditsSpinner);
		GridBagConstraints gbc_lblCreditsError = new GridBagConstraints();
		gbc_lblCreditsError.gridwidth = 2;
		gbc_lblCreditsError.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreditsError.gridx = 1;
		gbc_lblCreditsError.gridy = 13;
		add(getLblCreditsError(), gbc_lblCreditsError);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 14;
		add(getBtnNewButton(), gbc_btnNewButton);
	}

	public void listenTo(OnAddedResearchLine listener) {
		this.listener = listener;
	}

	private JLabel getLblAgregarLneaDe() {
		if (lblAgregarLneaDe == null) {
			lblAgregarLneaDe = new JLabel("Agregar l\u00EDnea de investigaci\u00F3n");
			lblAgregarLneaDe.setFont(Constants.getTitleFont());
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
			textFieldName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textFieldName.setColumns(10);
		}
		return textFieldName;
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
			minCreditsSpinner.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			minCreditsSpinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		}
		return minCreditsSpinner;
	}

	public Profesor registerChief() {
		int id = faculty.addProfesor(chief.getName(), chief.getDegree(), chief.getCategory(), null);
		
		return (Profesor)faculty.findResearcher(id);
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Agregar");
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (Validation.notEmpty(textFieldName.getText())) {
						errorName.setText("");
						if (multipleInput.amountOfItems() > 0) {
							if (chief != null) {
								lblNoChiefError.setVisible(false);

								if ((int)minCreditsSpinner.getValue() > 0) {		
									lblCreditsError.setText("");
									errorLabel.setText("");
									
									Profesor chiefProfesor = registerChief();
									String name = faculty.addResearchLine(textFieldName.getText(), chiefProfesor, (int)minCreditsSpinner.getValue());
									ResearchLine line = faculty.findResearchLine(name);

									for (String matter : multipleInput.getValues()) {
										line.addMatter(matter);
									}

									if (listener != null) {
										listener.added(textFieldName.getText());
									}

									ResearchMatter chiefResearchMatter = faculty.findResearchMatter(chief.getMatter());
									chiefResearchMatter.addResearcher(chiefProfesor);
									
									JOptionPane.showMessageDialog(null, "¡Se ha registrado la línea correctamente!", "Mensaje", JOptionPane.PLAIN_MESSAGE);

									resetForm();
								} else {
									lblCreditsError.setText("Todos los planes de maestría deben exigir al menos 1 crédito");
								}
							} else {
								lblNoChiefError.setVisible(true);
							}
						} else {
							errorLabel.setText("Debe existir al menos un tema de investigación");
						}
					} else {
						errorName.setText("El nombre no puede estar vacío");
					}
				}
			});
			btnNewButton.setBackground(Constants.getInsertionBtnColor());
		}
		return btnNewButton;
	}

	private ErrorLabel getErrorLabel() {
		if (errorLabel == null) {
			errorLabel = new ErrorLabel();
			errorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		}
		return errorLabel;
	}

	private void resetForm() {
		textFieldName.setText("");
		minCreditsSpinner.setValue(1);
		multipleInput.reset();
		chief = null;

		switchPanel("Add Chief");

		btnEditChief.setVisible(false);
		lblChiefData.setVisible(false);
	}

	private ErrorLabel getErrorName() {
		if (errorName == null) {
			errorName = new ErrorLabel();
		}
		return errorName;
	}

	private JLabel getLblJefeDeLa() {
		if (lblJefeDeLa == null) {
			lblJefeDeLa = new JLabel("Jefe de la l\u00EDnea");
			lblJefeDeLa.setFont(Constants.getLabelFont());
		}
		return lblJefeDeLa;
	}

	private void openChiefDialog() {
		try {
			AddChiefJDialog dialog = new AddChiefJDialog(multipleInput.getValues(), new OnSetChief() {
				@Override
				public void set(ProfesorFormData data) {
					chief = data;
					switchPanel("Change Chief");

					lblChiefData.setVisible(true);
					btnEditChief.setVisible(true);

					lblChiefName.setText(data.getName());
					lblChiefDegree.setText(EnumsDictionary.degree(data.getDegree()));
					lblChiefCat.setText(EnumsDictionary.category(data.getCategory()));
					lblChiefMatter.setText(data.getMatter());
				}
			}, chief);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JButton getBtnSetChief() {
		if (btnSetChief == null) {
			btnSetChief = new JButton("Insertar datos del docente");
			btnSetChief.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					openChiefDialog();
				}
			});
			btnSetChief.setEnabled(false);
			btnSetChief.setFont(Constants.getLabelFont());
			btnSetChief.setBackground(Color.WHITE);
		}
		return btnSetChief;
	}
	private JLabel getLblChiefWarning() {
		if (lblChiefWarning == null) {
			lblChiefWarning = new JLabel("*A\u00F1ade al menos un tema de investigaci\u00F3n");
			lblChiefWarning.setForeground(Color.DARK_GRAY);
			lblChiefWarning.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		}
		return lblChiefWarning;
	}
	private JPanel getPanelWrapper() {
		if (panelWrapper == null) {
			panelWrapper = new JPanel();
			panelWrapper.setBackground(Color.WHITE);
			panelWrapper.setLayout(new CardLayout(0, 0));
			panelWrapper.add(getAddChiefForm(), "Add Chief");
			panelWrapper.add(getChangeChief(), "Change Chief");
		}
		return panelWrapper;
	}
	private JPanel getAddChiefForm() {
		if (addChiefForm == null) {
			addChiefForm = new JPanel();
			addChiefForm.setBackground(Color.WHITE);
			GridBagLayout gbl_addChiefForm = new GridBagLayout();
			gbl_addChiefForm.columnWidths = new int[]{0, 0, 0};
			gbl_addChiefForm.rowHeights = new int[]{0, 30, 30, 0};
			gbl_addChiefForm.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_addChiefForm.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			addChiefForm.setLayout(gbl_addChiefForm);
			GridBagConstraints gbc_lblJefeDeLa = new GridBagConstraints();
			gbc_lblJefeDeLa.fill = GridBagConstraints.BOTH;
			gbc_lblJefeDeLa.insets = new Insets(0, 0, 5, 5);
			gbc_lblJefeDeLa.gridx = 0;
			gbc_lblJefeDeLa.gridy = 0;
			addChiefForm.add(getLblJefeDeLa(), gbc_lblJefeDeLa);
			GridBagConstraints gbc_btnSetChief = new GridBagConstraints();
			gbc_btnSetChief.fill = GridBagConstraints.BOTH;
			gbc_btnSetChief.insets = new Insets(0, 0, 5, 0);
			gbc_btnSetChief.gridx = 1;
			gbc_btnSetChief.gridy = 0;
			addChiefForm.add(getBtnSetChief(), gbc_btnSetChief);
			GridBagConstraints gbc_lblChiefWarning = new GridBagConstraints();
			gbc_lblChiefWarning.fill = GridBagConstraints.BOTH;
			gbc_lblChiefWarning.insets = new Insets(0, 0, 5, 0);
			gbc_lblChiefWarning.gridx = 1;
			gbc_lblChiefWarning.gridy = 1;
			addChiefForm.add(getLblChiefWarning(), gbc_lblChiefWarning);
			GridBagConstraints gbc_lblNoChiefError = new GridBagConstraints();
			gbc_lblNoChiefError.gridwidth = 2;
			gbc_lblNoChiefError.anchor = GridBagConstraints.NORTH;
			gbc_lblNoChiefError.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNoChiefError.weighty = 1.0;
			gbc_lblNoChiefError.gridx = 0;
			gbc_lblNoChiefError.gridy = 2;
			addChiefForm.add(getLblNoChiefError(), gbc_lblNoChiefError);
		}
		return addChiefForm;
	}
	private JPanel getChangeChief() {
		if (changeChief == null) {
			changeChief = new JPanel();
			changeChief.setForeground(new Color(0, 0, 0));
			changeChief.setBackground(new Color(204, 255, 255));
			GridBagLayout gbl_changeChief = new GridBagLayout();
			gbl_changeChief.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_changeChief.rowHeights = new int[]{0, 0, 30, 0};
			gbl_changeChief.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_changeChief.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
			changeChief.setLayout(gbl_changeChief);
			GridBagConstraints gbc_lblNombre_1 = new GridBagConstraints();
			gbc_lblNombre_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre_1.gridx = 0;
			gbc_lblNombre_1.gridy = 1;
			changeChief.add(getLblNombre_1(), gbc_lblNombre_1);
			GridBagConstraints gbc_lblCategoraCientfica = new GridBagConstraints();
			gbc_lblCategoraCientfica.insets = new Insets(0, 0, 5, 5);
			gbc_lblCategoraCientfica.gridx = 1;
			gbc_lblCategoraCientfica.gridy = 1;
			changeChief.add(getLblCategoraCientfica(), gbc_lblCategoraCientfica);
			GridBagConstraints gbc_lblCategora = new GridBagConstraints();
			gbc_lblCategora.insets = new Insets(0, 0, 5, 5);
			gbc_lblCategora.gridx = 2;
			gbc_lblCategora.gridy = 1;
			changeChief.add(getLblCategora(), gbc_lblCategora);
			GridBagConstraints gbc_lblMateria = new GridBagConstraints();
			gbc_lblMateria.insets = new Insets(0, 0, 5, 0);
			gbc_lblMateria.gridx = 3;
			gbc_lblMateria.gridy = 1;
			changeChief.add(getLblMateria(), gbc_lblMateria);
			GridBagConstraints gbc_lblChiefName = new GridBagConstraints();
			gbc_lblChiefName.insets = new Insets(0, 0, 0, 5);
			gbc_lblChiefName.gridx = 0;
			gbc_lblChiefName.gridy = 2;
			changeChief.add(getLblChiefName(), gbc_lblChiefName);
			GridBagConstraints gbc_lblChiefDegree = new GridBagConstraints();
			gbc_lblChiefDegree.insets = new Insets(0, 0, 0, 5);
			gbc_lblChiefDegree.gridx = 1;
			gbc_lblChiefDegree.gridy = 2;
			changeChief.add(getLblChiefDegree(), gbc_lblChiefDegree);
			GridBagConstraints gbc_lblChiefCat = new GridBagConstraints();
			gbc_lblChiefCat.insets = new Insets(0, 0, 0, 5);
			gbc_lblChiefCat.gridx = 2;
			gbc_lblChiefCat.gridy = 2;
			changeChief.add(getLblChiefCat(), gbc_lblChiefCat);
			GridBagConstraints gbc_lblChiefMatter = new GridBagConstraints();
			gbc_lblChiefMatter.gridx = 3;
			gbc_lblChiefMatter.gridy = 2;
			changeChief.add(getLblChiefMatter(), gbc_lblChiefMatter);
		}
		return changeChief;
	}
	
	private ErrorLabel getLblNoChiefError() {
		if (lblNoChiefError == null) {
			lblNoChiefError = new ErrorLabel();
			lblNoChiefError.setVisible(false);
			lblNoChiefError.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			lblNoChiefError.setText("Agrega al profesor responsable");
		}
		return lblNoChiefError;
	}
	
	private JLabel getLblChiefName() {
		if (lblChiefName == null) {
			lblChiefName = new JLabel("");
			lblChiefName.setToolTipText("Nombre");
			lblChiefName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblChiefName;
	}
	
	private JLabel getLblChiefDegree() {
		if (lblChiefDegree == null) {
			lblChiefDegree = new JLabel("");
			lblChiefDegree.setToolTipText("Categor\u00EDa cient\u00EDfica");
			lblChiefDegree.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblChiefDegree;
	}
	
	private JLabel getLblChiefMatter() {
		if (lblChiefMatter == null) {
			lblChiefMatter = new JLabel("");
			lblChiefMatter.setToolTipText("Materia de investigacion");
			lblChiefMatter.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblChiefMatter;
	}
	
	private JLabel getLblChiefCat() {
		if (lblChiefCat == null) {
			lblChiefCat = new JLabel("");
			lblChiefCat.setToolTipText("Categor\u00EDa");
			lblChiefCat.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblChiefCat;
	}
	
	private ErrorLabel getLblCreditsError() {
		if (lblCreditsError == null) {
			lblCreditsError = new ErrorLabel();
		}
		return lblCreditsError;
	}
	
	private JLabel getLblChiefData() {
		if (lblChiefData == null) {
			lblChiefData = new JLabel("Datos del jefe");
			lblChiefData.setFont(Constants.getLabelFont());
			lblChiefData.setVisible(false);
		}
		return lblChiefData;
	}
	
	private JButton getBtnEditChief() {
		if (btnEditChief == null) {
			btnEditChief = new JButton("Editar");
			btnEditChief.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					openChiefDialog();
				}
			});
			btnEditChief.setBackground(Color.WHITE);
			btnEditChief.setFont(Constants.getLabelFont());
			btnEditChief.setVisible(false);
		}
		return btnEditChief;
	}
	
	private JLabel getLblNombre_1() {
		if (lblNombre_1 == null) {
			lblNombre_1 = new JLabel("Nombre");
			lblNombre_1.setToolTipText("Nombre");
			lblNombre_1.setFont(Constants.getLabelFont());
		}
		return lblNombre_1;
	}
	
	private JLabel getLblCategoraCientfica() {
		if (lblCategoraCientfica == null) {
			lblCategoraCientfica = new JLabel("Categor\u00EDa cient\u00EDfica");
			lblCategoraCientfica.setToolTipText("Nombre");
			lblCategoraCientfica.setFont(Constants.getLabelFont());
		}
		return lblCategoraCientfica;
	}
	
	private JLabel getLblCategora() {
		if (lblCategora == null) {
			lblCategora = new JLabel("Categor\u00EDa");
			lblCategora.setToolTipText("Nombre");
			lblCategora.setFont(Constants.getLabelFont());
		}
		return lblCategora;
	}
	
	private JLabel getLblMateria() {
		if (lblMateria == null) {
			lblMateria = new JLabel("Materia");
			lblMateria.setToolTipText("Nombre");
			lblMateria.setFont(Constants.getLabelFont());
		}
		return lblMateria;
	}
	
	private void checkChiefButtonAvailability() {
		boolean noItems = multipleInput.amountOfItems() == 0;
		
		btnSetChief.setEnabled(!noItems);
		lblChiefWarning.setVisible(noItems);
	}
	
	private String getChiefMatter() {
		String matter = null;
		
		if (chief != null) {
			matter = chief.getMatter();
		}
		
		return matter;
	}
	
	private MultipleInput getMultipleInput() {
		if (multipleInput == null) {
			multipleInput = new MultipleInput("Temas", "Añadir un tema");
			multipleInput.listenTo(new OnDeletedInput() {
				@Override
				public void deletedItem(String item) {
					if (chief != null) {
						if (getChiefMatter().equals(item)) {
							chief = null;
						}
					}
					
					checkChiefButtonAvailability();
				}
			});
			multipleInput.listenTo(new OnAddedInput() {
				@Override
				public void newItem(String item) {
					checkChiefButtonAvailability();
				}
			});
		}
		return multipleInput;
	}
	
	private void switchPanel(String id) {
		CardLayout cl = (CardLayout)(panelWrapper.getLayout());
		cl.show(panelWrapper, id);
	}
}
