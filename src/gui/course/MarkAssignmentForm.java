package gui.course;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import schooling.Faculty;
import schooling.Matriculation;
import schooling.PostgraduateCourse;
import gui.component.TitleLabel;

public class MarkAssignmentForm extends JPanel {

	private static final long serialVersionUID = -929110073445811391L;

	private Faculty faculty;
	private PostgraduateCourse course;

	private JPanel panel;
	private JComboBox<String> comboBox;
	private JLabel lblProfesor;
	private JLabel lblNota;
	private JSpinner spinnerNota;
	private JButton btnNewButton;
	private JCheckBox chckbxHabilitarNota;

	private int[] profesorIDs;
	private TitleLabel tlblJ;
	private JLabel lblCurso;

	public MarkAssignmentForm(PostgraduateCourse course) {
		faculty = Faculty.newInstance();
		this.course = course;

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(getPanel());
	}

	private ArrayList<Matriculation> getMatriculations() {
		return faculty.getMatriculationsAtCourse(course);
	}

	private void fillProfessors() {
		ArrayList<Matriculation> matriculations = getMatriculations();
		String[] names = new String[matriculations.size()];
		profesorIDs = new int[matriculations.size()];

		for(int i = 0; i < matriculations.size(); i++) {
			names[i] = matriculations.get(i).getProfesor().getName();
			profesorIDs[i] = matriculations.get(i).getProfesor().getID();
		}

		comboBox.setModel(new DefaultComboBoxModel<>(names));
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{60, 70, 387, 60, 0};
			gbl_panel.rowHeights = new int[]{51, 0, 0, 35, 16, 35, 35, 16, 25, 48, 35, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_lblCurso = new GridBagConstraints();
			gbc_lblCurso.fill = GridBagConstraints.BOTH;
			gbc_lblCurso.insets = new Insets(0, 0, 5, 5);
			gbc_lblCurso.gridx = 1;
			gbc_lblCurso.gridy = 1;
			panel.add(getLblCurso(), gbc_lblCurso);
			GridBagConstraints gbc_tlblJ = new GridBagConstraints();
			gbc_tlblJ.fill = GridBagConstraints.BOTH;
			gbc_tlblJ.gridwidth = 2;
			gbc_tlblJ.insets = new Insets(0, 0, 5, 5);
			gbc_tlblJ.gridx = 1;
			gbc_tlblJ.gridy = 2;
			panel.add(getTlblJ(), gbc_tlblJ);
			GridBagConstraints gbc_lblProfesor = new GridBagConstraints();
			gbc_lblProfesor.anchor = GridBagConstraints.WEST;
			gbc_lblProfesor.fill = GridBagConstraints.VERTICAL;
			gbc_lblProfesor.insets = new Insets(0, 0, 5, 5);
			gbc_lblProfesor.gridwidth = 2;
			gbc_lblProfesor.gridx = 1;
			gbc_lblProfesor.gridy = 4;
			panel.add(getLblProfesor(), gbc_lblProfesor);
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.fill = GridBagConstraints.BOTH;
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.gridwidth = 2;
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 5;
			panel.add(getComboBox(), gbc_comboBox);
			GridBagConstraints gbc_lblNota = new GridBagConstraints();
			gbc_lblNota.anchor = GridBagConstraints.WEST;
			gbc_lblNota.fill = GridBagConstraints.VERTICAL;
			gbc_lblNota.insets = new Insets(0, 0, 5, 5);
			gbc_lblNota.gridwidth = 2;
			gbc_lblNota.gridx = 1;
			gbc_lblNota.gridy = 7;
			panel.add(getLblNota(), gbc_lblNota);
			GridBagConstraints gbc_chckbxHabilitarNota = new GridBagConstraints();
			gbc_chckbxHabilitarNota.anchor = GridBagConstraints.WEST;
			gbc_chckbxHabilitarNota.fill = GridBagConstraints.BOTH;
			gbc_chckbxHabilitarNota.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxHabilitarNota.gridx = 2;
			gbc_chckbxHabilitarNota.gridy = 8;
			panel.add(getChckbxHabilitarNota(), gbc_chckbxHabilitarNota);
			GridBagConstraints gbc_spinnerNota = new GridBagConstraints();
			gbc_spinnerNota.fill = GridBagConstraints.BOTH;
			gbc_spinnerNota.insets = new Insets(0, 0, 5, 5);
			gbc_spinnerNota.gridx = 1;
			gbc_spinnerNota.gridy = 8;
			panel.add(getSpinnerNota(), gbc_spinnerNota);
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
			gbc_btnNewButton.anchor = GridBagConstraints.EAST;
			gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
			gbc_btnNewButton.gridx = 2;
			gbc_btnNewButton.gridy = 10;
			panel.add(getBtnNewButton(), gbc_btnNewButton);
		}
		return panel;
	}

