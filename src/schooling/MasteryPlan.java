package schooling;

import java.util.ArrayList;

public class MasteryPlan {
	private int minCredits;

	private ArrayList<Matriculation> matriculations;
	private ArrayList<PostgraduateCourse> courses;

	public MasteryPlan(int minCredits) {
		setMinCredit(minCredits);

		matriculations = new ArrayList<>();
		courses = new ArrayList<PostgraduateCourse>();
	}

	public void addMatriculation(Profesor profesor, PostgraduateCourse course) {
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
		return minCredits;
	}

	public void setMinCredit(int minCredits) {
		if (minCredits < 1)
			throw new IllegalArgumentException("El cr�dito necesario tiene que ser mayor que 0");

		this.minCredits = minCredits;
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
		ArrayList<Profesor> profesors = getInvolvedPrfesors();

		for (Profesor profesor : profesors) {
			if (profesor.getCredits() < minCredits) {
				profesors.remove(profesor);
			}
		}

		return profesors;
	}
}