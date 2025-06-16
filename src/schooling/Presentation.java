package schooling;

import java.time.LocalDate;

import utils.Validation;

public class Presentation extends Breakthrough implements HasUniqueIndentifier {
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
            throw new IllegalArgumentException("Presentation name cannot be empty");
        }

        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setISBN(String ISBN) {
        if (!Validation.notEmpty(ISBN)) {
            throw new IllegalArgumentException("ISBN cannot be empty");
        }
        
        if (!Validation.validISBN(ISBN)) {
        	throw new IllegalArgumentException("ISBN code has to be 10 or 13 digits long");
        }

        if (!Validation.unique("ISBN", ISBN)) {
        	throw new IllegalArgumentException("ISBN code has to be unique");
        }
        
        this.ISBN = ISBN;
    }

    public void setLocation(String location) {
        if (location.trim().isEmpty()) {
            throw new IllegalArgumentException("Location cannot be empty");
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

	@Override
	public String getId() {
		return ISBN;
	}
}