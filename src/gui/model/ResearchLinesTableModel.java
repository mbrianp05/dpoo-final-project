package gui.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import schooling.Faculty;
import schooling.ResearchLine;
import schooling.ResearchMatter;
import utils.ArrayLib;

public class ResearchLinesTableModel extends DefaultTableModel {
	private static final long serialVersionUID = -473276802612602487L;
	private Faculty faculty;

	private String filterName;
	private String filterChief;
	private String filterMatter;
	private int filterCredits;

	private ArrayList<ResearchLine> shownResearchLines;

	public ResearchLinesTableModel() {
		this.faculty = Faculty.newInstance();

		filterName = "";
		filterChief = "";
		filterMatter = "";
		filterCredits = 0;

		String[] columns = { "Nombre", "Responsable", "Materias", "Créditos necesarios para la maestría" };
		this.setColumnIdentifiers(columns);

		fill();
	}

	public void setFilterCredits(int credits) {
		filterCredits = credits;
		fill();
	}

	public void setFilterMatter(String matter) {
		filterMatter = matter;
		fill();
	}

	public void setFilterName(String filter) {
		filterName = filter;
		fill();
	}

	public void setChiefFilter(String filter) {
		filterChief = filter;
		fill();
	}

	private ArrayList<ResearchLine> filterByChief(ArrayList<ResearchLine> entry) {
		ArrayList<ResearchLine> data = new ArrayList<>();

		for (ResearchLine r : entry) {
			if (r.getChief().getName().startsWith(filterChief)) {
				data.add(r);
			}
		}

		return data;
	}

	private ArrayList<ResearchLine> filterByName(ArrayList<ResearchLine> entry) {
		ArrayList<ResearchLine> data = new ArrayList<>();

		for (ResearchLine r : entry) {
			if (r.getName().startsWith(filterName)) {
				data.add(r);
			}
		}

		return data;
	}

	private ArrayList<ResearchLine> filterByMatter(ArrayList<ResearchLine> entry) {
		ArrayList<ResearchLine> data = new ArrayList<>();

		for (ResearchLine r : entry) {
			for (ResearchMatter m : r.getMatters()) {
				if (m.getName().startsWith(filterMatter)) {
					data.remove(r);
					data.add(r);
				}
			}
		}

		return data;
	}

	private ArrayList<ResearchLine> filterByCredits(ArrayList<ResearchLine> entry) {
		ArrayList<ResearchLine> data = entry;

		if (filterCredits != 0) {
			data = new ArrayList<>();

			for (ResearchLine r : entry) {
				if (r.getMasteryPlan().getMinCredits() >= filterCredits) {
					data.add(r);
				}
			}
		}

		return data;
	}

	public boolean isCellEditable(int row, int col) {
		return false;
	}

	public void emptyTable() {
		setRowCount(0);
	}

	public void addNew(ResearchLine line) {
		ArrayList<String> matters = new ArrayList<>();

		for (ResearchMatter matter : line.getMatters()) {
			matters.add(matter.getName());
		}

		Object[] newRow = new Object[] { line.getName(), line.getChief().getName(), ArrayLib.join(matters),
				line.getMasteryPlan().getMinCredits() };

		addRow(newRow);
	}

	public ArrayList<ResearchLine> getShownResearchLines() {
		return shownResearchLines;
	}

	public void fill() {
		emptyTable();

		ArrayList<ResearchLine> data = faculty.getResearchLines();

		data = filterByChief(data);
		data = filterByName(data);
		data = filterByMatter(data);
		data = filterByCredits(data);

		shownResearchLines = data;

		for (ResearchLine item : data) {
			addNew(item);
		}
	}
}
