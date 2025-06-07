package gui.researchers.activity;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;

import javax.swing.JTextField;

import java.awt.Insets;
import java.time.Year;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;

import utils.Constants;

import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;

public class PaperForm extends JPanel {
	public PaperForm() {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 0, 0, 30, 0, 0, 30, 0, 0, 30, 0, 0, 100, 0};
		gridBagLayout.rowHeights = new int[]{70, 0, 35, 40, 0, 40, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblTtulo = new GridBagConstraints();
		gbc_lblTtulo.gridwidth = 5;
		gbc_lblTtulo.fill = GridBagConstraints.BOTH;
		gbc_lblTtulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTtulo.gridx = 1;
		gbc_lblTtulo.gridy = 1;
		add(getLblTtulo(), gbc_lblTtulo);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 11;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		add(getTextField(), gbc_textField);
		GridBagConstraints gbc_lblNmero = new GridBagConstraints();
		gbc_lblNmero.fill = GridBagConstraints.BOTH;
		gbc_lblNmero.insets = new Insets(0, 0, 5, 5);
		gbc_lblNmero.gridx = 1;
		gbc_lblNmero.gridy = 4;
		add(getLblNmero(), gbc_lblNmero);
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 2;
		gbc_spinner.gridy = 4;
		add(getSpinner(), gbc_spinner);
		GridBagConstraints gbc_lblVolumen = new GridBagConstraints();
		gbc_lblVolumen.insets = new Insets(0, 0, 5, 5);
		gbc_lblVolumen.gridx = 4;
		gbc_lblVolumen.gridy = 4;
		add(getLblVolumen(), gbc_lblVolumen);
		GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
		gbc_spinner_1.fill = GridBagConstraints.BOTH;
		gbc_spinner_1.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_1.gridx = 5;
		gbc_spinner_1.gridy = 4;
		add(getSpinner_1(), gbc_spinner_1);
		GridBagConstraints gbc_lblAo = new GridBagConstraints();
		gbc_lblAo.insets = new Insets(0, 0, 5, 5);
		gbc_lblAo.gridx = 7;
		gbc_lblAo.gridy = 4;
		add(getLblAo(), gbc_lblAo);
		GridBagConstraints gbc_spinner_2 = new GridBagConstraints();
		gbc_spinner_2.fill = GridBagConstraints.BOTH;
		gbc_spinner_2.insets = new Insets(0, 0, 5, 5);
		gbc_spinner_2.gridx = 8;
		gbc_spinner_2.gridy = 4;
		add(getSpinner_2(), gbc_spinner_2);
		GridBagConstraints gbc_lblGrupoDeImpacto = new GridBagConstraints();
		gbc_lblGrupoDeImpacto.insets = new Insets(0, 0, 5, 5);
		gbc_lblGrupoDeImpacto.gridx = 10;
		gbc_lblGrupoDeImpacto.gridy = 4;
		add(getLblGrupoDeImpacto(), gbc_lblGrupoDeImpacto);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 11;
		gbc_comboBox.gridy = 4;
		add(getComboBox(), gbc_comboBox);
		GridBagConstraints gbc_btnRegistrar = new GridBagConstraints();
		gbc_btnRegistrar.anchor = GridBagConstraints.EAST;
		gbc_btnRegistrar.fill = GridBagConstraints.VERTICAL;
		gbc_btnRegistrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegistrar.gridwidth = 11;
		gbc_btnRegistrar.gridx = 1;
		gbc_btnRegistrar.gridy = 6;
		add(getBtnRegistrar(), gbc_btnRegistrar);
	}
	private static final long serialVersionUID = 8204693817348078346L;
	private JLabel lblTtulo;
	private JTextField textField;
	private JLabel lblNmero;
	private JSpinner spinner;
	private JLabel lblVolumen;
	private JSpinner spinner_1;
	private JLabel lblAo;
	private JSpinner spinner_2;
	private JLabel lblGrupoDeImpacto;
	private JComboBox<String> comboBox;
	private JButton btnRegistrar;
	
	private JLabel getLblTtulo() {
		if (lblTtulo == null) {
			lblTtulo = new JLabel("T\u00EDtulo");
			lblTtulo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblTtulo;
	}
	
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textField.setColumns(10);
		}
		return textField;
	}
	
	private JLabel getLblNmero() {
		if (lblNmero == null) {
			lblNmero = new JLabel("N\u00FAmero");
			lblNmero.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblNmero;
	}
	
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinner.setForeground(Color.WHITE);
			spinner.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return spinner;
	}
	
	private JLabel getLblVolumen() {
		if (lblVolumen == null) {
			lblVolumen = new JLabel("Volumen");
			lblVolumen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblVolumen;
	}
	
	private JSpinner getSpinner_1() {
		if (spinner_1 == null) {
			spinner_1 = new JSpinner();
			spinner_1.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spinner_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			spinner_1.setForeground(Color.WHITE);
		}
		return spinner_1;
	}
	
	private JLabel getLblAo() {
		if (lblAo == null) {
			lblAo = new JLabel("A\u00F1o");
			lblAo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblAo;
	}
	
	private JSpinner getSpinner_2() {
		if (spinner_2 == null) {
			spinner_2 = new JSpinner();
			
			spinner_2.setModel(new SpinnerNumberModel(Year.now().getValue(), 1, Year.now().getValue(), 1));
			spinner_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			spinner_2.setForeground(Color.WHITE);
		}
		return spinner_2;
	}
	
	private JLabel getLblGrupoDeImpacto() {
		if (lblGrupoDeImpacto == null) {
			lblGrupoDeImpacto = new JLabel("Grupo de impacto");
			lblGrupoDeImpacto.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		
		return lblGrupoDeImpacto;
	}
	
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<>();
			comboBox.setBackground(Color.WHITE);
			comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Web de ciencia", "Grupo 1", "Grupo 2", "Grupo 3", "Grupo 4"}));
			comboBox.setSelectedIndex(0);
		}
		return comboBox;
	}
	
	private JButton getBtnRegistrar() {
		if (btnRegistrar == null) {
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.setForeground(Color.WHITE);
			btnRegistrar.setBackground(Constants.getInsertionBtnColor());
			btnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		}
		return btnRegistrar;
	}
}
