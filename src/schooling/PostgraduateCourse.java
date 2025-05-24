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
		if (!Validation.notEmpty(name)) throw new IllegalArgumentException("El nombre del curso no puede estar vacío");
		
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		if (!Validation.notEmpty(description)) throw new IllegalArgumentException("La descripción del curso no puede estar vacío");
		
		this.description = description;
	}

	public Profesor getInstructor() {
		return instructor;
	}

	public void setInstructor(Profesor instructor) {
		if (instructor.getDegree() != Degree.Doctor) throw new IllegalArgumentException("Solo los profesores con categoría Doctor pueden impartir cursos de postgrado");
		
		this.instructor = instructor;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		if (credits < 1) throw new IllegalArgumentException("El curso debe aportar al menos 1 crédito");
		
		this.credits = credits;
	}
}