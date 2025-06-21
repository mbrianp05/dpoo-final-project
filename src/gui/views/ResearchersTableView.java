package gui.views;

import gui.component.TitleLabel;
import gui.event.OnAddedResearcher;
import gui.event.OnResearchActivityActionTriggered;
import gui.model.ResearcherTableModel;
import gui.researchers.EditResearcherJDialog;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import schooling.Faculty;
import schooling.Researcher;
import utils.Constants;

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
	private TitleLabel lblDatosDeInvestigadores;

	private EditResearcherJDialog current;
	private JLabel lblTema;
	private JTextField textFieldMatterFilter;
	private JButton btnRemove;

	private OnAddedResearcher listener;
	private JLabel label;

	public ResearchersTableView() {
		faculty = Faculty.newInstance();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 70, 100, 100, 0, 0, 180, 30, 0, 180, 30, 60, 0, 70, 70, 100, 0 };
		gridBagLayout.rowHeights = new int[] { 70, 45, 0, 60, 40, 207, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblDatosDeInvestigadores = new GridBagConstraints();
		gbc_lblDatosDeInvestigadores.fill = GridBagConstraints.BOTH;
		gbc_lblDatosDeInvestigadores.gridwidth = 14;
		gbc_lblDatosDeInvestigadores.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatosDeInvestigadores.gridx = 1;
		gbc_lblDatosDeInvestigadores.gridy = 1;
		add(getLblDatosDeInvestigadores(), gbc_lblDatosDeInvestigadores);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.gridwidth = 6;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 2;
		add(getLabel(), gbc_label);
		GridBagConstraints gbc_lblFiltrar = new GridBagConstraints();
		gbc_lblFiltrar.fill = GridBagConstraints.BOTH;
		gbc_lblFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltrar.gridx = 1;
		gbc_lblFiltrar.gridy = 4;
		add(getLblFiltrar(), gbc_lblFiltrar);
		GridBagConstraints gbc_filterProfesors = new GridBagConstraints();
		gbc_filterProfesors.fill = GridBagConstraints.BOTH;
		gbc_filterProfesors.insets = new Insets(0, 0, 5, 5);
		gbc_filterProfesors.gridx = 2;
		gbc_filterProfesors.gridy = 4;
		add(getFilterProfesors(), gbc_filterProfesors);
		GridBagConstraints gbc_filterStudents = new GridBagConstraints();
		gbc_filterStudents.fill = GridBagConstraints.BOTH;
		gbc_filterStudents.insets = new Insets(0, 0, 5, 5);
		gbc_filterStudents.gridx = 3;
		gbc_filterStudents.gridy = 4;
		add(getFilterStudents(), gbc_filterStudents);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 5;
		gbc_lblNombre.gridy = 4;
		add(getLblNombre(), gbc_lblNombre);
		GridBagConstraints gbc_filterByName = new GridBagConstraints();
		gbc_filterByName.fill = GridBagConstraints.BOTH;
		gbc_filterByName.insets = new Insets(0, 0, 5, 5);
		gbc_filterByName.gridx = 6;
		gbc_filterByName.gridy = 4;
		add(getFilterByName(), gbc_filterByName);
		GridBagConstraints gbc_lblTema = new GridBagConstraints();
		gbc_lblTema.anchor = GridBagConstraints.EAST;
		gbc_lblTema.insets = new Insets(0, 0, 5, 5);
		gbc_lblTema.gridx = 8;
		gbc_lblTema.gridy = 4;
		add(getLblTema(), gbc_lblTema);
		GridBagConstraints gbc_textFieldMatterFilter = new GridBagConstraints();
		gbc_textFieldMatterFilter.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldMatterFilter.fill = GridBagConstraints.BOTH;
		gbc_textFieldMatterFilter.gridx = 9;
		gbc_textFieldMatterFilter.gridy = 4;
		add(getTextFieldMatterFilter(), gbc_textFieldMatterFilter);
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.fill = GridBagConstraints.VERTICAL;
		gbc_btnRemove.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemove.gridx = 11;
		gbc_btnRemove.gridy = 4;
		add(getBtnRemove(), gbc_btnRemove);
		GridBagConstraints gbc_lblPuntuacin = new GridBagConstraints();
		gbc_lblPuntuacin.fill = GridBagConstraints.BOTH;
		gbc_lblPuntuacin.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntuacin.gridx = 13;
		gbc_lblPuntuacin.gridy = 4;
		add(getLblPuntuacin(), gbc_lblPuntuacin);
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.BOTH;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 14;
		gbc_spinner.gridy = 4;
		add(getSpinner(), gbc_spinner);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(5, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 14;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
		add(getScrollPane(), gbc_scrollPane);

		researcherModel = new ResearcherTableModel();
		table.setModel(researcherModel);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
	}

	public void listenTo(OnAddedResearcher listener) {
		this.listener = listener;
	}

	private void sendFeedback() {
		JOptionPane.showMessageDialog(null, "ï¿½Se ha actualizado el investigador correctamente!", "Mensaje",
				JOptionPane.PLAIN_MESSAGE);
	}

	private JCheckBox getFilterStudents() {
		if (filterStudents == null) {
			filterStudents = new JCheckBox("Estudiantes");
			filterStudents.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			filterStudents.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ResearcherTableModel tmodel = (ResearcherTableModel) table.getModel();
					tmodel.includeStudents(filterStudents.isSelected());
				}
			});
			filterStudents.setSelected(true);
		}

		return filterStudents;
	}

	private JCheckBox getFilterProfesors() {
		if (filterProfesors == null) {
			filterProfesors = new JCheckBox("Profesores");
			filterProfesors.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			filterProfesors.setHorizontalAlignment(SwingConstants.CENTER);
			filterProfesors.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ResearcherTableModel tmodel = (ResearcherTableModel) table.getModel();
					tmodel.includeProfesors(filterProfesors.isSelected());
				}
			});
			filterProfesors.setSelected(true);
		}

		return filterProfesors;
	}

	private JLabel getLblFiltrar() {
		if (lblFiltrar == null) {
			lblFiltrar = new JLabel("Filtrar");
			lblFiltrar.setHorizontalAlignment(SwingConstants.LEFT);
			lblFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}

		return lblFiltrar;
	}

	private JLabel getLblPuntuacin() {
		if (lblPuntuacin == null) {
			lblPuntuacin = new JLabel("Puntuaci\u00F3n");
			lblPuntuacin.setHorizontalAlignment(SwingConstants.CENTER);
			lblPuntuacin.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}

		return lblPuntuacin;
	}

	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			spinner.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinner.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					ResearcherTableModel tmodel = (ResearcherTableModel) table.getModel();
					tmodel.setMinScore((int) spinner.getValue());
				}
			});
			spinner.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent event) {
					ResearcherTableModel tmodel = (ResearcherTableModel) table.getModel();
					tmodel.setMinScore((int) spinner.getValue());
					btnRemove.setVisible(false);
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
			filterByName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			filterByName.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent event) {
					if (event.getKeyCode() != 16) {
						ResearcherTableModel tmodel = (ResearcherTableModel) table.getModel();
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
			table.setRowHeight(27);
			table.getTableHeader().setReorderingAllowed(false);
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					btnRemove.setVisible(table.getSelectedRow() != -1);
				}
			});
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					if (event.getClickCount() > 1 && table.getSelectedRow() >= 0) {
						int row = table.getSelectedRow();
						int ID = Integer.valueOf((String) table.getModel().getValueAt(row, 0));
						Researcher researcher = faculty.findResearcher(ID);

						if (current == null || !current.isVisible()) {
							try {
								current = new EditResearcherJDialog(researcher);
								current.listenTo(new OnAddedResearcher() {
									@Override
									public void newResearcher(int researcherID) {
										updateTable();
										listener.newResearcher(researcherID);

										sendFeedback();
									}
								});
								current.listenTo(new OnResearchActivityActionTriggered() {
									@Override
									public void actionPerformed() {
										updateTable();
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
		}
		return table;
	}

	public void updateTable() {
		((ResearcherTableModel) table.getModel()).fill();
		btnRemove.setVisible(false);
	}

	private TitleLabel getLblDatosDeInvestigadores() {
		if (lblDatosDeInvestigadores == null) {
			lblDatosDeInvestigadores = new TitleLabel();
			lblDatosDeInvestigadores.setText("Datos de investigadores registrados");
			lblDatosDeInvestigadores.setFont(Constants.getTitleFont());
		}
		return lblDatosDeInvestigadores;
	}

	private JLabel getLblTema() {
		if (lblTema == null) {
			lblTema = new JLabel("Tema");
			lblTema.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTema.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return lblTema;
	}

	private JTextField getTextFieldMatterFilter() {
		if (textFieldMatterFilter == null) {
			textFieldMatterFilter = new JTextField("");
			textFieldMatterFilter.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent event) {
					if (event.getKeyCode() != 16) {
						ResearcherTableModel tmodel = (ResearcherTableModel) table.getModel();
						tmodel.setFilterMatter(textFieldMatterFilter.getText());
					}
				}
			});
			textFieldMatterFilter.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textFieldMatterFilter.setColumns(10);
		}
		return textFieldMatterFilter;
	}

	private void removeResearcher() {
		int id = Integer.valueOf((String) table.getModel().getValueAt(table.getSelectedRow(), 0));

		if (faculty.canRemoveResearcher(id)) {
			faculty.removeResearcher(id);

			JOptionPane.showMessageDialog(null,
					"El investigador que desea eliminar imparte cursos o es jefe de alguna línea. Busca el sutituto e inténtelo después",
					"Error al eliminar el investigador", JOptionPane.ERROR_MESSAGE);
		} else {
			int input = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar al investigador?");

			if (input == JOptionPane.OK_OPTION) {
				updateTable();
			}
		}
	}

	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton();

			ImageIcon icon = new ImageIcon(ResearchersTableView.class.getResource("/resources/images/trash.png"));
			icon = new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));

			btnRemove.setIcon(icon);
			btnRemove.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					removeResearcher();
				}
			});
			btnRemove.setVisible(false);
		}
		return btnRemove;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Haga doble click en alguna fila para editar");
			label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		}
		return label;
	}
}
