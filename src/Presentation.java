import java.util.Date;

public class Presentation {
    private String name;
    // Le quité la propiedad año ya que como tambíen tenia la propiedad fecha pues la fecha ya incluye el año
    // El objeto Date facilita la manipulación y validaciones con fechas.
    private Date date;
    private String ISBN;
    private String location;

    public Presentation(String name, Date date, String ISBN, String location) {
        setName(name);
        setDate(date);
        setISBN(ISBN);
        setLocation(location);
    }

    public void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la presentación no puede estar vacío");
        }

        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Hay que investigar si el ISBN tiene una validación específica
    public void setISBN(String ISBN) {
        if (ISBN.trim().isEmpty()) {
            throw new IllegalArgumentException("El ISBN de la presentación no puede estar vacío");
        }

        this.ISBN = ISBN;
    }

    public void setLocation(String location) {
        if (location.trim().isEmpty()) {
            throw new IllegalArgumentException("La ubicación de la presentación no puede estar vacío");
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