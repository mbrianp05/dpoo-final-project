package gui.researchers.activity;

import gui.component.ErrorLabel;
import gui.event.OnResearchActivityActionTriggered;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Year;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import schooling.Presentation;
import schooling.Researcher;
import utils.Constants;
import utils.DateHelper;
import utils.Month;
import utils.Validation;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PresentationForm extends JPanel {
	private static final long serialVersionUID = 1218122467482657932L;

	private Researcher researcher;
	private Presentation breakthrough;
	private OnResearchActivityActionTriggered listener;

	private JLabel lblNombre;
	private JTextField textFieldName;
	private JLabel lblCdigoIsbn;
	private JTextField textFieldISBN;
	private JLabel lblLocalizacin;
	private JTextField textFieldLocation;
	private JLabel lblDa;
	private JLabel lblMes;
	private JLabel lblAo;
	private JComboBox<String> comboBoxDays;
	private JComboBox<String> comboBoxMonths;
	private JSpinner spinnerYear;
	private JButton btnAgregar;
	private JPanel panel;
	private ErrorLabel errorName;
	private ErrorLabel errorISBN;
	private ErrorLabel errorLocation;

	/**
	 * @wbp.parser.constructor
	 */
	public PresentationForm(Researcher researcher) {
		this(researcher, null);
	}

	public PresentationForm(Researcher researcher, Presentation breakthrough) {
		this.researcher = researcher;
		this.breakthrough = breakthrough;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 0, 0, 100, 0 };
		gridBagLayout.rowHeights = new int[] { 50, 0, 35, 40, 0, 35, 40, 0, 35, 40, 0, 40, 0, 40, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.gridwidth = 2;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
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
		gbc_errorName.fill = GridBagConstraints.BOTH;
		gbc_errorName.gridwidth = 2;
		gbc_errorName.insets = new Insets(0, 0, 5, 5);
		gbc_errorName.gridx = 1;
		gbc_errorName.gridy = 3;
		add(getErrorName(), gbc_errorName);
		GridBagConstraints gbc_lblCdigoIsbn = new GridBagConstraints();
		gbc_lblCdigoIsbn.fill = GridBagConstraints.BOTH;
		gbc_lblCdigoIsbn.gridwidth = 2;
		gbc_lblCdigoIsbn.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoIsbn.gridx = 1;
		gbc_lblCdigoIsbn.gridy = 4;
		add(getLblCdigoIsbn(), gbc_lblCdigoIsbn);
		GridBagConstraints gbc_textFieldISBN = new GridBagConstraints();
		gbc_textFieldISBN.gridwidth = 2;
		gbc_textFieldISBN.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldISBN.fill = GridBagConstraints.BOTH;
		gbc_textFieldISBN.gridx = 1;
		gbc_textFieldISBN.gridy = 5;
		add(getTextFieldISBN(), gbc_textFieldISBN);
		GridBagConstraints gbc_errorISBN = new GridBagConstraints();
		gbc_errorISBN.fill = GridBagConstraints.BOTH;
		gbc_errorISBN.gridwidth = 2;
		gbc_errorISBN.insets = new Insets(0, 0, 5, 5);
		gbc_errorISBN.gridx = 1;
		gbc_errorISBN.gridy = 6;
		add(getErrorISBN(), gbc_errorISBN);
		GridBagConstraints gbc_lblLocalizacin = new GridBagConstraints();
		gbc_lblLocalizacin.fill = GridBagConstraints.BOTH;
		gbc_lblLocalizacin.gridwidth = 2;
		gbc_lblLocalizacin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocalizacin.gridx = 1;
		gbc_lblLocalizacin.gridy = 7;
		add(getLblLocalizacin(), gbc_lblLocalizacin);
		GridBagConstraints gbc_textFieldLocation = new GridBagConstraints();
		gbc_textFieldLocation.gridwidth = 2;
		gbc_textFieldLocation.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldLocation.fill = GridBagConstraints.BOTH;
		gbc_textFieldLocation.gridx = 1;
		gbc_textFieldLocation.gridy = 8;
		add(getTextFieldLocation(), gbc_textFieldLocation);
		GridBagConstraints gbc_errorLocation = new GridBagConstraints();
		gbc_errorLocation.fill = GridBagConstraints.BOTH;
		gbc_errorLocation.gridwidth = 2;
		gbc_errorLocation.insets = new Insets(0, 0, 5, 5);
		gbc_errorLocation.gridx = 1;
		gbc_errorLocation.gridy = 9;
		add(getErrorLocation(), gbc_errorLocation);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 10;
		add(getPanel(), gbc_panel);
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAgregar.anchor = GridBagConstraints.EAST;
		gbc_btnAgregar.fill = GridBagConstraints.VERTICAL;
		gbc_btnAgregar.gridx = 2;
		gbc_btnAgregar.gridy = 13;
		add(getBtnAgregar(), gbc_btnAgregar);

		reset();
	}

	public void listenTo(OnResearchActivityActionTriggered listener) {
		this.listener = listener;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lblNombre.setBackground(Color.WHITE);
		}
		return lblNombre;
	}

	private JTextField getTextFieldName() {
		if (textFieldName == null) {
			textFieldName = new JTextField();
			if (breakthrough != null) {
				textFieldName.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent arg0) {
						hasChanges();
					}
				});
			}
			textFieldName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textFieldName.setColumns(10);
		}
		return textFieldName;
	}

	private JLabel getLblCdigoIsbn() {
		if (lblCdigoIsbn == null) {
			lblCdigoIsbn = new JLabel("C\u00F3digo ISBN");
			lblCdigoIsbn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lblCdigoIsbn.setBackground(Color.WHITE);
		}
		return lblCdigoIsbn;
	}

	private JTextField getTextFieldISBN() {
		if (textFieldISBN == null) {
			textFieldISBN = new JTextField();
			if (breakthrough != null) {
				textFieldISBN.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent arg0) {
						hasChanges();
					}
				});
			}
			textFieldISBN.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textFieldISBN.setColumns(10);
		}
		return textFieldISBN;
	}

	private JLabel getLblLocalizacin() {
		if (lblLocalizacin == null) {
			lblLocalizacin = new JLabel("Localizaci\u00F3n");
			lblLocalizacin.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lblLocalizacin.setBackground(Color.WHITE);
		}
		return lblLocalizacin;
	}

	private JTextField getTextFieldLocation() {
		if (textFieldLocation == null) {
			textFieldLocation = new JTextField();
			if (breakthrough != null) {
				textFieldLocation.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent arg0) {
						hasChanges();
					}
				});
			}
			textFieldLocation.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textFieldLocation.setColumns(10);
		}
		return textFieldLocation;
	}

	private JLabel getLblDa() {
		if (lblDa == null) {
			lblDa = new JLabel("D\u00EDa");
			lblDa.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lblDa.setBackground(Color.WHITE);
		}
		return lblDa;
	}

	private JLabel getLblMes() {
		if (lblMes == null) {
			lblMes = new JLabel("Mes");
			lblMes.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lblMes.setBackground(Color.WHITE);
		}
		return lblMes;
	}

	private JLabel getLblAo() {
		if (lblAo == null) {
			lblAo = new JLabel("A\u00F1o");
			lblAo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lblAo.setBackground(Color.WHITE);
		}
		return lblAo;
	}

	private Month getMonth() {
		Month month = Month.January;

		switch (comboBoxMonths.getSelectedIndex()) {
			case 0:
				month = Month.January;
				break;
			case 1:
				month = Month.February;
				break;
			case 2:
				month = Month.March;
				break;
			case 3:
				month = Month.April;
				break;
			case 4:
				month = Month.May;
				break;
			case 5:
				month = Month.June;
				break;
			case 6:
				month = Month.July;
				break;
			case 7:
				month = Month.August;
				break;
			case 8:
				month = Month.September;
				break;
			case 9:
				month = Month.Octuber;
				break;
			case 10:
				month = Month.November;
				break;
			case 11:
				month = Month.December;
				break;
		}

		return month;
	}

	private void setDays() {
		if (comboBoxDays == null)
			getComboBoxDays();

		int daysCount = DateHelper.getDaysFor(getMonth(), (Integer) spinnerYear.getValue());
		String[] days = new String[daysCount];

		for (int i = 0; i < daysCount; i++) {
			days[i] = String.valueOf(i + 1);
		}

		String selectedItem = (String) comboBoxDays.getSelectedItem();

		comboBoxDays.setModel(new DefaultComboBoxModel<>(days));

		if (selectedItem != null)
			comboBoxDays.setSelectedItem(selectedItem);
	}

	private JComboBox<String> getComboBoxDays() {
		if (comboBoxDays == null) {
			comboBoxDays = new JComboBox<>();
			comboBoxDays.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			comboBoxDays.setBackground(Color.WHITE);

			setDays();

			if (breakthrough != null) {
				comboBoxDays.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						hasChanges();
					}
				});
			}
		}
		return comboBoxDays;
	}

	private JComboBox<String> getComboBoxMonths() {
		if (comboBoxMonths == null) {
			comboBoxMonths = new JComboBox<>();
			comboBoxMonths.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setDays();
				}
			});
			comboBoxMonths.setModel(new DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril",
					"Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
			comboBoxMonths.setBackground(Color.WHITE);
			comboBoxMonths.setFont(new Font("Segoe UI", Font.PLAIN, 15));

			if (breakthrough != null) {
				comboBoxMonths.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						hasChanges();
					}
				});
			}
		}
		return comboBoxMonths;
	}

	private JSpinner getSpinnerYear() {
		if (spinnerYear == null) {
			spinnerYear = new JSpinner();
			spinnerYear.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					setDays();
				}
			});
			spinnerYear.setBackground(Color.WHITE);
			spinnerYear.setModel(new SpinnerNumberModel(Year.now().getValue(), 1, Year.now().getValue(), 1));
			spinnerYear.setFont(new Font("Segoe UI", Font.PLAIN, 15));

			if (breakthrough != null) {
				spinnerYear.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {
						hasChanges();
					}
				});
				spinnerYear.addChangeListener(new ChangeListener() {
					@Override
					public void stateChanged(ChangeEvent arg0) {
						hasChanges();
					}
				});
			}
		}
		return spinnerYear;
	}

	private JButton getBtnAgregar() {
		if (btnAgregar == null) {
			btnAgregar = new JButton(breakthrough == null ? "Agregar" : "Editar");
			btnAgregar.setForeground(Constants.getFormBtnForeground());
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					submit();
				}
			});
			btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 15));

			if (breakthrough != null)
				btnAgregar.setEnabled(false);
		}
		return btnAgregar;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 51, 153), 2, true), "Fecha",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 51, 255)));
			panel.setBackground(Color.WHITE);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[] { 0, 100, 35, 100, 35, 100, 0, 0 };
			gbl_panel.rowHeights = new int[] { 21, 35, 21, 0 };
			gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
			gbl_panel.rowWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_lblDa = new GridBagConstraints();
			gbc_lblDa.insets = new Insets(0, 0, 5, 5);
			gbc_lblDa.gridx = 1;
			gbc_lblDa.gridy = 0;
			panel.add(getLblDa(), gbc_lblDa);
			GridBagConstraints gbc_lblMes = new GridBagConstraints();
			gbc_lblMes.insets = new Insets(0, 0, 5, 5);
			gbc_lblMes.gridx = 3;
			gbc_lblMes.gridy = 0;
			panel.add(getLblMes(), gbc_lblMes);
			GridBagConstraints gbc_lblAo = new GridBagConstraints();
			gbc_lblAo.insets = new Insets(0, 0, 5, 5);
			gbc_lblAo.gridx = 5;
			gbc_lblAo.gridy = 0;
			panel.add(getLblAo(), gbc_lblAo);
			GridBagConstraints gbc_spinnerYear = new GridBagConstraints();
			gbc_spinnerYear.fill = GridBagConstraints.BOTH;
			gbc_spinnerYear.insets = new Insets(0, 0, 5, 5);
			gbc_spinnerYear.gridx = 5;
			gbc_spinnerYear.gridy = 1;
			panel.add(getSpinnerYear(), gbc_spinnerYear);
			GridBagConstraints gbc_comboBoxMonths = new GridBagConstraints();
			gbc_comboBoxMonths.fill = GridBagConstraints.BOTH;
			gbc_comboBoxMonths.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxMonths.gridx = 3;
			gbc_comboBoxMonths.gridy = 1;
			panel.add(getComboBoxMonths(), gbc_comboBoxMonths);
			GridBagConstraints gbc_comboBoxDays = new GridBagConstraints();
			gbc_comboBoxDays.fill = GridBagConstraints.BOTH;
			gbc_comboBoxDays.insets = new Insets(0, 0, 5, 5);
			gbc_comboBoxDays.gridx = 1;
			gbc_comboBoxDays.gridy = 1;
			panel.add(getComboBoxDays(), gbc_comboBoxDays);
		}
		return panel;
	}

	private boolean checkValidity() {
		resetErrorLabels();

		boolean validity = true;

		String name = textFieldName.getText();
		String ISBN = textFieldISBN.getText();
		String location = textFieldLocation.getText();

		if (!Validation.notEmpty(name)) {
			errorName.setVisible(true);
			validity = false;
		}

		if (!Validation.notEmpty(location)) {
			errorLocation.setVisible(true);
			validity = false;
		}

		if (!Validation.validISBN(ISBN)) {
			errorISBN.setVisible(true);
			validity = false;
		}

		return validity;
	}

	private void initForm() {
		textFieldName.setText(breakthrough.getName());
		textFieldISBN.setText(breakthrough.getISBN());
		textFieldLocation.setText(breakthrough.getLocation());

		LocalDate date = breakthrough.getDate();

		comboBoxDays.setSelectedItem(String.valueOf(date.getDayOfMonth()));
		comboBoxMonths.setSelectedItem(String.valueOf(date.getMonthValue()));
		spinnerYear.setValue(date.getYear());
	}

	private void reset() {
		resetErrorLabels();

		if (breakthrough == null) {
			textFieldName.setText("");
			textFieldISBN.setText("");
			textFieldLocation.setText("");

			comboBoxDays.setSelectedIndex(0);
			comboBoxMonths.setSelectedIndex(0);
			spinnerYear.setValue(Year.now().getValue());
		} else {
			initForm();
			btnAgregar.setEnabled(false);
		}
	}

	private void resetErrorLabels() {
		errorName.setVisible(false);
		errorLocation.setVisible(false);
		errorISBN.setVisible(false);
	}

	private LocalDate getDate() {
		int day = Integer.valueOf((String) comboBoxDays.getSelectedItem());
		int month = comboBoxMonths.getSelectedIndex() + 1;
		int year = (Integer) spinnerYear.getValue();

		return LocalDate.of(year, month, day);
	}

	private void sendFeedback() {
		JOptionPane.showMessageDialog(null, "¿Se ha registrado la ponencia correctamente!", "Mensaje",
				JOptionPane.PLAIN_MESSAGE);
	}

	private void submit() {
		if (checkValidity()) {
			String name = textFieldName.getText().trim();
			String ISBN = textFieldISBN.getText().trim();
			String location = textFieldLocation.getText().trim();

			LocalDate date = getDate();

			if (breakthrough == null) {
				try {
					researcher.addPresentation(name, date, ISBN, location);

					if (listener != null)
						listener.actionPerformed();

					reset();
					sendFeedback();
				} catch (IllegalArgumentException exception) {
					errorISBN.setVisible(true);
				}
			} else {
				Validation.removeValue("ISBN", ISBN);

				breakthrough.setName(name);
				breakthrough.setISBN(ISBN);
				breakthrough.setLocation(location);
				breakthrough.setDate(date);

				if (listener != null)
					listener.actionPerformed();

				reset();
				sendFeedback();
			}

		}
	}

	private ErrorLabel getErrorName() {
		if (errorName == null) {
			errorName = new ErrorLabel();
			errorName.setText("El nombre es requerido");
		}
		return errorName;
	}

	private ErrorLabel getErrorISBN() {
		if (errorISBN == null) {
			errorISBN = new ErrorLabel();
			errorISBN.setText("El c\u00F3digo ISBN es \u00FAnico y consta de 10 o 13 d\u00EFgitos");
		}
		return errorISBN;
	}

	private ErrorLabel getErrorLocation() {
		if (errorLocation == null) {
			errorLocation = new ErrorLabel();
			errorLocation.setText("La localizaci\u00F3n es requerida");
		}
		return errorLocation;
	}

	public void hasChanges() {
		String name = textFieldName.getText().trim();
		String code = textFieldISBN.getText().trim();
		String local = textFieldLocation.getText().trim();
		int day = Integer.valueOf((String) comboBoxDays.getSelectedItem());
		int month = comboBoxMonths.getSelectedIndex() + 1;
		int year = (Integer) spinnerYear.getValue();
		
		boolean differs = !breakthrough.getName().equals(name) || !breakthrough.getISBN().equals(code)
				|| !breakthrough.getLocation().equals(local) || breakthrough.getDate().getDayOfMonth() != day
				|| breakthrough.getDate().getMonthValue() != month || breakthrough.getDate().getYear() != year;

		btnAgregar.setEnabled(differs);
	}
}
