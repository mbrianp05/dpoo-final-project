package schooling;

import utils.Validation;

public class Chapter extends Breakthrough implements HasUniqueIndentifier {
    private String title;
    private String[] authors;
    private String[] editors;
    private String editorial;
    private String ISSN;
    private String bookName;
    private int volume;

    private final static int score = 3;

    public Chapter(String title, String[] authors, String[] editors, String editorial, String ISSN, String bookName,
            int volume) {
        setTitle(title);
        setAuthors(authors);
        setEditors(editors);
        setEditorial(editorial);
        setISSN(ISSN);
        setBookName(bookName);
        setVolume(volume);
    }

    public int getScore() {
        return score;
    }

    public void setTitle(String title) {
        if (!Validation.notEmpty(title)) {
            throw new IllegalArgumentException("Book chapter title cannot be empty");
        }

        this.title = title;
    }

    public void setAuthors(String[] authors) {
        if (authors.length == 0) {
            throw new IllegalArgumentException("Book has at least one author");
        }

        for (String author: authors) {
        	if (!Validation.notEmpty(author)) throw new IllegalArgumentException("Author name cannot be empty");
        }
        
        this.authors = authors;
    }

    public void setBookName(String bookName) {
        if (!Validation.notEmpty(bookName)) {
            throw new IllegalArgumentException("Book title cannot be empty");
        }

        this.bookName = bookName;
    }

    public void setVolume(int volume) {
        if (volume < 0) {
            throw new IllegalArgumentException("Volume cannot be a negative number or 0");
        }

        this.volume = volume;
    }

    public void setEditorial(String editorial) {
        if (!Validation.notEmpty(editorial)) {
            throw new IllegalArgumentException("Editorial cannot be empty");
        }

        this.editorial = editorial;
    }

    public void setEditors(String[] editors) {
        if (editors.length == 0) {
            throw new IllegalArgumentException("Book has at leat one editor");
        }

        for (String editor: editors) {
        	if (!Validation.notEmpty(editor)) throw new IllegalArgumentException("Editors cannot be empty");
        }
        
        this.editors = editors;
    }

    public void setISSN(String ISSN) {
        if (!Validation.notEmpty(ISSN)) {
            throw new IllegalArgumentException("ISSN cannot be empty");
        }

        if (!Validation.unique("ISSN", ISSN)) {
        	throw new IllegalArgumentException("ISSN code cannot be repeated");
        }
        
        if (!Validation.validISSN(ISSN)) {
            throw new IllegalArgumentException("ISSN should have the shape ISSN DDDD-DDDD");
        }

        this.ISSN = ISSN;
    }

    public String getTitle() {
        return title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public String[] getEditors() {
        return editors;
    }

    public String getISSN() {
        return ISSN;
    }

    public String getBookName() {
        return bookName;
    }

    public String getEditorial() {
        return editorial;
    }

    public int getVolume() {
        return volume;
    }

	@Override
	public String getId() {
		return ISSN;
	}

	@Override
	public String getName() {
		return title;
	}

	public boolean isAuthor(String name) {
		boolean found = false;
		int i = 0;
		
		while (!found && i < authors.length) {
			found = authors[i].equals(name);
			i++;
		}

		return found;
	}

	public boolean isEditor(String name) {
		boolean found = false;
		int i = 0;
		
		while (!found && i < authors.length) {
			found = editors[i].equals(name);
			i++;
		}

		return found;
	}
}