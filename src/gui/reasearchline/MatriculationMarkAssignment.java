package gui.reasearchline;

import javax.swing.JPanel;

import schooling.Faculty;
import schooling.PostgraduateCourse;
import schooling.Profesor;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MatriculationMarkAssignment extends JPanel {

	private static final long serialVersionUID = -929110073445811391L;

	private Faculty faculty;
	private PostgraduateCourse course;
	
	private int[] profIDs;
	private String[] names;
	
	private JPanel panel;
	private JComboBox<String> comboBox;
	private JLabel lblProfesor;
	private JLabel lblNota;
	private JSpinner spinnerNota;
	private JButton btnNewButton;
	private JCheckBox chckbxHabilitarNota;

	public MatriculationMarkAssignment(PostgraduateCourse course) {
		setLayout(null);
		add(getPanel());
	}
	
	private void fillProfessors(PostgraduateCourse course) {
		ArrayList<Profesor> profs = new ArrayList<>();
		
		names = new String[profs.size()];
		profIDs = new int[profs.size()];
		
		for(int i = 0; i < profs.size(); i++) {
			
			names[i] = profs.get(i).getName();
			profIDs[i] = profs.get(i).getID();
			
		}
		
		comboBox.setModel(new DefaultComboBoxModel<>(names));
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(12, 13, 596, 554);
			panel.setLayout(null);
			panel.add(getLblProfesor());
			panel.add(getComboBox());
			panel.add(getLblNota());
			panel.add(getSpinnerNota());
			panel.add(getBtnNewButton());
			panel.add(getChckbxHabilitarNota());
		}
		return panel;
	}
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			comboBox.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			comboBox.setBounds(60, 80, 440, 35);
			
			fillProfessors(course);
		}
		return comboBox;
	}
	private JLabel getLblProfesor() {
		if (lblProfesor == null) {
			lblProfesor = new JLabel("Profesor");
			lblProfesor.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lblProfesor.setBounds(60, 51, 56, 16);
		}
		return lblProfesor;
	}
	private JLabel getLblNota() {
		if (lblNota == null) {
			lblNota = new JLabel("Nota");
			lblNota.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			lblNota.setBounds(60, 149, 56, 16);
		}
		return lblNota;
	}
	private JSpinner getSpinnerNota() {
		if (spinnerNota == null) {
			spinnerNota = new JSpinner();
			spinnerNota.setModel(new SpinnerNumberModel(2, 2, 5, 1));
			spinnerNota.setBounds(60, 178, 45, 22);
		}
		return spinnerNota;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Actualizar");
			btnNewButton.setFont(new Font("Segoe UI Symbol", Font.BOLD, 15));
			btnNewButton.setBounds(60, 250, 110, 45);
		}
		return btnNewButton;
	}
	private JCheckBox getChckbxHabilitarNota() {
		if (chckbxHabilitarNota == null) {
			chckbxHabilitarNota = new JCheckBox("Habilitar Nota");
			chckbxHabilitarNota.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					spinnerNota.setEnabled(chckbxHabilitarNota.isSelected());
				}
			});
			chckbxHabilitarNota.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			chckbxHabilitarNota.setBounds(113, 177, 123, 25);
		}
		return chckbxHabilitarNota;
	}
}
