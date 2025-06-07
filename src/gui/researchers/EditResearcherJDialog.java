package gui.researchers;

import gui.event.OnProfesorFormActionTriggered;
import gui.event.OnAddedResearcher;
import gui.event.OnRemovedResearcher;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import schooling.Profesor;
import schooling.ResearchLine;
import schooling.ResearchMatter;
import schooling.Researcher;
import schooling.Student;

import java.awt.Color;

import schooling.Faculty;
import utils.ArrayLib;

import java.awt.Toolkit;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class EditResearcherJDialog extends JDialog {
	private static final long serialVersionUID = -8039865322179654975L;
	private final JPanel contentPanel = new JPanel();

	private Researcher researcher;
	private Faculty faculty;

	private ProfesorForm profesorForm;
	private JPanel panel;
	private JButton btnRemove;
	private JButton btnA;
	
	private OnRemovedResearcher listener;
	private StudentForm studentForm;

	public EditResearcherJDialog(Researcher researcher) {
		this.faculty = Faculty.newInstance();
		this.researcher = researcher;

		setAlwaysOnTop(true);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditResearcherJDialog.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBackground(Color.WHITE);

		setResizable(false);
		setTitle("Editar datos de investigador");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 897, 688);
		
		getContentPane().setLayout(new BorderLayout());
		
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{30, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;

		GridBagConstraints grid = new GridBagConstraints();
		grid.insets = new Insets(0, 0, 5, 5);
		grid.gridx = 1;
		grid.gridy = 1;
		
		if (researcher instanceof Profesor) {
			contentPanel.add(getProfesorForm(), grid);
		} else if (researcher instanceof Student) {
			contentPanel.add(getStudentForm(), grid);
		}

		contentPanel.add(getPanel(), gbc_panel);
	}

	public void listenTo(final OnAddedResearcher listener) {
		if (researcher instanceof Profesor) {
			profesorForm.listenTo(new OnProfesorFormActionTriggered() {
				@Override
				public void actionPerformed(ProfesorFormData data) {
					Profesor p = (Profesor)researcher;
					
					p.setName(data.getName());
					p.setDegree(data.getDegree());
					p.setCategory(data.getCategory());
					
					faculty.moveToOtherMatter(p.getID(), data.getMatter());
					
					listener.newResearcher(researcher.getID());
				}
			});
		} else {
			studentForm.listenTo(listener);
		}
	}
	
	public void listenTo(OnRemovedResearcher listener) {
		this.listener = listener;
	}

	private String[] getMatters() {
		String[] matters = ArrayLib.cast(faculty.getResearchMattersNames());
		
		if (researcher instanceof Profesor) {
			Profesor p = (Profesor)researcher;
			
			if (faculty.isChief(p)) {
				System.out.println(p.getName());
				
				ResearchLine line = faculty.getReseachLineByChief(p);
				matters = new String[line.getMatters().size()];
				
				for (int i = 0; i < line.getMatters().size(); i++) {
					matters[i] = line.getMatters().get(i).getName();
				}
			}
		}
		
		return matters;
	}
	
	private ProfesorForm getProfesorForm() {
		if (profesorForm == null) {
			Profesor profesor = (Profesor)researcher;
			ResearchMatter matter = faculty.findMatterOf(profesor.getID());
			
			String matterName = "";
			
			if (matter != null) matterName = matter.getName();
			
			profesorForm = new ProfesorForm(getMatters(), ProfesorFormData.fromResearcher(profesor, matterName));
		}

		return profesorForm;
	}
	
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.add(getBtnRemove());
			panel.add(getBtnA());
		}
		return panel;
	}
	private JButton getBtnRemove() {
		if (btnRemove == null) {
			btnRemove = new JButton("Eliminar");
			btnRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setAlwaysOnTop(false);
					int input = JOptionPane.showConfirmDialog(null, "Deseas eliminar a este investigador", "Eliminar", JOptionPane.WARNING_MESSAGE);

					setAlwaysOnTop(true);
					
					if (input == JOptionPane.YES_OPTION) {
						faculty.getResearchers().remove(researcher);

						if (listener != null) {
							listener.removed(researcher.getID());
						}
						
						researcher = null;
						setVisible(false);
					}
				}
			});
			btnRemove.setBackground(Color.WHITE);
		}
		return btnRemove;
	}
	private JButton getBtnA() {
		if (btnA == null) {
			btnA = new JButton("Cerrar");
			btnA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
			btnA.setBackground(Color.WHITE);
		}
		return btnA;
	}
	private StudentForm getStudentForm() {
		if (studentForm == null) {
			studentForm = new StudentForm(faculty, (Student)researcher);
		}
		return studentForm;
	}
}
