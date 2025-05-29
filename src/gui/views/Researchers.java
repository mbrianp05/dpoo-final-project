package gui.views;

import gui.event.OnAddedResearcher;
import gui.tablemodel.ResearcherTableModel;

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

import javax.swing.ButtonGroup;
import javax.swing.JTabbedPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class Researchers extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel panelTitle;
	private JCheckBox filterStudents;
	private JCheckBox filterProfesors;
	private JLabel lblFiltrar;
	private JLabel actionForm;
	private JLabel lblPuntuacin;
	private JSpinner spinner;
	private AddProfesorForm addProfesorForm;
	private JLabel lblNombre;
	private JTextField filterByName;
	private JScrollPane scrollPane;

	private ResearcherTableModel researcherModel;
	private JTable table;

	private Faculty faculty;
	private ButtonGroup buttonGroup;
	private JTabbedPane formTabs;
	private AddStudentForm addStudentForm;
	private JLabel lblInvestigadoresDestacados;
	private JLabel lblbestResearchers;
	private JLabel lblBestScore;
	private UpdateResearcherPopup dialog;
	
	private OnAddedResearcher event;
	private JButton btnEliminar;

	public Researchers(Faculty faculty) {
		this.faculty = faculty;

		setBackground(Color.WHITE);
		setLayout(null);
		add(getPanelTitle());
		add(getLblFiltrar());
		add(getActionForm());
		add(getLblPuntuacin());
		add(getSpinner());
		add(getLblNombre());
		add(getFilterByName());
		add(getScrollPane());
		add(getFormTabs());

		researcherModel = new ResearcherTableModel(faculty);
		table.setModel(researcherModel);

		add(getLblInvestigadoresDestacados());
		add(getLblbestResearchers());
		add(getLblBestScore());
		add(getFilterStudents());
		add(getFilterProfesors());
		add(getBtnEliminar());

		initTableData();	
	}

	public void listenTo(OnAddedResearcher listener) {
		event = listener;
	}
	
	private void initTableData() {
		for (Researcher r: faculty.getResearchers()) {
			((ResearcherTableModel)table.getModel()).addNew(r);
		}
	}

	private JLabel getPanelTitle() {
		if (panelTitle == null) {
			panelTitle = new JLabel("Investigadores");
			panelTitle.setFont(new Font("Segoe UI Symbol", Font.BOLD, 24));
			panelTitle.setBounds(12, 13, 196, 30);
		}

		return panelTitle;
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
			filterStudents.setBounds(167, 221, 100, 25);
		}

		return filterStudents;
	}

	private JCheckBox getFilterProfesors() {
		if (filterProfesors == null) {
			filterProfesors = new JCheckBox("Profesores");
			filterProfesors.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ResearcherTableModel tmodel = (ResearcherTableModel)table.getModel();
					tmodel.includeProfesors(filterProfesors.isSelected());
					tmodel.applyFilters();
				}
			});
			filterProfesors.setBackground(Color.WHITE);
			filterProfesors.setSelected(true);
			filterProfesors.setBounds(63, 221, 100, 25);
		}

		return filterProfesors;
	}

	private JLabel getLblFiltrar() {
		if (lblFiltrar == null) {
			lblFiltrar = new JLabel("Filtrar");
			lblFiltrar.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			lblFiltrar.setBounds(12, 223, 56, 16);
		}

		return lblFiltrar;
	}

	private JLabel getActionForm() {
		if (actionForm == null) {
			actionForm = new JLabel("A\u00F1adir investigador");
			actionForm.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			actionForm.setBounds(12, 42, 151, 23);
		}

		return actionForm;
	}

	private JLabel getLblPuntuacin() {
		if (lblPuntuacin == null) {
			lblPuntuacin = new JLabel("Min Puntuaci\u00F3n");
			lblPuntuacin.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			lblPuntuacin.setBounds(498, 220, 105, 22);
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
			spinner.setBounds(615, 222, 50, 22);
		}

		return spinner;
	}
	private AddProfesorForm getAddProfesorForm() {
		if (addProfesorForm == null) {
			addProfesorForm = new AddProfesorForm(faculty, null);
			addProfesorForm.listenTo(new OnAddedResearcher() {
				@Override
				public void added(Researcher profesor, String matter) {
					ResearcherTableModel model = (ResearcherTableModel)table.getModel();
					model.addNew(profesor);
					event.added(profesor, matter);
				}
			});
			addProfesorForm.setBorder(null);
		}
		return addProfesorForm;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre");
			lblNombre.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			lblNombre.setBounds(275, 220, 56, 22);
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
			filterByName.setBounds(336, 222, 139, 22);
			filterByName.setColumns(10);
		}
		return filterByName;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 257, 783, 207);
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
					
