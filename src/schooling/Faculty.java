package schooling;

import java.util.ArrayList;

public class Faculty {
	private ArrayList<ResearchLine> researchLines;
	private ArrayList<Researcher> researchers;

	private static Faculty instance = null;

	public static Faculty newInstance() {
		if (instance == null){
			instance = new Faculty();
		}

		return instance;
	}

	private Faculty() {
		researchers = new ArrayList<>();
		researchLines = new ArrayList<>();
	}

	public int addProfesor(String name, Degree degree, ProfesorCategory cat, String matterName) {
		Profesor profesor = new Profesor(name, degree, cat);
		this.researchers.add(profesor);

		ResearchMatter matter = findResearchMatter(matterName);
		if (matter != null) matter.addResearcher(profesor);

		return profesor.getID();
	}

	public int addStudent(String name, String matterName) {
		Student student = new Student(name);
		researchers.add(student);

		ResearchMatter matter = findResearchMatter(matterName);
		if (matter != null) matter.addResearcher(student);

		return student.getID();
	}

	public String addResearchLine(String name, Profesor chief, int credits) {
		researchLines.add(new ResearchLine(name, chief, credits));

		return name;
	}

	public ArrayList<ResearchLine> getReseachLines() {
		return researchLines;
	}

	public ArrayList<Researcher> getResearchers() {
		return researchers;
	}

	public ArrayList<Profesor> getProfesors() {
		ArrayList<Profesor> profesors = new ArrayList<>();

		for (Researcher r : researchers) {
			if (r instanceof Profesor) {
				profesors.add((Profesor) r);
			}
		}

		return profesors;
	}
	
	public ArrayList<Profesor> getProfesorsWithDegree(Degree degree) {
		ArrayList<Profesor> profs = new ArrayList<>();
		
		for(Profesor p: getProfesors()){
			if (p.getDegree() != null && p.getDegree() == degree) {
				profs.add(p);
			}
		}
		
		return profs;
	}

	public ArrayList<String> getResearchMattersNames() {
		ArrayList<String> matters = new ArrayList<>();

		for (ResearchLine line: researchLines) {
			for (ResearchMatter matter: line.getMatters()) {
				matters.add(matter.getName());
			}
		}

		return matters;
	}

	public ResearchMatter findMatterOf(int ID) {
		ResearchMatter matter = null;

		for (ResearchLine line: researchLines) {
			for (ResearchMatter m: line.getMatters()) {
				for (Researcher researcher: m.getResearchers()) {
					if (researcher.getID() == ID) {
						matter = m;
					}
				}
			}
		}

		return matter;
	}

	public ResearchMatter findResearchMatter(String name) {
		ResearchMatter matter = null;

		int i = 0;
		while (matter == null && i < researchLines.size()) {
			ResearchLine line = researchLines.get(i);

			int j = 0;
			while (matter == null && j < line.getMatters().size()) {
				if (line.getMatters().get(j).getName().equals(name)) {
					matter = line.getMatters().get(j);
				}

				j++;
			}

			i++;
		}

		return matter;
	}

	public Researcher findResearcher(int ID) {
		Researcher r = null;

		int i = 0;
		while (r == null && i < researchers.size()) {
			if (researchers.get(i).getID() == ID) {
				r = researchers.get(i);
			}
			i++;
		}

		return r;
	}

	public ResearchLine findResearchLine(String name) {
		ResearchLine r = null;

		int i = 0;
		while (r == null && i < researchLines.size()) {
			if (researchLines.get(i).getName().equals(name)) {
				r = researchLines.get(i);
			}
			i++;
		}

		return r;
	}

	public ArrayList<Researcher> bestResearchers() {
		ArrayList<Researcher> researchers = new ArrayList<>();
		int highestScore = Integer.MIN_VALUE;

		for (Researcher r : getResearchers()) {
			int score = r.getScore();

			if (score > highestScore) {
				highestScore = score;
				researchers.clear();
			}

			if (score == highestScore) {
				researchers.add(r);
			}
		}

		return researchers;
	}

	// REPORTE 2: (Brian): Los temas de investigaci�n con m�s investigadores
	public ArrayList<ResearchMatter> trendingMatters() {
		ArrayList<ResearchMatter> matters = new ArrayList<>();
		int mostResearchers = -1;

		for (ResearchLine line : researchLines) {
			for (ResearchMatter matter : line.getMatters()) {
				int researchersCount = matter.getResearchers().size();

				if (researchersCount > mostResearchers) {
					mostResearchers = researchersCount;
					matters.clear();
				}

				if (researchersCount == mostResearchers) {
					matters.add(matter);
				}
			}
		}

		return matters;
	}

	// REPORTE 3: (Brian): La mayor cantidad de art�culos publicado por un mismo
	// investigador
	public int mostPaperPublished() {
		int highest = 0;

		for (Researcher r : researchers) {
			if (r.getPapers().size() > highest) {
				highest = r.getPapers().size();
			}
		}

		return highest;
	}

