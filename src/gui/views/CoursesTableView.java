package gui.views;

import gui.model.CoursesTableModel;

import javax.swing.JPanel;

import schooling.Faculty;
import utils.Constants;

import java.awt.GridBagLayout;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class CoursesTableView extends JPanel {
	private static final long serialVersionUID = 7564447082179207965L;
	private JLabel lblCursosDePostgrado;
	private JScrollPane scrollPane;
	private JTable table;
	private CoursesTableModel coursesTableModel;
	private JLabel lblFiltrar;
	private JLabel lblNombre;
	private JTextField filterByName;
	private JLabel lblInstructor;
	private JSpinner filterCreds;
	
	private Faculty faculty;

	/**
	 * Create the panel.
	 */
	public CoursesTableView() {
		this.faculty = Faculty.newInstance();
		
		setBackground(Color.WHITE);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 0, 0, 55, 0, 116, 0, 0, 0, 100, 0};
		gridBagLayout.rowHeights = new int[]{70, 34, 60, 35, 90, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblCursosDePostgrado = new GridBagConstraints();
		gbc_lblCursosDePostgrado.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCursosDePostgrado.insets = new Insets(0, 0, 5, 5);
		gbc_lblCursosDePostgrado.gridwidth = 8;
		gbc_lblCursosDePostgrado.gridx = 1;
		gbc_lblCursosDePostgrado.gridy = 1;
		add(getLblCursosDePostgrado(), gbc_lblCursosDePostgrado);
		GridBagConstraints gbc_lblFiltrar = new GridBagConstraints();
		gbc_lblFiltrar.fill = GridBagConstraints.BOTH;
		gbc_lblFiltrar.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltrar.gridx = 1;
		gbc_lblFiltrar.gridy = 3;
		add(getLblFiltrar(), gbc_lblFiltrar);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 4;
		gbc_lblNombre.gridy = 3;
		add(getLblNombre(), gbc_lblNombre);
		GridBagConstraints gbc_filterByName = new GridBagConstraints();
		gbc_filterByName.fill = GridBagConstraints.BOTH;
		gbc_filterByName.anchor = GridBagConstraints.SOUTHWEST;
		gbc_filterByName.insets = new Insets(0, 0, 5, 5);
		gbc_filterByName.gridx = 5;
		gbc_filterByName.gridy = 3;
		add(getFilterByName(), gbc_filterByName);
		GridBagConstraints gbc_lblInstructor = new GridBagConstraints();
		gbc_lblInstructor.anchor = GridBagConstraints.EAST;
		gbc_lblInstructor.fill = GridBagConstraints.VERTICAL;
		gbc_lblInstructor.insets = new Insets(0, 0, 5, 5);
		gbc_lblInstructor.gridx = 7;
		gbc_lblInstructor.gridy = 3;
		add(getLblInstructor(), gbc_lblInstructor);
		GridBagConstraints gbc_filterCreds = new GridBagConstraints();
		gbc_filterCreds.fill = GridBagConstraints.BOTH;
		gbc_filterCreds.insets = new Insets(0, 0, 5, 5);
		gbc_filterCreds.gridx = 8;
		gbc_filterCreds.gridy = 3;
		add(getFilterCreds(), gbc_filterCreds);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 8;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		add(getScrollPane(), gbc_scrollPane);

		coursesTableModel = new CoursesTableModel(this.faculty);
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
			table.setFont(Constants.getLabelFont());
		}
		return table;
	}
	private JLabel getLblFiltrar() {
		if (lblFiltrar == null) {
			lblFiltrar = new JLabel("Filtrar");
			lblFiltrar.setHorizontalAlignment(SwingConstants.LEFT);
			lblFiltrar.setFont(Constants.getLabelFont());
		}
		return lblFiltrar;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre");
			lblNombre.setFont(Constants.getLabelFont());
		}
		return lblNombre;
	}
	private JTextField getFilterByName() {
		if (filterByName == null) {
			filterByName = new JTextField();
			filterByName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			filterByName.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent event) {
					if(event.getKeyCode() != 16) {
						CoursesTableModel ctmodel = (CoursesTableModel)table.getModel();
						ctmodel.setFilterName(filterByName.getText());
					}
				}
			});
			filterByName.setColumns(10);
		}
		return filterByName;
	}
	private JLabel getLblInstructor() {
		if (lblInstructor == null) {
			lblInstructor = new JLabel("Cred. Nec.");
			lblInstructor.setFont(Constants.getLabelFont());
		}
		return lblInstructor;
	}
	
	public void updateTable() {
		((CoursesTableModel)table.getModel()).fill();
	}
	private JSpinner getFilterCreds() {
		if (filterCreds == null) {
			filterCreds = new JSpinner();
			filterCreds.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			filterCreds.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					CoursesTableModel ctmodel = (CoursesTableModel)table.getModel();
					ctmodel.setFilterCreds((int)filterCreds.getValue());
				}
			});
			filterCreds.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			filterCreds.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent event) {
					CoursesTableModel ctmodel = (CoursesTableModel)table.getModel();
					ctmodel.setFilterCreds((int)filterCreds.getValue());
				}
			});
		}
		return filterCreds;
	}
}
