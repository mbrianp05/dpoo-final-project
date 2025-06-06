package gui.event;

import schooling.Degree;
import schooling.ProfesorCategory;

public interface OnAddedProfesor {
	void newProfesor(String name, Degree degree, ProfesorCategory category, String matter);
}
