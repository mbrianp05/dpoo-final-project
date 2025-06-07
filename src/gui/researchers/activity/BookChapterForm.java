package gui.researchers.activity;

import javax.swing.JPanel;

import java.awt.Color;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import utils.Constants;

import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import gui.component.MultipleInput;

public class BookChapterForm extends JPanel {
	public BookChapterForm() {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 35, 0, 0, 35, 0, 150, 150, 0, 0, 35, 0, 0, 35, 0, 0, 35, 0, 0, 35, 40, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblBookName = new GridBagConstraints();
		gbc_lblBookName.fill = GridBagConstraints.BOTH;
		gbc_lblBookName.insets = new Insets(0, 0, 5, 0);
		gbc_lblBookName.gridx = 0;
		gbc_lblBookName.gridy = 1;
		add(getLblBookName(), gbc_lblBookName);
		GridBagConstraints gbc_textFieldBookName = new GridBagConstraints();
		gbc_textFieldBookName.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldBookName.fill = GridBagConstraints.BOTH;
		gbc_textFieldBookName.gridx = 0;
		gbc_textFieldBookName.gridy = 2;
		add(getTextFieldBookName(), gbc_textFieldBookName);
		GridBagConstraints gbc_lblTtuloDelCaptulo = new GridBagConstraints();
		gbc_lblTtuloDelCaptulo.fill = GridBagConstraints.BOTH;
		gbc_lblTtuloDelCaptulo.insets = new Insets(0, 0, 5, 0);
		gbc_lblTtuloDelCaptulo.gridx = 0;
		gbc_lblTtuloDelCaptulo.gridy = 4;
		add(getLblTtuloDelCaptulo(), gbc_lblTtuloDelCaptulo);
		GridBagConstraints gbc_textFieldChapter = new GridBagConstraints();
		gbc_textFieldChapter.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldChapter.fill = GridBagConstraints.BOTH;
		gbc_textFieldChapter.gridx = 0;
		gbc_textFieldChapter.gridy = 5;
		add(getTextFieldChapter(), gbc_textFieldChapter);
		GridBagConstraints gbc_authorsInput = new GridBagConstraints();
		gbc_authorsInput.insets = new Insets(0, 0, 5, 0);
		gbc_authorsInput.fill = GridBagConstraints.BOTH;
		gbc_authorsInput.gridx = 0;
		gbc_authorsInput.gridy = 7;
		add(getAuthorsInput(), gbc_authorsInput);
		GridBagConstraints gbc_multipleInput = new GridBagConstraints();
		gbc_multipleInput.insets = new Insets(0, 0, 5, 0);
		gbc_multipleInput.fill = GridBagConstraints.BOTH;
		gbc_multipleInput.gridx = 0;
		gbc_multipleInput.gridy = 8;
		add(getMultipleInput_1(), gbc_multipleInput);
		GridBagConstraints gbc_lblEditorial = new GridBagConstraints();
		gbc_lblEditorial.insets = new Insets(0, 0, 5, 0);
		gbc_lblEditorial.fill = GridBagConstraints.BOTH;
		gbc_lblEditorial.gridx = 0;
		gbc_lblEditorial.gridy = 10;
		add(getLblEditorial(), gbc_lblEditorial);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.gridx = 0;
		gbc_textField_3.gridy = 11;
		add(getTextField_3(), gbc_textField_3);
		GridBagConstraints gbc_lblCdigoIssn = new GridBagConstraints();
		gbc_lblCdigoIssn.insets = new Insets(0, 0, 5, 0);
		gbc_lblCdigoIssn.fill = GridBagConstraints.BOTH;
		gbc_lblCdigoIssn.gridx = 0;
		gbc_lblCdigoIssn.gridy = 13;
		add(getLblCdigoIssn(), gbc_lblCdigoIssn);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.BOTH;
		gbc_textField_4.gridx = 0;
		gbc_textField_4.gridy = 14;
		add(getTextField_4(), gbc_textField_4);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 16;
		add(getLabel(), gbc_label);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.insets = new Insets(0, 0, 5, 0);
		gbc_textField_6.fill = GridBagConstraints.BOTH;
		gbc_textField_6.gridx = 0;
		gbc_textField_6.gridy = 17;
		add(getTextField_6(), gbc_textField_6);
		GridBagConstraints gbc_lblVolumen = new GridBagConstraints();
		gbc_lblVolumen.fill = GridBagConstraints.BOTH;
		gbc_lblVolumen.insets = new Insets(0, 0, 5, 0);
		gbc_lblVolumen.gridx = 0;
		gbc_lblVolumen.gridy = 19;
		add(getLblVolumen(), gbc_lblVolumen);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 20;
		add(getTextField(), gbc_textField);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 21;
		add(getBtnNewButton(), gbc_btnNewButton);
	}
	private static final long serialVersionUID = 8688995113018695988L;
	private JLabel lblBookName;
	private JTextField textFieldBookName;
	private JLabel lblEditorial;
	private JTextField textField_3;
	private JLabel lblCdigoIssn;
	private JTextField textField_4;
	private JLabel lblTtuloDelCaptulo;
	private JTextField textFieldChapter;
	private JLabel label;
	private JTextField textField_6;
	private JButton btnNewButton;
	private MultipleInput authorsInput;
	private MultipleInput multipleInput;
	private JLabel lblVolumen;
	private JTextField textField;

	private JLabel getLblBookName() {
		if (lblBookName == null) {
			lblBookName = new JLabel("Nombre del libro");
			lblBookName.setFont(Constants.getLabelFont());
		}
		return lblBookName;
	}
	private JTextField getTextFieldBookName() {
		if (textFieldBookName == null) {
			textFieldBookName = new JTextField();
			textFieldBookName.setColumns(10);
		}
		return textFieldBookName;
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
	private JTextField getTextFieldChapter() {
		if (textFieldChapter == null) {
			textFieldChapter = new JTextField();
			textFieldChapter.setColumns(10);
		}
		return textFieldChapter;
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
	private MultipleInput getAuthorsInput() {
		if (authorsInput == null) {
			authorsInput = new MultipleInput("Autores", "");
		}
		return authorsInput;
	}
	private MultipleInput getMultipleInput_1() {
		if (multipleInput == null) {
			multipleInput = new MultipleInput("Editores", "");
		}
		return multipleInput;
	}
	private JLabel getLblVolumen() {
		if (lblVolumen == null) {
			lblVolumen = new JLabel("Volumen");
			lblVolumen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblVolumen;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setColumns(10);
		}
		return textField;
	}
}
