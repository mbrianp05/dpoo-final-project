package gui.views;

import gui.component.TitleLabel;
import gui.model.ResearchLinesTableModel;
import gui.reasearchline.EditResearchLineJDialog;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import schooling.ResearchLine;
import utils.Constants;

import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

	public ResearchLinesTableView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 70, 0, 0, 180, 30, 0, 180, 30, 0, 180, 0, 0, 70, 100, 0};
		gridBagLayout.rowHeights = new int[]{70, 45, 60, 35, 207, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		gbc_lblResponsable.insets = new Insets(0, 0, 5, 5);
		gbc_lblResponsable.anchor = GridBagConstraints.EAST;
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
		gbc_lblTema.anchor = GridBagConstraints.EAST;
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
		GridBagConstraints gbc_lblCrditosDeMaestra = new GridBagConstraints();
		gbc_lblCrditosDeMaestra.anchor = GridBagConstraints.EAST;
		gbc_lblCrditosDeMaestra.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrditosDeMaestra.gridx = 12;
		gbc_lblCrditosDeMaestra.gridy = 3;
		add(getLblCrditosDeMaestra(), gbc_lblCrditosDeMaestra);
		GridBagConstraints gbc_spinnerFilterCredits = new GridBagConstraints();
		gbc_spinnerFilterCredits.insets = new Insets(0, 0, 5, 5);
		gbc_spinnerFilterCredits.fill = GridBagConstraints.BOTH;
		gbc_spinnerFilterCredits.gridx = 13;
		gbc_spinnerFilterCredits.gridy = 3;
		add(getSpinnerFilterCredits(), gbc_spinnerFilterCredits);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 13;
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
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					if (event.getClickCount() > 1 && table.getSelectedRow() >= 0) {
						ResearchLine line = getTableModel().getShownResearchLines().get(table.getSelectedRow());
						
						try {
							EditResearchLineJDialog dialog = new EditResearchLineJDialog(line);
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
		((ResearchLinesTableModel)table.getModel()).fill();
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
				}
			});
			spinnerFilterCredits.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					getTableModel().setFilterCredits((Integer)spinnerFilterCredits.getValue());
				}
			});
			spinnerFilterCredits.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spinnerFilterCredits.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return spinnerFilterCredits;
	}
}