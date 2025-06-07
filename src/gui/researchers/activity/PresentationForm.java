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
import javax.swing.JButton;

import utils.Constants;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.SpinnerNumberModel;

public class PresentationForm extends JPanel {
	public PresentationForm() {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 0, 100, 100, 0};
		gridBagLayout.rowHeights = new int[]{70, 0, 35, 40, 0, 35, 40, 0, 35, 40, 0, 40, 0, 40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.gridwidth = 2;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 1;
		add(getLblNombre(), gbc_lblNombre);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		add(getTextField(), gbc_textField);
		GridBagConstraints gbc_lblCdigoIsbn = new GridBagConstraints();
		gbc_lblCdigoIsbn.fill = GridBagConstraints.BOTH;
		gbc_lblCdigoIsbn.gridwidth = 2;
		gbc_lblCdigoIsbn.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoIsbn.gridx = 1;
		gbc_lblCdigoIsbn.gridy = 4;
		add(getLblCdigoIsbn(), gbc_lblCdigoIsbn);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 5;
		add(getTextField_1(), gbc_textField_1);
		GridBagConstraints gbc_lblLocalizacin = new GridBagConstraints();
		gbc_lblLocalizacin.fill = GridBagConstraints.BOTH;
		gbc_lblLocalizacin.gridwidth = 2;
		gbc_lblLocalizacin.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocalizacin.gridx = 1;
		gbc_lblLocalizacin.gridy = 7;
		add(getLblLocalizacin(), gbc_lblLocalizacin);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 8;
		add(getTextField_2(), gbc_textField_2);
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
	}
	private static final long serialVersionUID = 1218122467482657932L;
	private JLabel lblNombre;
	private JTextField textField;
	private JLabel lblCdigoIsbn;
	private JTextField textField_1;
	private JLabel lblLocalizacin;
	private JTextField textField_2;
	private JLabel lblDa;
	private JLabel lblMes;
	private JLabel lblAo;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JButton btnAgregar;
	private JPanel panel;
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lblNombre.setBackground(Color.WHITE);
		}
		return lblNombre;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblCdigoIsbn() {
		if (lblCdigoIsbn == null) {
			lblCdigoIsbn = new JLabel("C\u00F3digo ISBN");
			lblCdigoIsbn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lblCdigoIsbn.setBackground(Color.WHITE);
		}
		return lblCdigoIsbn;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLblLocalizacin() {
		if (lblLocalizacin == null) {
			lblLocalizacin = new JLabel("Localizaci\u00F3n");
			lblLocalizacin.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lblLocalizacin.setBackground(Color.WHITE);
		}
		return lblLocalizacin;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
		}
		return textField_2;
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
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(1, 1, 30, 1));
			spinner.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			spinner.setBackground(Color.WHITE);
		}
		return spinner;
	}
	private JSpinner getSpinner_1() {
		if (spinner_1 == null) {
			spinner_1 = new JSpinner();
			spinner_1.setModel(new SpinnerNumberModel(1, 1, 12, 1));
			spinner_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return spinner_1;
	}
	private JSpinner getSpinner_2() {
		if (spinner_2 == null) {
			spinner_2 = new JSpinner();
			spinner_2.setModel(new SpinnerNumberModel(Year.now().getValue(), 1, Year.now().getValue(), 1));
			spinner_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return spinner_2;
	}
	private JButton getBtnAgregar() {
		if (btnAgregar == null) {
			btnAgregar = new JButton("Agregar");
			btnAgregar.setForeground(Color.WHITE);
			btnAgregar.setBackground(Constants.getInsertionBtnColor());
			btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		}
		return btnAgregar;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 51, 153)), "Fecha", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 51, 255)));
			panel.setBackground(Color.WHITE);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 100, 35, 100, 35, 100, 0, 0};
			gbl_panel.rowHeights = new int[]{21, 35, 21, 0};
			gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
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
			GridBagConstraints gbc_spinner = new GridBagConstraints();
			gbc_spinner.fill = GridBagConstraints.BOTH;
			gbc_spinner.insets = new Insets(0, 0, 5, 5);
			gbc_spinner.gridx = 1;
			gbc_spinner.gridy = 1;
			panel.add(getSpinner(), gbc_spinner);
			GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
			gbc_spinner_1.fill = GridBagConstraints.BOTH;
			gbc_spinner_1.insets = new Insets(0, 0, 5, 5);
			gbc_spinner_1.gridx = 3;
			gbc_spinner_1.gridy = 1;
			panel.add(getSpinner_1(), gbc_spinner_1);
			GridBagConstraints gbc_spinner_2 = new GridBagConstraints();
			gbc_spinner_2.fill = GridBagConstraints.BOTH;
			gbc_spinner_2.insets = new Insets(0, 0, 5, 5);
			gbc_spinner_2.gridx = 5;
			gbc_spinner_2.gridy = 1;
			panel.add(getSpinner_2(), gbc_spinner_2);
		}
		return panel;
	}
}
