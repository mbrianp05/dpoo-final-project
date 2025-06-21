package gui.reasearchline;

import gui.component.CanBeRemoved;
import gui.component.ErrorLabel;
import gui.component.MultipleInput;
import gui.event.OnAddedInput;
import gui.event.OnAddedResearchLine;
import gui.event.OnDeletedInput;
import gui.event.OnSetChief;
import gui.researchers.ProfesorFormData;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import schooling.Faculty;
import schooling.Profesor;
import schooling.ResearchLine;
import schooling.ResearchMatter;
import utils.Constants;
import utils.EnumsDictionary;
import utils.Validation;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ResearchLineForm extends JPanel {
	private static final long serialVersionUID = 3971105665570208468L;
	private Faculty faculty;
	private ResearchLine line;
	private OnAddedResearchLine listener;
	private ProfesorFormData chief;

	private JLabel lblNombre;
	private JTextField textFieldName;
	private JButton btnNewButton;

	private ErrorLabel errorMatters;
	private ErrorLabel errorName;
	private JButton btnSetChief;
	private JLabel lblChiefWarning;
	private JPanel setChiefPanel;
	private JPanel addChiefForm;
	private JPanel editChiefPanel;
	private ErrorLabel errorChief;
	private JLabel lblChiefName;
	private JLabel lblChiefDegree;
	private JLabel lblChiefMatter;
	private JLabel lblChiefCat;
	private JLabel lblChiefData;
	private JButton btnEditChief;
	private JLabel lblNombre_1;
	private JLabel lblCategoraCientfica;
	private JLabel lblCategora;
	private JLabel lblMateria;
	private MultipleInput multipleInput;
	private JPanel panel;
	private JPanel changeChiefPanel;
	private JComboBox<String> chiefCandidatesComboBox;

	public ResearchLineForm() {
		this(null);
	}

	public ResearchLineForm(ResearchLine line) {
		this.faculty = Faculty.newInstance();
		this.line = line;
		chief = null;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 0, 288, 100, 0};
		gridBagLayout.rowHeights = new int[]{70, 0, 35, 35, 0, 35, 0, 0, 35, 50, 40, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.gridwidth = 2;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		add(getLblNombre(), gbc_lblNombre);
		GridBagConstraints gbc_textFieldName = new GridBagConstraints();
		gbc_textFieldName.gridwidth = 2;
		gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldName.fill = GridBagConstraints.BOTH;
		gbc_textFieldName.gridx = 1;
		gbc_textFieldName.gridy = 2;
		add(getTextFieldName(), gbc_textFieldName);
		GridBagConstraints gbc_errorName = new GridBagConstraints();
		gbc_errorName.gridwidth = 2;
		gbc_errorName.anchor = GridBagConstraints.NORTHWEST;
		gbc_errorName.insets = new Insets(0, 0, 5, 5);
		gbc_errorName.gridx = 1;
		gbc_errorName.gridy = 3;
		add(getErrorName(), gbc_errorName);
		GridBagConstraints gbc_multipleInput = new GridBagConstraints();
		gbc_multipleInput.gridwidth = 2;
		gbc_multipleInput.insets = new Insets(0, 0, 5, 5);
		gbc_multipleInput.fill = GridBagConstraints.BOTH;
		gbc_multipleInput.gridx = 1;
		gbc_multipleInput.gridy = 4;
		add(getMultipleInput(), gbc_multipleInput);
		GridBagConstraints gbc_errorMatters = new GridBagConstraints();
		gbc_errorMatters.anchor = GridBagConstraints.NORTHWEST;
		gbc_errorMatters.gridwidth = 2;
		gbc_errorMatters.insets = new Insets(0, 0, 5, 5);
		gbc_errorMatters.gridx = 1;
		gbc_errorMatters.gridy = 5;
		add(getErrorMatters(), gbc_errorMatters);
		GridBagConstraints gbc_lblChiefData = new GridBagConstraints();
		gbc_lblChiefData.fill = GridBagConstraints.BOTH;
		gbc_lblChiefData.anchor = GridBagConstraints.SOUTH;
		gbc_lblChiefData.insets = new Insets(0, 0, 5, 5);
		gbc_lblChiefData.gridx = 1;
		gbc_lblChiefData.gridy = 6;
		add(getLblChiefData(), gbc_lblChiefData);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 7;
		add(getPanel(), gbc_panel);
		GridBagConstraints gbc_btnEditChief = new GridBagConstraints();
		gbc_btnEditChief.anchor = GridBagConstraints.EAST;
		gbc_btnEditChief.fill = GridBagConstraints.VERTICAL;
		gbc_btnEditChief.insets = new Insets(0, 0, 5, 5);
		gbc_btnEditChief.gridx = 2;
		gbc_btnEditChief.gridy = 8;
		add(getBtnEditChief(), gbc_btnEditChief);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 10;
		add(getBtnNewButton(), gbc_btnNewButton);
		btnNewButton.setEnabled(false);

		initForm();
	}

	private void hideErrors() {
		errorName.setVisible(false);
		
		if (line == null) {
			errorChief.setVisible(false);
		}

		errorMatters.setVisible(false);
	}

	private void initMultipleInput() {
		if (line != null) {
			ArrayList<ResearchMatter> m = line.getMatters();
			String matters[] = new String[m.size()];
			
			for (int i = 0; i < matters.length; i++) {
				matters[i] = m.get(i).getName();
			}
			
			multipleInput.with(matters);
		}
	}
	
	private void initForm() {
		hideErrors();
		initMultipleInput();

		if (line != null) {
			textFieldName.setText(line.getName());

			Profesor p = line.getChief();
			chief = ProfesorFormData.fromResearcher(line.getChief(), faculty.findMatterOf(p.getID()).getName());

			if (line == null) {
				switchPanel("Edit Chief");
			}
		}
	}

	public void listenTo(OnAddedResearchLine listener) {
		this.listener = listener;
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
			textFieldName.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					hasChanges();
				}
			});
			textFieldName.requestFocus();
			textFieldName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textFieldName.setColumns(10);
		}
		return textFieldName;
	}

	public Profesor getChief() {
		Profesor profesor = null;

		if (line == null) {
			int id = faculty.addProfesor(chief.getName(), chief.getDegree(), chief.getCategory(), null);
			profesor = (Profesor)faculty.findResearcher(id);
		} else {
			int i = getChiefCandidatesComboBox().getSelectedIndex();
			Profesor p = getCandidates().get(i);
			
			line.setChief(p);
		}

		return profesor;
	}

	private boolean checkValidity() {
		hideErrors();
		boolean isValid = true;

		String name = textFieldName.getText();

		int mattersCount = multipleInput.amountOfItems();

		if (!Validation.notEmpty(name)) {
			errorName.setVisible(true);
			isValid = false;
		}

		if (mattersCount == 0) {
			errorMatters.setVisible(true);
			isValid = false;
		}

		if (chief == null) {
			errorChief.setVisible(true);
			isValid = false;
		}

		return isValid;
	}

	private void submit() {
		if (checkValidity()) {
			String name = textFieldName.getText();

			Profesor chiefProfesor = getChief();
			ResearchLine line = this.line;

			if (this.line == null) {
				faculty.addResearchLine(name, chiefProfesor);
				line = faculty.findResearchLine(name);
			} else {
				line.setName(name);
				
				// IMPORTANTE ELIMINAR SE DEBE HACER PRIMERO QUE EDITAR
				// PORQUE SINO SE PIERDE EL ID
				for (String matter : removedMatters()) {
					line.getMatters().remove(line.findMatter(matter));
				}

				for (String matter : multipleInput.getValues()) {
					String id = multipleInput.getIdentifier(matter);

					if (id != null) {
						ResearchMatter m = line.findMatter(id);

						Validation.removeValue(m.getClass().getSimpleName() + ".name", matter);
						line.findMatter(id).setName(matter);
					}
				}
			}

			for (String matter : insertedMatters()) {
				line.addMatter(matter);
			}

			if (listener != null) {
				listener.added(textFieldName.getText());
			}

			if (this.line == null) {
				ResearchMatter chiefResearchMatter = faculty.findResearchMatter(chief.getMatter());
				chiefResearchMatter.addResearcher(chiefProfesor);
			}

			resetForm();
			sendFeedback();
		}
	}

	private ArrayList<String> removedMatters() {
		ArrayList<String> removed = new ArrayList<>();

		for (ResearchMatter m: line.getMatters()) {
			if (!multipleInput.has(m.getName())) {
				removed.add(m.getName());
			}
		}

		return removed;
	}

	private ArrayList<String> insertedMatters() {
		String[] matters = multipleInput.getValues();
		ArrayList<String> actualMatters = new ArrayList<>();

		for (String matter: matters) {
			String id = multipleInput.getIdentifier(matter);

			if (id == null) actualMatters.add(matter);
		}

		return actualMatters;
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton(line == null ? "Agregar" : "Guardar cambios");
			btnNewButton.setForeground(Constants.getFormBtnForeground());
			btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					submit();
				}
			});
			btnNewButton.setBackground(Constants.getInsertionBtnColor());
		}
		return btnNewButton;
	}

	private void sendFeedback() {
		JOptionPane.showMessageDialog(null, "¡Se ha registrado la línea correctamente!", "Mensaje", JOptionPane.PLAIN_MESSAGE);
	}

	private ErrorLabel getErrorMatters() {
		if (errorMatters == null) {
			errorMatters = new ErrorLabel();
			errorMatters.setText("Debe existir al menos un tema de investigaci\u00F3n");
		}
		return errorMatters;
	}

	private void resetForm() {
		hideErrors();

		if (line == null) {
			textFieldName.setText("");
			chief = null;

			if (line == null) {
				switchPanel("Add Chief");
			}

			btnEditChief.setVisible(false);
			lblChiefData.setVisible(false);
		}

		int i = multipleInput.getSelectedIndex();
		
		multipleInput.reset();
		initMultipleInput();
		
		if (line != null) {
			multipleInput.setSelectedIndex(i);
		}
	}

	private ErrorLabel getErrorName() {
		if (errorName == null) {
			errorName = new ErrorLabel();
			errorName.setText("El nombre es requerido");
		}
		return errorName;
	}

	private void openChiefDialog() {
		try {
			AddChiefJDialog dialog = new AddChiefJDialog(multipleInput.getValues(), new OnSetChief() {
				@Override
				public void set(ProfesorFormData data) {
					chief = data;
					switchPanel("Edit Chief");

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
		}
		return btnSetChief;
	}
	private JLabel getLblChiefWarning() {
		if (lblChiefWarning == null) {
			lblChiefWarning = new JLabel("*A\u00F1ade al menos un tema de investigaci\u00F3n");
			lblChiefWarning.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		}
		return lblChiefWarning;
	}
	private JPanel getSetChiefPanel() {
		if (setChiefPanel == null) {
			setChiefPanel = new JPanel();
			setChiefPanel.setLayout(new CardLayout(0, 0));
			setChiefPanel.add(getAddChiefForm(), "Add Chief");
			setChiefPanel.add(getEditChiefPanel(), "Edit Chief");
		}
		return setChiefPanel;
	}
	private JPanel getAddChiefForm() {
		if (addChiefForm == null) {
			addChiefForm = new JPanel();
			GridBagLayout gbl_addChiefForm = new GridBagLayout();
			gbl_addChiefForm.columnWidths = new int[]{0, 0, 0};
			gbl_addChiefForm.rowHeights = new int[]{35, 30, 30, 0};
			gbl_addChiefForm.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_addChiefForm.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			addChiefForm.setLayout(gbl_addChiefForm);
			
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
			GridBagConstraints gbc_errorChief = new GridBagConstraints();
			gbc_errorChief.gridwidth = 2;
			gbc_errorChief.anchor = GridBagConstraints.NORTH;
			gbc_errorChief.fill = GridBagConstraints.HORIZONTAL;
			gbc_errorChief.weighty = 1.0;
			gbc_errorChief.gridx = 0;
			gbc_errorChief.gridy = 2;
			addChiefForm.add(getErrorChief(), gbc_errorChief);
		}
		return addChiefForm;
	}
	private JPanel getEditChiefPanel() {
		if (editChiefPanel == null) {
			editChiefPanel = new JPanel();
			editChiefPanel.setForeground(new Color(0, 0, 0));
			editChiefPanel.setBackground(new Color(204, 255, 255));
			GridBagLayout gbl_editChiefPanel = new GridBagLayout();
			gbl_editChiefPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_editChiefPanel.rowHeights = new int[]{0, 0, 30, 0};
			gbl_editChiefPanel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
			gbl_editChiefPanel.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
			editChiefPanel.setLayout(gbl_editChiefPanel);
			GridBagConstraints gbc_lblNombre_1 = new GridBagConstraints();
			gbc_lblNombre_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre_1.gridx = 0;
			gbc_lblNombre_1.gridy = 1;
			editChiefPanel.add(getLblNombre_1(), gbc_lblNombre_1);
			GridBagConstraints gbc_lblCategoraCientfica = new GridBagConstraints();
			gbc_lblCategoraCientfica.insets = new Insets(0, 0, 5, 5);
			gbc_lblCategoraCientfica.gridx = 1;
			gbc_lblCategoraCientfica.gridy = 1;
			editChiefPanel.add(getLblCategoraCientfica(), gbc_lblCategoraCientfica);
			GridBagConstraints gbc_lblCategora = new GridBagConstraints();
			gbc_lblCategora.insets = new Insets(0, 0, 5, 5);
			gbc_lblCategora.gridx = 2;
			gbc_lblCategora.gridy = 1;
			editChiefPanel.add(getLblCategora(), gbc_lblCategora);
			GridBagConstraints gbc_lblMateria = new GridBagConstraints();
			gbc_lblMateria.insets = new Insets(0, 0, 5, 0);
			gbc_lblMateria.gridx = 3;
			gbc_lblMateria.gridy = 1;
			editChiefPanel.add(getLblMateria(), gbc_lblMateria);
			GridBagConstraints gbc_lblChiefName = new GridBagConstraints();
			gbc_lblChiefName.insets = new Insets(0, 0, 0, 5);
			gbc_lblChiefName.gridx = 0;
			gbc_lblChiefName.gridy = 2;
			editChiefPanel.add(getLblChiefName(), gbc_lblChiefName);
			GridBagConstraints gbc_lblChiefDegree = new GridBagConstraints();
			gbc_lblChiefDegree.insets = new Insets(0, 0, 0, 5);
			gbc_lblChiefDegree.gridx = 1;
			gbc_lblChiefDegree.gridy = 2;
			editChiefPanel.add(getLblChiefDegree(), gbc_lblChiefDegree);
			GridBagConstraints gbc_lblChiefCat = new GridBagConstraints();
			gbc_lblChiefCat.insets = new Insets(0, 0, 0, 5);
			gbc_lblChiefCat.gridx = 2;
			gbc_lblChiefCat.gridy = 2;
			editChiefPanel.add(getLblChiefCat(), gbc_lblChiefCat);
			GridBagConstraints gbc_lblChiefMatter = new GridBagConstraints();
			gbc_lblChiefMatter.gridx = 3;
			gbc_lblChiefMatter.gridy = 2;
			editChiefPanel.add(getLblChiefMatter(), gbc_lblChiefMatter);
		}
		return editChiefPanel;
	}

	private ErrorLabel getErrorChief() {
		if (errorChief == null) {
			errorChief = new ErrorLabel();
			errorChief.setVisible(false);
			errorChief.setText("Agrega al profesor responsable");
		}
		return errorChief;
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

	private JLabel getLblChiefData() {
		if (lblChiefData == null) {
			lblChiefData = new JLabel("Jefe de la l\u00EDnea");
			lblChiefData.setFont(Constants.getLabelFont());
		}
		return lblChiefData;
	}

	private JButton getBtnEditChief() {
		if (btnEditChief == null) {
			ImageIcon icon = new ImageIcon(ResearchLineForm.class.getResource("/resources/images/edit.png"));
			icon = new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
			
			btnEditChief = new JButton(icon);
			btnEditChief.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					openChiefDialog();
				}
			});
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

			if (line != null) {
				multipleInput.setNotPermittedDeletionMsg("No se puede eliminar un tema con investigadores");
				multipleInput.canRemove(new CanBeRemoved() {
					@Override
					public boolean granted(String item) {
						return line.findMatter(item).getResearchers().size() == 0;
					}
				});
			} else {
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
		}
		return multipleInput;
	}

	private void switchPanel(String id) {
		CardLayout cl = (CardLayout)(setChiefPanel.getLayout());
		cl.show(setChiefPanel, id);
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			
			if (line == null) {
				panel.add(getSetChiefPanel());
			} else {
				panel.add(getChangeChiefPanel());
			}
		}
		return panel;
	}
	private JPanel getChangeChiefPanel() {
		if (changeChiefPanel == null) {
			changeChiefPanel = new JPanel();
			
			GridBagLayout gbl_changeChiefPanel = new GridBagLayout();
			gbl_changeChiefPanel.columnWidths = new int[]{0, 0};
			gbl_changeChiefPanel.rowHeights = new int[]{35, 0};
			gbl_changeChiefPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_changeChiefPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			changeChiefPanel.setLayout(gbl_changeChiefPanel);
			
			GridBagConstraints gbc_chiefCandidatesComboBox = new GridBagConstraints();
			gbc_chiefCandidatesComboBox.fill = GridBagConstraints.BOTH;
			gbc_chiefCandidatesComboBox.gridx = 0;
			gbc_chiefCandidatesComboBox.gridy = 0;
			changeChiefPanel.add(getChiefCandidatesComboBox(), gbc_chiefCandidatesComboBox);
		}
		return changeChiefPanel;
	}
	
	private ArrayList<Profesor> getCandidates() {
		ArrayList<Profesor> chiefCandidates = new ArrayList<>();
		chiefCandidates.add(line.getChief());
		
		for (Profesor p: line.getProfesorsInvolved()) {
			if (!faculty.isChief(p)) {
				chiefCandidates.add(p);
			}
		}
		
		return chiefCandidates;
	}
	
	private void hasChanges() {
		
		btnNewButton.setEnabled(true);
		
	}
	
	private JComboBox<String> getChiefCandidatesComboBox() {
		if (chiefCandidatesComboBox == null) {
			chiefCandidatesComboBox = new JComboBox<>();
			
			ArrayList<Profesor> chiefCandidates = getCandidates();
			String[] names = new String[chiefCandidates.size()];
			
			for (int i = 0; i < names.length; i++) {
				names[i] = chiefCandidates.get(i).getName();
			}
			
			chiefCandidatesComboBox.setModel(new DefaultComboBoxModel<>(names));
		}
		
		return chiefCandidatesComboBox;
	}
}
