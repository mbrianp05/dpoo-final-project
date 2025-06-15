package schooling;

import java.util.ArrayList;

import utils.Validation;

public class ResearchLine {
	private String name;
	private Profesor chief;
	private MasteryPlan masteryPlan;
	private ArrayList<ResearchMatter> matters;

	public ResearchLine(String name, Profesor chief) {
		setName(name);
		setChief(chief);

		masteryPlan = new MasteryPlan();
		matters = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!Validation.notEmpty(name))
			throw new IllegalArgumentException("El nombre no puede estar vac�o");

		this.name = name;
	}

	public Profesor getChief() {
		return chief;
	}

	public void setChief(Profesor chief) {
		this.chief = chief;
	}

	public void addMatter(String name) {
		matters.add(new ResearchMatter(name));
	}

	public MasteryPlan getMasteryPlan() {
		return masteryPlan;
	}

	public ArrayList<ResearchMatter> getMatters() {
		return matters;
	}
	
	public ArrayList<Profesor> getRelatedDoctors() {
		ArrayList<Profesor> doctors = new ArrayList<>();
		
		for(ResearchMatter r: matters) {
			for(Researcher res: r.getResearchers()) {
				if(res instanceof Profesor) {
					Profesor prof = (Profesor)res;
					
					if(prof.getDegree() == Degree.Doctor) {
						doctors.add(prof);
					}
				}
			}
		}
		
		return doctors;
	}
	
	public int getResearchersInvolvedCount() {
		int count = 0;
		
		for (ResearchMatter m: matters) {
			count += m.getResearchers().size();
		}
		
		return count;
	}

	public boolean hasResearcher() {
		return getResearchersInvolvedCount() == 0;
	}

	public ResearchMatter findMatter(String name) {
		ResearchMatter m = null;
		int i = 0;
		
		while(m == null && i < matters.size()) {
			if (matters.get(i).getName().equals(name)) {
				m = matters.get(i);
			}
			
			i++;
		}
		
		return m;
	}

	public ArrayList<Profesor> getProfesorsInvolved() {
		ArrayList<Profesor> profesors = new ArrayList<>();
		
		for (ResearchMatter m: matters) {
			for (Researcher r: m.getResearchers()) {
				if (r instanceof Profesor) {
					profesors.add((Profesor)r);
				}
			}
		}
		
		return profesors;
	}

	public ArrayList<Profesor> getMatriculableProfesors() {
		ArrayList<Profesor> profesors = new ArrayList<>();
	
		for (Profesor p: getProfesorsWithoutDegree()) {
			if (!hasMatriculation(p)) {
				profesors.add(p);
			}
		}
		
		return profesors;
	}
	
	public ArrayList<Profesor> getProfesorsWithoutDegree() {
		ArrayList<Profesor> profesors = new ArrayList<>();
		
		for (Profesor p: getProfesorsInvolved()) {
			if (p.getDegree() == null) profesors.add(p);
		}
		
		return profesors;
	}

	public void matriculate(Profesor profesor) {
		if (profesor.getDegree() != null) throw new IllegalArgumentException("Only profesors with no degree can recieve mastery plan courses");
	
		for (PostgraduateCourse c: getMasteryPlan().getCourses()) {
			masteryPlan.addMatriculation(profesor, c);
		}
	}

	public boolean hasMatriculation(Profesor p) {
		boolean result = false;
		int i = 0;
		
		while (!result && i < masteryPlan.getMatriculations().size()) {
			result = masteryPlan.getMatriculations().get(i).getProfesor() == p;
			
			i++;
		}
		
		return result;
	}
}