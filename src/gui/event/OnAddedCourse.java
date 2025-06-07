package gui.event;

import schooling.Profesor;

public interface OnAddedCourse {
	void added(String name, String descrip, Profesor instruct, int credits);
}
