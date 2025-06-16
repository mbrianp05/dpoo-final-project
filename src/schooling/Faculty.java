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
	
	public int linesWithAtLeastOneInstructorCandidate() {
		int count = 0;
		
		for (ResearchLine l: researchLines) {
			if(l.getRelatedDoctors().size() > 0) {
				count++;
			}
		}

		return count;
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

	public String addResearchLine(String name, Profesor chief) {
		researchLines.add(new ResearchLine(name, chief));

		return name;
	}

	public ArrayList<ResearchLine> getResearchLines() {
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

	public ArrayList<Profesor> getDoctorsSelectedLine(ResearchLine line) {
		return line.getRelatedDoctors();
	}

	public ResearchLine findResearchLineByCourse(PostgraduateCourse course) {
		ResearchLine line = null;

		for(ResearchLine r: researchLines) {
			if(r.getMasteryPlan().getCourses().contains(course)) {
				line = r;
			}
		}

		return line;
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

	// REPORTE 2: (Brian): Los temas de investigaciï¿½n con mï¿½s investigadores
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

	// REPORTE 3: (Brian): La mayor cantidad de artï¿½culos publicado por un mismo
	// investigador
	public ArrayList<Researcher> mostPaperPublished() {
		ArrayList<Researcher> result = new ArrayList<>();
		int highest = 0;

		for (Researcher r : researchers) {
			if (r.getPapers().size() > highest) {
				highest = r.getPapers().size();
				result.clear();
			}

			if (r.getPapers().size() == highest) {
				result.add(r);
			}
		}

		return result;
	}

	// REPORTE 4: (Aleksandr): Los profesores que tienen los crï¿½ditos necesarios
	// para aprobar su maestrï¿½a
	public ArrayList<Profesor> pendingAprovals() {
		ArrayList<Profesor> aprovalPendings = new ArrayList<>();

		for (ResearchLine line : researchLines) {
			aprovalPendings.addAll(line.getMasteryPlan().profesorsToAproveMastery());
		}

		return aprovalPendings;
	}

	// REPORTE 5: (Aleksandr): Maestrias con la mayor matrícula
	public ArrayList<ResearchLine> trendingMasteryPlans() {
		ArrayList<ResearchLine> best = new ArrayList<>();
		int mayorMatric = 0;

		for(ResearchLine r: researchLines) {
			if(r.getMasteryPlan().getMatriculations().size() > mayorMatric) {
				best.clear();
				mayorMatric = r.getMasteryPlan().getMatriculations().size();
				best.add(r);
			} else {
				if(r.getMasteryPlan().getMatriculations().size() == mayorMatric) {
					best.add(r);
				}
			}
		}
		return best;
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

	public double getAverageMarksOf(int ID) {
		Researcher r = findResearcher(ID);

		if (r == null || !(r instanceof Profesor)) {
			throw new IllegalArgumentException("Researcher with ID " + ID + " either doesn't exits or its not a profesor");
		}

		int total = 0;
		int counter = 0;
		ArrayList<Matriculation> matriculations = getMatriculationsOf(r.getID());

		for (Matriculation m: matriculations) {
			if (m.hasMark()) {
				total += m.getMark();
				counter++;
			}
		}

		return (double)total / Math.max(1, counter);
	}

	public ArrayList<PostgraduateCourse> getCoursesList () {
		ArrayList<PostgraduateCourse> courses = new ArrayList<>();

		for(ResearchLine r: getResearchLines()){
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

	public ResearchLine findResearchLineByChief(Profesor researcher) {
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

	public boolean canRemoveResearcher(int id) {
		boolean canBeRemoved = true;
		Researcher researcher = findResearcher(id);
		
		if (researcher instanceof Profesor) {
			canBeRemoved = !isChief((Profesor)researcher) && !isInstructor((Profesor)researcher);
		}
		
		return canBeRemoved;
	}
	
	public boolean removeResearcher(int id) {
		Researcher researcher = findResearcher(id);

		if (researcher == null) throw new IllegalArgumentException("Researcher with ID " + id + " does not exist");
		boolean canBeRemoved = canRemoveResearcher(id);

		if (canBeRemoved) {
			ResearchMatter matter = findMatterOf(id);
			matter.getResearchers().remove(researcher);

			if (researcher instanceof Profesor) {
				ResearchLine line = findResearchLineByMatter(matter);
				line.getMasteryPlan().revertMatriculation((Profesor)researcher);
			}
			
			researchers.remove(researcher);
		}

		return canBeRemoved;
	}

	public boolean removeCourseFromLine(String name) {
		PostgraduateCourse course = findCourseByName(name);
		ResearchLine line = findResearchLineByCourse(course);

		boolean removible = true;

		if(line.getMasteryPlan().getCourses().contains(course)) {
			// Cuando se elimina el curso hay restarle los créditos
			// que aportaba el curso a los que habían aprobado
			for (Matriculation m: line.getMasteryPlan().getMatriculations()) {
				if (m.getCourse() == course && m.hasMark() && m.getMark() >= 3) {
					Profesor p = m.getProfesor();
					p.setCredits(p.getCredits() - course.getCredits());
				}
			}
			
			line.getMasteryPlan().getCourses().remove(course);
		} else {
			removible = false;
		}

		return removible;
	}

	public ArrayList<Matriculation> getMatriculationsAtCourse(PostgraduateCourse course) {
		MasteryPlan plan = findResearchLineByCourse(course).getMasteryPlan();

		return plan.findMatriculations(course);
	}

	public boolean isInstructor(Profesor profesor) {
		boolean result = false;
		int i = 0;

		while (!result && i < researchLines.size()) {
			ArrayList<PostgraduateCourse> courses = researchLines.get(i).getMasteryPlan().getCourses();
			int k = 0;

			while (!result && k < courses.size()) {
				result = courses.get(k).getInstructor() == profesor;

				k++;
			}

			i++;
		}

		return result;
	}

	public ResearchLine findResearchLineByMatter(ResearchMatter m) {
		ResearchLine line = null;
		int i = 0;
		
		while (line == null && i < researchLines.size()){
			if (researchLines.get(i).getMatters().contains(m)) line = researchLines.get(i);
			i++;
		}
		
		return line;
	}

	public ResearchLine findResearchLineByResearcher(Researcher researcher) {
		ResearchLine line = null;
		int i = 0;
		
		while(line == null && i < researchLines.size()) {
			if (researchLines.get(i).hasResearcher(researcher)) line = researchLines.get(i);
			
			i++;
		}
		
		return line;
	}
}