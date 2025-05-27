package gui.views;

import gui.event.OnAddedResearcher;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import schooling.Faculty;
import schooling.ResearchMatter;
import schooling.Student;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudentForm extends JPanel {
	private JTextField studentName;
	private JLabel lblNombre;
	private Faculty faculty;
	private JComboBox slcMatter;
	private JLabel lblTemaDeInvestigacin;
	private JButton button;
	private JLabel lblError;
	private JLabel label_1;
	
	private OnAddedResearcher event;
	
	public AddStudentForm(Faculty faculty) {
		this.faculty = faculty;

		setBackground(Color.WHITE);
		setLayout(new GridLayout(0, 3, 0, 0));
		add(getLblNombre());
		add(getLblTemaDeInvestigacin());
		add(getLabel_1_2());
		add(getStudentName());
		add(getSlcMatter());
		add(getButton());
		add(getLabel_1_1());
	}
	
	public void listenTo(OnAddedResearcher listener) {
		event = listener;
	}
	
	private JTextField getStudentName() {
		if (studentName == null) {
			studentName = new JTextField();
			studentName.setBackground(Color.WHITE);
			studentName.setColumns(10);
		}
		return studentName;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		}
		return lblNombre;
	}
	private JComboBox getSlcMatter() {
		if (slcMatter == null) {
			Object[] mattersNames = faculty.getResearchMattersNames().toArray();
			
			slcMatter = new JComboBox();
			slcMatter.setBackground(Color.WHITE);
			slcMatter.setModel(new DefaultComboBoxModel(mattersNames));
		}
		return slcMatter;
	}
	
	private JLabel getLblTemaDeInvestigacin() {
		if (lblTemaDeInvestigacin == null) {
			lblTemaDeInvestigacin = new JLabel("Tema de investigaci\u00F3n");
			lblTemaDeInvestigacin.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		}
		return lblTemaDeInvestigacin;
	}
	
	private JButton getButton() {
		if (button == null) {
			button = new JButton("+");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!studentName.getText().trim().isEmpty()) {
						if (event != null) {							
							lblError.setVisible(false);
							Student student = faculty.addStudent(studentName.getText());
							String matterName = (String)slcMatter.getModel().getElementAt(slcMatter.getSelectedIndex());
							
							event.added(student, matterName);
						}
					} else {
						lblError.setVisible(true);
					}
				}
			});
			button.setForeground(Color.WHITE);
			button.setBackground(new Color(255, 102, 153));
			button.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 19));
		}
		return button;
	}
	private JLabel getLabel_1_1() {
		if (lblError == null) {
			lblError = new JLabel("El nombre es requerido");
			lblError.setForeground(new Color(255, 0, 153));
			lblError.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
			lblError.setVisible(false);
		}
		return lblError;
	}
	private JLabel getLabel_1_2() {
		if (label_1 == null) {
			label_1 = new JLabel("");
		}
		return label_1;
	}
}
