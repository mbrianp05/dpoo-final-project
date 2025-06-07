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
import javax.swing.JButton;
import gui.component.MultipleInput;

public class BookChapterForm extends JPanel {
	public BookChapterForm() {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 35, 0, 0, 35, 0, 150, 150, 0, 0, 35, 0, 0, 35, 0, 0, 35, 0, 40, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		GridBagConstraints gbc_editorsInput = new GridBagConstraints();
		gbc_editorsInput.insets = new Insets(0, 0, 5, 0);
		gbc_editorsInput.fill = GridBagConstraints.BOTH;
		gbc_editorsInput.gridx = 0;
		gbc_editorsInput.gridy = 8;
		add(getMultipleInput_1(), gbc_editorsInput);
		GridBagConstraints gbc_lblEditorial = new GridBagConstraints();
		gbc_lblEditorial.insets = new Insets(0, 0, 5, 0);
		gbc_lblEditorial.fill = GridBagConstraints.BOTH;
		gbc_lblEditorial.gridx = 0;
		gbc_lblEditorial.gridy = 10;
		add(getLblEditorial(), gbc_lblEditorial);
		GridBagConstraints gbc_textFieldEditorial = new GridBagConstraints();
		gbc_textFieldEditorial.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldEditorial.fill = GridBagConstraints.BOTH;
		gbc_textFieldEditorial.gridx = 0;
		gbc_textFieldEditorial.gridy = 11;
		add(getTextFieldEditorial(), gbc_textFieldEditorial);
		GridBagConstraints gbc_lblCdigoIssn = new GridBagConstraints();
		gbc_lblCdigoIssn.insets = new Insets(0, 0, 5, 0);
		gbc_lblCdigoIssn.fill = GridBagConstraints.BOTH;
		gbc_lblCdigoIssn.gridx = 0;
		gbc_lblCdigoIssn.gridy = 13;
		add(getLblCdigoIssn(), gbc_lblCdigoIssn);
		GridBagConstraints gbc_textFieldISSN = new GridBagConstraints();
		gbc_textFieldISSN.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldISSN.fill = GridBagConstraints.BOTH;
		gbc_textFieldISSN.gridx = 0;
		gbc_textFieldISSN.gridy = 14;
		add(getTextFieldISSN(), gbc_textFieldISSN);
		GridBagConstraints gbc_lblVolumen = new GridBagConstraints();
		gbc_lblVolumen.fill = GridBagConstraints.BOTH;
		gbc_lblVolumen.insets = new Insets(0, 0, 5, 0);
		gbc_lblVolumen.gridx = 0;
		gbc_lblVolumen.gridy = 16;
		add(getLblVolumen(), gbc_lblVolumen);
		GridBagConstraints gbc_textFieldVol = new GridBagConstraints();
		gbc_textFieldVol.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldVol.fill = GridBagConstraints.BOTH;
		gbc_textFieldVol.gridx = 0;
		gbc_textFieldVol.gridy = 17;
		add(getTextFieldVol(), gbc_textFieldVol);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 19;
		add(getBtnNewButton(), gbc_btnNewButton);
	}
	private static final long serialVersionUID = 8688995113018695988L;
	private JLabel lblBookName;
	private JTextField textFieldBookName;
	private JLabel lblEditorial;
	private JTextField textFieldEditorial;
	private JLabel lblCdigoIssn;
	private JTextField textFieldISSN;
	private JLabel lblTtuloDelCaptulo;
	private JTextField textFieldChapter;
	private JLabel lblVolumen;
	private JTextField textFieldVol;
	private JButton btnNewButton;
	private MultipleInput authorsInput;
	private MultipleInput editorsInput;

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
	private JTextField getTextFieldEditorial() {
		if (textFieldEditorial == null) {
			textFieldEditorial = new JTextField();
			textFieldEditorial.setColumns(10);
		}
		return textFieldEditorial;
	}
	private JLabel getLblCdigoIssn() {
		if (lblCdigoIssn == null) {
			lblCdigoIssn = new JLabel("C\u00F3digo ISSN");
			lblCdigoIssn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblCdigoIssn;
	}
	private JTextField getTextFieldISSN() {
		if (textFieldISSN == null) {
			textFieldISSN = new JTextField();
			textFieldISSN.setColumns(10);
		}
		return textFieldISSN;
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
	private JLabel getLblVolumen() {
		if (lblVolumen == null) {
			lblVolumen = new JLabel("Volumen");
			lblVolumen.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblVolumen;
	}
	private JTextField getTextFieldVol() {
		if (textFieldVol == null) {
			textFieldVol = new JTextField();
			textFieldVol.setColumns(10);
		}
		return textFieldVol;
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
		if (editorsInput == null) {
			editorsInput = new MultipleInput("Editores", "");
		}
		return editorsInput;
	}
}
