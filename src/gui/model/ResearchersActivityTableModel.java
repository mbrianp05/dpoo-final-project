package gui.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import schooling.Breakthrough;
import schooling.Faculty;
import schooling.HasUniqueIndentifier;
import schooling.Researcher;

public class ResearchersActivityTableModel extends DefaultTableModel {
	private static final long serialVersionUID = -1630353171311020485L;
	
	private Faculty faculty;
	private ArrayList<Breakthrough> breakthroughs;
	
	private String filterName;
	private String filterResearcher;
	private int filterScore;
	
	public ResearchersActivityTableModel() {
		filterName = "";
		filterResearcher = "";
		filterScore = 0;
		
		this.faculty = Faculty.newInstance();

		String[] columns = {"Nombre", "Investigador", "Puntuación", "Identificador"};
		this.setColumnIdentifiers(columns);

		init();
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
			id = ((HasUniqueIndentifier)breakthrough).getId();
		}
		
		Researcher researcher;
		
		try {
			researcher = faculty.findResearcherByBreakthrough(breakthrough);
			Object[] newRow = new Object[]{breakthrough.getName(), researcher.getName(), breakthrough.getScore(), id};
			addRow(newRow);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void emptyTable() {		
		while (getRowCount() > 0) {
			removeRow(0);
		}
	}
	
	private ArrayList<Breakthrough> filterByName(ArrayList<Breakthrough> data) {
		ArrayList<Breakthrough> filter = new ArrayList<>();
		
		for (Breakthrough b: data) {
			if (b.getName().startsWith(filterName)) {
				filter.add(b);
			}
		}
		
		return filter;
	}
	
	private ArrayList<Breakthrough> filterByResearcher(ArrayList<Breakthrough> data) {
		ArrayList<Breakthrough> filter = new ArrayList<>();
		
		for (Breakthrough b: data) {
			try {
				if (faculty.findResearcherByBreakthrough(b).getName().startsWith(filterResearcher)) {
					filter.add(b);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return filter;
	}

	private ArrayList<Breakthrough> filterByScore(ArrayList<Breakthrough> data) {
		ArrayList<Breakthrough> filter = data;
		
		if (filterScore != 0) {
			filter.clear();
			
			for (Breakthrough b: breakthroughs) {
				if (b.getScore() == filterScore) filter.add(b);
			}
		}
		
		return filter;
	}
	
	public void fill() {
		init();
		emptyTable();
		
		ArrayList<Breakthrough> data = breakthroughs;
		
		data = filterByName(data);
		data = filterByResearcher(data);
		data = filterByScore(data);
		
		for (Breakthrough b: data) {
			addNew(b);
		}
	}
}
