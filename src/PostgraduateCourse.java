import java.util.ArrayList;

public class PostgraduateCourse {
    private String topic;
    // Le puse descripci�n en vez de objetivos que me parece un nombre
    // m�s intuitivo
    private String description;
    private Profesor instructor;
    
    // Necesimatos una propiedad para saber cu�ntos cr�ditos aporta el curso
    private int credits;

    private ArrayList<Profesor> profesors;

    public void emitirNota() {}
    public void giveCredits() {}
}