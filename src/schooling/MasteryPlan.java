package schooling;

import java.util.ArrayList;

public class MasteryPlan {
	private ArrayList<Matriculation> matriculations;
	private ArrayList<PostgraduateCourse> courses;

	public MasteryPlan() {
		matriculations = new ArrayList<>();
		courses = new ArrayList<>();
	}

	public ArrayList<Profesor> getMatriculatedProfesors() {
		ArrayList<Profesor> profesors = new ArrayList<>();
		
		for (Matriculation m: matriculations) {
			if (!profesors.contains(m.getProfesor())) {
				profesors.add(m.getProfesor());
			}
		}
		
		return profesors;
	}
	
	public void matriculate(Profesor profesor) {
		if (profesor.getDegree() != null) throw new IllegalArgumentException("Only profesors with no degree can recieve mastery plan courses");
	
		for (PostgraduateCourse c: getCourses()) {
			addMatriculation(profesor, c);
		}
	}
	
	public ArrayList<Matriculation> findMatriculations(Profesor profesor) {
		ArrayList<Matriculation> ms = new ArrayList<>();
		
		for (Matriculation m: matriculations) {
			if (m.getProfesor() == profesor) {
				ms.add(m);
			}
		}
		
		return ms;
	}
	
	public ArrayList<Matriculation> findMatriculations(PostgraduateCourse course) {
		ArrayList<Matriculation> ms = new ArrayList<>();
		
		for (Matriculation m: matriculations) {
			if (m.getCourse() == course) {
				ms.add(m);
			}
		}
		
		return ms;
	}
	
	private void addMatriculation(Profesor profesor, PostgraduateCourse course) {
		matriculations.add(new Matriculation(profesor, course));
	}

	public ArrayList<Matriculation> getMatriculations() {
		return matriculations;
	}

	public void addCourse(String name, String description, Profesor instructor, int credits) {
		courses.add(new PostgraduateCourse(name, description, instructor, credits));
	}

	public ArrayList<PostgraduateCourse> getCourses() {
		return courses;
	}

	public int getMinCredits() {
		int minCredits = 0;
		
		for (PostgraduateCourse course: courses) {
			minCredits += course.getCredits();
		}
		
		return minCredits;
	}

	public ArrayList<Profesor> getInvolvedPrfesors() {
		ArrayList<Profesor> profesors = new ArrayList<>();

		for (Matriculation matriculation : matriculations) {
			Profesor profesor = matriculation.getProfesor();

			if (!profesors.contains(profesor)) {
				profesors.add(profesor);
			}
		}

		return profesors;
	}

	public ArrayList<Profesor> profesorsToAproveMastery() {
		ArrayList<Profesor> profesors = new ArrayList<>();

		for (Profesor profesor : getInvolvedPrfesors()) {
			if (profesor.getCredits() == getMinCredits()) {
				profesors.add(profesor);
			}
		}

		return profesors;
	}

	public double progressMade(ArrayList<Matriculation> matriculations) {
		double coursesCompleted = 0;
		
		for (Matriculation m: matriculations) {
			if (m.getMark() >= 3) coursesCompleted++;
		}
		
		return coursesCompleted / Math.max(matriculations.size(), 1);
	}
	
	public void revertMatriculation(Profesor p) {
		p.setCredits(0);
		matriculations.removeAll(findMatriculations(p));
	}
}