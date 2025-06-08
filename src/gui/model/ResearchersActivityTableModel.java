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

	public ResearchersActivityTableModel() {
		this.faculty = Faculty.newInstance();

		String[] columns = {"Nombre", "Investigador", "Puntuación", "Identificador"};
		this.setColumnIdentifiers(columns);

		fill();
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

	public void fill() {
		emptyTable();

		ArrayList<Breakthrough> data = faculty.getBreakthroughs();

		for (Breakthrough b: data) {
			addNew(b);
		}
	}
}
