package gui.researchers.activity;

import javax.swing.JPanel;

import java.awt.Color;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import utils.Constants;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class BookChapterForm extends JPanel {
	public BookChapterForm() {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 35, 0, 0, 35, 0, 0, 35, 35, 0, 0, 35, 35, 0, 0, 35, 0, 0, 35, 0, 0, 35, 0, 40, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblBookName = new GridBagConstraints();
		gbc_lblBookName.fill = GridBagConstraints.BOTH;
		gbc_lblBookName.insets = new Insets(0, 0, 5, 0);
		gbc_lblBookName.gridx = 0;
		gbc_lblBookName.gridy = 1;
		add(getLblBookName(), gbc_lblBookName);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		add(getTextField(), gbc_textField);
		GridBagConstraints gbc_lblTtuloDelCaptulo = new GridBagConstraints();
		gbc_lblTtuloDelCaptulo.fill = GridBagConstraints.BOTH;
		gbc_lblTtuloDelCaptulo.insets = new Insets(0, 0, 5, 0);
		gbc_lblTtuloDelCaptulo.gridx = 0;
		gbc_lblTtuloDelCaptulo.gridy = 4;
		add(getLblTtuloDelCaptulo(), gbc_lblTtuloDelCaptulo);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.insets = new Insets(0, 0, 5, 0);
		gbc_textField_5.fill = GridBagConstraints.BOTH;
		gbc_textField_5.gridx = 0;
		gbc_textField_5.gridy = 5;
		add(getTextField_5(), gbc_textField_5);
		GridBagConstraints gbc_lblChapterName = new GridBagConstraints();
		gbc_lblChapterName.fill = GridBagConstraints.BOTH;
		gbc_lblChapterName.insets = new Insets(0, 0, 5, 0);
		gbc_lblChapterName.gridx = 0;
		gbc_lblChapterName.gridy = 7;
		add(getLblChapterName(), gbc_lblChapterName);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 0;
		gbc_comboBox.gridy = 8;
		add(getComboBox(), gbc_comboBox);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 9;
		add(getTextField_2(), gbc_textField_2);
		GridBagConstraints gbc_lblEditors = new GridBagConstraints();
		gbc_lblEditors.insets = new Insets(0, 0, 5, 0);
		gbc_lblEditors.fill = GridBagConstraints.BOTH;
		gbc_lblEditors.gridx = 0;
		gbc_lblEditors.gridy = 11;
		add(getLblEditors(), gbc_lblEditors);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.BOTH;
		gbc_comboBox_1.gridx = 0;
		gbc_comboBox_1.gridy = 12;
		add(getComboBox_1(), gbc_comboBox_1);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 13;
		add(getTextField_1(), gbc_textField_1);
		GridBagConstraints gbc_lblEditorial = new GridBagConstraints();
		gbc_lblEditorial.insets = new Insets(0, 0, 5, 0);
		gbc_lblEditorial.fill = GridBagConstraints.BOTH;
		gbc_lblEditorial.gridx = 0;
		gbc_lblEditorial.gridy = 15;
		add(getLblEditorial(), gbc_lblEditorial);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.gridx = 0;
		gbc_textField_3.gridy = 16;
		add(getTextField_3(), gbc_textField_3);
		GridBagConstraints gbc_lblCdigoIssn = new GridBagConstraints();
		gbc_lblCdigoIssn.insets = new Insets(0, 0, 5, 0);
		gbc_lblCdigoIssn.fill = GridBagConstraints.BOTH;
		gbc_lblCdigoIssn.gridx = 0;
		gbc_lblCdigoIssn.gridy = 18;
		add(getLblCdigoIssn(), gbc_lblCdigoIssn);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.BOTH;
		gbc_textField_4.gridx = 0;
		gbc_textField_4.gridy = 19;
		add(getTextField_4(), gbc_textField_4);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 21;
		add(getLabel(), gbc_label);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.fill = GridBagConstraints.BOTH;
		gbc_textField_6.gridx = 0;
		gbc_textField_6.gridy = 22;
		add(getTextField_6(), gbc_textField_6);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 24;
		add(getBtnNewButton(), gbc_btnNewButton);
	}
	private static final long serialVersionUID = 8688995113018695988L;
	private JLabel lblBookName;
	private JTextField textField;
	private JLabel lblChapterName;
	private JTextField textField_2;
	private JComboBox comboBox;
	private JLabel lblEditors;
	private JComboBox comboBox_1;
	private JTextField textField_1;
	private JLabel lblEditorial;
	private JTextField textField_3;
	private JLabel lblCdigoIssn;
	private JTextField textField_4;
	private JLabel lblTtuloDelCaptulo;
	private JTextField textField_5;
	private JLabel label;
	private JTextField textField_6;
	private JButton btnNewButton;

	private JLabel getLblBookName() {
		if (lblBookName == null) {
			lblBookName = new JLabel("Nombre del libro");
			lblBookName.setFont(Constants.getLabelFont());
		}
		return lblBookName;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblChapterName() {
		if (lblChapterName == null) {
			lblChapterName = new JLabel("Autores");
			lblChapterName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblChapterName;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
		}
		return comboBox;
	}
	private JLabel getLblEditors() {
		if (lblEditors == null) {
			lblEditors = new JLabel("Editores");
			lblEditors.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblEditors;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
		}
		return comboBox_1;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLblEditorial() {
		if (lblEditorial == null) {
			lblEditorial = new JLabel("Editorial");
			lblEditorial.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblEditorial;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JLabel getLblCdigoIssn() {
		if (lblCdigoIssn == null) {
			lblCdigoIssn = new JLabel("C\u00F3digo ISSN");
			lblCdigoIssn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblCdigoIssn;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
		}
		return textField_4;
	}
	private JLabel getLblTtuloDelCaptulo() {
		if (lblTtuloDelCaptulo == null) {
			lblTtuloDelCaptulo = new JLabel("T\u00EDtulo del cap\u00EDtulo");
			lblTtuloDelCaptulo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblTtuloDelCaptulo;
	}
	private JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setColumns(10);
		}
		return textField_5;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("C\u00F3digo ISSN");
			label.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return label;
	}
	private JTextField getTextField_6() {
		if (textField_6 == null) {
			textField_6 = new JTextField();
			textField_6.setColumns(10);
		}
		return textField_6;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Agregar");
			btnNewButton.setBackground(Constants.getInsertionBtnColor());
			btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
			btnNewButton.setForeground(Color.WHITE);
		}
		return btnNewButton;
	}
}
