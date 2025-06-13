package schooling;

public class Matriculation {
    private Profesor profesor;
    private PostgraduateCourse course;
    private int mark = -1;

    public Matriculation(Profesor profesor, PostgraduateCourse course) {
        setProfesor(profesor);
        setCourse(course);
    }

    public void noMarkYet() {
    	mark = -1;
    }
    
    public void setMark(int mark) {
    	if (mark > 5 || mark < 2) throw new IllegalArgumentException("La nota v�lida est� entre 2 y 5");
    	
    	this.mark = mark;
    }
    
    public int getMark() {
    	return mark;
    }
    
    public boolean hasMark() {
    	return mark != -1;
    }
    
    public void setProfesor(Profesor profesor) {
        if (profesor.getDegree() != null)
            throw new IllegalArgumentException(
                    "Los profesores con maestr�a o con doctorados no pueden recibir cursos de maestr�a");

        this.profesor = profesor;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setCourse(PostgraduateCourse course) {
        this.course = course;
    }

    public PostgraduateCourse getCourse() {
        return course;
    }
}