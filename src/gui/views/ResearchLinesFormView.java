package gui.views;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;

import java.awt.Font;

import schooling.Faculty;
import schooling.Profesor;
import schooling.ResearchMatter;

import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResearchLinesFormView extends JPanel {
	private static final long serialVersionUID = 3971105665570208468L;
	private Faculty faculty;
	private JLabel lblAgregarLneaDe;
	private JLabel lblNombre;
	private JTextField textFieldName;
	private JLabel lblProfesor;
	private JComboBox<String> comboBox;
	private JLabel lblMaestra;
	private JLabel lblCrditoNecesario;
	private JSpinner spinner;
	private JLabel lblTemas;
	private JLabel lblAgregarTema;
	private JTextField textFieldMatterName;
	private JButton button;
	private JButton btnNewButton;
	private JLabel lblMatterNames;
	
	private ArrayList<ResearchMatter> matters;
	
	public ResearchLinesFormView(Faculty faculty) {
		this.faculty = faculty;
		matters = new ArrayList<>();
		
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 50, 288, 50, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 45, 50, 0, 30, 50, 0, 30, 50, 30, 30, 50, 0, 30, 50, 30, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblAgregarLneaDe = new GridBagConstraints();
		gbc_lblAgregarLneaDe.gridwidth = 4;
		gbc_lblAgregarLneaDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblAgregarLneaDe.fill = GridBagConstraints.BOTH;
		gbc_lblAgregarLneaDe.gridx = 1;
		gbc_lblAgregarLneaDe.gridy = 1;
		add(getLblAgregarLneaDe(), gbc_lblAgregarLneaDe);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.gridwidth = 4;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		add(getLblNombre(), gbc_lblNombre);
		GridBagConstraints gbc_textFieldName = new GridBagConstraints();
		gbc_textFieldName.gridwidth = 4;
		gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldName.fill = GridBagConstraints.BOTH;
		gbc_textFieldName.gridx = 1;
		gbc_textFieldName.gridy = 4;
		add(getTextFieldName(), gbc_textFieldName);
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.gridwidth = 4;
		gbc_lblProfesor.fill = GridBagConstraints.BOTH;
		gbc_lblProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesor.gridx = 1;
		gbc_lblProfesor.gridy = 6;
		add(getLblProfesor(), gbc_lblProfesor);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 7;
		add(getComboBox(), gbc_comboBox);
		GridBagConstraints gbc_lblTemas = new GridBagConstraints();
		gbc_lblTemas.fill = GridBagConstraints.BOTH;
		gbc_lblTemas.insets = new Insets(0, 0, 5, 5);
		gbc_lblTemas.gridx = 1;
		gbc_lblTemas.gridy = 9;
		add(getLblTemas(), gbc_lblTemas);
		GridBagConstraints gbc_lblMatterNames = new GridBagConstraints();
		gbc_lblMatterNames.fill = GridBagConstraints.BOTH;
		gbc_lblMatterNames.gridwidth = 2;
		gbc_lblMatterNames.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatterNames.gridx = 2;
		gbc_lblMatterNames.gridy = 9;
		add(getLblMatterNames(), gbc_lblMatterNames);
		GridBagConstraints gbc_lblAgregarTema = new GridBagConstraints();
		gbc_lblAgregarTema.anchor = GridBagConstraints.EAST;
		gbc_lblAgregarTema.fill = GridBagConstraints.BOTH;
		gbc_lblAgregarTema.insets = new Insets(0, 0, 5, 5);
		gbc_lblAgregarTema.gridx = 1;
		gbc_lblAgregarTema.gridy = 10;
		add(getLblAgregarTema(), gbc_lblAgregarTema);
		GridBagConstraints gbc_textFieldMatterName = new GridBagConstraints();
		gbc_textFieldMatterName.gridwidth = 2;
		gbc_textFieldMatterName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMatterName.fill = GridBagConstraints.BOTH;
		gbc_textFieldMatterName.gridx = 2;
		gbc_textFieldMatterName.gridy = 10;
		add(getTextFieldMatterName(), gbc_textFieldMatterName);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.fill = GridBagConstraints.BOTH;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 10;
		add(getButton(), gbc_button);
		GridBagConstraints gbc_lblMaestra = new GridBagConstraints();
		gbc_lblMaestra.gridwidth = 4;
		gbc_lblMaestra.fill = GridBagConstraints.BOTH;
		gbc_lblMaestra.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaestra.gridx = 1;
		gbc_lblMaestra.gridy = 12;
		add(getLblMaestra(), gbc_lblMaestra);
		GridBagConstraints gbc_lblCrditoNecesario = new GridBagConstraints();
		gbc_lblCrditoNecesario.fill = GridBagConstraints.BOTH;
		gbc_lblCrditoNecesario.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrditoNecesario.gridx = 1;
		gbc_lblCrditoNecesario.gridy = 13;
		add(getLblCrditoNecesario(), gbc_lblCrditoNecesario);
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.BOTH;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 2;
		gbc_spinner.gridy = 13;
		add(getSpinner(), gbc_spinner);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 15;
		add(getBtnNewButton(), gbc_btnNewButton);
	}

	private JLabel getLblAgregarLneaDe() {
		if (lblAgregarLneaDe == null) {
			lblAgregarLneaDe = new JLabel("Agregar l\u00EDnea de investigaci\u00F3n");
			lblAgregarLneaDe.setFont(new Font("Segoe UI", Font.PLAIN, 25));
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
			textFieldName.setColumns(10);
		}
		return textFieldName;
	}
	private JLabel getLblProfesor() {
		if (lblProfesor == null) {
			lblProfesor = new JLabel("Profesor");
			lblProfesor.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblProfesor;
	}

	public void fetchProfesors() {
		ArrayList<Profesor> profesors = faculty.getProfesors();
		String[] names = new String[profesors.size()];
		
		for (int i = 0; i < profesors.size(); i++) {
			names[i] = profesors.get(i).getName();
		}
		
		comboBox.setModel(new DefaultComboBoxModel<>(names));
	}
	
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			fetchProfesors();
		}
		return comboBox;
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
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		}
		return spinner;
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
			textFieldMatterName.setColumns(10);
		}
		return textFieldMatterName;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("+");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					matters.add(new ResearchMatter(textFieldMatterName.getText()));
					textFieldMatterName.setText("");
					lblMatterNames.setText("");
					
					for (int i = 0; i < matters.size(); i++) {
						lblMatterNames.setText(lblMatterNames.getText() + matters.get(i).getName());
						
						if (i + 1 != matters.size()) {
							if (i == matters.size() - 2) {
								lblMatterNames.setText(lblMatterNames.getText() + " y ");
							} else {
								lblMatterNames.setText(lblMatterNames.getText() + ", ");
							}
						}
					}
				}
			});
			button.setBackground(Color.WHITE);
		}
		return button;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Agregar");
			btnNewButton.setBackground(Color.WHITE);
		}
		return btnNewButton;
	}
	private JLabel getLblMatterNames() {
		if (lblMatterNames == null) {
			lblMatterNames = new JLabel("");
			lblMatterNames.setForeground(Color.DARK_GRAY);
			lblMatterNames.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		}
		return lblMatterNames;
	}
}
