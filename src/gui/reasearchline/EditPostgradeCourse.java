package gui.reasearchline;

import gui.event.OnAddedCourse;
import gui.event.OnCoursesFormActionTriggered;
import gui.event.OnRemovedCourse;
import gui.researchers.EditResearcherJDialog;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import schooling.Faculty;
import schooling.PostgraduateCourse;
import schooling.ResearchLine;

import javax.swing.JRadioButton;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.ButtonGroup;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;

public class EditPostgradeCourse extends JDialog {

	private static final long serialVersionUID = 2529539427327666554L;
	private final JPanel contentPanel = new JPanel();

	private PostgraduateCourse course;
	private Faculty faculty;
	
	private OnRemovedCourse listenerRemove;
	
	private JPanel operationPanel;
	private JRadioButton rBtnEditCourse;
	private JRadioButton rBtnMatriculations;
	
	private CourseForm courseForm;
	
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JPanel panelWrapper;
	private ButtonGroup buttonGroup;
	private JPanel panel;
	private JRadioButton rBtnMatriculate;
	
	public EditPostgradeCourse(PostgraduateCourse course) {
		setTitle("Editar datos del curso");
		setResizable(false);
		this.faculty = Faculty.newInstance();
		this.course = course;
		
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditResearcherJDialog.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		
		setBounds(100, 100, 975, 746);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{945, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		GridBagConstraints gbc_operationPanel = new GridBagConstraints();
		gbc_operationPanel.fill = GridBagConstraints.BOTH;
		gbc_operationPanel.insets = new Insets(0, 0, 5, 0);
		gbc_operationPanel.gridx = 0;
		gbc_operationPanel.gridy = 0;
		contentPanel.add(getOperationPanel(), gbc_operationPanel);
		GridBagConstraints gbc_panelWrapper = new GridBagConstraints();
		gbc_panelWrapper.fill = GridBagConstraints.BOTH;
		gbc_panelWrapper.insets = new Insets(0, 0, 5, 0);
		gbc_panelWrapper.gridx = 0;
		gbc_panelWrapper.gridy = 1;
		contentPanel.add(getPanelWrapper(), gbc_panelWrapper);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		contentPanel.add(getPanel(), gbc_panel);
		
		getButtonGroup();
	}

	public void listenTo(final OnAddedCourse listener) {
		courseForm.listenTo(new OnCoursesFormActionTriggered() {			
			@Override
			public void actionPerformed(CourseFormData data) {
				PostgraduateCourse c = (PostgraduateCourse)course;
				
				c.setName(data.getName());
				c.setDescription(data.getDescription());
				c.setInstructor(data.getInstructor());
				c.setCredits(data.getCredits());
				
				listener.added(c.getName(), c.getInstructor());
			}
		});
	}
	
	public void listenTo(OnRemovedCourse listenerRemove) {
		this.listenerRemove = listenerRemove;
		
	}
	
	private void switchPanel(String id) {
		CardLayout cl = (CardLayout)panelWrapper.getLayout();
		cl.show(panelWrapper, id);
	}
	
	private JPanel getOperationPanel() {
		if (operationPanel == null) {
			operationPanel = new JPanel();
			operationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			operationPanel.add(getRBtnEditCourse());
			operationPanel.add(getRBtnMatriculations());
			operationPanel.add(getRBtnMatriculate());
		}
		return operationPanel;
	}
	private JRadioButton getRBtnEditCourse() {
		if (rBtnEditCourse == null) {
			rBtnEditCourse = new JRadioButton("Editar curso");
			rBtnEditCourse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchPanel("Course Form");
				}
			});
			rBtnEditCourse.setSelected(true);
			rBtnEditCourse.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return rBtnEditCourse;
	}
	private JRadioButton getRBtnMatriculations() {
		if (rBtnMatriculations == null) {
			rBtnMatriculations = new JRadioButton("Ver matr\u00EDculas");
			rBtnMatriculations.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchPanel("Matric Table");
				}
			});
			rBtnMatriculations.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return rBtnMatriculations;
	}
	private CourseForm getCourseForm() {
		if (courseForm == null) {
			
			ResearchLine line = faculty.findLineByCourse(course);
			courseForm = new CourseForm(CourseFormData.courseForm(course), line);
			courseForm.setLayout(new BoxLayout(courseForm, BoxLayout.X_AXIS));
		}
		return courseForm;
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					setAlwaysOnTop(false);
					int input = JOptionPane.showConfirmDialog(null, "Deseas eliminar a este curso", "Eliminar", JOptionPane.WARNING_MESSAGE);					
					setAlwaysOnTop(true);
					
					if(input == JOptionPane.YES_OPTION) {
						
						faculty.getCoursesList().remove(course);
						
						if(listenerRemove != null) {
							listenerRemove.removed(course.getName());
						}
						
						course = null;
						setVisible(false);
					}
				}
			});
		}
		return btnEliminar;
	}
	private JButton getBtnCerrar() {
		if (btnCerrar == null) {
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setVisible(false);
				}
			});
		}
		return btnCerrar;
	}
	private JPanel getPanelWrapper() {
		if (panelWrapper == null) {
			panelWrapper = new JPanel();
			GridBagLayout gbl_panelWrapper = new GridBagLayout();
			gbl_panelWrapper.columnWidths = new int[]{911, 0};
			gbl_panelWrapper.rowHeights = new int[]{622, 0};
			gbl_panelWrapper.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panelWrapper.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panelWrapper.setLayout(gbl_panelWrapper);
			GridBagConstraints gbc_courseForm = new GridBagConstraints();
			gbc_courseForm.fill = GridBagConstraints.BOTH;
			gbc_courseForm.gridx = 0;
			gbc_courseForm.gridy = 0;
			
			
			panelWrapper.add(getCourseForm(), "Course Form");
		}
		return panelWrapper;
	}
	/**
	 * @wbp.nonvisual location=1,64
	 */
	private ButtonGroup getButtonGroup() {
		if (buttonGroup == null) {
			buttonGroup = new ButtonGroup();
			buttonGroup.add(rBtnMatriculate);
			buttonGroup.add(rBtnMatriculations);
			buttonGroup.add(rBtnEditCourse);
		}
		return buttonGroup;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
			panel.add(getBtnEliminar());
			panel.add(getBtnCerrar());
		}
		return panel;
	}
	private JRadioButton getRBtnMatriculate() {
		if (rBtnMatriculate == null) {
			rBtnMatriculate = new JRadioButton("Matr\u00EDcula");
			rBtnMatriculate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchPanel("Add Matric");
				}
			});
			rBtnMatriculate.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return rBtnMatriculate;
	}
}
