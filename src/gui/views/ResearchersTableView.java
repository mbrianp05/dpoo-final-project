package gui.views;

import gui.event.OnAddedResearcher;
import gui.event.OnRemovedResearcher;
import gui.model.ResearcherTableModel;
import gui.researchers.EditResearcherJDialog;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JScrollPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ListSelectionModel;

import schooling.Faculty;
import schooling.Researcher;
import utils.Constants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private JLabel lblDatosDeInvestigadores;
	
	private EditResearcherJDialog current;

	public ResearchersTableView(Faculty faculty) {
		this.faculty = faculty;

		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 70, 100, 100, 30, 100, 0, 0, 70, 70, 100, 0};
		gridBagLayout.rowHeights = new int[]{70, 0, 50, 50, 207, 0, 0};
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
		GridBagConstraints gbc_filterProfesors = new GridBagConstraints();
		gbc_filterProfesors.fill = GridBagConstraints.BOTH;
		gbc_filterProfesors.insets = new Insets(0, 0, 5, 5);
		gbc_filterProfesors.gridx = 2;
		gbc_filterProfesors.gridy = 3;
		add(getFilterProfesors(), gbc_filterProfesors);
		GridBagConstraints gbc_filterStudents = new GridBagConstraints();
		gbc_filterStudents.fill = GridBagConstraints.BOTH;
		gbc_filterStudents.insets = new Insets(0, 0, 5, 5);
		gbc_filterStudents.gridx = 3;
		gbc_filterStudents.gridy = 3;
		add(getFilterStudents(), gbc_filterStudents);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 4;
		gbc_lblNombre.gridy = 3;
		add(getLblNombre(), gbc_lblNombre);
		GridBagConstraints gbc_filterByName = new GridBagConstraints();
		gbc_filterByName.fill = GridBagConstraints.HORIZONTAL;
		gbc_filterByName.insets = new Insets(0, 0, 5, 5);
		gbc_filterByName.gridx = 5;
		gbc_filterByName.gridy = 3;
		add(getFilterByName(), gbc_filterByName);
		GridBagConstraints gbc_lblPuntuacin = new GridBagConstraints();
		gbc_lblPuntuacin.fill = GridBagConstraints.BOTH;
		gbc_lblPuntuacin.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntuacin.gridx = 8;
		gbc_lblPuntuacin.gridy = 3;
		add(getLblPuntuacin(), gbc_lblPuntuacin);
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 9;
		gbc_spinner.gridy = 3;
		add(getSpinner(), gbc_spinner);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 9;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		add(getScrollPane(), gbc_scrollPane);

		researcherModel = new ResearcherTableModel(faculty);
		table.setModel(researcherModel);
	}

	private JCheckBox getFilterStudents() {
		if (filterStudents == null) {
			filterStudents = new JCheckBox("Estudiantes");
			filterStudents.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ResearcherTableModel tmodel = (ResearcherTableModel)table.getModel();
					tmodel.includeStudents(filterStudents.isSelected());
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
			lblFiltrar.setHorizontalAlignment(SwingConstants.LEFT);
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
				}
			});
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent event) {
					ResearcherTableModel tmodel = (ResearcherTableModel)table.getModel();
					tmodel.setMinScore((int)spinner.getValue());
				}
			});
		}

		return spinner;
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
			filterByName.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent event) {
					if (event.getKeyCode() != 16) {		
						ResearcherTableModel tmodel = (ResearcherTableModel)table.getModel();
						tmodel.setFilterName(filterByName.getText());
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
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					if (event.getClickCount() > 1 && table.getSelectedRow() >= 0) {
						int row = table.getSelectedRow();
						int ID = Integer.valueOf((String)table.getModel().getValueAt(row, 0));
						Researcher researcher = faculty.findResearcher(ID);
						
						if (current == null || !current.isVisible()) {
							try {
								current = new EditResearcherJDialog(faculty, researcher);
								current.listenTo(new OnAddedResearcher() {
									@Override
									public void added(int researcherID) {
										((ResearcherTableModel)table.getModel()).fill();
									}
								});
								current.listenTo(new OnRemovedResearcher() {
									@Override
									public void removed(int ID) {
										((ResearcherTableModel)table.getModel()).fill();
									}
								});
								current.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								current.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			});

			table.setFillsViewportHeight(true);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			table.setBackground(Color.WHITE);
		}
		return table;
	}

	public void updateTable() {
		((ResearcherTableModel)table.getModel()).fill();
	}
	private JLabel getLblDatosDeInvestigadores() {
		if (lblDatosDeInvestigadores == null) {
			lblDatosDeInvestigadores = new JLabel("Datos de investigadores registrados");
			lblDatosDeInvestigadores.setFont(Constants.getTitleFont());
		}
		return lblDatosDeInvestigadores;
	}
}
