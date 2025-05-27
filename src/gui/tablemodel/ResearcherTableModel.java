package gui.tablemodel;

import javax.swing.table.DefaultTableModel;

public class ResearcherTableModel extends DefaultTableModel {
	public ResearcherTableModel() {
		String[] columns = {"Nombre", "Tema", "Puntuación"};

		this.setColumnIdentifiers(columns);
	}

	public void addNew(String name, String matter, int score){
		Object[] newRow = new Object[]{name, matter, score};
		
		addRow(newRow);
	}

}
