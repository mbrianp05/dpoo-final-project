package schooling;

import java.util.ArrayList;

public class MasteryPlan {
	private int minCredits;

	private ArrayList<Matriculation> matriculations;
	private ArrayList<PostgraduateCourse> courses;

	public MasteryPlan() {
		matriculations = new ArrayList<>();
		courses = new ArrayList<>();
	}

	public void addMatriculation(Profesor profesor, PostgraduateCourse course) {
		matriculations.add(new Matriculation(profesor, course));
	}

	public ArrayList<Matriculation> getMatriculations() {
		return matriculations;
	}

	public void addCourse(String name, String description, Profesor instructor, int credits) {
		courses.add(new PostgraduateCourse(name, description, instructor, credits));
		minCredits += credits;
	}

	public ArrayList<PostgraduateCourse> getCourses() {
		return courses;
	}

	public int getMinCredits() {
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
			if (profesor.getCredits() >= minCredits) {
				profesors.add(profesor);
			}
		}

		return profesors;
	}

	public void substractNecessaryCredits(int credits) {
		if (credits > minCredits) throw new IllegalArgumentException("Cannot substract a higher amount of credits than there is now");
		
		minCredits -= credits;
	}
}