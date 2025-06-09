package gui.reasearchline;

import gui.event.OnAddedCourse;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import schooling.Faculty;
import schooling.PostgraduateCourse;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Font;

public class EditPostgradeCourse extends JDialog {

	private static final long serialVersionUID = 2529539427327666554L;
	private final JPanel contentPanel = new JPanel();

	private PostgraduateCourse course;
	private Faculty faculty;
	
	private OnAddedCourse listener;
	private JPanel panel;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnMatrcula;
	
	public EditPostgradeCourse(PostgraduateCourse course) {
		this.faculty = Faculty.newInstance();
		this.course = course;
		
		setModal(true);
		setBounds(100, 100, 975, 835);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		getPanel().setLayout(null);
		contentPanel.add(getPanel());
	}

	public void listenTo(final OnAddedCourse listener) {
		
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(5, 5, 947, 70);
			panel.add(getRdbtnNewRadioButton());
			panel.add(getRdbtnMatrcula());
		}
		return panel;
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
}
