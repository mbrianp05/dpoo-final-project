package schooling;

public class Chapter implements ScorableBreakthrough {
    private String title;
    private String[] authors;
    private String[] editors;
    private String editorial;
    private String ISSN;
    private String bookName;
    private int volume;

    private final static int score = 3;

    public Chapter(String title, String[] authors, String[] editors, String editorial, String ISSN, String bookName, int volume) {
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
        if (title.trim().isEmpty()) {
            throw new IllegalArgumentException("El título del capítulo no puede estar vacío");
        }

        this.title = title;
    }

    public void setAuthors(String[] authors) {
        if (authors.length == 0) {
            throw new IllegalArgumentException("El capítulo no tiene autores");
        }

        this.authors = authors;
    }

    public void setBookName(String bookName) {
        if (bookName.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del libro no puede estar vacío");
        }

        this.bookName = bookName;
    }

    public void setVolume(int volume) {
        if (volume < 0) {
            throw new IllegalArgumentException("El volumen del libro no puede ser negativo");
        }

        this.volume = volume;
    }

    public void setEditorial(String editorial) {
        if (editorial.trim().isEmpty()) {
            throw new IllegalArgumentException("El editorial del libro no puede estar vacío");
        }

        this.editorial = editorial;
    }

    public void setEditors(String[] editors) {
        if (editors.length == 0) {
            throw new IllegalArgumentException("El libro no tiene editores");
        }

        this.editors = editors;
    }

    // Hay que investigar si el ISSN tiene una validaci�n espec�fica
    public void setISSN(String ISSN) {
        if (ISSN.trim().isEmpty()) {
            throw new IllegalArgumentException("El ISSN del libro no puede estar vacío");
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
}