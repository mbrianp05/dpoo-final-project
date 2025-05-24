package schooling;

public class Matriculation {
    private Profesor profesor;
    private PostgraduateCourse course;

    public Matriculation(Profesor profesor, PostgraduateCourse course) {
        setProfesor(profesor);
        setCourse(course);
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