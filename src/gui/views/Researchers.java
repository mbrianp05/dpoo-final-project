package gui.views;

import gui.tablemodel.ResearcherTableModel;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class Researchers extends JPanel {
	private JLabel panelTitle;
	private JCheckBox filterStudents;
	private JCheckBox filterProfesors;
	private JSeparator separator;
	private JLabel lblFiltrar;
	private JLabel actionForm;
	private JLabel lblPuntuacin;
	private JSpinner spinner;
	private JButton btnNewButton;
	private JRadioButton addStudent;
	private JRadioButton addProfesor;
	private AddProfesorForm addProfesorForm;
	private JPanel panel;
	private JLabel lblNombre;
	private JTextField filterByName;
	private JScrollPane scrollPane;
	
	private ResearcherTableModel researcherModel;
	private JTable table;
	
	public Researchers() {
		setLayout(null);
		add(getPanelTitle());
		add(getFilterStudents());
		add(getFilterProfesors());
		add(getSeparator());
		add(getLblFiltrar());
		add(getActionForm());
		add(getLblPuntuacin());
		add(getSpinner());
		add(getBtnNewButton());
		add(getAddProfesorForm());
		add(getPanel());
		add(getLblNombre());
		add(getFilterByName());
		add(getScrollPane());
		
		researcherModel = new ResearcherTableModel();
		table.setModel(researcherModel);
	}
	private JLabel getPanelTitle() {
		if (panelTitle == null) {
			panelTitle = new JLabel("Investigadores");
			panelTitle.setFont(new Font("Segoe UI Symbol", Font.BOLD, 17));
			panelTitle.setBounds(12, 13, 196, 30);
		}
		return panelTitle;
	}
	private JCheckBox getFilterStudents() {
		if (filterStudents == null) {
			filterStudents = new JCheckBox("Estudiantes");
			filterStudents.setSelected(true);
			filterStudents.setBounds(167, 174, 100, 25);
		}
		return filterStudents;
	}
	private JCheckBox getFilterProfesors() {
		if (filterProfesors == null) {
			filterProfesors = new JCheckBox("Profesores");
			filterProfesors.setSelected(true);
			filterProfesors.setBounds(63, 174, 100, 25);
		}
		return filterProfesors;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 163, 783, 2);
		}
		return separator;
	}
	private JLabel getLblFiltrar() {
		if (lblFiltrar == null) {
			lblFiltrar = new JLabel("Filtrar");
			lblFiltrar.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			lblFiltrar.setBounds(12, 176, 56, 16);
		}
		return lblFiltrar;
	}
	private JLabel getActionForm() {
		if (actionForm == null) {
			actionForm = new JLabel("A\u00F1adir investigador");
			actionForm.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			actionForm.setBounds(12, 42, 151, 23);
		}
		return actionForm;
	}
	private JLabel getLblPuntuacin() {
		if (lblPuntuacin == null) {
			lblPuntuacin = new JLabel("Puntuaci\u00F3n");
			lblPuntuacin.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			lblPuntuacin.setBounds(486, 173, 79, 22);
		}
		return lblPuntuacin;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setBounds(577, 175, 50, 22);
		}
		return spinner;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Reiniciar");
			btnNewButton.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.setBounds(684, 174, 97, 25);
		}
		return btnNewButton;
	}
	private JRadioButton getAddStudent() {
		if (addStudent == null) {
			addStudent = new JRadioButton("Estudiante");
			addStudent.setBackground(Color.WHITE);
		}
		return addStudent;
	}
	private JRadioButton getAddProfesor() {
		if (addProfesor == null) {
			addProfesor = new JRadioButton("Profesor");
			addProfesor.setBackground(Color.WHITE);
			addProfesor.setSelected(true);
		}
		return addProfesor;
	}
	private AddProfesorForm getAddProfesorForm() {
		if (addProfesorForm == null) {
			addProfesorForm = new AddProfesorForm();
			addProfesorForm.setBorder(new LineBorder(new Color(204, 0, 102)));
			addProfesorForm.setBounds(12, 78, 783, 72);
		}
		return addProfesorForm;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(167, 40, 200, 30);
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			panel.add(getAddProfesor());
			panel.add(getAddStudent());
		}
		return panel;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			lblNombre.setBounds(275, 173, 79, 22);
		}
		return lblNombre;
	}
	private JTextField getFilterByName() {
		if (filterByName == null) {
			filterByName = new JTextField();
			filterByName.setBounds(336, 175, 116, 22);
			filterByName.setColumns(10);
		}
		return filterByName;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 205, 783, 207);
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.setBackground(Color.WHITE);
		}
		return table;
	}
}