	// REPORTE 4: (Aleksandr): Los profesores que tienen los cr�ditos necesarios
	// para aprobar su maestr�a
	public ArrayList<Profesor> pendingAprovals() {
		ArrayList<Profesor> aprovalPendings = new ArrayList<>();

		for (ResearchLine line : researchLines) {
			aprovalPendings.addAll(line.getMasteryPlan().profesorsToAproveMastery());
		}

		return aprovalPendings;
	}

	// REPORTE 5: (Aleksandr): Total de cursos de postgrado proporcionados por el
	// vicedecanato
	public int totalPostgradeCourses() {
		int total = 0;

		for (ResearchLine line : researchLines) {
			MasteryPlan plan = line.getMasteryPlan();

			if (plan != null)
				total += plan.getCourses().size();
		}

		return total;
	}

	private ArrayList<Matriculation> getMatriculationsOf(int ID) {
		ArrayList<Matriculation> matriculations = new ArrayList<>();

		for (ResearchLine l: researchLines) {
			for (Matriculation m: l.getMasteryPlan().getMatriculations()) {
				if (m.getProfesor().getID() == ID) {
					matriculations.add(m);
				}
			}
		}

		return matriculations;
	}

	private double getAverageMarksOf(int ID) {
		Researcher r = findResearcher(ID);

		if (r == null || !(r instanceof Profesor)) {
			throw new IllegalArgumentException("Researcher with ID " + ID + " either doesn't exits or its not a profesor");
		}

		int total = 0;
		ArrayList<Matriculation> matriculations = getMatriculationsOf(r.getID());

		for (Matriculation m: matriculations) {
			total += m.getMark();
		}

		return total / (double)Math.max(1, matriculations.size());
	}


	// Reporte 6: (Aleksandr): Los profesores con mejor promedio de notas
	public ArrayList<Profesor> profesorsWithBestAverage() {
		ArrayList<Profesor> profesors = new ArrayList<>();
		double max = Double.MIN_VALUE;

		for (Profesor p: getProfesors()) {
			double avg = getAverageMarksOf(p.getID());

			if (avg > max) {
				max = avg;
				profesors.clear();
			}

			if (avg == max) {
				profesors.add(p);
			}
		}

		return profesors;
	}

	public ArrayList<PostgraduateCourse> getCoursesList () {
		ArrayList<PostgraduateCourse> courses = new ArrayList<>();

		for(ResearchLine r: getReseachLines()){
			MasteryPlan p = r.getMasteryPlan();
			for(PostgraduateCourse c: p.getCourses()){
				courses.add(c);
			}
		}
		return courses;
	}

	public PostgraduateCourse findCourseByName (String name) {
		PostgraduateCourse course = null;
		
		for (MasteryPlan m: getMasteryPlans()) {
			for(PostgraduateCourse p: m.getCourses()) {
				if(name.equalsIgnoreCase(p.getName())) {
					course = p;
				}
			}
		}
		return course;
	}
	
	// Cambia de materia de investigacion a un investigador
	public void moveToOtherMatter(int ID, String newMatterName) {
		ResearchMatter newMatter = findResearchMatter(newMatterName);

		if (newMatter == null) {
			throw new IllegalArgumentException("No matter with name " + newMatterName + " exists");
		}

		Researcher r = findResearcher(ID);
		ResearchMatter matter = findMatterOf(ID);

		newMatter.addResearcher(r);

		if (matter != null) 
			matter.getResearchers().remove(r);
	}

	public ResearchLine findResearchLine(Profesor profesor) {
		ResearchLine line = null;
		int i = 0;

		while (line == null && i < researchLines.size()) {
			if (researchLines.get(i).getChief() == profesor) line = researchLines.get(i);

			i++;
		}

		return line;
	}
	
	public ArrayList<MasteryPlan> getMasteryPlans() {
		ArrayList<MasteryPlan> masteries = new ArrayList<>();
		
		for(ResearchLine r: researchLines) {
			masteries.add(r.getMasteryPlan());
		}
		
		return masteries;
	}

	public boolean isChief(Profesor profesor) {
		boolean found = false;
		int i = 0;

		while (!found && i < researchLines.size()) {
			found = researchLines.get(i).getChief() == profesor;

			i++;
		}

		return found;
	}

	public ResearchLine findReseachLineByChief(Profesor researcher) {
		ResearchLine line = null;
		int i = 0;
		
		while (line == null && i < researchLines.size()) {
			if (researchLines.get(i).getChief() == researcher) line = researchLines.get(i);
			
			i++;
		}
		
		return line;
	}

	public ArrayList<Breakthrough> getBreakthroughs() {
		ArrayList<Breakthrough> breakthroughs = new ArrayList<>();
	
		for (Researcher r: researchers) {
			breakthroughs.addAll(r.getBreakthroughs());
		}
		
		return breakthroughs;
	}
	
	public Researcher findResearcherByBreakthrough(Breakthrough breakthrough) throws Exception {
		Researcher r = null;
		int i = 0;
		
		while (r == null && i < researchers.size()) {
			if (researchers.get(i).getBreakthroughs().contains(breakthrough)) {
				r = researchers.get(i);
			}
			
			i++;
		}
		
		if (r == null) {
			throw new Exception("There is a registered breakthrough by a non-existant researcher");
		}
		
		return r;
	}
}