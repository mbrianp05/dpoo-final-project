package gui.reasearchline;

import schooling.PostgraduateCourse;
import schooling.Profesor;

public final class CourseFormData {
	private String name;
	private	String description;
	private Profesor instructor;
	private int credits;

	public CourseFormData (String name, String description, Profesor instructor, int credits) {
		this.name = name;
		this.description = description;
		this.instructor = instructor;
		this.credits = credits;
	}
	
	public static CourseFormData courseForm(PostgraduateCourse course) {
		return new CourseFormData(course.getName(), course.getDescription(), course.getInstructor(), course.getCredits());
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Profesor getInstructor() {
		return instructor;
	}
	
	public int getCredits() {
		return credits;
	}
	
}
