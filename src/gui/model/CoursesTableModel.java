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
	private String filterInstr;

	public CoursesTableModel(Faculty faculty) {

		this.faculty = faculty;

		filterName = "";
		filterInstr = "";
		filterMinCreds = 0;

		String[] columns = { "Nombre", "Instructor", "L�nea vinculada", "Cr�ditos", "Descripci�n" };
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

	public void setFilterByInstruc(String name) {
		filterInstr = name;
		fill();
	}

	public ArrayList<PostgraduateCourse> filterByName(ArrayList<PostgraduateCourse> courses) {
		ArrayList<PostgraduateCourse> filtered = new ArrayList<>();

		if (filterName.isEmpty()) {
			filtered = courses;
		} else {
			for (PostgraduateCourse c : faculty.getCoursesList()) {
				if (c.getName().startsWith(filterName)) {
					filtered.add(c);
				}
			}
		}

		return filtered;
	}

	public ArrayList<PostgraduateCourse> filterByCreds(ArrayList<PostgraduateCourse> courses) {
		ArrayList<PostgraduateCourse> filtered = new ArrayList<>();

		if (filterMinCreds <= 0) {
			filtered = courses;
		} else {
			for (PostgraduateCourse c : courses) {
				if (c.getCredits() >= filterMinCreds) {
					filtered.add(c);
				}
			}
		}
		return filtered;
	}

	public ArrayList<PostgraduateCourse> filterProfesors(ArrayList<PostgraduateCourse> courses) {
		ArrayList<PostgraduateCourse> filtered = new ArrayList<>();

		if (filterInstr.isEmpty())
			filtered = courses;
		else {
			for (PostgraduateCourse p : courses) {
				if (p.getInstructor().getName().startsWith(filterInstr)) {
					filtered.add(p);
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
		filter = filterProfesors(filter);

		for (PostgraduateCourse c : filter) {
			addNew(c);
		}
	}

	public void emptyTable() {
		setRowCount(0);
	}

	public void addNew(PostgraduateCourse c) {
		Object[] newRow = new Object[] { c.getName(), c.getInstructor().getName(),
				faculty.findResearchLineByCourse(c).getName(), String.valueOf(c.getCredits()), c.getDescription() };

		addRow(newRow);
	}
}
