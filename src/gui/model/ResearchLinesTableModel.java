package gui.model;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import schooling.Faculty;
import schooling.Profesor;
import schooling.ResearchLine;
import schooling.ResearchMatter;
import schooling.Researcher;
import schooling.Student;
import utils.ArrayLib;

public class ResearchLinesTableModel extends DefaultTableModel {
	private static final long serialVersionUID = -473276802612602487L;
	private Faculty faculty;
	
	private String filterName;
	private String filterChief;
	
	public ResearchLinesTableModel() {
		this.faculty = Faculty.newInstance();
		
		filterName = "";
		filterChief = "";
		
		String[] columns = {"Nombre", "Responsable", "Materias"};
		this.setColumnIdentifiers(columns);
		
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

		for (ResearchLine r: entry) {
			if (r.getChief().getName().startsWith(filterChief)) {
				data.add(r);
			}
		}

		return data;
	}
	
	private ArrayList<ResearchLine> filterByName(ArrayList<ResearchLine> entry) {
		ArrayList<ResearchLine> data = new ArrayList<>();

		for (ResearchLine r: entry) {
			if (r.getName().startsWith(filterName)) {
				data.add(r);
			}
		}

		return data;
	}
	
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	
	public void emptyTable() {		
		while (getRowCount() > 0) {
			removeRow(0);
		}
	}
	
	public void addNew(ResearchLine line) {	
		ArrayList<String> matters = new ArrayList<>();
		
		for (ResearchMatter matter: line.getMatters()) {
			matters.add(matter.getName());
		}
		
		Object[] newRow = new Object[]{line.getName(), line.getChief().getName(), ArrayLib.join(matters)};
		
		addRow(newRow);
	}
	
	public void fill() {
		emptyTable();
		
		ArrayList<ResearchLine> data = faculty.getReseachLines();
		
		data = filterByChief(data);
		data = filterByName(data);
		
		for (ResearchLine item: data) {
			addNew(item);
		}
	}
}
