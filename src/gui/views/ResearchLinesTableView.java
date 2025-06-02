package gui.views;

import gui.model.ResearchLinesTableModel;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTable;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JScrollPane;

import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ListSelectionModel;

import schooling.Faculty;

public class ResearchLinesTableView extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblFiltrar;
	private JLabel lblNombre;
	private JTextField filterByName;
	private JScrollPane scrollPane;

	private ResearchLinesTableModel tableModel;
	private JTable table;

	private Faculty faculty;
	private JLabel lblDatosDeInvestigadores;

	public ResearchLinesTableView(Faculty faculty) {
		this.faculty = faculty;

		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 70, 30, 100, 0, 0, 100, 0};
		gridBagLayout.rowHeights = new int[]{40, 0, 50, 50, 207, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblDatosDeInvestigadores = new GridBagConstraints();
		gbc_lblDatosDeInvestigadores.fill = GridBagConstraints.BOTH;
		gbc_lblDatosDeInvestigadores.gridwidth = 5;
		gbc_lblDatosDeInvestigadores.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatosDeInvestigadores.gridx = 1;
		gbc_lblDatosDeInvestigadores.gridy = 1;
		add(getLblDatosDeInvestigadores(), gbc_lblDatosDeInvestigadores);
		GridBagConstraints gbc_lblFiltrar = new GridBagConstraints();
		gbc_lblFiltrar.fill = GridBagConstraints.BOTH;
		gbc_lblFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltrar.gridx = 1;
		gbc_lblFiltrar.gridy = 3;
		add(getLblFiltrar(), gbc_lblFiltrar);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 2;
		gbc_lblNombre.gridy = 3;
		add(getLblNombre(), gbc_lblNombre);
		GridBagConstraints gbc_filterByName = new GridBagConstraints();
		gbc_filterByName.fill = GridBagConstraints.HORIZONTAL;
		gbc_filterByName.insets = new Insets(0, 0, 5, 5);
		gbc_filterByName.gridx = 3;
		gbc_filterByName.gridy = 3;
		add(getFilterByName(), gbc_filterByName);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		add(getScrollPane(), gbc_scrollPane);

		tableModel = new ResearchLinesTableModel(faculty);
		table.setModel(tableModel);
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
			lblNombre.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNombre.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return lblNombre;
	}
	private JTextField getFilterByName() {
		if (filterByName == null) {
			filterByName = new JTextField("");
			filterByName.setColumns(10);
		}
		return filterByName;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable_1());
		}
		return scrollPane;
	}
	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.setFillsViewportHeight(true);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			table.setBackground(Color.WHITE);
		}
		return table;
	}

	public void updateTable() {
		((ResearchLinesTableModel)table.getModel()).fill();
	}
	
	private JLabel getLblDatosDeInvestigadores() {
		if (lblDatosDeInvestigadores == null) {
			lblDatosDeInvestigadores = new JLabel("Datos de l\u00EDneas de investigaci\u00F3n");
			lblDatosDeInvestigadores.setFont(new Font("Segoe UI", Font.PLAIN, 25));
		}
		return lblDatosDeInvestigadores;
	}
}