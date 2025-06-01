package gui.component;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import schooling.Faculty;

public class ResearchMatterComboBox extends JComboBox<Object> {
	private static final long serialVersionUID = 1L;
	private Faculty faculty;
	
	public ResearchMatterComboBox(Faculty faculty) {
		this.faculty = faculty;
		
		setData();
	}
	
	public void setData() {
		setModel(new DefaultComboBoxModel<Object>(faculty.getResearchMattersNames().toArray()));
	}
}
