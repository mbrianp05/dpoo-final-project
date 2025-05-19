public class Matriculation {
    private Profesor profesor;
    private PostgraduateCourse course;

    public Matriculation(Profesor profesor, PostgraduateCourse course) {
        setProfesor(profesor);
        setCourse(course);
    }

    public void setProfesor(Profesor profesor) {
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