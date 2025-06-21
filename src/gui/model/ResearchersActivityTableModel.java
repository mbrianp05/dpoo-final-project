package gui.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import schooling.Breakthrough;
import schooling.Chapter;
import schooling.Faculty;
import schooling.HasUniqueIndentifier;
import schooling.Paper;
import schooling.Presentation;
import schooling.Researcher;

public class ResearchersActivityTableModel extends DefaultTableModel {
	private static final long serialVersionUID = -1630353171311020485L;

	private Faculty faculty;
	private ArrayList<Breakthrough> breakthroughs;

	private String filterName;
	private String filterResearcher;
	private boolean includePapers;
	private boolean includePresentations;
	private boolean includeChapters;
	private int filterScore;

	public ResearchersActivityTableModel() {
		filterName = "";
		filterResearcher = "";
		filterScore = 0;
		includePapers = true;
		includePresentations = true;
		includeChapters = true;

		this.faculty = Faculty.newInstance();

		String[] columns = { "Nombre", "Investigador", "Puntuación", "Identificador" };
		this.setColumnIdentifiers(columns);

		init();
		fill();
	}

	public void includePapers(boolean include) {
		includePapers = include;
		fill();
	}

	public void includePresentations(boolean include) {
		includePresentations = include;
		fill();
	}

	public void includeChapters(boolean include) {
		includeChapters = include;
		fill();
	}

	public void setFilterName(String filter) {
		filterName = filter;
		fill();
	}

	public void setFilterResearcher(String filter) {
		filterResearcher = filter;
		fill();
	}

	public void setFilterScore(int score) {
		filterScore = score;
		fill();
	}

	public void init() {
		breakthroughs = faculty.getBreakthroughs();
	}

	public ArrayList<Breakthrough> getData() {
		return breakthroughs;
	}

	public boolean isCellEditable(int row, int col) {
		return false;
	}

	public void addNew(Breakthrough breakthrough) {
		String id = "-";

		if (breakthrough instanceof HasUniqueIndentifier) {
			id = ((HasUniqueIndentifier) breakthrough).getId();
		}

		Researcher researcher;

		try {
			researcher = faculty.findResearcherByBreakthrough(breakthrough);
			Object[] newRow = new Object[] { breakthrough.getName(), researcher.getName(), breakthrough.getScore(),
					id };
			addRow(newRow);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void emptyTable() {
		setRowCount(0);
	}

	private void filterByName() {
		ArrayList<Breakthrough> filter = new ArrayList<>();

		for (Breakthrough b : breakthroughs) {
			if (b.getName().startsWith(filterName)) {
				filter.add(b);
			}
		}

		this.breakthroughs = filter;
	}

	private void filterByResearcher() {
		ArrayList<Breakthrough> filter = new ArrayList<>();

		for (Breakthrough b : breakthroughs) {
			try {
				if (faculty.findResearcherByBreakthrough(b).getName().startsWith(filterResearcher)) {
					filter.add(b);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		this.breakthroughs = filter;
	}

	private void filterByScore() {
		ArrayList<Breakthrough> filter = new ArrayList<>();

		if (filterScore != 0) {
			for (Breakthrough b : breakthroughs) {
				if (b.getScore() == filterScore)
					filter.add(b);
			}
		} else {
			filter = breakthroughs;
		}

		breakthroughs = filter;
	}

	private void filterByInclusions() {
		ArrayList<Breakthrough> filter = new ArrayList<>();

		for (Breakthrough b : breakthroughs) {
			if (includePapers && b instanceof Paper)
				filter.add(b);
			if (includePresentations && b instanceof Presentation)
				filter.add(b);
			if (includeChapters && b instanceof Chapter)
				filter.add(b);
		}

		this.breakthroughs = filter;
	}

	public ArrayList<Breakthrough> getShownBreakthroughs() {
		return breakthroughs;
	}

	public void fill() {
		init();
		emptyTable();

		filterByScore();
		filterByName();
		filterByResearcher();
		filterByInclusions();

		for (Breakthrough b : breakthroughs) {
			addNew(b);
		}
	}
}
