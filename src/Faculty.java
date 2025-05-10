import java.util.ArrayList;

public class Faculty {
    private ArrayList<ResearchLine> researchLines;
    private ArrayList<Researcher> researchers;

    // Método para filtrar a los profesores de los investigadores
    public ArrayList<Profesor> getProfesors() {
    	ArrayList<Profesor> profesors = new ArrayList<>();
    	
    	for (Researcher r: researchers) {
    		if (r instanceof Profesor) {
    			profesors.add((Profesor)r);
    		}
    	}
    	
    	return profesors;
    }

    // REPORTE: (Brian): Los investigadores con más puntos por ponencias/capítulos/artículos
    public ArrayList<Researcher> bestResearchers() {}
    // REPORTE: (Brian): Los temas de investigación con más investigadores
    public ArrayList<ResearchMatter> trendingMatter() {}
    // REPORTE: (Brian): La mayor cantidad de artículos publicado por un mismo investigador
    public int mostPaperPublished() {}
    
    // REPORTE: (Aleksander): Los profesores que tienen los créditos necesarios para aprobar su maestría
    public ArrayList<Profesor> profesorsWithMasteryReady() {}
    // REPORTE: (Aleksander): Los mayor cantidad de cursos que imparte un profesor
    public int mostCoursesByOneInstructor() {}
    // Añadir más reportes relacionados a los cursos de considerar necesario
}