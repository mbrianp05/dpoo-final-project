import java.util.ArrayList;
import java.util.Date;

public abstract class Researcher {
	protected int score;
	protected String name;

    protected ArrayList<ScorableBreakthrough> breakthoughs;

	// Propiedad comodin para hacer que el ID sea autoincremental
	protected static int lastID = 1;

	// Le puse un ID al profesor/estudiante para poder buscarlo en la facultad despues
	private final int ID;
	// Le puse un nombre tambien porque en la interfaz sera raro no tener los nombres
	// Tipo profesor 4 en vez de ver tipo Alejandro Garcia

	public Researcher(String name) {
		ID = lastID;
		lastID++;

		breakthoughs = new ArrayList<ScorableBreakthrough>();
	}

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
        Paper paper = new Paper(title, no, volume, year, group);
        breakthoughs.add(paper);

        score += paper.getScore();
	}

	public void addPresentation(String name, Date date, String ISBN, String location) {
		Presentation presentation = new Presentation(name, date, ISBN, location);
        breakthoughs.add(presentation);

        score += presentation.getScore();
	}

	public void addBookChapter(String title, ArrayList<String> authors, ArrayList<String> editors, String editorial, String ISSN, String bookName, int volume) {
        Chapter chapter = new Chapter(title, authors, editors, editorial, ISSN, bookName, volume);
        breakthoughs.add(chapter);

        score += chapter.getScore();
	}

	public ArrayList<Paper> getPapers() {
        ArrayList<Paper> papers = new ArrayList<Paper>();

        for (ScorableBreakthrough b: breakthoughs) {
            if (b instanceof Paper) {
                papers.add((Paper)b);
            }
        }

		return papers;
	}

	public ArrayList<Presentation> getPresentations() {
        ArrayList<Presentation> presentations = new ArrayList<Presentation>();

        for (ScorableBreakthrough b: breakthoughs) {
            if (b instanceof Presentation) {
                presentations.add((Presentation)b);
            }
        }

		return presentations;
	}

	public ArrayList<Chapter> getBookChapter() {
        ArrayList<Chapter> chapters = new ArrayList<Chapter>();

        for (ScorableBreakthrough b: breakthoughs) {
            if (b instanceof Chapter) {
                chapters.add((Chapter)b);
            }
        }

		return chapters;
	}

	public int getID() {
		return ID;
	}
}