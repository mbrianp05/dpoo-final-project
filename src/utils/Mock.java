package utils;

import schooling.Degree;
import schooling.Faculty;
import schooling.Profesor;
import schooling.ProfesorCategory;
import schooling.ResearchLine;
import schooling.TargetedGroup;

public class Mock {
	public static void mockFacultyData() {
		/// Datos de prueba
		Faculty faculty = Faculty.newInstance();

		//-------------Crear investigadores------------
		int profesorID = faculty.addProfesor("Juan", Degree.Doctor, ProfesorCategory.Permanent, null);
		int profesorID2 = faculty.addProfesor("Kevin", Degree.Doctor, ProfesorCategory.Permanent, null);
		int profesorID3 = faculty.addProfesor("Ernesto", null, ProfesorCategory.Assistant, null);
		int profesorID4 = faculty.addProfesor("Daniel", Degree.Doctor, ProfesorCategory.Permanent, null);
		int profesorID5 = faculty.addProfesor("Carlos", Degree.Doctor, ProfesorCategory.Instructor, null);
		int profesorID6 = faculty.addProfesor("Fernando", Degree.Doctor, ProfesorCategory.Auxiliar, null);
		int profesorID7 = faculty.addProfesor("Oscar", null, ProfesorCategory.Auxiliar, null);

		//------------Añadir líneas-----------
		faculty.addResearchLine("Seguridad de softwares", faculty.getProfesors().get(0));
		ResearchLine line = faculty.getResearchLines().get(0);
		faculty.addResearchLine("Automatización de sistemas", faculty.getProfesors().get(1));
		ResearchLine line1 = faculty.getResearchLines().get(1);
		faculty.addResearchLine("Lógica e interfaces", faculty.getProfesors().get(3));
		ResearchLine line2 = faculty.getResearchLines().get(2);
		faculty.addResearchLine("Funciones especiales de sistemas", faculty.getProfesors().get(4));
		ResearchLine line3 = faculty.getResearchLines().get(3);
		faculty.addResearchLine("Desarrollo de hardware", faculty.getProfesors().get(5));
		ResearchLine line4 = faculty.getResearchLines().get(4);

		//------------Añadir temas de investigación en las líneas-------------
		line.addMatter("Antivirus");
		line.addMatter("Filtros y capas de seguridad");
		line1.addMatter("Automatización lógica");
		line1.addMatter("Estructuras autoconstructivas");
		line2.addMatter("Polimorfismo de interfaces");
		line2.addMatter("Bloques de código modulares");
		line3.addMatter("Características distintivas de sistemas operativos");
		line4.addMatter("Evolución de ordenadores");

		//------------Añadir cursos a los planes de maestría------------------
		line.getMasteryPlan().addCourse("Encriptación", "test", (Profesor)faculty.findResearcher(profesorID), 2);
		line.getMasteryPlan().addCourse("Detección del malware", "test2", (Profesor)faculty.findResearcher(profesorID2), 3);
		line1.getMasteryPlan().addCourse("Inteligencia artificial", "testIA", (Profesor)faculty.findResearcher(profesorID4), 7);
		line2.getMasteryPlan().addCourse("Desarrollo de IDEs", "testIDEs", (Profesor)faculty.findResearcher(profesorID5), 4);
		line3.getMasteryPlan().addCourse("Desarrollo de SO", "testSO", (Profesor)faculty.findResearcher(profesorID6), 5);

		//----------------Matricular a profesores-----------------
		line.matriculate((Profesor)faculty.findResearcher(profesorID3));
		line3.matriculate((Profesor)faculty.findResearcher(profesorID7));

		//------------Añadir estudiantes-----------
		int ID1 = faculty.addStudent("Brian", "IAs Generativas");
		int ID2 = faculty.addStudent("Aleksandr", "Seguridad de sistemas");

		//----------------Asignar los temas de investigacion a los investigadores------------
		line.getMatters().get(0).addResearcher(faculty.findResearcher(profesorID));
		line.getMatters().get(1).addResearcher(faculty.findResearcher(profesorID2));
		line.getMatters().get(1).addResearcher(faculty.findResearcher(profesorID3));
		line1.getMatters().get(0).addResearcher(faculty.findResearcher(profesorID4));
		line2.getMatters().get(1).addResearcher(faculty.findResearcher(profesorID5));
		line4.getMatters().get(0).addResearcher(faculty.findResearcher(profesorID6));
		line3.getMatters().get(0).addResearcher(faculty.findResearcher(profesorID7));
		line.getMatters().get(1).addResearcher(faculty.findResearcher(ID1));
		line3.getMatters().get(0).addResearcher(faculty.findResearcher(ID2));

		// ---------------Añadir aportes investigativos-------------------------
		faculty.getResearchers().get(0).addBookChapter("Chapter 1", new String[]{"@a"}, new String[] {"@a"}, "FESX", "ISSN 1233-032X", "Name", 1);
		faculty.getResearchers().get(0).addBookChapter("Chapter 2", new String[]{"@a"}, new String[] {"@a"}, "ABSH", "ISSN 1233-0321", "Name", 1);
		faculty.getResearchers().get(6).addPaper("Paper 1", 1, 2, 2019, TargetedGroup.Wos);
		faculty.getResearchers().get(4).addPaper("Titulo", 1, 1, 2010, TargetedGroup.Group2);
		faculty.getResearchers().get(3).addBookChapter("Chapter 2", new String[]{"@a"}, new String[] {"@a"}, "AASS", "ISSN 1233-0322", "Name", 1);
		//-----------------------------
	}
}
