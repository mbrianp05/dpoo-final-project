package gui;

import gui.event.OnAuthenticate;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import schooling.Degree;
import schooling.Faculty;
import schooling.MasteryPlan;
import schooling.ProfesorCategory;
import schooling.ResearchLine;

import java.awt.Color;

public class MainScreen extends JFrame {
	private JPanel contentPane;
	private AuthenticationPanel authenticationPanel;
	private MenuPanel menu;
	
	private Faculty faculty;

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
		faculty.addStudent("Brian");
		faculty.addProfesor("Juan", Degree.Doctor, ProfesorCategory.Permanent);
		faculty.addResearchLine("Inteligencia artificial", null, null);
		
		ResearchLine line = faculty.getReseachLines().get(0);

		line.addMatter("IAs Generativas");
		line.addMatter("Transformers");
		
		line.getMatters().get(0).addResearcher(faculty.getResearchers().get(0));
		line.getMatters().get(0).addResearcher(faculty.getProfesors().get(0));
		faculty.getResearchers().get(0).addBookChapter("Sample", new String[]{""}, new String[] {""}, "FESX", "ISSN 1233-032X", "Name", 1);
		
		MasteryPlan plan = new MasteryPlan(20);
		
		plan.addCourse("Curso 1", "test", faculty.getProfesors().get(0), 10);
		
		line.setMasteryPlan(plan);
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 570);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getAuthenticationPanel());
		contentPane.add(getMenu());
	}

	private AuthenticationPanel getAuthenticationPanel() {
		if (authenticationPanel == null) {
			authenticationPanel = new AuthenticationPanel();
			authenticationPanel.setBounds(270, 100, 270, 200);
			authenticationPanel.listenTo(new OnAuthenticate() {
				@Override
				public void granted() {
					authenticationPanel.setVisible(false);
					menu.setVisible(true);
				}
			});
		}

		return authenticationPanel;
	}

	private MenuPanel getMenu() {
		if (menu == null) {
			menu = new MenuPanel(faculty);
			menu.setBounds(0, 0, 809, 539);
			menu.setVisible(false);
		}
		return menu;
	}
}
