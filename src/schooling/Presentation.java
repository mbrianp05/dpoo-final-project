package schooling;

import java.time.LocalDate;

import utils.Validation;

public class Presentation implements ScorableBreakthrough {
    private String name;
    private String ISBN;
    private String location;
    private LocalDate date;

    private final static int score = 1;

    public Presentation(String name, LocalDate date, String ISBN, String location) {
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

    public void setDate(LocalDate date) {
        this.date = date;
    }

    // Hay que investigar si el ISBN tiene una validaci�n espec�fica
    public void setISBN(String ISBN) {
        if (!Validation.notEmpty(ISBN)) {
            throw new IllegalArgumentException("El ISBN de la presentaci�n no puede estar vac�o");
        }
        
        if (!Validation.validISBN(ISBN)) {
        	throw new IllegalArgumentException("ISBN code has to be 10 or 13 digits long");
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

    public LocalDate getDate() {
        return date;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getLocation() {
        return location;
    }
}