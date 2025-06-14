package utils;

import schooling.Degree;
import schooling.Faculty;
import schooling.Profesor;
import schooling.ProfesorCategory;
import schooling.ResearchLine;

public class Mock {
	public static void mockFacultyData(Faculty faculty) {
		/// Datos de prueba
		
		//-------------Crear investigadores------------
		int profesorID = faculty.addProfesor("Juan", Degree.Doctor, ProfesorCategory.Permanent, null);
		int profesorID2 = faculty.addProfesor("Kevin", Degree.Doctor, ProfesorCategory.Permanent, null);
		int profesorID3 = faculty.addProfesor("Ernesto", null, ProfesorCategory.Assistant, null);
		
		//------------Añadir una línea-----------
		faculty.addResearchLine("Seguridad de softwares", faculty.getProfesors().get(0));
		ResearchLine line = faculty.getResearchLines().get(0);
		
		//------------Añadir dos temas de investigación en la línea-------------
		line.addMatter("Antivirus");
		line.addMatter("Filtros y capas de seguridad");
		
		
		//------------Añadir dos cursos al plan de maestría------------------
		line.getMasteryPlan().addCourse("Encriptación", "test", (Profesor)faculty.findResearcher(profesorID), 2);
		line.getMasteryPlan().addCourse("Detección del malware", "test2", (Profesor)faculty.findResearcher(profesorID2), 3);
		
		//----------------Matricular a un profesor-----------------
		line.getMasteryPlan().addMatriculation((Profesor)faculty.findResearcher(profesorID3), line.getMasteryPlan().getCourses().get(0));
		line.getMasteryPlan().addMatriculation((Profesor)faculty.findResearcher(profesorID3), line.getMasteryPlan().getCourses().get(1));

		//------------Añadir un estudiante-----------
		int ID4 = faculty.addStudent("Brian", "IAs Generativas");
		
		//----------------Asignar los temas de investigacion a los investigadores------------
		line.getMatters().get(0).addResearcher(faculty.findResearcher(profesorID));
		line.getMatters().get(1).addResearcher(faculty.findResearcher(profesorID2));
		line.getMatters().get(1).addResearcher(faculty.findResearcher(profesorID3));
		line.getMatters().get(1).addResearcher(faculty.findResearcher(ID4));
		
		// ---------------Añadir aportes investigativos-------------------------
		faculty.getResearchers().get(0).addBookChapter("Chapter 1", new String[]{"@a"}, new String[] {"@a"}, "FESX", "ISSN 1233-032X", "Name", 1);
		faculty.getResearchers().get(0).addBookChapter("Chapter 2", new String[]{"@a"}, new String[] {"@a"}, "ABSH", "ISSN 1233-0321", "Name", 1);
		//-----------------------------
	}
}
