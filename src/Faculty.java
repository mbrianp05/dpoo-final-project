import java.util.ArrayList;

public class Faculty {
	private ArrayList<ResearchLine> researchLines;
	private ArrayList<Researcher> researchers;

	// Método para filtrar a los profesores de los investigadores
	public ArrayList<Profesor> getProfesors() {
		ArrayList<Profesor> profesors = new ArrayList<Profesor>();

		for (Researcher r: researchers) {
			if (r instanceof Profesor) {
				profesors.add((Profesor)r);
			}
		}

		return profesors;
	}

	// REPORTE 1: (Brian): Los investigadores con más puntos por ponencias/capítulos/artículos
	public ArrayList<Researcher> bestResearchers() {}
	// REPORTE 2: (Brian): Los temas de investigación con más investigadores
	public ArrayList<ResearchMatter> trendingMatter() {}
	// REPORTE 3: (Brian): La mayor cantidad de artículos publicado por un mismo investigador
	public int mostPaperPublished() {}

	// REPORTE 4: (Aleksandr): Los profesores que tienen los créditos necesarios para aprobar su maestría
	public ArrayList<Profesor> profesorsWithMasteryReady() {

		ArrayList<Profesor> ready = new ArrayList<Profesor>();


		for(ResearchLine rl: researchLines){
			for(MasteryPlan mp: rl.getMastPlans()){
				for(PostgraduateCourse pc: mp.getCourses()){
					for(Profesor p: pc.getProfesors()){

						if(p.getCredits() >= mp.getMinCredit()){
							ready.add(p);
						}
					}
				}
			}
		}

		return ready;
	}
	// REPORTE 5: (Aleksandr): Total de cursos de postgrado proporcionados por el vicedecanato
	public int totalPostgradeCourses() {

		int total = 0;

		for(ResearchLine r: researchLines){
			for(MasteryPlan m: r.getMastPlans()){
				total += m.getCourses().size();
			}
		}
		return total;
	}
	// Añadir más reportes relacionados a los cursos de considerar necesario
}