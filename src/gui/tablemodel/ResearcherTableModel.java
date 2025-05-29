package gui.tablemodel;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import schooling.Faculty;
import schooling.Profesor;
import schooling.Researcher;
import schooling.Student;

public class ResearcherTableModel extends DefaultTableModel {
	private Faculty faculty;
	
	
	// Filters
	private String filterName;
	private int filterMinScore;
	private boolean includeProfesorsFilter;
	private boolean includeStudentsFilter;
	
	public ResearcherTableModel(Faculty faculty) {
		this.faculty = faculty;

		filterMinScore = 0;
		filterName = "";
		includeProfesorsFilter = true;
		includeStudentsFilter = true;
		
		String[] columns = {"Nombre", "Tema", "Puntuación"};
		this.setColumnIdentifiers(columns);
	}

	public void update(int row, String name, String matter, int score) {
		setValueAt(name, row, 0);
		setValueAt(matter, row, 1);
		setValueAt(score, row, 2);
	}
	
	public void addNew(Researcher r) {
		String matter = faculty.findMatterOf(r.getName()).getName();
		Object[] newRow = new Object[]{r.getName(), matter, r.getScore()};
		
		addRow(newRow);
	}
	
	public void emptyTable() {		
		while (getRowCount() > 0) {
			removeRow(0);
		}
	}
	
	public void setMinScore(int minScore) {
		filterMinScore = minScore;
	}
	
	public void setFilterName(String name) {
		filterName = name;
	}
	
	public void includeProfesors(boolean act) {
		includeProfesorsFilter = act;
	}
	
	public void includeStudents(boolean act) {
		includeStudentsFilter = act;
	}
	
	private ArrayList<Researcher> filterByName(ArrayList<Researcher> researchers) {
		ArrayList<Researcher> filtered = new ArrayList<>();
		
		if (filterName.isEmpty()) {
			filtered = researchers;
		} else {
			for (Researcher r: researchers) {
				if (r.getName().startsWith(filterName)) {
					filtered.add(r);
				}
			}
		}

		return filtered;
	}
	
	private ArrayList<Researcher> filterByScore(ArrayList<Researcher> researchers) {
		ArrayList<Researcher> filtered = new ArrayList<>();
		
		if (filterMinScore <= 0) {
			filtered = researchers;
		} else {
			for (Researcher r: researchers) {
				if (r.getScore() > filterMinScore) {
					filtered.add(r);
				}
			}
		}

		return filtered;
	}
	
	private ArrayList<Researcher> filterByKind(ArrayList<Researcher> researchers) {
		ArrayList<Researcher> filtered = new ArrayList<>();
		
		for (Researcher r: researchers) {
			if (includeProfesorsFilter && r instanceof Profesor) {
				filtered.add(r);
			}
			
			if (includeStudentsFilter && r instanceof Student) {
				filtered.add(r);
			}
		}

		return filtered;
	}
	
	public void applyFilters() {
		emptyTable();
		
		ArrayList<Researcher> filter = faculty.getResearchers();
		filter = filterByName(filter);
		filter = filterByScore(filter);
		filter = filterByKind(filter);
		
		for (Researcher r: filter) {
			String matter = faculty.findMatterOf(r.getName()).getName();
			
			addRow(new Object[] { r.getName(), matter, r.getScore() });
		}
	}

	public void removeSelectedItem(int row) {
		String name = (String)getValueAt(row, 0);
		removeRow(row);
//
//		Researcher r = faculty.findResearcherByName(name);
//		int index = faculty.getResearchers().indexOf(r);
//		faculty.getResearchers().remove(index);
	}
}