	private Matriculation getSelectedMatriculation() {
		Matriculation m = null;

		if (profesorIDs.length > 0) {
			int index = comboBox.getSelectedIndex() != -1 ? comboBox.getSelectedIndex() : 0;
			int selectedProfesorID = profesorIDs[index];
			int i = 0;
			
			ArrayList<Matriculation> matriculations = getMatriculations();
			
			while (i < matriculations.size()) {
				if (matriculations.get(i).getProfesor().getID() == selectedProfesorID) {
					m = matriculations.get(i);
				}
				
				i++;
			}
		}

		return m;
	}

	private void setMarkValue() {
		if (profesorIDs.length > 0) {
			Matriculation m = getSelectedMatriculation();
			
			if (m.getMark() != -1)
				spinnerNota.setValue(m.getMark());
			else
				spinnerNota.setValue(2);
		}
	}

	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setMarkValue();
				}
			});
			comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 15));

			fillProfessors();
		}
		return comboBox;
	}
	private JLabel getLblProfesor() {
		if (lblProfesor == null) {
			lblProfesor = new JLabel("Profesor matriculado");
			lblProfesor.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblProfesor;
	}
	private JLabel getLblNota() {
		if (lblNota == null) {
			lblNota = new JLabel("Nota");
			lblNota.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblNota;
	}
	private JSpinner getSpinnerNota() {
		if (spinnerNota == null) {
			spinnerNota = new JSpinner();
			spinnerNota.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			spinnerNota.setModel(new SpinnerNumberModel(2, 2, 5, 1));
			spinnerNota.setEnabled(chckbxHabilitarNota.isSelected());

			setMarkValue();
		}
		return spinnerNota;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Actualizar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (comboBox.getSelectedIndex() != -1) {
						Matriculation m = getSelectedMatriculation();
						
						if (chckbxHabilitarNota.isSelected()) {
							int newMark = (Integer)spinnerNota.getValue();
							m.setMark(newMark);
						} else {
							m.noMarkYet();
							setMarkValue();
						}
					}

					sendFeedback();
				}
			});
			btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		}
		return btnNewButton;
	}
	private JCheckBox getChckbxHabilitarNota() {
		if (chckbxHabilitarNota == null) {
			chckbxHabilitarNota = new JCheckBox("Otorgar Nota");
			chckbxHabilitarNota.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					spinnerNota.setEnabled(chckbxHabilitarNota.isSelected());
					spinnerNota.setValue(2);
				}
			});

			chckbxHabilitarNota.setFont(new Font("Segoe UI", Font.PLAIN, 15));

			if (profesorIDs.length > 0)
				chckbxHabilitarNota.setSelected(getSelectedMatriculation().getMark() != -1);
		}
		return chckbxHabilitarNota;
	}
	
	private void sendFeedback() {
		JOptionPane.showMessageDialog(null, "¡La nota del profesor ha sido asignada correctamente!");
	}
	private TitleLabel getTlblJ() {
		if (tlblJ == null) {
			tlblJ = new TitleLabel();
			tlblJ.setText(course.getName());
		}
		return tlblJ;
	}
	private JLabel getLblCurso() {
		if (lblCurso == null) {
			lblCurso = new JLabel("Curso");
			lblCurso.setFont(new Font("Segoe UI", Font.PLAIN, 17));
		}
		return lblCurso;
	}
}
