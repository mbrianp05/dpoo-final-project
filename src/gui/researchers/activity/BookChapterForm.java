package gui.researchers.activity;

import gui.component.ErrorLabel;
import gui.component.MultipleInput;
import gui.event.OnResearchActivityActionTriggered;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import schooling.Chapter;
import schooling.Researcher;
import utils.Constants;
import utils.Validation;

public class BookChapterForm extends JPanel {
	private Researcher researcher;
	private Chapter breakthrough;

	private OnResearchActivityActionTriggered listener;

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
	private JSpinner spinnerVol;
	private JButton btnNewButton;
	private MultipleInput authorsInput;
	private MultipleInput editorsInput;
	private ErrorLabel errorBookName;
	private ErrorLabel errorChapter;
	private ErrorLabel errorEditorial;
	private ErrorLabel errorISSN;
	private ErrorLabel errorVol;


	public BookChapterForm(Researcher researcher) {
		this(researcher, null);
	}

	/**
	 * @wbp.parser.constructor
	 */
	public BookChapterForm(Researcher researcher, Chapter breakthrough) {
		this.researcher = researcher;
		this.breakthrough = breakthrough;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 0, 0, 0, 30, 0, 100};
		gridBagLayout.rowHeights = new int[]{50, 0, 35, 30, 0, 35, 30, 0, 10, 0, 35, 30, 0, 35, 30, 35, 30, 20, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblBookName = new GridBagConstraints();
		gbc_lblBookName.gridwidth = 5;
		gbc_lblBookName.fill = GridBagConstraints.BOTH;
		gbc_lblBookName.insets = new Insets(0, 0, 5, 5);
		gbc_lblBookName.gridx = 1;
		gbc_lblBookName.gridy = 1;
		add(getLblBookName(), gbc_lblBookName);
		GridBagConstraints gbc_textFieldBookName = new GridBagConstraints();
		gbc_textFieldBookName.gridwidth = 5;
		gbc_textFieldBookName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldBookName.fill = GridBagConstraints.BOTH;
		gbc_textFieldBookName.gridx = 1;
		gbc_textFieldBookName.gridy = 2;
		add(getTextFieldBookName(), gbc_textFieldBookName);
		GridBagConstraints gbc_errorBookName = new GridBagConstraints();
		gbc_errorBookName.fill = GridBagConstraints.BOTH;
		gbc_errorBookName.gridwidth = 5;
		gbc_errorBookName.insets = new Insets(0, 0, 5, 5);
		gbc_errorBookName.gridx = 1;
		gbc_errorBookName.gridy = 3;
		add(getErrorBookName(), gbc_errorBookName);
		GridBagConstraints gbc_lblTtuloDelCaptulo = new GridBagConstraints();
		gbc_lblTtuloDelCaptulo.gridwidth = 5;
		gbc_lblTtuloDelCaptulo.fill = GridBagConstraints.BOTH;
		gbc_lblTtuloDelCaptulo.insets = new Insets(0, 0, 5, 5);
		gbc_lblTtuloDelCaptulo.gridx = 1;
		gbc_lblTtuloDelCaptulo.gridy = 4;
		add(getLblTtuloDelCaptulo(), gbc_lblTtuloDelCaptulo);
		GridBagConstraints gbc_textFieldChapter = new GridBagConstraints();
		gbc_textFieldChapter.gridwidth = 5;
		gbc_textFieldChapter.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldChapter.fill = GridBagConstraints.BOTH;
		gbc_textFieldChapter.gridx = 1;
		gbc_textFieldChapter.gridy = 5;
		add(getTextFieldChapter(), gbc_textFieldChapter);
		GridBagConstraints gbc_errorChapter = new GridBagConstraints();
		gbc_errorChapter.fill = GridBagConstraints.BOTH;
		gbc_errorChapter.gridwidth = 5;
		gbc_errorChapter.insets = new Insets(0, 0, 5, 5);
		gbc_errorChapter.gridx = 1;
		gbc_errorChapter.gridy = 6;
		add(getErrorChapter(), gbc_errorChapter);
		GridBagConstraints gbc_authorsInput = new GridBagConstraints();
		gbc_authorsInput.gridwidth = 3;
		gbc_authorsInput.insets = new Insets(0, 0, 5, 5);
		gbc_authorsInput.fill = GridBagConstraints.BOTH;
		gbc_authorsInput.gridx = 1;
		gbc_authorsInput.gridy = 7;
		add(getAuthorsInput(), gbc_authorsInput);
		GridBagConstraints gbc_editorsInput = new GridBagConstraints();
		gbc_editorsInput.insets = new Insets(0, 0, 5, 5);
		gbc_editorsInput.fill = GridBagConstraints.BOTH;
		gbc_editorsInput.gridx = 5;
		gbc_editorsInput.gridy = 7;
		add(getMultipleInput_1(), gbc_editorsInput);
		GridBagConstraints gbc_lblEditorial = new GridBagConstraints();
		gbc_lblEditorial.gridwidth = 5;
		gbc_lblEditorial.insets = new Insets(0, 0, 5, 5);
		gbc_lblEditorial.fill = GridBagConstraints.BOTH;
		gbc_lblEditorial.gridx = 1;
		gbc_lblEditorial.gridy = 9;
		add(getLblEditorial(), gbc_lblEditorial);
		GridBagConstraints gbc_textFieldEditorial = new GridBagConstraints();
		gbc_textFieldEditorial.gridwidth = 5;
		gbc_textFieldEditorial.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldEditorial.fill = GridBagConstraints.BOTH;
		gbc_textFieldEditorial.gridx = 1;
		gbc_textFieldEditorial.gridy = 10;
		add(getTextFieldEditorial(), gbc_textFieldEditorial);
		GridBagConstraints gbc_errorEditorial = new GridBagConstraints();
		gbc_errorEditorial.fill = GridBagConstraints.BOTH;
		gbc_errorEditorial.gridwidth = 5;
		gbc_errorEditorial.insets = new Insets(0, 0, 5, 5);
		gbc_errorEditorial.gridx = 1;
		gbc_errorEditorial.gridy = 11;
		add(getErrorEditorial(), gbc_errorEditorial);
		GridBagConstraints gbc_lblCdigoIssn = new GridBagConstraints();
		gbc_lblCdigoIssn.gridwidth = 5;
		gbc_lblCdigoIssn.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoIssn.fill = GridBagConstraints.BOTH;
		gbc_lblCdigoIssn.gridx = 1;
		gbc_lblCdigoIssn.gridy = 12;
		add(getLblCdigoIssn(), gbc_lblCdigoIssn);
		GridBagConstraints gbc_textFieldISSN = new GridBagConstraints();
		gbc_textFieldISSN.gridwidth = 5;
		gbc_textFieldISSN.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldISSN.fill = GridBagConstraints.BOTH;
		gbc_textFieldISSN.gridx = 1;
		gbc_textFieldISSN.gridy = 13;
		add(getTextFieldISSN(), gbc_textFieldISSN);
		GridBagConstraints gbc_errorISSN = new GridBagConstraints();
		gbc_errorISSN.fill = GridBagConstraints.BOTH;
		gbc_errorISSN.gridwidth = 5;
		gbc_errorISSN.insets = new Insets(0, 0, 5, 5);
		gbc_errorISSN.gridx = 1;
		gbc_errorISSN.gridy = 14;
		add(getErrorISSN(), gbc_errorISSN);
		GridBagConstraints gbc_lblVolumen = new GridBagConstraints();
		gbc_lblVolumen.fill = GridBagConstraints.BOTH;
		gbc_lblVolumen.insets = new Insets(0, 0, 5, 5);
		gbc_lblVolumen.gridx = 1;
		gbc_lblVolumen.gridy = 15;
		add(getLblVolumen(), gbc_lblVolumen);
		GridBagConstraints gbc_spinnerVol = new GridBagConstraints();
		gbc_spinnerVol.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerVol.fill = GridBagConstraints.BOTH;
		gbc_spinnerVol.gridx = 2;
		gbc_spinnerVol.gridy = 15;
		add(getSpinnerVol(), gbc_spinnerVol);
		GridBagConstraints gbc_errorVol = new GridBagConstraints();
		gbc_errorVol.fill = GridBagConstraints.BOTH;
		gbc_errorVol.gridwidth = 3;
		gbc_errorVol.insets = new Insets(0, 0, 5, 5);
		gbc_errorVol.gridx = 3;
		gbc_errorVol.gridy = 15;
		add(getErrorVol(), gbc_errorVol);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 17;
		add(getBtnNewButton(), gbc_btnNewButton);

		reset();
	}

