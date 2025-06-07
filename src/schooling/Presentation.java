package schooling;

import java.util.Date;

import utils.Validation;

public class Presentation implements ScorableBreakthrough {
    private String name;
    private String ISBN;
    private String location;
    private Date date;

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
        if (!Validation.notEmpty(name)) {
            throw new IllegalArgumentException("El nombre de la presentaci�n no puede estar vac�o");
        }

        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Hay que investigar si el ISBN tiene una validaci�n espec�fica
    public void setISBN(String ISBN) {
        if (!Validation.notEmpty(ISBN)) {
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