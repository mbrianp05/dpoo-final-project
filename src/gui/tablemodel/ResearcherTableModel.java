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

	public void update(int row, String name, String matter, int score) {
		setValueAt(name, row, 0);
		setValueAt(matter, row, 1);
		setValueAt(score, row, 2);
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
		while (getRowCount() > 0) {
			removeRow(0);
		}
	}
	
	public void filterByName(String query) {
		emptyTable();
		
		for (Object[] item: preFilter) {
			String name = (String)item[0];
			
			if (name.startsWith(query)) {
				addRow(new Object[] {name, (String)item[1], (int)item[2]});
			}
		}
	}
}
