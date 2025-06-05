package gui.views;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import schooling.Degree;
import schooling.Faculty;
import schooling.Profesor;
import schooling.ProfesorCategory;
import schooling.ResearchLine;
import schooling.ResearchMatter;
import utils.ArrayLib;
import utils.Constants;
import utils.EnumsDictionary;
import utils.Validation;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
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
import gui.event.OnSetChief;
import gui.reasearchline.AddChiefJDialog;

import java.awt.CardLayout;
import javax.swing.SwingConstants;

public class ResearchLineFormView extends JPanel {
	private static final long serialVersionUID = 3971105665570208468L;
	private Faculty faculty;
	private OnAddedResearchLine listener;
	
	private Object[] chief;

	private JLabel lblAgregarLneaDe;
	private JLabel lblNombre;
	private JTextField textFieldName;
	private JLabel lblMaestra;
	private JLabel lblCrditoNecesario;
	private JSpinner minCreditsSpinner;
	private JLabel lblTemas;
	private JLabel lblAgregarTema;
	private JTextField textFieldMatterName;
	private JButton button;
	private JButton btnNewButton;

	private ArrayList<String> matters;
	private ErrorLabel errorLabel;
	private JComboBox<String> mattersComboBox;
	private JButton editBtn;
	private JButton btnEliminar;
	private ErrorLabel lblCreditsError;
	private ErrorLabel errorName;
	private JLabel lblJefeDeLa;
	private JButton btnSetChief;
	private JLabel lblChiefWarning;
	private JPanel panelWrapper;
	private JPanel addChiefForm;
	private JPanel changeChief;
	private JLabel lblNombre_1;
	private JLabel lblChiefName;
	private JLabel lblCategora;
	private JLabel lblChiefDegree;
	private JLabel label;
	private JLabel lblChiefCat;
	private JLabel lblMateria;
	private JLabel lblChiefMatter;
	private ErrorLabel lblNoChiefError;

