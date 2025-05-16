import java.util.Date;

public class Presentation implements ScorableBreakthrough {
    private String name;
    // Le quit� la propiedad a�o ya que como tamb�en tenia la propiedad fecha pues la fecha ya incluye el a�o
    // El objeto Date facilita la manipulaci�n y validaciones con fechas.
    private Date date;
    private String ISBN;
    private String location;

    private final static int score = 1;

    public Presentation(String name, Date date, String ISBN, String location) {
        setName(name);
        setDate(date);
        setISBN(ISBN);
        setLocation(location);
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la presentaci�n no puede estar vac�o");
        }

        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Hay que investigar si el ISBN tiene una validaci�n espec�fica
    public void setISBN(String ISBN) {
        if (ISBN.trim().isEmpty()) {
            throw new IllegalArgumentException("El ISBN de la presentaci�n no puede estar vac�o");
        }

        this.ISBN = ISBN;
    }

    public void setLocation(String location) {
        if (location.trim().isEmpty()) {
            throw new IllegalArgumentException("La ubicaci�n de la presentaci�n no puede estar vac�o");
        }

        this.location = location;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getLocation() {
        return location;
    }
}