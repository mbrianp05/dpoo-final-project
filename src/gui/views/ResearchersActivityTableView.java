package gui.views;

import gui.model.ResearchersActivityTableModel;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTable;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ListSelectionModel;

import utils.Constants;

public class ResearchersActivityTableView extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblFiltrar;
	private JScrollPane scrollPane;

	private ResearchersActivityTableModel researcherModel;
	private JTable table;

	private JLabel lblDatosDeInvestigadores;
	
	public ResearchersActivityTableView() {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 70, 100, 100, 30, 100, 0, 0, 70, 70, 100, 0};
		gridBagLayout.rowHeights = new int[]{70, 45, 60, 35, 207, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblDatosDeInvestigadores = new GridBagConstraints();
		gbc_lblDatosDeInvestigadores.fill = GridBagConstraints.BOTH;
		gbc_lblDatosDeInvestigadores.gridwidth = 9;
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
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 9;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		add(getScrollPane(), gbc_scrollPane);

		researcherModel = new ResearchersActivityTableModel();
		table.setModel(researcherModel);
	}

	private JLabel getLblFiltrar() {
		if (lblFiltrar == null) {
			lblFiltrar = new JLabel("Filtrar");
			lblFiltrar.setHorizontalAlignment(SwingConstants.LEFT);
			lblFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}

		return lblFiltrar;
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
			table.setFont(Constants.getLabelFont());
			table.setRowHeight(24);
			table.setFillsViewportHeight(true);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			table.setBackground(Color.WHITE);
		}
		
		return table;
	}

	public void updateTable() {
		((ResearchersActivityTableModel)table.getModel()).fill();
	}
	
	private JLabel getLblDatosDeInvestigadores() {
		if (lblDatosDeInvestigadores == null) {
			lblDatosDeInvestigadores = new JLabel("Datos de la actividad investigativa");
			lblDatosDeInvestigadores.setFont(Constants.getTitleFont());
		}
		
		return lblDatosDeInvestigadores;
	}
}