	public ResearchLineFormView(Faculty faculty) {
		this.faculty = faculty;
		matters = new ArrayList<>();
		chief = null;

		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 50, 75, 30, 288, 50, 100, 0};
		gridBagLayout.rowHeights = new int[]{70, 45, 50, 0, 35, 30, 35, 35, 35, 50, 0, 35, 80, 40, 50, 35, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblAgregarLneaDe = new GridBagConstraints();
		gbc_lblAgregarLneaDe.gridwidth = 5;
		gbc_lblAgregarLneaDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblAgregarLneaDe.fill = GridBagConstraints.BOTH;
		gbc_lblAgregarLneaDe.gridx = 1;
		gbc_lblAgregarLneaDe.gridy = 1;
		add(getLblAgregarLneaDe(), gbc_lblAgregarLneaDe);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.gridwidth = 5;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		add(getLblNombre(), gbc_lblNombre);
		GridBagConstraints gbc_textFieldName = new GridBagConstraints();
		gbc_textFieldName.gridwidth = 5;
		gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldName.fill = GridBagConstraints.BOTH;
		gbc_textFieldName.gridx = 1;
		gbc_textFieldName.gridy = 4;
		add(getTextFieldName(), gbc_textFieldName);
		GridBagConstraints gbc_errorName = new GridBagConstraints();
		gbc_errorName.gridwidth = 5;
		gbc_errorName.anchor = GridBagConstraints.NORTHWEST;
		gbc_errorName.insets = new Insets(0, 0, 5, 5);
		gbc_errorName.gridx = 1;
		gbc_errorName.gridy = 5;
		add(getErrorName(), gbc_errorName);
		GridBagConstraints gbc_editBtn = new GridBagConstraints();
		gbc_editBtn.fill = GridBagConstraints.BOTH;
		gbc_editBtn.anchor = GridBagConstraints.SOUTHWEST;
		gbc_editBtn.insets = new Insets(0, 0, 5, 5);
		gbc_editBtn.gridx = 2;
		gbc_editBtn.gridy = 6;
		add(getEditBtn(), gbc_editBtn);
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.VERTICAL;
		gbc_btnEliminar.gridwidth = 2;
		gbc_btnEliminar.anchor = GridBagConstraints.SOUTHWEST;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminar.gridx = 3;
		gbc_btnEliminar.gridy = 6;
		add(getBtnEliminar(), gbc_btnEliminar);
		GridBagConstraints gbc_lblTemas = new GridBagConstraints();
		gbc_lblTemas.fill = GridBagConstraints.BOTH;
		gbc_lblTemas.insets = new Insets(0, 0, 5, 5);
		gbc_lblTemas.gridx = 1;
		gbc_lblTemas.gridy = 7;
		add(getLblTemas(), gbc_lblTemas);
		GridBagConstraints gbc_mattersComboBox = new GridBagConstraints();
		gbc_mattersComboBox.gridwidth = 4;
		gbc_mattersComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_mattersComboBox.fill = GridBagConstraints.BOTH;
		gbc_mattersComboBox.gridx = 2;
		gbc_mattersComboBox.gridy = 7;
		add(getMattersComboBox(), gbc_mattersComboBox);
		GridBagConstraints gbc_lblAgregarTema = new GridBagConstraints();
		gbc_lblAgregarTema.anchor = GridBagConstraints.EAST;
		gbc_lblAgregarTema.fill = GridBagConstraints.BOTH;
		gbc_lblAgregarTema.insets = new Insets(0, 0, 5, 5);
		gbc_lblAgregarTema.gridx = 1;
		gbc_lblAgregarTema.gridy = 8;
		add(getLblAgregarTema(), gbc_lblAgregarTema);
		GridBagConstraints gbc_textFieldMatterName = new GridBagConstraints();
		gbc_textFieldMatterName.gridwidth = 3;
		gbc_textFieldMatterName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMatterName.fill = GridBagConstraints.BOTH;
		gbc_textFieldMatterName.gridx = 2;
		gbc_textFieldMatterName.gridy = 8;
		add(getTextFieldMatterName(), gbc_textFieldMatterName);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 5;
		gbc_button.gridy = 8;
		add(getButton(), gbc_button);
		GridBagConstraints gbc_errorLabel = new GridBagConstraints();
		gbc_errorLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_errorLabel.gridwidth = 3;
		gbc_errorLabel.insets = new Insets(0, 0, 5, 5);
		gbc_errorLabel.gridx = 2;
		gbc_errorLabel.gridy = 9;
		add(getErrorLabel(), gbc_errorLabel);
		GridBagConstraints gbc_panelWrapper = new GridBagConstraints();
		gbc_panelWrapper.gridwidth = 5;
		gbc_panelWrapper.gridheight = 3;
		gbc_panelWrapper.insets = new Insets(0, 0, 5, 5);
		gbc_panelWrapper.fill = GridBagConstraints.BOTH;
		gbc_panelWrapper.gridx = 1;
		gbc_panelWrapper.gridy = 10;
		add(getPanelWrapper(), gbc_panelWrapper);
		GridBagConstraints gbc_lblCreditsError = new GridBagConstraints();
		gbc_lblCreditsError.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCreditsError.gridwidth = 2;
		gbc_lblCreditsError.insets = new Insets(0, 0, 5, 5);
		gbc_lblCreditsError.gridx = 1;
		gbc_lblCreditsError.gridy = 12;
		add(getLblCreditsError(), gbc_lblCreditsError);
		GridBagConstraints gbc_lblMaestra = new GridBagConstraints();
		gbc_lblMaestra.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblMaestra.anchor = GridBagConstraints.SOUTH;
		gbc_lblMaestra.gridwidth = 2;
		gbc_lblMaestra.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaestra.gridx = 1;
		gbc_lblMaestra.gridy = 14;
		add(getLblMaestra(), gbc_lblMaestra);
		GridBagConstraints gbc_lblCrditoNecesario = new GridBagConstraints();
		gbc_lblCrditoNecesario.fill = GridBagConstraints.BOTH;
		gbc_lblCrditoNecesario.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrditoNecesario.gridx = 1;
		gbc_lblCrditoNecesario.gridy = 15;
		add(getLblCrditoNecesario(), gbc_lblCrditoNecesario);
		GridBagConstraints gbc_minCreditsSpinner = new GridBagConstraints();
		gbc_minCreditsSpinner.fill = GridBagConstraints.BOTH;
		gbc_minCreditsSpinner.insets = new Insets(0, 0, 5, 5);
		gbc_minCreditsSpinner.gridx = 2;
		gbc_minCreditsSpinner.gridy = 15;
		add(getMinCreditsSpinner(), gbc_minCreditsSpinner);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 16;
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

	public void fetchProfesors() {
		ArrayList<Profesor> profesors = faculty.getProfesors();
		String[] names = new String[profesors.size()];

		for (int i = 0; i < profesors.size(); i++) {
			names[i] = profesors.get(i).getName();
		}
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
			textFieldMatterName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textFieldMatterName.setColumns(10);
		}
		return textFieldMatterName;
	}

