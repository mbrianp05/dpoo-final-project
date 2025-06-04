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
import javax.swing.JTextField;

public class CoursesTableView extends JPanel {
	private JLabel lblCursosDePostgrado;
	private JScrollPane scrollPane;
	private JTable table;
	private CoursesTableModel coursesTableModel;
	private JLabel lblFiltrar;
	private JLabel lblNombre;
	private JTextField filterByName;
	private JLabel lblInstructor;
	private JTextField filterByCred;

	/**
	 * Create the panel.
	 */
	public CoursesTableView(Faculty faculty) {
		setBackground(Color.WHITE);
		
		coursesTableModel = new CoursesTableModel(faculty);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{45, 55, 116, 56, 116, 0};
		gridBagLayout.rowHeights = new int[]{70, 34, 72, 23, 90, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblCursosDePostgrado = new GridBagConstraints();
		gbc_lblCursosDePostgrado.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCursosDePostgrado.insets = new Insets(0, 0, 5, 0);
		gbc_lblCursosDePostgrado.gridwidth = 4;
		gbc_lblCursosDePostgrado.gridx = 1;
		gbc_lblCursosDePostgrado.gridy = 1;
		add(getLblCursosDePostgrado(), gbc_lblCursosDePostgrado);
		GridBagConstraints gbc_lblFiltrar = new GridBagConstraints();
		gbc_lblFiltrar.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltrar.gridx = 0;
		gbc_lblFiltrar.gridy = 3;
		add(getLblFiltrar(), gbc_lblFiltrar);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 3;
		add(getLblNombre(), gbc_lblNombre);
		GridBagConstraints gbc_filterByName = new GridBagConstraints();
		gbc_filterByName.anchor = GridBagConstraints.SOUTHWEST;
		gbc_filterByName.insets = new Insets(0, 0, 5, 5);
		gbc_filterByName.gridx = 2;
		gbc_filterByName.gridy = 3;
		add(getFilterByName(), gbc_filterByName);
		GridBagConstraints gbc_lblInstructor = new GridBagConstraints();
		gbc_lblInstructor.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblInstructor.insets = new Insets(0, 0, 5, 5);
		gbc_lblInstructor.gridx = 3;
		gbc_lblInstructor.gridy = 3;
		add(getLblInstructor(), gbc_lblInstructor);
		GridBagConstraints gbc_filterByCred = new GridBagConstraints();
		gbc_filterByCred.anchor = GridBagConstraints.SOUTHWEST;
		gbc_filterByCred.insets = new Insets(0, 0, 5, 0);
		gbc_filterByCred.gridx = 4;
		gbc_filterByCred.gridy = 3;
		add(getFilterByCred(), gbc_filterByCred);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		add(getScrollPane(), gbc_scrollPane);
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
	private JLabel getLblFiltrar() {
		if (lblFiltrar == null) {
			lblFiltrar = new JLabel("Filtrar");
			lblFiltrar.setHorizontalAlignment(SwingConstants.LEFT);
			lblFiltrar.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return lblFiltrar;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return lblNombre;
	}
	private JTextField getFilterByName() {
		if (filterByName == null) {
			filterByName = new JTextField();
			filterByName.setColumns(10);
		}
		return filterByName;
	}
	private JLabel getLblInstructor() {
		if (lblInstructor == null) {
			lblInstructor = new JLabel("Cred. Nec.");
			lblInstructor.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return lblInstructor;
	}
	private JTextField getFilterByCred() {
		if (filterByCred == null) {
			filterByCred = new JTextField();
			filterByCred.setColumns(10);
		}
		return filterByCred;
	}
}
