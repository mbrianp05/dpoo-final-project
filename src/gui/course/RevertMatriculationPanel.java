package gui.course;

import javax.swing.JPanel;

import schooling.Profesor;
import schooling.ResearchLine;

import java.awt.GridBagLayout;

import gui.component.TitleLabel;
import gui.event.OnNoMatriculableProfesorLeft;

import java.awt.GridBagConstraints;

import javax.swing.JLabel;

import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RevertMatriculationPanel extends JPanel {
	private static final long serialVersionUID = 2362388346234493838L;

	private ResearchLine line;
	private TitleLabel tlblMatricularProfesor;
	private JLabel lblPlanDeMaestra;
	private JComboBox<String> comboBox;
	private JLabel lblProfesoresDeLa;
	private JButton btnRegistrarMatrcula;
	private JLabel lblSeMatricular;

	private OnNoMatriculableProfesorLeft listener;

	public RevertMatriculationPanel(ResearchLine line) {
		this.line = line;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{50, 0, 50, 0};
		gridBagLayout.rowHeights = new int[]{50, 0, 0, 30, 0, 35, 0, 30, 35, 50, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblPlanDeMaestra = new GridBagConstraints();
		gbc_lblPlanDeMaestra.fill = GridBagConstraints.BOTH;
		gbc_lblPlanDeMaestra.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlanDeMaestra.gridx = 1;
		gbc_lblPlanDeMaestra.gridy = 1;
		add(getLblPlanDeMaestra(), gbc_lblPlanDeMaestra);
		GridBagConstraints gbc_tlblMatricularProfesor = new GridBagConstraints();
		gbc_tlblMatricularProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_tlblMatricularProfesor.fill = GridBagConstraints.BOTH;
		gbc_tlblMatricularProfesor.gridx = 1;
		gbc_tlblMatricularProfesor.gridy = 2;
		add(getTlblMatricularProfesor(), gbc_tlblMatricularProfesor);
		GridBagConstraints gbc_lblProfesoresDeLa = new GridBagConstraints();
		gbc_lblProfesoresDeLa.fill = GridBagConstraints.BOTH;
		gbc_lblProfesoresDeLa.insets = new Insets(0, 0, 5, 5);
		gbc_lblProfesoresDeLa.gridx = 1;
		gbc_lblProfesoresDeLa.gridy = 4;
		add(getLblProfesoresDeLa(), gbc_lblProfesoresDeLa);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 5;
		add(getComboBox(), gbc_comboBox);
		GridBagConstraints gbc_lblSeMatricular = new GridBagConstraints();
		gbc_lblSeMatricular.fill = GridBagConstraints.BOTH;
		gbc_lblSeMatricular.insets = new Insets(0, 0, 5, 5);
		gbc_lblSeMatricular.gridx = 1;
		gbc_lblSeMatricular.gridy = 6;
		add(getLblSeMatricular(), gbc_lblSeMatricular);
		GridBagConstraints gbc_btnRegistrarMatrcula = new GridBagConstraints();
		gbc_btnRegistrarMatrcula.anchor = GridBagConstraints.EAST;
		gbc_btnRegistrarMatrcula.fill = GridBagConstraints.VERTICAL;
		gbc_btnRegistrarMatrcula.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegistrarMatrcula.gridx = 1;
		gbc_btnRegistrarMatrcula.gridy = 8;
		add(getBtnRegistrarMatrcula(), gbc_btnRegistrarMatrcula);
	}

	public void listenTo(OnNoMatriculableProfesorLeft listener) {
		this.listener = listener;
	}

	private TitleLabel getTlblMatricularProfesor() {
		if (tlblMatricularProfesor == null) {
			tlblMatricularProfesor = new TitleLabel();
			tlblMatricularProfesor.setText("Eliminar matr\u00EDcula del plan de maestr\u00EDa");
		}
		return tlblMatricularProfesor;
	}

	private JLabel getLblPlanDeMaestra() {
		if (lblPlanDeMaestra == null) {
			lblPlanDeMaestra = new JLabel("Plan de maestr\u00EDa de la l\u00EDnea " + line.getName());
		}
		return lblPlanDeMaestra;
	}

	public void fillComboBox() {
		ArrayList<Profesor> profesors = line.getMasteryPlan().getMatriculatedProfesors();

		String[] names = new String[profesors.size()];

		for (int i = 0; i < profesors.size(); i++) {
			names[i] = profesors.get(i).getName();
		}

		comboBox.setModel(new DefaultComboBoxModel<>(names));
	}

	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<>();
			fillComboBox();
		}
		return comboBox;
	}
	private JLabel getLblProfesoresDeLa() {
		if (lblProfesoresDeLa == null) {
			lblProfesoresDeLa = new JLabel("Profesores matriculados");
		}
		return lblProfesoresDeLa;
	}

	private void resetForm() {
		comboBox.setSelectedIndex(-1);
	}

	private void sendFeedback() {
		JOptionPane.showMessageDialog(null, "¡Se ha quitado la matricula correctamente!");
	}

	private JButton getBtnRegistrarMatrcula() {
		if (btnRegistrarMatrcula == null) {
			btnRegistrarMatrcula = new JButton("Eliminar");
			btnRegistrarMatrcula.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int index = comboBox.getSelectedIndex();

					if (index != -1) {
						int input = JOptionPane.showConfirmDialog(null, "¿Estás seguro de desmatricular al profesor?");

						if (input == JOptionPane.OK_OPTION) {
							Profesor p = line.getMasteryPlan().getMatriculatedProfesors().get(index);
							line.getMasteryPlan().revertMatriculation(p);

							fillComboBox();
							resetForm();
							sendFeedback();

							if (line.getMasteryPlan().getMatriculatedProfesors().size() == 0 && listener != null) {
								listener.noProfesorLeft();
							}
						}
					}
				}
			});
		}
		return btnRegistrarMatrcula;
	}
	private JLabel getLblSeMatricular() {
		if (lblSeMatricular == null) {
			lblSeMatricular = new JLabel("* Se eliminar\u00E1n los cr\u00E9ditos acumulados");
		}
		return lblSeMatricular;
	}
}