	private void updateComboBox() {
		mattersComboBox.setModel(new DefaultComboBoxModel<>(ArrayLib.cast(matters)));
	}

	private JButton getButton() {
		if (button == null) {
			button = new JButton("+");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (!textFieldMatterName.getText().trim().isEmpty()) {
						matters.add(textFieldMatterName.getText());
						int lastIndex = mattersComboBox.getSelectedIndex();
						updateComboBox();

						mattersComboBox.setSelectedIndex(lastIndex + 1);

						errorLabel.setText("");
						textFieldMatterName.setText("");

						manageBtns();
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
		int id = faculty.addProfesor((String)chief[0], (Degree)chief[1], (ProfesorCategory)chief[2], null);
		
		return (Profesor)faculty.findResearcher(id);
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Agregar");
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(Constants.getLabelFont());
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (Validation.notEmpty(textFieldName.getText())) {
						errorName.setText("");
						if (matters.size() > 0) {
							if (chief != null) {
								lblNoChiefError.setVisible(false);
								
								if ((int)minCreditsSpinner.getValue() > 0) {		
									lblCreditsError.setText("");
									
									try {
										Profesor chiefProfesor = getChief();
										String name = faculty.addResearchLine(textFieldName.getText(), chiefProfesor, (int)minCreditsSpinner.getValue());
										ResearchLine line = faculty.findResearchLine(name);
										
										for (String matter : matters) {
											line.addMatter(matter);
										}
										
										if (listener != null) {
											listener.added(textFieldName.getText());
										}
										
										ResearchMatter chiefResearchMatter = faculty.findResearchMatter((String)chief[3]);
										chiefResearchMatter.addResearcher(chiefProfesor);
										
										resetForm();
									} catch (Exception e) {
										// TODO: handle exception
									}
									
									// Reset form
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
		textFieldMatterName.setText("");
		textFieldName.setText("");
		minCreditsSpinner.setValue(1);
		mattersComboBox.setModel(new DefaultComboBoxModel<>(new String[] {}));
		matters.clear();
		chief = null;
		
		CardLayout cl = (CardLayout)(panelWrapper.getLayout());
		cl.show(panelWrapper, "Add Chief");
		
		manageBtns();
	}
	private JComboBox<String> getMattersComboBox() {
		if (mattersComboBox == null) {
			mattersComboBox = new JComboBox<String>();
			mattersComboBox.setFont(Constants.getLabelFont());
			mattersComboBox.setBackground(Color.WHITE);
			mattersComboBox.setModel(new DefaultComboBoxModel<>(new String[] {}));
		}
		return mattersComboBox;
	}
	private JButton getEditBtn() {
		if (editBtn == null) {
			editBtn = new JButton("Editar");
			editBtn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			editBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String newName = JOptionPane.showInputDialog(null, "Cambiar " + mattersComboBox.getSelectedItem(), "Editar", JOptionPane.PLAIN_MESSAGE);

					if (newName != null) {
						if (Validation.notEmpty(newName)) {
							int index = mattersComboBox.getSelectedIndex();
							
							matters.set(index, newName);
							updateComboBox();
							
							mattersComboBox.setSelectedIndex(index);
						} else {
							JOptionPane.showMessageDialog(null, "El nuevo nombre no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
			editBtn.setBackground(Color.WHITE);
			editBtn.setVisible(false);
		}
		return editBtn;
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setFont(new Font("Segoe UI", Font.PLAIN, 13));
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int input = JOptionPane.showConfirmDialog(null, "Desea eliminar el tema de investigación", "Eliminar materia", JOptionPane.WARNING_MESSAGE);

					if (input == JOptionPane.YES_OPTION) {
						int index = mattersComboBox.getSelectedIndex();

						if (chief != null && matters.get(index).equals(chief[3])) {
							chief = null;
							
							manageBtns();
							CardLayout cl = (CardLayout)(panelWrapper.getLayout());
							cl.show(panelWrapper, "Add Chief");
						}
						
						matters.remove(index);
						updateComboBox();

						if (index > 0) {
							mattersComboBox.setSelectedIndex(index - 1);
						}
					}

					manageBtns();
				}
			});
			btnEliminar.setBackground(Color.WHITE);
			btnEliminar.setVisible(false);
		}
		return btnEliminar;
	}
	private ErrorLabel getLblCreditsError() {
		if (lblCreditsError == null) {
			lblCreditsError = new ErrorLabel();
		}
		return lblCreditsError;
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
	private JButton getBtnSetChief() {
		if (btnSetChief == null) {
			btnSetChief = new JButton("Insertar datos del docente");
			btnSetChief.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						AddChiefJDialog dialog = new AddChiefJDialog(ArrayLib.cast(matters), new OnSetChief() {
							@Override
							public void set(String name, ProfesorCategory category, Degree degree, String matter) {
								chief = new Object[4];
								
								chief[0] = name;
								chief[1] = degree;
								chief[2] = category;
								chief[3] = matter;
								
								CardLayout cl = (CardLayout)(panelWrapper.getLayout());
								cl.show(panelWrapper, "Change Chief");
								
								lblChiefName.setText((String)chief[0]);
								lblChiefDegree.setText(EnumsDictionary.degree((Degree)chief[1]));
								lblChiefCat.setText(EnumsDictionary.category((ProfesorCategory)chief[2]));
								lblChiefMatter.setText((String)chief[3]);
							}
						});
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
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
	private void manageBtns() {
		if (matters.size() == 0) {
			btnEliminar.setVisible(false);
			editBtn.setVisible(false);
			btnSetChief.setEnabled(false);
			lblChiefWarning.setVisible(true);
		} else {
			btnEliminar.setVisible(true);
			editBtn.setVisible(true);
			btnSetChief.setEnabled(true);
			lblChiefWarning.setVisible(false);
		}
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
			gbl_addChiefForm.rowHeights = new int[]{0, 0, 0, 0};
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
			changeChief.setBackground(Color.WHITE);
			GridBagLayout gbl_changeChief = new GridBagLayout();
			gbl_changeChief.columnWidths = new int[]{0, 0, 0};
			gbl_changeChief.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_changeChief.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			gbl_changeChief.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			changeChief.setLayout(gbl_changeChief);
			GridBagConstraints gbc_lblNombre_1 = new GridBagConstraints();
			gbc_lblNombre_1.anchor = GridBagConstraints.WEST;
			gbc_lblNombre_1.fill = GridBagConstraints.BOTH;
			gbc_lblNombre_1.weighty = 1.0;
			gbc_lblNombre_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre_1.gridx = 0;
			gbc_lblNombre_1.gridy = 0;
			changeChief.add(getLblNombre_1(), gbc_lblNombre_1);
			GridBagConstraints gbc_lblChiefName = new GridBagConstraints();
			gbc_lblChiefName.insets = new Insets(0, 0, 5, 0);
			gbc_lblChiefName.weightx = 1.0;
			gbc_lblChiefName.fill = GridBagConstraints.BOTH;
			gbc_lblChiefName.gridx = 1;
			gbc_lblChiefName.gridy = 0;
			changeChief.add(getLblChiefName(), gbc_lblChiefName);
			GridBagConstraints gbc_lblMateria = new GridBagConstraints();
			gbc_lblMateria.fill = GridBagConstraints.BOTH;
			gbc_lblMateria.weighty = 1.0;
			gbc_lblMateria.insets = new Insets(0, 0, 5, 5);
			gbc_lblMateria.gridx = 0;
			gbc_lblMateria.gridy = 1;
			changeChief.add(getLblMateria(), gbc_lblMateria);
			GridBagConstraints gbc_lblChiefMatter = new GridBagConstraints();
			gbc_lblChiefMatter.fill = GridBagConstraints.BOTH;
			gbc_lblChiefMatter.anchor = GridBagConstraints.WEST;
			gbc_lblChiefMatter.insets = new Insets(0, 0, 5, 0);
			gbc_lblChiefMatter.gridx = 1;
			gbc_lblChiefMatter.gridy = 1;
			changeChief.add(getLblChiefMatter(), gbc_lblChiefMatter);
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.fill = GridBagConstraints.BOTH;
			gbc_label.weighty = 1.0;
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 0;
			gbc_label.gridy = 2;
			changeChief.add(getLabel(), gbc_label);
			GridBagConstraints gbc_lblChiefCat = new GridBagConstraints();
			gbc_lblChiefCat.fill = GridBagConstraints.BOTH;
			gbc_lblChiefCat.insets = new Insets(0, 0, 5, 0);
			gbc_lblChiefCat.gridx = 1;
			gbc_lblChiefCat.gridy = 2;
			changeChief.add(getLblChiefCat(), gbc_lblChiefCat);
			GridBagConstraints gbc_lblCategora = new GridBagConstraints();
			gbc_lblCategora.fill = GridBagConstraints.BOTH;
			gbc_lblCategora.weighty = 1.0;
			gbc_lblCategora.insets = new Insets(0, 0, 0, 5);
			gbc_lblCategora.gridx = 0;
			gbc_lblCategora.gridy = 3;
			changeChief.add(getLblCategora(), gbc_lblCategora);
			GridBagConstraints gbc_lblChiefDegree = new GridBagConstraints();
			gbc_lblChiefDegree.fill = GridBagConstraints.BOTH;
			gbc_lblChiefDegree.gridx = 1;
			gbc_lblChiefDegree.gridy = 3;
			changeChief.add(getLblChiefDegree(), gbc_lblChiefDegree);
		}
		return changeChief;
	}
	private JLabel getLblNombre_1() {
		if (lblNombre_1 == null) {
			lblNombre_1 = new JLabel("Nombre");
			lblNombre_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNombre_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblNombre_1;
	}
	private JLabel getLblChiefName() {
		if (lblChiefName == null) {
			lblChiefName = new JLabel("");
			lblChiefName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblChiefName;
	}
	private JLabel getLblCategora() {
		if (lblCategora == null) {
			lblCategora = new JLabel("Categor\u00EDa Cientifica");
			lblCategora.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblCategora;
	}
	private JLabel getLblChiefDegree() {
		if (lblChiefDegree == null) {
			lblChiefDegree = new JLabel("");
			lblChiefDegree.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblChiefDegree;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Categor\u00EDa");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return label;
	}
	private JLabel getLblChiefCat() {
		if (lblChiefCat == null) {
			lblChiefCat = new JLabel("");
			lblChiefCat.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblChiefCat;
	}
	private JLabel getLblMateria() {
		if (lblMateria == null) {
			lblMateria = new JLabel("Materia");
			lblMateria.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMateria.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblMateria;
	}
	private JLabel getLblChiefMatter() {
		if (lblChiefMatter == null) {
			lblChiefMatter = new JLabel("");
			lblChiefMatter.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblChiefMatter;
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
}
