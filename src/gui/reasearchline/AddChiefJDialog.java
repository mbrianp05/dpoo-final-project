package gui.reasearchline;

import gui.event.OnAddedProfesor;
import gui.event.OnSetChief;

import javax.swing.JDialog;

import java.awt.Color;
import java.awt.GridBagLayout;


import java.awt.GridBagConstraints;

import java.awt.Insets;

import schooling.Degree;
import schooling.ProfesorCategory;

import gui.researchers.ProfesorForm;

public class AddChiefJDialog extends JDialog {
	private static final long serialVersionUID = 3142798032279882910L;

	private String[] matters;
	private ProfesorForm profesorForm;
	private OnSetChief listener;

	public AddChiefJDialog(String[] matters, OnSetChief listener) {
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		this.matters = matters;
		this.listener = listener;

		setAlwaysOnTop(true);
		setTitle("Insertar datos el jefe de la l\u00EDnea");
		setModal(true);
		setBackground(Color.WHITE);
		setBounds(100, 100, 626, 670);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{70, 0, 70, 0};
		gridBagLayout.rowHeights = new int[]{70, 545, 70, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);

		GridBagConstraints gbc_profesorForm = new GridBagConstraints();
		gbc_profesorForm.insets = new Insets(0, 0, 5, 5);
		gbc_profesorForm.fill = GridBagConstraints.BOTH;
		gbc_profesorForm.gridx = 1;
		gbc_profesorForm.gridy = 1;
		getContentPane().add(getProfesorForm(), gbc_profesorForm);
	}

	private ProfesorForm getProfesorForm() {
		if (profesorForm == null) {
			profesorForm = new ProfesorForm(matters);
			profesorForm.setBackground(Color.WHITE);
			profesorForm.listenTo(new OnAddedProfesor() {
				@Override
				public void newProfesor(String name, Degree degree, ProfesorCategory category, String matter) {
					listener.set(name, category, degree, matter);
					setVisible(false);
				}
			});
		}

		return profesorForm;
	}
}