	public void listenTo(OnResearchActivityActionTriggered listener) {
		this.listener = listener;
	}

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
			textFieldBookName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
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
			textFieldEditorial.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textFieldEditorial.setColumns(10);
		}
		return textFieldEditorial;
	}
	private JLabel getLblCdigoIssn() {
		if (lblCdigoIssn == null) {
			lblCdigoIssn = new JLabel("C\u00F3digo ISSN (Sigue la forma ISSN DDDD-DDDD)");
			lblCdigoIssn.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblCdigoIssn;
	}
	private JTextField getTextFieldISSN() {
		if (textFieldISSN == null) {
			textFieldISSN = new JTextField();
			textFieldISSN.setFont(new Font("Segoe UI", Font.PLAIN, 15));
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
			textFieldChapter.setFont(new Font("Segoe UI", Font.PLAIN, 15));
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
	private JSpinner getSpinnerVol() {
		if (spinnerVol == null) {
			spinnerVol = new JSpinner();
			spinnerVol.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			spinnerVol.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		}
		return spinnerVol;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton(breakthrough == null ? "Agregar" : "Editar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					submit();
				}
			});
			btnNewButton.setBackground(Constants.getInsertionBtnColor());
			btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		}
		return btnNewButton;
	}
	private MultipleInput getAuthorsInput() {
		if (authorsInput == null) {
			authorsInput = new MultipleInput("Autores", "A\u00F1adir");
			authorsInput.getErrorLbl().setText("Introduzca al menos un autor");
		}
		return authorsInput;
	}
	private MultipleInput getMultipleInput_1() {
		if (editorsInput == null) {
			editorsInput = new MultipleInput("Editores", "A\u00F1adir");
			editorsInput.getErrorLbl().setText("Introduzca al menos un editor");
		}
		return editorsInput;
	}

	private void initForm() {
		if (breakthrough != null) {
			textFieldBookName.setText(breakthrough.getBookName());
			textFieldChapter.setText(breakthrough.getTitle());
			textFieldEditorial.setText(breakthrough.getEditorial());
			textFieldISSN.setText(breakthrough.getISSN());
			authorsInput.with(breakthrough.getAuthors());
			editorsInput.with(breakthrough.getEditors());
			spinnerVol.setValue(breakthrough.getVolume());
		}
	}

	private void reset() {
		if (breakthrough == null) {
			textFieldBookName.setText("");
			textFieldChapter.setText("");
			textFieldEditorial.setText("");
			textFieldISSN.setText("");
			authorsInput.reset();
			editorsInput.reset();
			spinnerVol.setValue(1);
		} else {
			initForm();
		}

		resetErrorLabels();
	}

	private void resetErrorLabels() {
		errorBookName.setVisible(false);
		errorChapter.setVisible(false);
		errorEditorial.setVisible(false);
		errorVol.setVisible(false);
		errorISSN.setVisible(false);
		editorsInput.getErrorLbl().setVisible(false);
		authorsInput.getErrorLbl().setVisible(false);
	}

	private boolean checkValidity() {
		resetErrorLabels();

		boolean isValid = true;

		String bookName = textFieldBookName.getText();
		String chapter = textFieldChapter.getText();
		String editorial = textFieldEditorial.getText();
		int authorsSize = authorsInput.amountOfItems();
		int editorsSize = editorsInput.amountOfItems();
		String ISSN = textFieldISSN.getText();
		int vol = (Integer)spinnerVol.getValue();

		if (!Validation.notEmpty(bookName)) {
			errorBookName.setVisible(true);
			isValid = false;
		}

		if (!Validation.notEmpty(chapter)) {
			errorChapter.setVisible(true);
			isValid = false;
		}

		if (!Validation.notEmpty(editorial)) {
			errorEditorial.setVisible(true);
			isValid = false;
		}

		if (authorsSize == 0) {
			authorsInput.getErrorLbl().setVisible(true);
			isValid = false;
		}

		if (editorsSize == 0) {
			editorsInput.getErrorLbl().setVisible(true);
			isValid = false;
		}

		if (!Validation.validISSN(ISSN)) {
			errorISSN.setVisible(true);
			isValid = false;
		}

		if (vol < 1) {
			errorVol.setVisible(true);
			isValid = false;
		}

		return isValid;
	}

	private void sendFeedback() {
		JOptionPane.showMessageDialog(null, "¡Se ha registrado el capítulo correctamente!", "Mensaje", JOptionPane.PLAIN_MESSAGE);
	}

	private void submit() {
		if (checkValidity()) {
			String bookName = textFieldBookName.getText();
			String chapter = textFieldChapter.getText();
			String editorial = textFieldEditorial.getText();
			String[] authors = authorsInput.getValues();
			String[] editors = editorsInput.getValues();
			String ISSN = textFieldISSN.getText();
			int vol = (Integer)spinnerVol.getValue();

			
			try {
				if (breakthrough == null) {
					researcher.addBookChapter(chapter, authors, editors, editorial, ISSN, bookName, vol);
				} else {
					Validation.removeValue("ISSN", breakthrough.getISSN());
					
					breakthrough.setTitle(chapter);
					breakthrough.setBookName(bookName);
					breakthrough.setEditorial(editorial);
					breakthrough.setAuthors(authors);
					breakthrough.setEditors(editors);
					breakthrough.setISSN(ISSN);
					breakthrough.setVolume(vol);
				}

				sendFeedback();

				if (listener != null) {
					listener.actionPerformed();
				}
			} catch (IllegalArgumentException exception) {
				errorISSN.setVisible(true);
			}
		}
	}
	private ErrorLabel getErrorBookName() {
		if (errorBookName == null) {
			errorBookName = new ErrorLabel();
			errorBookName.setText("El nombre del libro es requerido");
		}
		return errorBookName;
	}
	private ErrorLabel getErrorChapter() {
		if (errorChapter == null) {
			errorChapter = new ErrorLabel();
			errorChapter.setText("El t\u00EDtulo del cap\u00EDtulo es requerido");
		}
		return errorChapter;
	}
	private ErrorLabel getErrorEditorial() {
		if (errorEditorial == null) {
			errorEditorial = new ErrorLabel();
			errorEditorial.setText("La editorial es requerida");
		}
		return errorEditorial;
	}
	private ErrorLabel getErrorISSN() {
		if (errorISSN == null) {
			errorISSN = new ErrorLabel();
			errorISSN.setText("El c\u00F3digo ISSN es \u00FAnico y sigue la forma indicada anteriormente");
		}
		return errorISSN;
	}
	private ErrorLabel getErrorVol() {
		if (errorVol == null) {
			errorVol = new ErrorLabel();
			errorVol.setText("El volumen del libro debe ser mayor que 0");
		}
		return errorVol;
	}
}
