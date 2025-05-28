package gui.tablemodel;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import schooling.Faculty;
import schooling.Profesor;
import schooling.Researcher;
import schooling.Student;

public class ResearcherTableModel extends DefaultTableModel {
	private Faculty faculty;
	
	public ResearcherTableModel(Faculty faculty) {
		this.faculty = faculty;
		String[] columns = {"Nombre", "Tema", "Puntuación"};
		
		this.setColumnIdentifiers(columns);
	}

	public void update(int row, String name, String matter, int score) {
		setValueAt(name, row, 0);
		setValueAt(matter, row, 1);
		setValueAt(score, row, 2);
	}
	
	public void addNew(Researcher r) {
		String matter = faculty.findMatterOf(r.getName()).getName();
		Object[] newRow = new Object[]{r.getName(), matter, r.getScore()};
		
		addRow(newRow);
	}
	
	public void emptyTable() {		
		while (getRowCount() > 0) {
			removeRow(0);
		}
	}
	
	public void filterByName(String query) {
		emptyTable();
		
		for (Researcher r: faculty.getResearchers()) {
			if (r.getName().startsWith(query)) {
				String matter = faculty.findMatterOf(r.getName()).getName();
				addRow(new Object[] {r.getName(), matter, r.getScore()});
			}
		}
	}

	public void filterByScore(int score) {
		emptyTable();
		
		for (Researcher r: faculty.getResearchers()) {
			if (r.getScore() >= score) {
				String matter = faculty.findMatterOf(r.getName()).getName();
				addRow(new Object[] {r.getName(), matter, r.getScore()});
			}
		}
	}

	public void filterByType(boolean students, boolean profesors) {
		emptyTable();
		
		for (Researcher r: faculty.getResearchers()) {
			if (profesors && r instanceof Profesor) {
				String matter = faculty.findMatterOf(r.getName()).getName();
				addRow(new Object[] {r.getName(), matter, r.getScore()});
			}
			
			if (students && r instanceof Student) {
				String matter = faculty.findMatterOf(r.getName()).getName();
				addRow(new Object[] {r.getName(), matter, r.getScore()});
			}
		}
	}
}
