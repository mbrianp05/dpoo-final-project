import java.util.ArrayList;

public class Faculty {
    private ArrayList<ResearchLine> researchLines;
    private ArrayList<Researcher> researchers;

    // M�todo para filtrar a los profesores de los investigadores
    public ArrayList<Profesor> getProfesors() {
    	ArrayList<Profesor> profesors = new ArrayList<>();
    	
    	for (Researcher r: researchers) {
    		if (r instanceof Profesor) {
    			profesors.add((Profesor)r);
    		}
    	}
    	
    	return profesors;
    }

    // REPORTE: (Brian): Los investigadores con m�s puntos por ponencias/cap�tulos/art�culos
    public ArrayList<Researcher> bestResearchers() {}
    // REPORTE: (Brian): Los temas de investigaci�n con m�s investigadores
    public ArrayList<ResearchMatter> trendingMatter() {}
    // REPORTE: (Brian): La mayor cantidad de art�culos publicado por un mismo investigador
    public int mostPaperPublished() {}
    
    // REPORTE: (Aleksander): Los profesores que tienen los cr�ditos necesarios para aprobar su maestr�a
    public ArrayList<Profesor> profesorsWithMasteryReady() {}
    // REPORTE: (Aleksander): Los mayor cantidad de cursos que imparte un profesor
    public int mostCoursesByOneInstructor() {}
    // A�adir m�s reportes relacionados a los cursos de considerar necesario
}