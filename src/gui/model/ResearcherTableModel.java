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
	private String filterMatter;
	private int filterMinScore;
	private boolean includeProfesorsFilter;
	private boolean includeStudentsFilter;

	public ResearcherTableModel() {
		this.faculty = Faculty.newInstance();

		filterName = "";
		filterMatter = "";
		filterMinScore = 0;
		includeProfesorsFilter = true;
		includeStudentsFilter = true;

		String[] columns = { "ID", "Nombre", "Línea", "Tema", "Puntuación" };
		this.setColumnIdentifiers(columns);

		fill();
	}

	public boolean isCellEditable(int row, int col) {
		return false;
	}

	public void addNew(Researcher r) {
		ResearchMatter matter = faculty.findMatterOf(r.getID());
		String matterName = "-";

		if (matter != null) {
			matterName = matter.getName();
		}

		Object[] newRow = new Object[] { String.valueOf(r.getID()), r.getName(),
				faculty.findResearchLineByResearcher(r).getName(), matterName, r.getScore() };

		addRow(newRow);
	}

	public void emptyTable() {
		setRowCount(0);
	}

	public void setFilterMatter(String filter) {
		filterMatter = filter;
		fill();
	}

	public void setMinScore(int minScore) {
		filterMinScore = minScore;
		fill();
	}

	public void setFilterName(String name) {
		filterName = name;
		fill();
	}

	public void includeProfesors(boolean act) {
		includeProfesorsFilter = act;
		fill();
	}

	public void includeStudents(boolean act) {
		includeStudentsFilter = act;
		fill();
	}

	private ArrayList<Researcher> filterByMatter(ArrayList<Researcher> researchers) {
		ArrayList<Researcher> filtered = new ArrayList<>();

		if (filterMatter.isEmpty()) {
			filtered = researchers;
		} else {
			for (Researcher r : researchers) {
				ResearchMatter matter = faculty.findMatterOf(r.getID());

				if (matter != null && matter.getName().startsWith(filterMatter)) {
					filtered.add(r);
				}
			}
		}

		return filtered;
	}

	private ArrayList<Researcher> filterByName(ArrayList<Researcher> researchers) {
		ArrayList<Researcher> filtered = new ArrayList<>();

		if (filterName.isEmpty()) {
			filtered = researchers;
		} else {
			for (Researcher r : researchers) {
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
			for (Researcher r : researchers) {
				if (r.getScore() >= filterMinScore) {
					filtered.add(r);
				}
			}
		}

		return filtered;
	}

	private ArrayList<Researcher> filterByKind(ArrayList<Researcher> researchers) {
		ArrayList<Researcher> filtered = new ArrayList<>();

		for (Researcher r : researchers) {
			if (includeProfesorsFilter && r instanceof Profesor) {
				filtered.add(r);
			}

			if (includeStudentsFilter && r instanceof Student) {
				filtered.add(r);
			}
		}

		return filtered;
	}

	public void fill() {
		emptyTable();

		ArrayList<Researcher> filter = faculty.getResearchers();

		filter = filterByMatter(filter);
		filter = filterByName(filter);
		filter = filterByScore(filter);
		filter = filterByKind(filter);

		for (Researcher r : filter) {
			addNew(r);
		}
	}
}
