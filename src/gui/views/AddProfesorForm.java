package gui.views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import schooling.ProfesorCategory;
import schooling.Degree;
import javax.swing.JButton;

public class AddProfesorForm extends JPanel {
	private JLabel lblName;
	private JTextField researcherName;
	private JLabel category;
	private JComboBox profesorCatSelect;
	private JComboBox degreeSelect;
	private JButton btnRegistrar;
	private JLabel lblDegree;
	private JComboBox matterSelect;
	private JLabel lblmatter;
	private JButton addBtn;
	
	public AddProfesorForm() {
		setBackground(Color.WHITE);
		setLayout(null);
		add(getLblName());
		add(getResearcherName());
		add(getCategory());
		add(getProfesorCatSelect());
		add(getDegreeSelect());
		add(getBtnRegistrar());
		add(getLblDegree());
		add(getComboBox_2());
		add(getLblmatter());
		add(getAddBtn());
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Nombre");
			lblName.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
			lblName.setBounds(12, 13, 103, 16);
		}
		return lblName;
	}
	private JTextField getResearcherName() {
		if (researcherName == null) {
			researcherName = new JTextField();
			researcherName.setBounds(12, 35, 165, 25);
			researcherName.setColumns(10);
		}
		return researcherName;
	}
	private JLabel getCategory() {
		if (category == null) {
			category = new JLabel("Categor\u00EDa");
			category.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
			category.setBounds(189, 11, 103, 21);
		}
		return category;
	}
	private JComboBox getProfesorCatSelect() {
		if (profesorCatSelect == null) {
			profesorCatSelect = new JComboBox();
			profesorCatSelect.setBackground(Color.WHITE);
			profesorCatSelect.setModel(new DefaultComboBoxModel(new String[] {"Instructor", "Auxiliar", "Titular", "Asistente"}));
			profesorCatSelect.setBounds(189, 35, 165, 25);
		}
		return profesorCatSelect;
	}
	private JComboBox getDegreeSelect() {
		if (degreeSelect == null) {
			degreeSelect = new JComboBox();
			degreeSelect.setBackground(Color.WHITE);
			degreeSelect.setModel(new DefaultComboBoxModel(new String[] {"M\u00E1ster", "Doctor", "Ninguna"}));
			degreeSelect.setBounds(366, 35, 165, 25);
		}
		return degreeSelect;
	}
	private JButton getBtnRegistrar() {
		if (btnRegistrar == null) {
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.setBackground(Color.WHITE);
			btnRegistrar.setBounds(12, 211, 97, 25);
		}
		return btnRegistrar;
	}
	private JLabel getLblDegree() {
		if (lblDegree == null) {
			lblDegree = new JLabel("Categor\u00EDa");
			lblDegree.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
			lblDegree.setBounds(366, 14, 103, 21);
		}
		return lblDegree;
	}
	private JComboBox getComboBox_2() {
		if (matterSelect == null) {
			matterSelect = new JComboBox();
			matterSelect.setBackground(Color.WHITE);
			matterSelect.setBounds(543, 36, 165, 25);
		}
		return matterSelect;
	}
	private JLabel getLblmatter() {
		if (lblmatter == null) {
			lblmatter = new JLabel("Tema de investigaci\u00F3n");
			lblmatter.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
			lblmatter.setBounds(543, 14, 144, 21);
		}
		return lblmatter;
	}
	private JButton getAddBtn() {
		if (addBtn == null) {
			addBtn = new JButton("+");
			addBtn.setBackground(Color.WHITE);
			addBtn.setBounds(720, 35, 49, 25);
		}
		return addBtn;
	}
}
