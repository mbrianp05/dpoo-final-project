package schooling;

import utils.Validation;

public class PostgraduateCourse {
	private String name;
	private String description;
	private Profesor instructor;
	private int credits;

	public PostgraduateCourse(String name, String description, Profesor instructor, int credits) {
		setName(name);
		setDescription(description);
		setInstructor(instructor);
		setCredits(credits);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!Validation.notEmpty(name))
			throw new IllegalArgumentException("Course name cannot be empty");

		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (!Validation.notEmpty(description))
			throw new IllegalArgumentException("Description cannot be empty");

		this.description = description;
	}

	public Profesor getInstructor() {
		return instructor;
	}

	public void setInstructor(Profesor instructor) {
		if (instructor.getDegree() != null && instructor.getDegree() != Degree.Doctor)
			throw new IllegalArgumentException("Only profesors with doctor degree can be instructors of courses");

		this.instructor = instructor;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		if (credits < 1)
			throw new IllegalArgumentException("Courses give at least one credit");

		this.credits = credits;
	}
}