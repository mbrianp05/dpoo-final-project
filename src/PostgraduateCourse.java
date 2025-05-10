import java.util.ArrayList;

public class PostgraduateCourse {
    private String topic;
    // Le puse descripción en vez de objetivos que me parece un nombre
    // más intuitivo
    private String description;
    private Profesor instructor;
    
    // Necesimatos una propiedad para saber cuántos créditos aporta el curso
    private int credits;

    private ArrayList<Profesor> profesors;

    public void emitirNota() {}
    public void giveCredits() {}
}