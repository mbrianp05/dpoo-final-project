package gui.reasearchline;

import gui.event.OnAddedCourse;
import gui.event.OnCoursesFormActionTriggered;
import gui.event.OnRemovedCourse;
import gui.researchers.EditResearcherJDialog;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import schooling.Faculty;
import schooling.PostgraduateCourse;

import javax.swing.JRadioButton;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.ButtonGroup;

import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditPostgradeCourse extends JDialog {

	private static final long serialVersionUID = 2529539427327666554L;
	private final JPanel contentPanel = new JPanel();

	private PostgraduateCourse course;
	private Faculty faculty;
	
	private OnRemovedCourse listenerRemove;
	
	private JPanel operationPanel;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnMatrcula;
	
	private CourseForm courseForm;
	private CourseForm courseForm_1;
	private JButton btnEliminar;
	private JButton btnCerrar;
	private JPanel panelWrapper;
	private ButtonGroup buttonGroup;
	private JPanel panel;
	
	public EditPostgradeCourse(PostgraduateCourse course) {
		this.faculty = Faculty.newInstance();
		this.course = course;
		
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditResearcherJDialog.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		
		setBounds(100, 100, 975, 835);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		getOperationPanel().setLayout(null);
		contentPanel.add(getOperationPanel());
		contentPanel.add(getPanelWrapper());
		contentPanel.add(getPanel());
		
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
	private JPanel getOperationPanel() {
		if (operationPanel == null) {
			operationPanel = new JPanel();
			operationPanel.setBounds(5, 5, 940, 70);
			operationPanel.add(getRdbtnNewRadioButton());
			operationPanel.add(getRdbtnMatrcula());
		}
		return operationPanel;
	}
	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("Editar curso");
			rdbtnNewRadioButton.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			rdbtnNewRadioButton.setBounds(287, 24, 127, 25);
		}
		return rdbtnNewRadioButton;
	}
	private JRadioButton getRdbtnMatrcula() {
		if (rdbtnMatrcula == null) {
			rdbtnMatrcula = new JRadioButton("Matr\u00EDcula");
			rdbtnMatrcula.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
			rdbtnMatrcula.setBounds(469, 24, 127, 25);
		}
		return rdbtnMatrcula;
	}
	private CourseForm getCourseForm_1() {
		if (courseForm_1 == null) {
			courseForm_1 = new CourseForm();
		}
		return courseForm_1;
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
			panelWrapper.setBounds(0, 88, 935, 560);
			GridBagLayout gbl_panelWrapper = new GridBagLayout();
			gbl_panelWrapper.columnWidths = new int[]{911, 0};
			gbl_panelWrapper.rowHeights = new int[]{622, 0};
			gbl_panelWrapper.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_panelWrapper.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panelWrapper.setLayout(gbl_panelWrapper);
			GridBagConstraints gbc_courseForm_1 = new GridBagConstraints();
			gbc_courseForm_1.gridx = 0;
			gbc_courseForm_1.gridy = 0;
			panelWrapper.add(getCourseForm_1(), gbc_courseForm_1);
		}
		return panelWrapper;
	}
	/**
	 * @wbp.nonvisual location=1,64
	 */
	private ButtonGroup getButtonGroup() {
		if (buttonGroup == null) {
			buttonGroup = new ButtonGroup();
			buttonGroup.add(btnCerrar);
			buttonGroup.add(btnEliminar);
		}
		return buttonGroup;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(5, 730, 940, 45);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{358, 79, 79, 0};
			gbl_panel.rowHeights = new int[]{30, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
			gbc_btnEliminar.anchor = GridBagConstraints.WEST;
			gbc_btnEliminar.fill = GridBagConstraints.VERTICAL;
			gbc_btnEliminar.insets = new Insets(0, 0, 0, 5);
			gbc_btnEliminar.gridx = 1;
			gbc_btnEliminar.gridy = 0;
			panel.add(getBtnEliminar(), gbc_btnEliminar);
			GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
			gbc_btnCerrar.fill = GridBagConstraints.BOTH;
			gbc_btnCerrar.gridx = 2;
			gbc_btnCerrar.gridy = 0;
			panel.add(getBtnCerrar(), gbc_btnCerrar);
		}
		return panel;
	}
}
