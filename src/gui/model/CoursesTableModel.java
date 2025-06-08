package gui.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import schooling.Faculty;
import schooling.PostgraduateCourse;

public class CoursesTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 9038021182128267655L;
	private Faculty faculty;
	private String filterName;
	private int filterMinCreds;

	public CoursesTableModel(Faculty faculty) {

		this.faculty = faculty;
		
		filterName = "";
		filterMinCreds = 0;

		String[] columns = {"Nombre", "Instructor", "Créditos", "Descripción"};
		this.setColumnIdentifiers(columns);

		fill();
	}

	public boolean isCellEditable(int row, int col) {
		return false;
	}
	
	public void setFilterName(String name) {
		filterName = name;
		fill();
	}
	
	public void setFilterCreds(int creds) {
		filterMinCreds = creds;
		fill();
	}
	
	public ArrayList<PostgraduateCourse> filterByName(ArrayList<PostgraduateCourse> courses) {
		ArrayList<PostgraduateCourse> filtered = new ArrayList<>();

		if(filterName.isEmpty()) {
			filtered = courses;
		} else {
			for(PostgraduateCourse c: faculty.getCoursesList()) {
				if(c.getName().startsWith(filterName)){
					filtered.add(c);
				}
			}
		}

		return filtered;
	}
	
	public ArrayList<PostgraduateCourse> filterByCreds(ArrayList<PostgraduateCourse> courses) {
		ArrayList<PostgraduateCourse> filtered = new ArrayList<>();
		
		if(filterMinCreds <= 0) {
			filtered = courses;
		} else {
			for(PostgraduateCourse c: courses) {
				if(c.getCredits() >= filterMinCreds) {
					filtered.add(c);
				}
			}
		}
		return filtered;
	}

	public void fill() {
		emptyTable();
		
		ArrayList<PostgraduateCourse> filter = faculty.getCoursesList();
		
		filter = filterByName(filter);
		filter = filterByCreds(filter);
		
		for(PostgraduateCourse c: filter){
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
