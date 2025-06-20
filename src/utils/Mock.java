package utils;

import java.time.LocalDate;

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
		int profesorID8 = faculty.addProfesor("Manuel", Degree.Master, ProfesorCategory.Assistant, null);

		//------------A�adir l�neas-----------
		faculty.addResearchLine("Seguridad de softwares", faculty.getProfesors().get(0));
		ResearchLine line = faculty.getResearchLines().get(0);
		faculty.addResearchLine("Automatizaci�n de sistemas", faculty.getProfesors().get(1));
		ResearchLine line1 = faculty.getResearchLines().get(1);
		faculty.addResearchLine("L�gica e interfaces", faculty.getProfesors().get(3));
		ResearchLine line2 = faculty.getResearchLines().get(2);
		faculty.addResearchLine("Funciones especiales de sistemas", faculty.getProfesors().get(4));
		ResearchLine line3 = faculty.getResearchLines().get(3);
		faculty.addResearchLine("Desarrollo de hardware", faculty.getProfesors().get(5));
		ResearchLine line4 = faculty.getResearchLines().get(4);

		//------------A�adir temas de investigaci�n en las l�neas-------------
		line.addMatter("Antivirus");
		line.addMatter("Filtros y capas de seguridad");
		line1.addMatter("Automatizaci�n l�gica");
		line1.addMatter("Estructuras autoconstructivas");
		line2.addMatter("Polimorfismo de interfaces");
		line2.addMatter("Bloques de c�digo modulares");
		line3.addMatter("Caracter�sticas distintivas de sistemas operativos");
		line4.addMatter("Evoluci�n de ordenadores");

		//------------A�adir cursos a los planes de maestr�a------------------
		line.getMasteryPlan().addCourse("Encriptaci�n", "test", (Profesor)faculty.findResearcher(profesorID), 2);
		line.getMasteryPlan().addCourse("Detecci�n del malware", "test2", (Profesor)faculty.findResearcher(profesorID2), 3);
		line1.getMasteryPlan().addCourse("Inteligencia artificial", "testIA", (Profesor)faculty.findResearcher(profesorID4), 7);
		line2.getMasteryPlan().addCourse("Desarrollo de IDEs", "testIDEs", (Profesor)faculty.findResearcher(profesorID5), 4);
		line3.getMasteryPlan().addCourse("Desarrollo de SO", "testSO", (Profesor)faculty.findResearcher(profesorID6), 5);

		//----------------Matricular a profesores-----------------
		line.getMasteryPlan().matriculate((Profesor)faculty.findResearcher(profesorID3));
		line3.getMasteryPlan().matriculate((Profesor)faculty.findResearcher(profesorID7));

		//------------A�adir estudiantes-----------
		int ID1 = faculty.addStudent("Brian", "IAs Generativas");
		int ID2 = faculty.addStudent("Aleksandr", "Seguridad de sistemas");

		//----------------Asignar los temas de investigacion a los investigadores------------
		line.getMatters().get(0).addResearcher(faculty.findResearcher(profesorID));
		line.getMatters().get(1).addResearcher(faculty.findResearcher(profesorID2));
		line.getMatters().get(1).addResearcher(faculty.findResearcher(profesorID3));
		line1.getMatters().get(0).addResearcher(faculty.findResearcher(profesorID4));
		line2.getMatters().get(1).addResearcher(faculty.findResearcher(profesorID5));
		line4.getMatters().get(0).addResearcher(faculty.findResearcher(profesorID6));
		line4.getMatters().get(0).addResearcher(faculty.findResearcher(profesorID8));
		line3.getMatters().get(0).addResearcher(faculty.findResearcher(profesorID6));
		line3.getMatters().get(0).addResearcher(faculty.findResearcher(profesorID7));
		line.getMatters().get(1).addResearcher(faculty.findResearcher(ID1));
		line3.getMatters().get(0).addResearcher(faculty.findResearcher(ID2));

		// ---------------A�adir aportes investigativos-------------------------
		faculty.getResearchers().get(0).addBookChapter("Networks", new String[]{"@D"}, new String[] {"@D"}, "FESX", "ISSN 1233-032X", "Internet", 1);
		faculty.getResearchers().get(0).addBookChapter("Bank Accounts", new String[]{"@A"}, new String[] {"@A"}, "ABSH", "ISSN 1233-0321", "Bank System", 1);
		faculty.getResearchers().get(6).addPaper("Paper 1", 12, 1, 2019, TargetedGroup.Wos);
		faculty.getResearchers().get(4).addPaper("Titulo", 3, 1, 2010, TargetedGroup.Group2);
		faculty.getResearchers().get(3).addPresentation("Thoery", LocalDate.now(), "0393202203", "La Habana");
		//-----------------------------
	}
}
