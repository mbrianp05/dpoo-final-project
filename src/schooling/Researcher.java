package schooling;

import java.time.LocalDate;
import java.util.ArrayList;

import utils.Validation;

public abstract class Researcher {
	protected String name;
	protected ArrayList<Breakthrough> breakthroughs;

	// ID autoincremental
	protected static int lastID = 1;
	protected final int ID;

	protected int score;

	public Researcher(String name) {
		ID = lastID;
		lastID++;

		score = 0;
		breakthroughs = new ArrayList<>();

		setName(name);
	}

	public int getScore() {
		return score;
	}

	public void setName(String name) {
		if (!Validation.notEmpty(name)) {
			throw new IllegalArgumentException("Researcher's name cannot be empty");
		}
		
		if (!Validation.validName(name)) {
			throw new IllegalArgumentException("Researcher's name cannot contain numbers or symbols");
		}

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void removeBreakthrough(Breakthrough breakthrough) {
		score -= breakthrough.getScore();
		breakthroughs.remove(breakthrough);

		if (breakthrough instanceof Chapter)
			Validation.removeValue("ISSN", ((Chapter) breakthrough).getISSN());
		if (breakthrough instanceof Presentation)
			Validation.removeValue("ISBN", ((Presentation) breakthrough).getISBN());
	}

	public void addPaper(String title, int no, int volume, int year, TargetedGroup group) {
		Paper paper = new Paper(title, no, volume, year, group);
		breakthroughs.add(paper);

		score += paper.getScore();
	}

	public void addPresentation(String name, LocalDate date, String ISBN, String location) {
		Presentation presentation = new Presentation(name, date, ISBN, location);
		breakthroughs.add(presentation);

		score += presentation.getScore();
	}

	public void addBookChapter(String title, String[] authors, String[] editors, String editorial, String ISSN,
			String bookName, int volume) {
		Chapter chapter = new Chapter(title, authors, editors, editorial, ISSN, bookName, volume);
		breakthroughs.add(chapter);

		score += chapter.getScore();
	}

	public ArrayList<Paper> getPapers() {
		ArrayList<Paper> papers = new ArrayList<Paper>();

		for (Breakthrough b : breakthroughs) {
			if (b instanceof Paper) {
				papers.add((Paper) b);
			}
		}

		return papers;
	}

	public ArrayList<Presentation> getPresentations() {
		ArrayList<Presentation> presentations = new ArrayList<Presentation>();

		for (Breakthrough b : breakthroughs) {
			if (b instanceof Presentation) {
				presentations.add((Presentation) b);
			}
		}

		return presentations;
	}

	public ArrayList<Chapter> getBookChapter() {
		ArrayList<Chapter> chapters = new ArrayList<Chapter>();

		for (Breakthrough b : breakthroughs) {
			if (b instanceof Chapter) {
				chapters.add((Chapter) b);
			}
		}

		return chapters;
	}

	public int getID() {
		return ID;
	}

	public ArrayList<Breakthrough> getBreakthroughs() {
		return breakthroughs;
	}
}