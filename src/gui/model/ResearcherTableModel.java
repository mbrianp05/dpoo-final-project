package gui.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import schooling.Faculty;
import schooling.Profesor;
import schooling.ResearchMatter;
import schooling.Researcher;
import schooling.Student;

public class ResearcherTableModel extends DefaultTableModel {
	private static final long serialVersionUID = -1630353171311020485L;
	private Faculty faculty;
	
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
		
		String[] columns = {"ID", "Nombre", "Tema", "Puntuación"};
		this.setColumnIdentifiers(columns);
	}

	public void addNew(Researcher r) {
		ResearchMatter matter = faculty.findMatterOf(r.getID());
		String matterName = "-";
		
		if (matter != null) {
			matterName = matter.getName();
		}
		
		Object[] newRow = new Object[]{r.getID(), r.getName(), matterName, r.getScore()};
		
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
			addNew(r);
		}
	}

	public void removeSelectedItem(int row) {
//		String name = (String)getValueAt(row, 0);
//		removeRow(row);
//
//		Researcher r = faculty.findResearcherByName(name);
//		int index = faculty.getResearchers().indexOf(r);
//		faculty.getResearchers().remove(index);
	}
}
