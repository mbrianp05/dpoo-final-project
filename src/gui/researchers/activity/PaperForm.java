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

import schooling.Paper;
import schooling.Researcher;
import schooling.TargetedGroup;
import utils.Constants;
import utils.EnumsDictionary;
import utils.Validation;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class PaperForm extends JPanel {
	private static final long serialVersionUID = 8204693817348078346L;

	private Researcher researcher;
	private Paper breakthrough;
	private OnResearchActivityActionTriggered listener;

	private JLabel lblTtulo;
	private JTextField textFieldTitle;
	private JLabel lblNmero;
	private JLabel lblVolumen;
	private JSpinner spinnerVol;
	private JLabel lblAo;
	private JSpinner spinnerYear;
	private JLabel lblGrupoDeImpacto;
	private JComboBox<String> comboBoxTargetedGroup;
	private JButton btnRegistrar;
	private ErrorLabel errorTitle;
	private JSpinner spinnerNo;

	/**
	 * @wbp.parser.constructor
	 */
	public PaperForm(Researcher researcher) {
		this(researcher, null);
	}

	public PaperForm(Researcher researcher, Paper paper) {
		this.researcher = researcher;
		this.breakthrough = paper;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 0, 0, 30, 0, 0, 30, 0, 0, 30, 0, 0, 100, 0 };
		gridBagLayout.rowHeights = new int[] { 50, 0, 35, 40, 0, 40, 40, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0,
				Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblTtulo = new GridBagConstraints();
		gbc_lblTtulo.gridwidth = 5;
		gbc_lblTtulo.fill = GridBagConstraints.BOTH;
		gbc_lblTtulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTtulo.gridx = 1;
		gbc_lblTtulo.gridy = 1;
		add(getLblTtulo(), gbc_lblTtulo);
		GridBagConstraints gbc_textFieldTitle = new GridBagConstraints();
		gbc_textFieldTitle.gridwidth = 11;
		gbc_textFieldTitle.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldTitle.fill = GridBagConstraints.BOTH;
		gbc_textFieldTitle.gridx = 1;
		gbc_textFieldTitle.gridy = 2;
		add(getTextFieldTitle(), gbc_textFieldTitle);
		GridBagConstraints gbc_errorTitle = new GridBagConstraints();
		gbc_errorTitle.fill = GridBagConstraints.BOTH;
		gbc_errorTitle.gridwidth = 11;
		gbc_errorTitle.insets = new Insets(0, 0, 5, 5);
		gbc_errorTitle.gridx = 1;
		gbc_errorTitle.gridy = 3;
		add(getErrorTitle(), gbc_errorTitle);
		GridBagConstraints gbc_lblNmero = new GridBagConstraints();
		gbc_lblNmero.fill = GridBagConstraints.BOTH;
		gbc_lblNmero.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmero.gridx = 1;
		gbc_lblNmero.gridy = 4;
		add(getLblNmero(), gbc_lblNmero);
		GridBagConstraints gbc_spinnerNo = new GridBagConstraints();
		gbc_spinnerNo.fill = GridBagConstraints.BOTH;
		gbc_spinnerNo.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerNo.gridx = 2;
		gbc_spinnerNo.gridy = 4;
		add(getSpinnerNo(), gbc_spinnerNo);
		GridBagConstraints gbc_lblVolumen = new GridBagConstraints();
		gbc_lblVolumen.insets = new Insets(0, 0, 5, 5);
		gbc_lblVolumen.gridx = 4;
		gbc_lblVolumen.gridy = 4;
		add(getLblVolumen(), gbc_lblVolumen);
		GridBagConstraints gbc_spinnerVol = new GridBagConstraints();
		gbc_spinnerVol.fill = GridBagConstraints.BOTH;
		gbc_spinnerVol.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerVol.gridx = 5;
		gbc_spinnerVol.gridy = 4;
		add(getSpinnerVol(), gbc_spinnerVol);
		GridBagConstraints gbc_lblAo = new GridBagConstraints();
		gbc_lblAo.insets = new Insets(0, 0, 5, 5);
		gbc_lblAo.gridx = 7;
		gbc_lblAo.gridy = 4;
		add(getLblAo(), gbc_lblAo);
		GridBagConstraints gbc_spinnerYear = new GridBagConstraints();
		gbc_spinnerYear.fill = GridBagConstraints.BOTH;
		gbc_spinnerYear.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerYear.gridx = 8;
		gbc_spinnerYear.gridy = 4;
		add(getSpinnerYear(), gbc_spinnerYear);
		GridBagConstraints gbc_lblGrupoDeImpacto = new GridBagConstraints();
		gbc_lblGrupoDeImpacto.insets = new Insets(0, 0, 5, 5);
		gbc_lblGrupoDeImpacto.gridx = 10;
		gbc_lblGrupoDeImpacto.gridy = 4;
		add(getLblGrupoDeImpacto(), gbc_lblGrupoDeImpacto);
		GridBagConstraints gbc_comboBoxTargetedGroup = new GridBagConstraints();
		gbc_comboBoxTargetedGroup.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxTargetedGroup.fill = GridBagConstraints.BOTH;
		gbc_comboBoxTargetedGroup.gridx = 11;
		gbc_comboBoxTargetedGroup.gridy = 4;
		add(getComboBoxTargetedGroup(), gbc_comboBoxTargetedGroup);
		GridBagConstraints gbc_btnRegistrar = new GridBagConstraints();
		gbc_btnRegistrar.anchor = GridBagConstraints.EAST;
		gbc_btnRegistrar.fill = GridBagConstraints.VERTICAL;
		gbc_btnRegistrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistrar.gridx = 11;
		gbc_btnRegistrar.gridy = 6;
		add(getBtnRegistrar(), gbc_btnRegistrar);

		reset();
	}

	public void listenTo(OnResearchActivityActionTriggered listener) {
		this.listener = listener;
	}

	private JLabel getLblTtulo() {
		if (lblTtulo == null) {
			lblTtulo = new JLabel("T\u00EDtulo");
			lblTtulo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblTtulo;
	}

	private JTextField getTextFieldTitle() {
		if (textFieldTitle == null) {
			textFieldTitle = new JTextField();
			if (breakthrough != null) {
				textFieldTitle.addKeyListener(new KeyAdapter() {
					@Override
					public void keyReleased(KeyEvent arg0) {
						hasChanges();
					}
				});
				textFieldTitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
				textFieldTitle.setColumns(10);
			}
		}
		return textFieldTitle;
	}

	private JLabel getLblNmero() {
		if (lblNmero == null) {
			lblNmero = new JLabel("N\u00FAmero");
			lblNmero.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblNmero;
	}

	private JLabel getLblVolumen() {
		if (lblVolumen == null) {
			lblVolumen = new JLabel("Volumen");
			lblVolumen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblVolumen;
	}

	private JSpinner getSpinnerVol() {
		if (spinnerVol == null) {
			spinnerVol = new JSpinner();
			spinnerVol.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinnerVol.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			spinnerVol.setForeground(Color.WHITE);

			if (breakthrough != null) {
				spinnerVol.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {
						hasChanges();
					}
				});
				spinnerVol.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent arg0) {
						hasChanges();
					}
				});
			}
		}
		return spinnerVol;
	}

	private JLabel getLblAo() {
		if (lblAo == null) {
			lblAo = new JLabel("A\u00F1o");
			lblAo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblAo;
	}

	private JSpinner getSpinnerYear() {
		if (spinnerYear == null) {
			spinnerYear = new JSpinner();

			spinnerYear.setModel(new SpinnerNumberModel(Year.now().getValue(), 1, Year.now().getValue(), 1));
			spinnerYear.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			spinnerYear.setForeground(Color.WHITE);

			if (breakthrough != null) {
				spinnerYear.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {
						hasChanges();
					}
				});
				spinnerYear.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent arg0) {
						hasChanges();
					}
				});
			}
		}
		return spinnerYear;
	}

	private JLabel getLblGrupoDeImpacto() {
		if (lblGrupoDeImpacto == null) {
			lblGrupoDeImpacto = new JLabel("Grupo de impacto");
			lblGrupoDeImpacto.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}

		return lblGrupoDeImpacto;
	}

	private JComboBox<String> getComboBoxTargetedGroup() {
		if (comboBoxTargetedGroup == null) {
			comboBoxTargetedGroup = new JComboBox<>();
			comboBoxTargetedGroup.setBackground(Color.WHITE);
			comboBoxTargetedGroup.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			comboBoxTargetedGroup.setModel(new DefaultComboBoxModel<>(
					new String[] { "Web de ciencia", "Grupo 1", "Grupo 2", "Grupo 3", "Grupo 4" }));
			comboBoxTargetedGroup.setSelectedIndex(0);

			if (breakthrough != null) {
				comboBoxTargetedGroup.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						hasChanges();
					}
				});
			}
		}
		return comboBoxTargetedGroup;
	}

	private JButton getBtnRegistrar() {
		if (btnRegistrar == null) {
			btnRegistrar = new JButton(breakthrough == null ? "Registrar" : "Editar");
			btnRegistrar.setForeground(Constants.getFormBtnForeground());
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					submit();
				}
			});
			btnRegistrar.setBackground(Constants.getInsertionBtnColor());
			btnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 15));

			if (breakthrough != null)
				btnRegistrar.setEnabled(false);
		}
		return btnRegistrar;
	}

	private boolean checkValidity() {
		boolean validity = true;
		String title = textFieldTitle.getText();

		if (!Validation.notEmpty(title)) {
			errorTitle.setVisible(true);
			validity = false;
		}

		return validity;
	}

	private TargetedGroup getGroup() {
		TargetedGroup group;

		switch (comboBoxTargetedGroup.getSelectedIndex()) {
			case 0:
				group = TargetedGroup.Wos;
				break;
			case 1:
				group = TargetedGroup.Group1;
				break;
			case 2:
				group = TargetedGroup.Group2;
				break;
			case 3:
				group = TargetedGroup.Group3;
				break;
			default:
			case 4:
				group = TargetedGroup.Group4;
		}

		return group;
	}

	private void initForm() {
		textFieldTitle.setText(breakthrough.getTitle());
		spinnerYear.setValue(breakthrough.getYear());
		spinnerNo.setValue(breakthrough.getNo());
		spinnerVol.setValue(breakthrough.getVolume());
		comboBoxTargetedGroup.setSelectedItem(EnumsDictionary.group(breakthrough.getGroup()));
	}

	private void reset() {
		if (breakthrough == null) {
			textFieldTitle.setText("");
			spinnerYear.setValue(Year.now().getValue());
			spinnerVol.setValue(1);
			spinnerNo.setValue(1);
			comboBoxTargetedGroup.setSelectedIndex(0);
		} else {
			initForm();
			btnRegistrar.setEnabled(false);
		}

		errorTitle.setVisible(false);
	}

	private void sendFeedback() {
		JOptionPane.showMessageDialog(null, "�Se ha registrado el art�culo correctamente!", "Mensaje",
				JOptionPane.PLAIN_MESSAGE);
	}

	private void submit() {
		if (checkValidity()) {
			String title = textFieldTitle.getText();
			int no = (Integer) spinnerNo.getValue();
			int year = (Integer) spinnerYear.getValue();
			int vol = (Integer) spinnerVol.getValue();
			TargetedGroup group = getGroup();

			if (breakthrough == null) {
				researcher.addPaper(title, no, vol, year, group);
			} else {
				breakthrough.setTitle(title);
				breakthrough.setNo(no);
				breakthrough.setYear(year);
				breakthrough.setGroup(group);
				breakthrough.setVolume(vol);
			}

			if (listener != null) {
				listener.actionPerformed();
			}

			reset();
			sendFeedback();
		}
	}

	private ErrorLabel getErrorTitle() {
		if (errorTitle == null) {
			errorTitle = new ErrorLabel();
			errorTitle.setText("El t\u00EDtulo es requerido");
		}
		return errorTitle;
	}

	private JSpinner getSpinnerNo() {
		if (spinnerNo == null) {
			spinnerNo = new JSpinner();
			spinnerNo.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinnerNo.setBackground(Color.WHITE);
			spinnerNo.setFont(new Font("Segoe UI", Font.PLAIN, 15));

			if (breakthrough != null) {
				spinnerNo.addKeyListener(new KeyAdapter() {
					@Override
					public void keyTyped(KeyEvent arg0) {
						hasChanges();
					}
				});
				spinnerNo.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent arg0) {
						hasChanges();
					}
				});
			}
		}
		return spinnerNo;
	}

	public void hasChanges() {
		String title = textFieldTitle.getText().trim();
		int num = (Integer) spinnerNo.getValue();
		int vol = (Integer) spinnerVol.getValue();
		int year = (Integer) spinnerYear.getValue();

		boolean differs = !breakthrough.getTitle().equals(title) || breakthrough.getNo() != num
				|| breakthrough.getVolume() != vol
				|| breakthrough.getYear() != year || breakthrough.getGroup() != getGroup();

		btnRegistrar.setEnabled(differs);
	}
}
