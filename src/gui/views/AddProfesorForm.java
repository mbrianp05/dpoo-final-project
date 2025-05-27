package gui.views;

import gui.event.OnAddedResearcher;

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
import java.awt.GridLayout;

public class AddProfesorForm extends JPanel {
	private JLabel lblName;
	private JTextField researcherName;
	private JLabel category;
	private JComboBox profesorCatSelect;
	private JComboBox degreeSelect;
	private JComboBox matterSelect;
	private JLabel lblDegree;
	private JLabel lblmatter;
	private JButton addBtn;
	
	private Faculty faculty;
	private OnAddedResearcher event;
	private JLabel lblElNombreEs;
	private JLabel label;
	
	public AddProfesorForm(Faculty faculty) {
		this.faculty = faculty;

		setBackground(Color.WHITE);
		setLayout(new GridLayout(0, 5, 0, 0));
		add(getLblName());
		add(getCategory());
		add(getLblDegree());
		add(getLblmatter());
		add(getLabel());
		add(getResearcherName());
		add(getProfesorCatSelect());
		add(getDegreeSelect());
		add(getMatterSelect());
		add(getAddBtn());
		add(getLblElNombreEs());
	}
	
	public void listenTo(OnAddedResearcher listener) {
		event = listener;
	}

	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("Nombre");
			lblName.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		}
		return lblName;
	}
	private JTextField getResearcherName() {
		if (researcherName == null) {
			researcherName = new JTextField();
			researcherName.setColumns(10);
		}
		return researcherName;
	}
	private JLabel getCategory() {
		if (category == null) {
			category = new JLabel("Categor\u00EDa");
			category.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		}
		return category;
	}
	private JComboBox getProfesorCatSelect() {
		if (profesorCatSelect == null) {
			profesorCatSelect = new JComboBox();
			profesorCatSelect.setBackground(Color.WHITE);
			profesorCatSelect.setModel(new DefaultComboBoxModel(new String[] {"Instructor", "Asistente", "Auxiliar", "Titular"}));
		}
		return profesorCatSelect;
	}
	private JComboBox getDegreeSelect() {
		if (degreeSelect == null) {
			degreeSelect = new JComboBox();
			degreeSelect.setBackground(Color.WHITE);
			degreeSelect.setModel(new DefaultComboBoxModel(new String[] {"Ninguna", "M\u00E1ster", "Doctor"}));
		}
		return degreeSelect;
	}
	private JLabel getLblDegree() {
		if (lblDegree == null) {
			lblDegree = new JLabel("Categor\u00EDa");
			lblDegree.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		}
		return lblDegree;
	}
	private JComboBox getMatterSelect() {
		if (matterSelect == null) {
			Object[] mattersNames = faculty.getResearchMattersNames().toArray();
			
			matterSelect = new JComboBox();
			matterSelect.setBackground(Color.WHITE);
			matterSelect.setModel(new DefaultComboBoxModel(mattersNames));
		}
		return matterSelect;
	}
	
	private JLabel getLblmatter() {
		if (lblmatter == null) {
			lblmatter = new JLabel("Tema de investigaci\u00F3n");
			lblmatter.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
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
			addBtn.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 19));
			addBtn.setForeground(Color.LIGHT_GRAY);
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (!researcherName.getText().trim().isEmpty()) {						
						if (event != null) {						
							Profesor profesor = faculty.addProfesor(researcherName.getText(), getDegree(), getCat());
							String matterName = (String)matterSelect.getModel().getElementAt(matterSelect.getSelectedIndex());
							ResearchMatter matter = faculty.findResearchMatter(matterName);
							matter.addResearcher(profesor);
							
							event.added(profesor, matterName);
						}
						
						// Reset the form
						lblElNombreEs.setVisible(false);
						researcherName.setText("");
						profesorCatSelect.setSelectedIndex(0);
						degreeSelect.setSelectedIndex(0);
						matterSelect.setSelectedIndex(0);
					} else {
						lblElNombreEs.setVisible(true);
					}
				}
			});
			addBtn.setBackground(new Color(255, 102, 153));
		}
		return addBtn;
	}
	private JLabel getLblElNombreEs() {
		if (lblElNombreEs == null) {
			lblElNombreEs = new JLabel("El nombre es requerido");
			lblElNombreEs.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			lblElNombreEs.setVisible(false);
			lblElNombreEs.setForeground(new Color(204, 0, 102));
		}
		return lblElNombreEs;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
		}
		return label;
	}
}
