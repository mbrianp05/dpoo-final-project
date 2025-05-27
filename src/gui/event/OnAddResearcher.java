package gui.event;

import schooling.Profesor;
import schooling.Student;

public interface OnAddResearcher {
	void addedStudent(Student student);
	void addedProfesor(Profesor profesor, String matter);
}
