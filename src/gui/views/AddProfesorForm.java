package gui.views;

import gui.event.OnAddResearcher;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import schooling.Faculty;
import schooling.Profesor;
import schooling.ProfesorCategory;
import schooling.Degree;
import schooling.ResearchMatter;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class AddProfesorForm extends JPanel {
	private JLabel lblName;
	private JTextField researcherName;
	private JLabel category;
	private JComboBox profesorCatSelect;
	private JComboBox degreeSelect;
	private JComboBox matterSelect;
	private JButton btnRegistrar;
	private JLabel lblDegree;
	private JLabel lblmatter;
	private JButton addBtn;
	
	private Faculty faculty;
	private OnAddResearcher event;
	
	public AddProfesorForm(Faculty faculty) {
		this.faculty = faculty;

		setBackground(Color.WHITE);
		setLayout(null);
		add(getLblName());
		add(getResearcherName());
		add(getCategory());
		add(getProfesorCatSelect());
		add(getDegreeSelect());
		add(getBtnRegistrar());
		add(getLblDegree());
		add(getMatterSelect());
		add(getLblmatter());
		add(getAddBtn());
	}
	
	public void listenTo(OnAddResearcher listener) {
		event = listener;
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
			profesorCatSelect.setModel(new DefaultComboBoxModel(new String[] {"Instructor", "Asistente", "Auxiliar", "Titular"}));
			profesorCatSelect.setBounds(189, 35, 165, 25);
		}
		return profesorCatSelect;
	}
	private JComboBox getDegreeSelect() {
		if (degreeSelect == null) {
			degreeSelect = new JComboBox();
			degreeSelect.setBackground(Color.WHITE);
			degreeSelect.setModel(new DefaultComboBoxModel(new String[] {"Ninguna", "M\u00E1ster", "Doctor"}));
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
	private JComboBox getMatterSelect() {
		if (matterSelect == null) {
			Object[] mattersNames = faculty.getResearchMattersNames().toArray();
			
			matterSelect = new JComboBox();
			matterSelect.setBackground(Color.WHITE);
			matterSelect.setModel(new DefaultComboBoxModel(mattersNames));
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
	
	private Degree getDegree() {
		Degree[] degrees = new Degree[]{ null, Degree.Master, Degree.Doctor };
		
		return degrees[degreeSelect.getSelectedIndex()];
	}
	
	private ProfesorCategory getCat() {
		ProfesorCategory[] categories = new ProfesorCategory[]{ ProfesorCategory.Instructor, ProfesorCategory.Assistant, ProfesorCategory.Auxiliar, ProfesorCategory.Permanent };
		
		return categories[profesorCatSelect.getSelectedIndex()];
	}
	
	private JButton getAddBtn() {
		if (addBtn == null) {
			addBtn = new JButton("+");
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!researcherName.getText().trim().isEmpty()) {						
						if (event != null) {						
							Profesor profesor = faculty.addProfesor(researcherName.getText(), getDegree(), getCat());
							String matterName = (String)matterSelect.getModel().getElementAt(matterSelect.getSelectedIndex());
							ResearchMatter matter = faculty.findResearchMatter(matterName);
							matter.addResearcher(profesor);
							
							event.addedProfesor(profesor, matterName);
						}
					}
				}
			});
			addBtn.setBackground(Color.WHITE);
			addBtn.setBounds(720, 35, 49, 25);
		}
		return addBtn;
	}
}
