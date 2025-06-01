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

public class ResearchLinesFormView extends JPanel {
	private static final long serialVersionUID = 3971105665570208468L;
	private Faculty faculty;
	private JLabel lblAgregarLneaDe;
	private JLabel lblNombre;
	private JTextField textFieldName;
	private JLabel lblProfesor;
	private JComboBox<String> comboBox;
	
	public ResearchLinesFormView(Faculty faculty) {
		this.faculty = faculty;
		
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 288, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 45, 0, 0, 30, 0, 0, 30, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblAgregarLneaDe = new GridBagConstraints();
		gbc_lblAgregarLneaDe.insets = new Insets(0, 0, 5, 5);
		gbc_lblAgregarLneaDe.fill = GridBagConstraints.BOTH;
		gbc_lblAgregarLneaDe.gridx = 1;
		gbc_lblAgregarLneaDe.gridy = 1;
		add(getLblAgregarLneaDe(), gbc_lblAgregarLneaDe);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		add(getLblNombre(), gbc_lblNombre);
		GridBagConstraints gbc_textFieldName = new GridBagConstraints();
		gbc_textFieldName.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldName.fill = GridBagConstraints.BOTH;
		gbc_textFieldName.gridx = 1;
		gbc_textFieldName.gridy = 4;
		add(getTextFieldName(), gbc_textFieldName);
		GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
		gbc_lblProfesor.fill = GridBagConstraints.BOTH;
		gbc_lblProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesor.gridx = 1;
		gbc_lblProfesor.gridy = 6;
		add(getLblProfesor(), gbc_lblProfesor);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 7;
		add(getComboBox(), gbc_comboBox);
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
}