//					if (row >= 0) {
//						String name = (String)table.getModel().getValueAt(row, 0);
//						try {
//							dialog = new UpdateResearcherPopup(faculty, faculty.findProfesorByName(name));
//							dialog.listenTo(new OnAddedResearcher() {
//								@Override
//								public void added(Researcher researcher, String matter) {
//									((ResearcherTableModel)table.getModel()).update(row, researcher.getName(), matter, researcher.getScore());
//								}
//							});
//							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//							dialog.setVisible(true);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
				}
			});
			table.setBackground(Color.WHITE);
		}
		return table;
	}
	/**
	 * @wbp.nonvisual location=121,484
	 */
	private ButtonGroup getButtonGroup() {
		if (buttonGroup == null) {
			buttonGroup = new ButtonGroup();
		}
		return buttonGroup;
	}
	private JTabbedPane getFormTabs() {
		if (formTabs == null) {
			formTabs = new JTabbedPane(JTabbedPane.TOP);
			formTabs.setBorder(null);
			formTabs.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			formTabs.setBackground(Color.WHITE);
			formTabs.setBounds(12, 78, 783, 131);

			formTabs.addTab("Profesor", null, getAddProfesorForm(), null);
			formTabs.addTab("Estudiante", null, getAddStudentForm(), null);
		}
		return formTabs;
	}
	private AddStudentForm getAddStudentForm() {
		if (addStudentForm == null) {
			addStudentForm = new AddStudentForm(faculty);
			addStudentForm.listenTo(new OnAddedResearcher() {
				@Override
				public void added(Researcher student, String matter) {
					ResearcherTableModel model = (ResearcherTableModel)table.getModel();
					model.addNew(student);
					event.added(student, matter);
				}
			});
		}
		return addStudentForm;
	}
	private JLabel getLblInvestigadoresDestacados() {
		if (lblInvestigadoresDestacados == null) {
			lblInvestigadoresDestacados = new JLabel("Investigadores destacados");
			lblInvestigadoresDestacados.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			lblInvestigadoresDestacados.setBounds(211, 20, 186, 23);
		}
		return lblInvestigadoresDestacados;
	}
	private JLabel getLblbestResearchers() {
		if (lblbestResearchers == null) {
			String text = "";

			for (Researcher r: faculty.bestResearchers()) {
				text += r.getName() + ", ";
			}

			if (text.length() > 2) {				
				text = text.substring(0, text.length() - 2);
			}

			lblbestResearchers = new JLabel(text);
			lblbestResearchers.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			lblbestResearchers.setBounds(397, 20, 398, 23);
		}
		return lblbestResearchers;
	}

	private String resolveBestResearchersLabelText() {
		String text = "";
		ArrayList<Researcher> best = faculty.bestResearchers();

		if (best.size() > 0) {
			text = "Puntuación de " + String.valueOf(faculty.bestResearchers().get(0).getScore());
		}

		return text;
	}

	private JLabel getLblBestScore() {
		if (lblBestScore == null) {
			lblBestScore = new JLabel(resolveBestResearchersLabelText());
			lblBestScore.setBackground(new Color(0, 51, 0));
			lblBestScore.setHorizontalAlignment(SwingConstants.RIGHT);
			lblBestScore.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 12));
			lblBestScore.setBounds(211, 42, 174, 23);
		}
		return lblBestScore;
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
			btnEliminar.setBounds(698, 221, 97, 25);
		}
		return btnEliminar;
	}
}
