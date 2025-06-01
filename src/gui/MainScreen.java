package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import schooling.Degree;
import schooling.Faculty;
import schooling.MasteryPlan;
import schooling.Profesor;
import schooling.ProfesorCategory;
import schooling.ResearchLine;

import java.awt.Color;

import javax.swing.JLayeredPane;
import java.awt.BorderLayout;

public class MainScreen extends JFrame {
	private static final long serialVersionUID = -5078546845004098026L;

	private JPanel contentPane;
	
	private Faculty faculty;
	private JLayeredPane layeredPane;
	private MenuPanel menuPanel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainScreen() {
		faculty = Faculty.newInstance();
		
		/// Datos de prueba
		int profesorID = faculty.addProfesor("Juan", Degree.Doctor, ProfesorCategory.Permanent, null);
		
		faculty.addResearchLine("Inteligencia artificial", null, null);
		ResearchLine line = faculty.getReseachLines().get(0);
		
		line.addMatter("IAs Generativas");
		line.addMatter("Transformers");
		
		MasteryPlan plan = new MasteryPlan(20);
		plan.addCourse("Curso 1", "test", (Profesor)faculty.findResearcher(profesorID), 2);
		
		line.setMasteryPlan(plan);
		
		faculty.addStudent("Brian", "IAs Generativas");
		
		faculty.getResearchers().get(0).addBookChapter("Sample", new String[]{""}, new String[] {""}, "FESX", "ISSN 1233-032X", "Name", 1);
		//-----------------------------
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1029, 803);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getLayeredPane_1());
	}
	private JLayeredPane getLayeredPane_1() {
		if (layeredPane == null) {
			layeredPane = new JLayeredPane();
			layeredPane.setLayout(new BorderLayout(0, 0));
			layeredPane.add(getMenuPanel());
		}
		return layeredPane;
	}
	private MenuPanel getMenuPanel() {
		if (menuPanel == null) {
			menuPanel = new MenuPanel(faculty);
		}
		return menuPanel;
	}
}
