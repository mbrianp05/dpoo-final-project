package gui.tablemodel;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class ResearcherTableModel extends DefaultTableModel {
	private ArrayList<Object[]> preFilter;
	
	public ResearcherTableModel() {
		preFilter = new ArrayList<>();
		String[] columns = {"Nombre", "Tema", "Puntuación"};
		
		this.setColumnIdentifiers(columns);
	}

	public void addNew(String name, String matter, int score){
		preFilter.add(new Object[]{name, matter, score});
		Object[] newRow = new Object[]{name, matter, score};
		
		addRow(newRow);
	}

	public void removeFilters() {
		emptyTable();
		
		for (Object[] data: preFilter) {
			addRow(new Object[] { data[0], data[1], data[2] });
		}
	}
	
	public void emptyTable() {
		for (int i = 0; i < getRowCount(); i++) {
			removeRow(i);
		}
	}
	
	public void filterByName(String query) {
	
	}
}
