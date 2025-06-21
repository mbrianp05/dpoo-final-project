package gui.views;

import gui.component.TitleLabel;
import gui.course.EditPostgradeCourseJDialog;
import gui.event.OnAddedCourse;
import gui.model.CoursesTableModel;

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
import schooling.PostgraduateCourse;
import schooling.Profesor;
import utils.Constants;

import javax.swing.JButton;

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

	private EditPostgradeCourseJDialog select;

	private Faculty faculty;
	private JLabel lblLblinstruct;
	private JTextField filterByInstruct;
	private JButton btnRemove;
	private JLabel lblHagaDobleClick;

	/**
	 * Create the panel.
	 */
	public CoursesTableView() {
		this.faculty = Faculty.newInstance();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 100, 0, 30, 0, 150, 30, 0, 150, 30, 62, 0, 0, 70, 100, 0 };
		gridBagLayout.rowHeights = new int[] { 70, 45, 0, 60, 40, 90, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lblCursosDePostgrado = new GridBagConstraints();
		gbc_lblCursosDePostgrado.fill = GridBagConstraints.BOTH;
		gbc_lblCursosDePostgrado.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCursosDePostgrado.insets = new Insets(0, 0, 5, 5);
		gbc_lblCursosDePostgrado.gridwidth = 12;
		gbc_lblCursosDePostgrado.gridx = 1;
		gbc_lblCursosDePostgrado.gridy = 1;
		add(getLblCursosDePostgrado(), gbc_lblCursosDePostgrado);
		GridBagConstraints gbc_lblHagaDobleClick = new GridBagConstraints();
		gbc_lblHagaDobleClick.fill = GridBagConstraints.BOTH;
		gbc_lblHagaDobleClick.gridwidth = 4;
		gbc_lblHagaDobleClick.insets = new Insets(0, 0, 5, 5);
		gbc_lblHagaDobleClick.gridx = 1;
		gbc_lblHagaDobleClick.gridy = 2;
		add(getLblHagaDobleClick(), gbc_lblHagaDobleClick);
		GridBagConstraints gbc_lblFiltrar = new GridBagConstraints();
		gbc_lblFiltrar.fill = GridBagConstraints.BOTH;
		gbc_lblFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_lblFiltrar.gridx = 1;
		gbc_lblFiltrar.gridy = 4;
		add(getLblFiltrar(), gbc_lblFiltrar);
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.fill = GridBagConstraints.BOTH;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 3;
		gbc_lblNombre.gridy = 4;
		add(getLblNombre(), gbc_lblNombre);
		GridBagConstraints gbc_filterByName = new GridBagConstraints();
		gbc_filterByName.fill = GridBagConstraints.BOTH;
		gbc_filterByName.insets = new Insets(0, 0, 5, 5);
		gbc_filterByName.gridx = 4;
		gbc_filterByName.gridy = 4;
		add(getFilterByName(), gbc_filterByName);
		GridBagConstraints gbc_lblLblinstruct = new GridBagConstraints();
		gbc_lblLblinstruct.fill = GridBagConstraints.BOTH;
		gbc_lblLblinstruct.insets = new Insets(0, 0, 5, 5);
		gbc_lblLblinstruct.gridx = 6;
		gbc_lblLblinstruct.gridy = 4;
		add(getLblLblinstruct(), gbc_lblLblinstruct);
		GridBagConstraints gbc_filterByInstruct = new GridBagConstraints();
		gbc_filterByInstruct.insets = new Insets(0, 0, 5, 5);
		gbc_filterByInstruct.fill = GridBagConstraints.BOTH;
		gbc_filterByInstruct.gridx = 7;
		gbc_filterByInstruct.gridy = 4;
		add(getFilterByInstruct(), gbc_filterByInstruct);
		GridBagConstraints gbc_btnBorrar = new GridBagConstraints();
		gbc_btnBorrar.fill = GridBagConstraints.BOTH;
		gbc_btnBorrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnBorrar.gridx = 9;
		gbc_btnBorrar.gridy = 4;
		add(getBtnRemove(), gbc_btnBorrar);
		GridBagConstraints gbc_lblInstructor = new GridBagConstraints();
		gbc_lblInstructor.anchor = GridBagConstraints.EAST;
		gbc_lblInstructor.fill = GridBagConstraints.VERTICAL;
		gbc_lblInstructor.insets = new Insets(0, 0, 5, 5);
		gbc_lblInstructor.gridx = 11;
		gbc_lblInstructor.gridy = 4;
		add(getLblInstructor(), gbc_lblInstructor);
		GridBagConstraints gbc_filterCreds = new GridBagConstraints();
		gbc_filterCreds.fill = GridBagConstraints.BOTH;
		gbc_filterCreds.insets = new Insets(0, 0, 5, 5);
		gbc_filterCreds.gridx = 12;
		gbc_filterCreds.gridy = 4;
		add(getFilterCreds(), gbc_filterCreds);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(5, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 12;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 5;
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
			table.setRowHeight(27);
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent arg0) {
					btnRemove.setVisible(table.getSelectedRow() != -1);
				}
			});
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					int row = table.getSelectedRow();

					if (event.getClickCount() > 1 && table.getSelectedRow() >= 0) {
						String courseName = String.valueOf((String) table.getModel().getValueAt(row, 0));
						PostgraduateCourse course = faculty.findCourseByName(courseName);

						if (select == null || !select.isVisible()) {
							try {
								select = new EditPostgradeCourseJDialog(course);
								select.listenTo(new OnAddedCourse() {
									@Override
									public void added(String name, Profesor instruct) {
										updateTable();
									}
								});
								select.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}

				}
			});
			table.getTableHeader().setReorderingAllowed(false);
			table.setFont(Constants.getLabelFont());
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
					if (event.getKeyCode() != 16) {
						CoursesTableModel ctmodel = (CoursesTableModel) table.getModel();
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
		((CoursesTableModel) table.getModel()).fill();
		btnRemove.setVisible(false);
	}

	private JSpinner getFilterCreds() {
		if (filterCreds == null) {
			filterCreds = new JSpinner();
			filterCreds.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			filterCreds.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					CoursesTableModel ctmodel = (CoursesTableModel) table.getModel();
					ctmodel.setFilterCreds((int) filterCreds.getValue());
				}
			});
			filterCreds.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			filterCreds.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent event) {
					CoursesTableModel ctmodel = (CoursesTableModel) table.getModel();
					ctmodel.setFilterCreds((int) filterCreds.getValue());

					btnRemove.setVisible(false);
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
					CoursesTableModel ctModel = (CoursesTableModel) table.getModel();
					ctModel.setFilterByInstruc(filterByInstruct.getText());
				}
			});
			filterByInstruct.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			filterByInstruct.setColumns(10);
		}
		return filterByInstruct;
	}

	public void removeCourse() {
		String name = String.valueOf((String) table.getModel().getValueAt(table.getSelectedRow(), 0));
		int input = JOptionPane.showConfirmDialog(null, "�Est�s seguro de eliminar el curso?");

		if (input == JOptionPane.OK_OPTION) {
			if (!faculty.removeCourseFromLine(name)) {
				JOptionPane.showMessageDialog(null, "El curso que desea eliminar no existe",
						"Error al eliminar el curso", JOptionPane.ERROR_MESSAGE);
			} else {
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
					removeCourse();
				}
			});
			btnRemove.setVisible(false);
		}
		return btnRemove;
	}

	private JLabel getLblHagaDobleClick() {
		if (lblHagaDobleClick == null) {
			lblHagaDobleClick = new JLabel("Haga doble click en alguna fila para editar");
			lblHagaDobleClick.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		}
		return lblHagaDobleClick;
	}
}
