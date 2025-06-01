package gui.views;

import gui.model.ResearcherTableModel;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JScrollPane;

import schooling.Faculty;
import schooling.Researcher;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ResearchersTableView extends JPanel {
	private static final long serialVersionUID = 1L;
	private JCheckBox filterStudents;
	private JCheckBox filterProfesors;
	private JLabel lblFiltrar;
	private JLabel lblPuntuacin;
	private JSpinner spinner;
	private JLabel lblNombre;
	private JTextField filterByName;
	private JScrollPane scrollPane;

	private ResearcherTableModel researcherModel;
	private JTable table;

	private Faculty faculty;
	
	private JButton btnEliminar;

	public ResearchersTableView(Faculty faculty) {
		this.faculty = faculty;

		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{70, 100, 100, 30, 70, 100, 0, 70, 50, 0, 100, 0};
		gridBagLayout.rowHeights = new int[]{26, 207, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblFiltrar = new GridBagConstraints();
		gbc_lblFiltrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltrar.gridx = 0;
		gbc_lblFiltrar.gridy = 0;
		add(getLblFiltrar(), gbc_lblFiltrar);
		GridBagConstraints gbc_filterProfesors = new GridBagConstraints();
		gbc_filterProfesors.fill = GridBagConstraints.HORIZONTAL;
		gbc_filterProfesors.anchor = GridBagConstraints.SOUTH;
		gbc_filterProfesors.insets = new Insets(0, 0, 5, 5);
		gbc_filterProfesors.gridx = 1;
		gbc_filterProfesors.gridy = 0;
		add(getFilterProfesors(), gbc_filterProfesors);
		GridBagConstraints gbc_filterStudents = new GridBagConstraints();
		gbc_filterStudents.anchor = GridBagConstraints.SOUTH;
		gbc_filterStudents.fill = GridBagConstraints.HORIZONTAL;
		gbc_filterStudents.insets = new Insets(0, 0, 5, 5);
		gbc_filterStudents.gridx = 2;
		gbc_filterStudents.gridy = 0;
		add(getFilterStudents(), gbc_filterStudents);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.NORTH;
		gbc_lblNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 4;
		gbc_lblNombre.gridy = 0;
		add(getLblNombre(), gbc_lblNombre);
		GridBagConstraints gbc_filterByName = new GridBagConstraints();
		gbc_filterByName.fill = GridBagConstraints.HORIZONTAL;
		gbc_filterByName.insets = new Insets(0, 0, 5, 5);
		gbc_filterByName.gridx = 5;
		gbc_filterByName.gridy = 0;
		add(getFilterByName(), gbc_filterByName);
		GridBagConstraints gbc_lblPuntuacin = new GridBagConstraints();
		gbc_lblPuntuacin.anchor = GridBagConstraints.NORTH;
		gbc_lblPuntuacin.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPuntuacin.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntuacin.gridx = 7;
		gbc_lblPuntuacin.gridy = 0;
		add(getLblPuntuacin(), gbc_lblPuntuacin);
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 8;
		gbc_spinner.gridy = 0;
		add(getSpinner(), gbc_spinner);
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.anchor = GridBagConstraints.SOUTH;
		gbc_btnEliminar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 0);
		gbc_btnEliminar.gridx = 10;
		gbc_btnEliminar.gridy = 0;
		add(getBtnEliminar(), gbc_btnEliminar);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 11;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(getScrollPane(), gbc_scrollPane);

		researcherModel = new ResearcherTableModel(faculty);
		table.setModel(researcherModel);

		initTableData();	
	}
	
	private void initTableData() {
		for (Researcher r: faculty.getResearchers()) {
			((ResearcherTableModel)table.getModel()).addNew(r);
		}
	}

	private JCheckBox getFilterStudents() {
		if (filterStudents == null) {
			filterStudents = new JCheckBox("Estudiantes");
			filterStudents.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ResearcherTableModel tmodel = (ResearcherTableModel)table.getModel();
					tmodel.includeStudents(filterStudents.isSelected());
					tmodel.applyFilters();
				}
			});
			filterStudents.setBackground(Color.WHITE);
			filterStudents.setSelected(true);
		}

		return filterStudents;
	}

	private JCheckBox getFilterProfesors() {
		if (filterProfesors == null) {
			filterProfesors = new JCheckBox("Profesores");
			filterProfesors.setHorizontalAlignment(SwingConstants.CENTER);
			filterProfesors.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ResearcherTableModel tmodel = (ResearcherTableModel)table.getModel();
					tmodel.includeProfesors(filterProfesors.isSelected());
					tmodel.applyFilters();
				}
			});
			filterProfesors.setBackground(Color.WHITE);
			filterProfesors.setSelected(true);
		}

		return filterProfesors;
	}

	private JLabel getLblFiltrar() {
		if (lblFiltrar == null) {
			lblFiltrar = new JLabel("Filtrar");
			lblFiltrar.setHorizontalAlignment(SwingConstants.CENTER);
			lblFiltrar.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}

		return lblFiltrar;
	}

	private JLabel getLblPuntuacin() {
		if (lblPuntuacin == null) {
			lblPuntuacin = new JLabel("Puntuaci\u00F3n");
			lblPuntuacin.setHorizontalAlignment(SwingConstants.CENTER);
			lblPuntuacin.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}

		return lblPuntuacin;
	}

	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					ResearcherTableModel tmodel = (ResearcherTableModel)table.getModel();
					tmodel.setMinScore((int)spinner.getValue());
					tmodel.applyFilters();
				}
			});
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent event) {
					ResearcherTableModel tmodel = (ResearcherTableModel)table.getModel();
					tmodel.setMinScore((int)spinner.getValue());
					tmodel.applyFilters();
				}
			});
		}

		return spinner;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre");
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombre.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return lblNombre;
	}
	private JTextField getFilterByName() {
		if (filterByName == null) {
			filterByName = new JTextField("");
			filterByName.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent event) {
					if (event.getKeyCode() != 16) {		
						ResearcherTableModel tmodel = (ResearcherTableModel)table.getModel();
						tmodel.setFilterName(filterByName.getText());
						tmodel.applyFilters();
					}
				}
			});
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
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					final int row = table.getSelectedRow();

					
					if (row >= 0) {
						btnEliminar.setVisible(true);
					}
				}
			});
			table.setBackground(Color.WHITE);
		}
		return table;
	}

	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					((ResearcherTableModel)table.getModel()).removeSelectedItem(table.getSelectedRow());
				}
			});
			btnEliminar.setVisible(false);
			btnEliminar.setBackground(Color.WHITE);
		}
		return btnEliminar;
	}
}
