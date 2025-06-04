package gui.views;

import gui.model.CoursesTableModel;

import javax.swing.JPanel;

import schooling.Faculty;

import java.awt.GridBagLayout;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

public class CoursesTableView extends JPanel {
	private JLabel lblCursosDePostgrado;
	private JScrollPane scrollPane;
	private JTable table;
	private CoursesTableModel coursesTableModel;

	/**
	 * Create the panel.
	 */
	public CoursesTableView(Faculty faculty) {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblCursosDePostgrado = new GridBagConstraints();
		gbc_lblCursosDePostgrado.insets = new Insets(0, 0, 5, 5);
		gbc_lblCursosDePostgrado.gridx = 2;
		gbc_lblCursosDePostgrado.gridy = 1;
		add(getLblCursosDePostgrado(), gbc_lblCursosDePostgrado);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 3;
		add(getScrollPane(), gbc_scrollPane);
		
		coursesTableModel = new CoursesTableModel(faculty);
		table.setModel(coursesTableModel);

		
	}

	private JLabel getLblCursosDePostgrado() {
		if (lblCursosDePostgrado == null) {
			lblCursosDePostgrado = new JLabel("Cursos de postgrado registrados");
			lblCursosDePostgrado.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		}
		return lblCursosDePostgrado;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setFillsViewportHeight(true);
			table.setBackground(Color.WHITE);
			table.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return table;
	}
}
