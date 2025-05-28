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

import javax.swing.JDialog;

public class Researchers extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel panelTitle;
	private JCheckBox filterStudents;
	private JCheckBox filterProfesors;
	private JLabel lblFiltrar;
	private JLabel actionForm;
	private JLabel lblPuntuacin;
	private JSpinner spinner;
	private JButton btnNewButton;
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
	
	public Researchers(Faculty faculty) {
		this.faculty = faculty;

		setBackground(Color.WHITE);
		setLayout(null);
		add(getPanelTitle());
		add(getFilterStudents());
		add(getFilterProfesors());
		add(getLblFiltrar());
		add(getActionForm());
		add(getLblPuntuacin());
		add(getSpinner());
		add(getBtnNewButton());
		add(getLblNombre());
		add(getFilterByName());
		add(getScrollPane());
		add(getFormTabs());
		
		researcherModel = new ResearcherTableModel();
		table.setModel(researcherModel);
		add(getLblInvestigadoresDestacados());
		add(getLblbestResearchers());
		
		initTableData();
	}
	
	private void initTableData() {
		for (Researcher r: faculty.getResearchers()) {
			String matter = faculty.findMatterOf(r.getName()).getName();
			
			((ResearcherTableModel)table.getModel()).addNew(r.getName(), matter, r.getScore());
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
			filterStudents.setBackground(Color.WHITE);
			filterStudents.setSelected(true);
			filterStudents.setBounds(167, 221, 100, 25);
		}
		
		return filterStudents;
	}
	
	private JCheckBox getFilterProfesors() {
		if (filterProfesors == null) {
			filterProfesors = new JCheckBox("Profesores");
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
			lblPuntuacin.setBounds(486, 220, 111, 22);
		}
		
		return lblPuntuacin;
	}
	
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setBounds(599, 222, 50, 22);
		}
		
		return spinner;
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Reiniciar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					((ResearcherTableModel)table.getModel()).removeFilters();
				}
			});
			btnNewButton.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.setBounds(684, 221, 97, 25);
		}
		return btnNewButton;
	}
	private AddProfesorForm getAddProfesorForm() {
		if (addProfesorForm == null) {
			addProfesorForm = new AddProfesorForm(faculty, null);
			addProfesorForm.listenTo(new OnAddedResearcher() {
				@Override
				public void added(Researcher profesor, String matter) {
					ResearcherTableModel model = (ResearcherTableModel)table.getModel();
					model.addNew(profesor.getName(), matter, profesor.getScore());
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
			filterByName = new JTextField();
			filterByName.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent arg0) {
					ResearcherTableModel tmodel = (ResearcherTableModel)table.getModel();
					tmodel.filterByName(filterByName.getText());
				}
			});
			filterByName.setBounds(336, 222, 116, 22);
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
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent event) {
					int row = table.getSelectedRow();
					
					if (row >= 0) {
						String name = (String)table.getModel().getValueAt(row, 0);
						
						try {
							UpdateResearcherPopup dialog = new UpdateResearcherPopup(faculty, faculty.findProfesorByName(name));
							dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
							dialog.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
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
					model.addNew(student.getName(), matter, student.getScore());
				}
			});
		}
		return addStudentForm;
	}
	private JLabel getLblInvestigadoresDestacados() {
		if (lblInvestigadoresDestacados == null) {
			lblInvestigadoresDestacados = new JLabel("Investigadores destacados");
			lblInvestigadoresDestacados.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			lblInvestigadoresDestacados.setBounds(215, 20, 184, 23);
		}
		return lblInvestigadoresDestacados;
	}
	private JLabel getLblbestResearchers() {
		if (lblbestResearchers == null) {
			String text = new String();

			for (Researcher r: faculty.bestResearchers()) {
				System.out.println(r.getName());
				
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
}
