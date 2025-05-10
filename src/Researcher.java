import java.util.ArrayList;
import java.util.Date;

public abstract class Researcher {
    protected int score;

    protected ArrayList<Paper> papers;
    protected ArrayList<Chapter> chapters;
    protected ArrayList<Presentation> presentations;

    // Propiedad comodín para hacer que el ID sea autoincremental
    protected static int lastID = 1;

    // Le puse un ID al profesor/estudiante para poder buscarlo en la facultad después
    private final int ID;
    // Le puse un nombre también porque en la interfaz sería raro no tener los nombres
    // Tipo profesor 4 en vez de ver tipo Alejandro García
    protected String name;

    public Researcher(String name) {
        ID = lastID;
        lastID++;

        papers = new ArrayList<>();
        chapters = new ArrayList<>();
        presentations = new ArrayList<>();
    }

    // No puse un setScore porque la puntuación se aumentará directamente en los addArticle, addPresentation y addBookChapter
    public int getScore() {
        return score;
    }

    // Puse protegido el setName porque no quiero que el nombre del Profesor/Estudiante cambie, no tiene mucho sentido que cambie
    protected void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del investigador no debe estar vacío");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPaper(String title, int no, int volume, int year, TargetedGroup group) {
        papers.add(new Paper(title, no, volume, year, group));

        // Calcular la puntuación que da el artículo
        switch (group) {
            case Wos:
                score += 10;
                break;
            case Group1:
                score += 8;
                break;
            case Group2:
                score += 6;
                break;
            case Group3:
            case Group4:
                score += 4;
                break;
        }
    }

    public void addPresentation(String name, Date date, String ISBN, String location) {
        presentations.add(new Presentation(name, date, ISBN, location));

        score += 1;
    }

    public void addBookChapter(String title, ArrayList<String> authors, ArrayList<String> editors, String editorial, String ISSN, String bookName, int volume) {
        chapters.add(new Chapter(title, authors, editors, editorial, ISSN, bookName, volume));

        score += 3;
    }

    public ArrayList<Paper> getPapers() {
        return papers;
    }

    public ArrayList<Presentation> getPresentations() {
        return presentations;
    }

    public ArrayList<Chapter> getBookChapter() {
        return chapters;
    }
}