package gui.views;

import gui.component.TitleLabel;
import gui.event.OnAddedCourse;
import gui.event.OnRemovedCourse;
import gui.model.CoursesTableModel;
import gui.reasearchline.EditPostgradeCourse;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
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
import schooling.PostgraduateCourse;
import schooling.Profesor;
import utils.Constants;

public class CoursesTableView extends JPanel {
	private static final long serialVersionUID = 7564447082179207965L;
	private TitleLabel lblCursosDePostgrado;
	private JScrollPane scrollPane;
	private JTable table;
	private CoursesTableModel coursesTableModel;
	private JLabel lblFiltrar;
	private JLabel lblNombre;
	private JTextField filterByName;
	private JLabel lblInstructor;
	private JSpinner filterCreds;

	private EditPostgradeCourse select;

	private Faculty faculty;
	private JLabel lblLblinstruct;
	private JTextField filterByInstruct;

	/**
	 * Create the panel.
	 */
	public CoursesTableView() {
		this.faculty = Faculty.newInstance();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{100, 0, 30, 0, 0, 30, 0, 0, 30, 0, 0, 100, 0};
		gridBagLayout.rowHeights = new int[]{70, 45, 60, 35, 90, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblCursosDePostgrado = new GridBagConstraints();
		gbc_lblCursosDePostgrado.fill = GridBagConstraints.BOTH;
		gbc_lblCursosDePostgrado.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCursosDePostgrado.insets = new Insets(0, 0, 5, 5);
		gbc_lblCursosDePostgrado.gridwidth = 10;
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
		gbc_lblNombre.gridx = 3;
		gbc_lblNombre.gridy = 3;
		add(getLblNombre(), gbc_lblNombre);
		GridBagConstraints gbc_filterByName = new GridBagConstraints();
		gbc_filterByName.fill = GridBagConstraints.BOTH;
		gbc_filterByName.insets = new Insets(0, 0, 5, 5);
		gbc_filterByName.gridx = 4;
		gbc_filterByName.gridy = 3;
		add(getFilterByName(), gbc_filterByName);
		GridBagConstraints gbc_lblLblinstruct = new GridBagConstraints();
		gbc_lblLblinstruct.fill = GridBagConstraints.BOTH;
		gbc_lblLblinstruct.anchor = GridBagConstraints.EAST;
		gbc_lblLblinstruct.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblinstruct.gridx = 6;
		gbc_lblLblinstruct.gridy = 3;
		add(getLblLblinstruct(), gbc_lblLblinstruct);
		GridBagConstraints gbc_filterByInstruct = new GridBagConstraints();
		gbc_filterByInstruct.insets = new Insets(0, 0, 5, 5);
		gbc_filterByInstruct.fill = GridBagConstraints.BOTH;
		gbc_filterByInstruct.gridx = 7;
		gbc_filterByInstruct.gridy = 3;
		add(getFilterByInstruct(), gbc_filterByInstruct);
		GridBagConstraints gbc_lblInstructor = new GridBagConstraints();
		gbc_lblInstructor.anchor = GridBagConstraints.EAST;
		gbc_lblInstructor.fill = GridBagConstraints.VERTICAL;
		gbc_lblInstructor.insets = new Insets(0, 0, 5, 5);
		gbc_lblInstructor.gridx = 9;
		gbc_lblInstructor.gridy = 3;
		add(getLblInstructor(), gbc_lblInstructor);
		GridBagConstraints gbc_filterCreds = new GridBagConstraints();
		gbc_filterCreds.fill = GridBagConstraints.BOTH;
		gbc_filterCreds.insets = new Insets(0, 0, 5, 5);
		gbc_filterCreds.gridx = 10;
		gbc_filterCreds.gridy = 3;
		add(getFilterCreds(), gbc_filterCreds);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 10;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		add(getScrollPane(), gbc_scrollPane);

		coursesTableModel = new CoursesTableModel(this.faculty);
		table.setModel(coursesTableModel);

	}

	private TitleLabel getLblCursosDePostgrado() {
		if (lblCursosDePostgrado == null) {
			lblCursosDePostgrado = new TitleLabel();
			lblCursosDePostgrado.setText("Cursos de postgrado registrados");
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
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					if (event.getClickCount() > 1 && table.getSelectedRow() >= 0) {
						int row = table.getSelectedRow();
						String courseName = String.valueOf((String)table.getModel().getValueAt(row, 0));
						PostgraduateCourse course = faculty.findCourseByName(courseName);
						
						if(select == null || !select.isVisible()) {
							try {
								select = new EditPostgradeCourse(course);
								select.setVisible(true);
								select.listenTo(new OnAddedCourse() {								
									@Override
									public void added(String name, Profesor instruct) {
										updateTable();
									}
								});
								select.listenTo(new OnRemovedCourse() {
									@Override
									public void removed(String name) {
										
									}
								});
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}

				}
			});
			table.setFont(Constants.getLabelFont());
			table.setRowHeight(24);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setFillsViewportHeight(true);
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
			lblInstructor = new JLabel("Cr\u00E9ditos");
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
	private JLabel getLblLblinstruct() {
		if (lblLblinstruct == null) {
			lblLblinstruct = new JLabel("Instructor");
			lblLblinstruct.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return lblLblinstruct;
	}
	private JTextField getFilterByInstruct() {
		if (filterByInstruct == null) {
			filterByInstruct = new JTextField();
			filterByInstruct.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent event) {
					CoursesTableModel ctModel = (CoursesTableModel)table.getModel();
					ctModel.setFilterByInstruc(filterByInstruct.getText());
				}
			});
			filterByInstruct.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			filterByInstruct.setColumns(10);
		}
		return filterByInstruct;
	}
}
