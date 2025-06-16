package gui.views;

import gui.component.TitleLabel;
import gui.event.OnResearchActivityActionTriggered;
import gui.model.ResearchersActivityTableModel;
import gui.researchers.activity.EditBreakthroughJDialog;

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

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import schooling.Breakthrough;
import schooling.Faculty;
import schooling.Researcher;
import utils.Constants;

public class ResearchersActivityTableView extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblFiltrar;
	private JScrollPane scrollPane;

	private Faculty faculty;
	
	private ResearchersActivityTableModel researcherModel;
	private JTable table;

	private TitleLabel lblDatosDeInvestigadores;
	private JLabel lblNombre;
	private JTextField textField;
	private JLabel lblInvestigador;
	private JTextField textField_1;
	private JLabel lblPuntuacin;
	private JComboBox<Integer> comboBox;
	private JCheckBox filterChapter;
	private JCheckBox filterPaper;
	private JCheckBox filterPresentation;
	private JButton btnRemove;
	
	public ResearchersActivityTableView() {
		this.faculty = Faculty.newInstance();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 70, 0, 0, 0, 30, 0, 100, 30, 0, 100, 30, 60, 0, 0, 70, 100, 0};
		gridBagLayout.rowHeights = new int[]{70, 45, 60, 40, 207, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblDatosDeInvestigadores = new GridBagConstraints();
		gbc_lblDatosDeInvestigadores.fill = GridBagConstraints.BOTH;
		gbc_lblDatosDeInvestigadores.gridwidth = 15;
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
		GridBagConstraints gbc_filterChapter = new GridBagConstraints();
		gbc_filterChapter.fill = GridBagConstraints.BOTH;
		gbc_filterChapter.insets = new Insets(0, 0, 5, 5);
		gbc_filterChapter.gridx = 2;
		gbc_filterChapter.gridy = 3;
		add(getFilterChapter(), gbc_filterChapter);
		GridBagConstraints gbc_filterPaper = new GridBagConstraints();
		gbc_filterPaper.fill = GridBagConstraints.BOTH;
		gbc_filterPaper.insets = new Insets(0, 0, 5, 5);
		gbc_filterPaper.gridx = 3;
		gbc_filterPaper.gridy = 3;
		add(getFilterPaper(), gbc_filterPaper);
		GridBagConstraints gbc_filterPresentation = new GridBagConstraints();
		gbc_filterPresentation.fill = GridBagConstraints.BOTH;
		gbc_filterPresentation.insets = new Insets(0, 0, 5, 5);
		gbc_filterPresentation.gridx = 4;
		gbc_filterPresentation.gridy = 3;
		add(getFilterPresentation(), gbc_filterPresentation);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 6;
		gbc_lblNombre.gridy = 3;
		add(getLblNombre(), gbc_lblNombre);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 7;
		gbc_textField.gridy = 3;
		add(getTextField(), gbc_textField);
		GridBagConstraints gbc_lblInvestigador = new GridBagConstraints();
		gbc_lblInvestigador.anchor = GridBagConstraints.EAST;
		gbc_lblInvestigador.fill = GridBagConstraints.VERTICAL;
		gbc_lblInvestigador.insets = new Insets(0, 0, 5, 5);
		gbc_lblInvestigador.gridx = 9;
		gbc_lblInvestigador.gridy = 3;
		add(getLblInvestigador(), gbc_lblInvestigador);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 10;
		gbc_textField_1.gridy = 3;
		add(getTextField_1(), gbc_textField_1);
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.fill = GridBagConstraints.BOTH;
		gbc_btnRemove.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemove.gridx = 12;
		gbc_btnRemove.gridy = 3;
		add(getBtnRemove(), gbc_btnRemove);
		GridBagConstraints gbc_lblPuntuacin = new GridBagConstraints();
		gbc_lblPuntuacin.anchor = GridBagConstraints.EAST;
		gbc_lblPuntuacin.fill = GridBagConstraints.VERTICAL;
		gbc_lblPuntuacin.insets = new Insets(0, 0, 5, 5);
		gbc_lblPuntuacin.gridx = 14;
		gbc_lblPuntuacin.gridy = 3;
		add(getLblPuntuacin(), gbc_lblPuntuacin);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 15;
		gbc_comboBox.gridy = 3;
		add(getComboBox(), gbc_comboBox);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 15;
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
	
	private ResearchersActivityTableModel getTableModel() {
		return (ResearchersActivityTableModel)table.getModel();
	}
	
	private void openEditBreakthroughDialog() {
		try {
			int selectedIndex = table.getSelectedRow();
			Breakthrough selectedBreakthrough = getTableModel().getData().get(selectedIndex);
			Researcher researcher = faculty.findResearcherByBreakthrough(selectedBreakthrough);
			
			EditBreakthroughJDialog dialog = new EditBreakthroughJDialog(researcher, selectedBreakthrough);
			dialog.listenTo(new OnResearchActivityActionTriggered() {
				@Override
				public void actionPerformed() {
					updateTable();
				}
			});
			
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					btnRemove.setVisible(table.getSelectedRow() != -1);
				}
			});
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					if (event.getClickCount() > 1) {
						openEditBreakthroughDialog();
					}
				}
			});
			table.getTableHeader().setReorderingAllowed(false);
			table.setFont(Constants.getLabelFont());
			table.setRowHeight(24);
			table.setFillsViewportHeight(true);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		
		return table;
	}

	public void updateTable() {
		getTableModel().fill();
		btnRemove.setVisible(false);
	}
	
	private TitleLabel getLblDatosDeInvestigadores() {
		if (lblDatosDeInvestigadores == null) {
			lblDatosDeInvestigadores = new TitleLabel();
			lblDatosDeInvestigadores.setText("Datos de la actividad investigativa");
			lblDatosDeInvestigadores.setFont(Constants.getTitleFont());
		}
		
		return lblDatosDeInvestigadores;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre");
			lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
			lblNombre.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblNombre;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					getTableModel().setFilterName(textField.getText());
				}
			});
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblInvestigador() {
		if (lblInvestigador == null) {
			lblInvestigador = new JLabel("Investigador");
			lblInvestigador.setHorizontalAlignment(SwingConstants.LEFT);
			lblInvestigador.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblInvestigador;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					getTableModel().setFilterResearcher(textField_1.getText());
				}
			});
			textField_1.setColumns(10);
		}
		return textField_1;
	}
	private JLabel getLblPuntuacin() {
		if (lblPuntuacin == null) {
			lblPuntuacin = new JLabel("Puntuaci\u00F3n");
			lblPuntuacin.setHorizontalAlignment(SwingConstants.LEFT);
			lblPuntuacin.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblPuntuacin;
	}
	private JComboBox<Integer> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<>();
			comboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (comboBox.getSelectedItem() == null) {
						getTableModel().setFilterScore(0);
					} else {
						getTableModel().setFilterScore((Integer)comboBox.getSelectedItem());
					}
				}
			});
			comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			comboBox.setModel(new DefaultComboBoxModel<>(new Integer[] {null, 1, 3, 4, 6, 8, 10}));
		}
		return comboBox;
	}
	private JCheckBox getFilterChapter() {
		if (filterChapter == null) {
			filterChapter = new JCheckBox("Cap\u00EDtulos");
			filterChapter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getTableModel().includeChapters(filterChapter.isSelected());
				}
			});
			filterChapter.setSelected(true);
			filterChapter.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return filterChapter;
	}
	private JCheckBox getFilterPaper() {
		if (filterPaper == null) {
			filterPaper = new JCheckBox("Art\u00EDculos");
			filterPaper.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getTableModel().includePapers(filterPaper.isSelected());
				}
			});
			filterPaper.setSelected(true);
			filterPaper.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return filterPaper;
	}
	private JCheckBox getFilterPresentation() {
		if (filterPresentation == null) {
			filterPresentation = new JCheckBox("Ponencias");
			filterPresentation.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					getTableModel().includePresentations(filterPresentation.isSelected());
				}
			});
			filterPresentation.setSelected(true);
			filterPresentation.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return filterPresentation;
	}
	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int input = JOptionPane.showConfirmDialog(null, "Confirme que desea eliminar el aporte investigativo seleccionado");
				
					if (input == JOptionPane.OK_OPTION) {
						Breakthrough breakthrough = getTableModel().getShownBreakthroughs().get(table.getSelectedRow());
						try {
							Researcher researcher = faculty.findResearcherByBreakthrough(breakthrough);
							researcher.removeBreakthrough(breakthrough);
							
							updateTable();
							JOptionPane.showMessageDialog(null, "¡Actividad investigativa eliminada con éxito!");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});
			
			ImageIcon icon = new ImageIcon(ResearchersTableView.class.getResource("/resources/images/trash.png"));
			icon = new ImageIcon(icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
			
			btnRemove.setIcon(icon);
			btnRemove.setVisible(false);
		}
		return btnRemove;
	}
}
