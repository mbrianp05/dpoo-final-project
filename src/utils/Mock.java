package utils;

import schooling.Degree;
import schooling.Faculty;
import schooling.MasteryPlan;
import schooling.Profesor;
import schooling.ProfesorCategory;
import schooling.ResearchLine;

public class Mock {
	public static void mockFacultyData(Faculty faculty) {
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
		
		faculty.getResearchers().get(0).addBookChapter("Chapter 1", new String[]{"@a"}, new String[] {"@a"}, "FESX", "ISSN 1233-032X", "Name", 1);
		faculty.getResearchers().get(0).addBookChapter("Chapter 2", new String[]{"@a"}, new String[] {"@a"}, "ABSH", "ISSN 1233-0321", "Name", 1);
		//-----------------------------
	}
}
