package gui.model;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import schooling.Faculty;
import schooling.PostgraduateCourse;
import schooling.Researcher;

public class CoursesTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 9038021182128267655L;
	private Faculty faculty;
	
	public CoursesTableModel(Faculty faculty) {
		
		this.faculty = faculty;
		
		String[] columns = {"Nombre", "Instructor", "Créditos", "Descripción"};
		this.setColumnIdentifiers(columns);

		fill();
	}
	
	public void fill() {
		emptyTable();
		
		ArrayList<PostgraduateCourse> courses = new ArrayList<PostgraduateCourse>();
				
		for (PostgraduateCourse c: courses) {
			addNew(c);
		}
	}

	public void emptyTable() {		
		while (getRowCount() > 0) {
			removeRow(0);
		}
	}
	
	public void addNew(PostgraduateCourse c){
		Object[] newRow = new Object[]{c.getName(), c.getInstructor().getName(), String.valueOf(c.getCredits()), c.getDescription()};
		
		addRow(newRow);
	}
}
