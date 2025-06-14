package gui.reasearchline;

import gui.event.OnAddedCourse;
import gui.event.OnCoursesFormActionTriggered;
import gui.researchers.EditResearcherJDialog;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import schooling.Faculty;
import schooling.PostgraduateCourse;
import schooling.ResearchLine;

public class EditPostgradeCourseJDialog extends JDialog {

	private static final long serialVersionUID = 2529539427327666554L;
	private final JPanel contentPanel = new JPanel();

	private PostgraduateCourse course;
	private Faculty faculty;

	private OnAddedCourse listenerAdded;

	private JPanel operationPanel;
	private JRadioButton rBtnEditCourse;
	private JRadioButton rBtnAssignMarks;

	private CourseForm courseForm;
	private JPanel panelWrapper;
	private ButtonGroup buttonGroup;
	private MaskAssignmentForm maskAssignmentForm;

	public EditPostgradeCourseJDialog(PostgraduateCourse course) {
		setTitle("Editar datos del curso");
		setResizable(false);
		this.faculty = Faculty.newInstance();
		this.course = course;

		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(EditResearcherJDialog.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);


		setBounds(100, 100, 800, 650);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{945, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		GridBagConstraints gbc_operationPanel = new GridBagConstraints();
		gbc_operationPanel.fill = GridBagConstraints.BOTH;
		gbc_operationPanel.insets = new Insets(0, 0, 5, 0);
		gbc_operationPanel.gridx = 0;
		gbc_operationPanel.gridy = 0;
		contentPanel.add(getOperationPanel(), gbc_operationPanel);
		GridBagConstraints gbc_panelWrapper = new GridBagConstraints();
		gbc_panelWrapper.fill = GridBagConstraints.BOTH;
		gbc_panelWrapper.gridx = 0;
		gbc_panelWrapper.gridy = 1;
		contentPanel.add(getPanelWrapper(), gbc_panelWrapper);

		getButtonGroup();
	}

	public void listenTo(OnAddedCourse listener) {
		this.listenerAdded = listener;
	}

	private void switchPanel(String id) {
		CardLayout cl = (CardLayout)panelWrapper.getLayout();
		cl.show(panelWrapper, id);
	}

	private JPanel getOperationPanel() {
		if (operationPanel == null) {
			operationPanel = new JPanel();
			operationPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			if(faculty.getMatriculationsAtCourse(course).size() > 0) {
				operationPanel.add(getRBtnEditCourse());
				operationPanel.add(getRBtnAssignMarks());			
			}
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
	private JRadioButton getRBtnAssignMarks() {
		if (rBtnAssignMarks == null) {
			rBtnAssignMarks = new JRadioButton("Asignar Notas");
			rBtnAssignMarks.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					switchPanel("Matriculations Form");
				}
			});
			rBtnAssignMarks.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		}
		return rBtnAssignMarks;
	}
	private CourseForm getCourseForm() {
		if (courseForm == null) {
			ResearchLine line = faculty.findResearchLineByCourse(course);
			courseForm = new CourseForm(CourseFormData.courseForm(course), line);
			courseForm.setLayout(new BoxLayout(courseForm, BoxLayout.X_AXIS));
			courseForm.listenTo(new OnCoursesFormActionTriggered() {
				@Override
				public void actionPerformed(CourseFormData data) {
					course.setName(data.getName());
					course.setCredits(data.getCredits());
					course.setInstructor(data.getInstructor());
					course.setDescription(data.getDescription());

					if (listenerAdded != null) listenerAdded.added(data.getName(), data.getInstructor());
				}
			});
		}
		return courseForm;
	}

	private MaskAssignmentForm getMatriculationMarkAssignment() {
		if (maskAssignmentForm == null) {
			maskAssignmentForm = new MaskAssignmentForm(course);
		}
		return maskAssignmentForm;
	}
	private JPanel getPanelWrapper() {
		if (panelWrapper == null) {
			panelWrapper = new JPanel();
			GridBagConstraints gbc_courseForm = new GridBagConstraints();
			gbc_courseForm.fill = GridBagConstraints.BOTH;
			gbc_courseForm.gridx = 0;
			gbc_courseForm.gridy = 0;
			panelWrapper.setLayout(new CardLayout(0, 0));


			panelWrapper.add(getCourseForm(), "Course Form");
			panelWrapper.add(getMatriculationMarkAssignment(), "Matriculations Form");
		}
		return panelWrapper;
	}
	/**
	 * @wbp.nonvisual location=1,64
	 */
	private ButtonGroup getButtonGroup() {
		if (buttonGroup == null) {
			buttonGroup = new ButtonGroup();
			buttonGroup.add(rBtnAssignMarks);
			buttonGroup.add(rBtnEditCourse);
		}
		return buttonGroup;
	}
}