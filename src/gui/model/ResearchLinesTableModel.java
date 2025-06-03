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
	
	public ResearchLinesTableModel(Faculty faculty) {
		this.faculty = faculty;
		
		String[] columns = {"Nombre", "Responsable", "Materias"};
		this.setColumnIdentifiers(columns);
		
		fill();
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
		
		for (ResearchLine item: data) {
			addNew(item);
		}
	}
}
