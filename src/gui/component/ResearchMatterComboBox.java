package gui.component;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import schooling.Faculty;
import schooling.Profesor;
import schooling.ResearchMatter;
import utils.ArrayLib;

public class ResearchMatterComboBox extends JComboBox<String> {
	private static final long serialVersionUID = 1L;
	private Faculty faculty;
	
	public ResearchMatterComboBox(Faculty faculty) {
		this.faculty = faculty;
		
		setData();
	}
	
	public void setData() {
		String[] names = ArrayLib.cast(faculty.getResearchMattersNames());
		
		setModel(new DefaultComboBoxModel<String>(names));
	}
	
	public void setData(Profesor profesor) {
		if (!faculty.isChief(profesor)) {
			throw new IllegalArgumentException("The profesor given does not lead any research line");
		}

		ArrayList<ResearchMatter> matters = faculty.findResearchLineByChief(profesor).getMatters();
		String[] names = new String[matters.size()];

		for (int i = 0; i < matters.size(); i++) {
			names[i] = matters.get(i).getName();
		}
		
		setModel(new DefaultComboBoxModel<>(names));
	}
}
