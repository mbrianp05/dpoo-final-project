package gui.views;

import gui.component.TitleLabel;
import gui.event.OnAddedResearchLine;
import gui.event.OnMovedChief;
import gui.model.ResearchLinesTableModel;
import gui.reasearchline.EditResearchLineJDialog;
import gui.reasearchline.MoveResearcherToOtherMatterJDialog;

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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import schooling.Faculty;
import schooling.ResearchLine;
import schooling.ResearchMatter;
import utils.ArrayLib;
import utils.Constants;

public class ResearchLinesTableView extends JPanel {
	private static final long serialVersionUID = 1L;
	private JLabel lblFiltrar;
	private JLabel lblNombre;
	private JTextField filterByName;
	private JScrollPane scrollPane;

	private ResearchLinesTableModel tableModel;
	private JTable table;

	private TitleLabel lblDatosDeInvestigadores;
	private JTextField filterByChief;
	private JLabel lblResponsable;
	private JLabel lblTema;
	private JTextField textField;
	private JLabel lblCrditosDeMaestra;
	private JSpinner spinnerFilterCredits;
	private JButton btnRemove;

	public ResearchLinesTableView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 70, 0, 0, 180, 30, 0, 180, 30, 0, 180, 30, 65, 0, 0, 70, 100, 0};
		gridBagLayout.rowHeights = new int[]{70, 45, 60, 40, 207, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblDatosDeInvestigadores = new GridBagConstraints();
		gbc_lblDatosDeInvestigadores.fill = GridBagConstraints.BOTH;
		gbc_lblDatosDeInvestigadores.gridwidth = 7;
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
		gbc_lblNombre.gridx = 3;
		gbc_lblNombre.gridy = 3;
		add(getLblNombre(), gbc_lblNombre);
		GridBagConstraints gbc_filterByName = new GridBagConstraints();
		gbc_filterByName.fill = GridBagConstraints.BOTH;
		gbc_filterByName.insets = new Insets(0, 0, 5, 5);
		gbc_filterByName.gridx = 4;
		gbc_filterByName.gridy = 3;
		add(getFilterByName(), gbc_filterByName);
		GridBagConstraints gbc_lblResponsable = new GridBagConstraints();
		gbc_lblResponsable.fill = GridBagConstraints.BOTH;
		gbc_lblResponsable.insets = new Insets(0, 0, 5, 5);
		gbc_lblResponsable.gridx = 6;
		gbc_lblResponsable.gridy = 3;
		add(getLblResponsable(), gbc_lblResponsable);
		GridBagConstraints gbc_filterByChief = new GridBagConstraints();
		gbc_filterByChief.insets = new Insets(0, 0, 5, 5);
		gbc_filterByChief.fill = GridBagConstraints.BOTH;
		gbc_filterByChief.gridx = 7;
		gbc_filterByChief.gridy = 3;
		add(getFilterByChief(), gbc_filterByChief);
		GridBagConstraints gbc_lblTema = new GridBagConstraints();
		gbc_lblTema.fill = GridBagConstraints.BOTH;
		gbc_lblTema.insets = new Insets(0, 0, 5, 5);
		gbc_lblTema.gridx = 9;
		gbc_lblTema.gridy = 3;
		add(getLblTema(), gbc_lblTema);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 10;
		gbc_textField.gridy = 3;
		add(getTextField(), gbc_textField);
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.fill = GridBagConstraints.VERTICAL;
		gbc_btnRemove.insets = new Insets(0, 0, 5, 5);
		gbc_btnRemove.gridx = 12;
		gbc_btnRemove.gridy = 3;
		add(getBtnRemove(), gbc_btnRemove);
		GridBagConstraints gbc_lblCrditosDeMaestra = new GridBagConstraints();
		gbc_lblCrditosDeMaestra.fill = GridBagConstraints.BOTH;
		gbc_lblCrditosDeMaestra.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrditosDeMaestra.gridx = 14;
		gbc_lblCrditosDeMaestra.gridy = 3;
		add(getLblCrditosDeMaestra(), gbc_lblCrditosDeMaestra);
		GridBagConstraints gbc_spinnerFilterCredits = new GridBagConstraints();
		gbc_spinnerFilterCredits.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerFilterCredits.fill = GridBagConstraints.BOTH;
		gbc_spinnerFilterCredits.gridx = 15;
		gbc_spinnerFilterCredits.gridy = 3;
		add(getSpinnerFilterCredits(), gbc_spinnerFilterCredits);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 15;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		add(getScrollPane(), gbc_scrollPane);

		tableModel = new ResearchLinesTableModel();
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
			filterByName.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					getTableModel().setFilterName(filterByName.getText());
					btnRemove.setVisible(false);
				}
			});
			filterByName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			filterByName.setColumns(10);
		}
		return filterByName;
	}

	private ResearchLinesTableModel getTableModel() {
		return (ResearchLinesTableModel)table.getModel();
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
			table.getTableHeader().setReorderingAllowed(false);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					if (table.getSelectedRow() >= 0) btnRemove.setVisible(true);

					if (event.getClickCount() > 1 && table.getSelectedRow() >= 0) {
						ResearchLine line = getTableModel().getShownResearchLines().get(table.getSelectedRow());

						try {
							EditResearchLineJDialog dialog = new EditResearchLineJDialog(line);
							dialog.listenTo(new OnAddedResearchLine() {
								@Override
								public void added(String name) {
									updateTable();
								}
							});
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			});
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
			lblDatosDeInvestigadores.setText("Datos de l\u00EDneas de investigaci\u00F3n");
			lblDatosDeInvestigadores.setFont(Constants.getTitleFont());
		}
		return lblDatosDeInvestigadores;
	}
	private JTextField getFilterByChief() {
		if (filterByChief == null) {
			filterByChief = new JTextField("");
			filterByChief.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					getTableModel().setChiefFilter(filterByChief.getText());
					btnRemove.setVisible(false);
				}
			});
			filterByChief.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			filterByChief.setColumns(10);
		}
		return filterByChief;
	}
	private JLabel getLblResponsable() {
		if (lblResponsable == null) {
			lblResponsable = new JLabel("Responsable");
			lblResponsable.setHorizontalAlignment(SwingConstants.RIGHT);
			lblResponsable.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return lblResponsable;
	}
	private JLabel getLblTema() {
		if (lblTema == null) {
			lblTema = new JLabel("Tema");
			lblTema.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTema.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return lblTema;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField("");
			textField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					getTableModel().setFilterMatter(textField.getText());;
					btnRemove.setVisible(false);
				}
			});
			textField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblCrditosDeMaestra() {
		if (lblCrditosDeMaestra == null) {
			lblCrditosDeMaestra = new JLabel("Cr\u00E9ditos de maestr\u00EDa");
			lblCrditosDeMaestra.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCrditosDeMaestra.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return lblCrditosDeMaestra;
	}
	private JSpinner getSpinnerFilterCredits() {
		if (spinnerFilterCredits == null) {
			spinnerFilterCredits = new JSpinner();
			spinnerFilterCredits.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					getTableModel().setFilterCredits((Integer)spinnerFilterCredits.getValue());
					btnRemove.setVisible(false);
				}
			});
			spinnerFilterCredits.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					getTableModel().setFilterCredits((Integer)spinnerFilterCredits.getValue());
					btnRemove.setVisible(false);
				}
			});
			spinnerFilterCredits.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinnerFilterCredits.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return spinnerFilterCredits;
	}

	private void openChiefDialog() {
		ArrayList<String> matters = Faculty.newInstance().getResearchMattersNames();
		final ResearchLine line = getTableModel().getShownResearchLines().get(table.getSelectedRow());

		for (ResearchMatter m: line.getMatters()) {
			if (matters.contains(m.getName())) matters.remove(m.getName());
		}

		try {
			MoveResearcherToOtherMatterJDialog dialog = new MoveResearcherToOtherMatterJDialog(
				line.getChief(), 
				ArrayLib.cast(matters), 
				new OnMovedChief() {
					@Override
					public void moved(String newMatter) {
						Faculty f = Faculty.newInstance();
						
						f.moveToOtherMatter(line.getChief().getID(), newMatter);
						f.getResearchLines().remove(line);
						
						updateTable();
						
						JOptionPane.showMessageDialog(null, "Línea eliminada correctamente");
					}
				}
			);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("");

			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int input = JOptionPane.showConfirmDialog(null, "Confirma tu desición de eliminar la línea");

					if (input == JOptionPane.OK_OPTION) {
						Faculty faculty = Faculty.newInstance();
						String researchLineName = (String)table.getValueAt(table.getSelectedRow(), 0);
						ResearchLine line = faculty.findResearchLine(researchLineName);

						if (line.getResearchersInvolvedCount() == 1) {
							openChiefDialog();
						} else {
							JOptionPane.showMessageDialog(null, "Existen investigadores en esta línea. Asegúrate de moverlos a otra línea e intentálo después", "No se puede eliminar la línea", JOptionPane.ERROR_MESSAGE);
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