package schooling;

import utils.Validation;

public class Paper implements ScorableBreakthrough {
    private String title;
    private int no;
    private int volume;
    private int year;
    private TargetedGroup group;

    private final int score;

    public Paper(String title, int no, int volume, int year, TargetedGroup group) {
        setTitle(title);
        setNo(no);
        setVolume(volume);
        setYear(year);
        setGroup(group);

        switch (group) {
        case Wos:
        	score = 10;
        	break;
        case Group1:
        	score = 8;
        	break;
        case Group2:
        	score = 6;
        	break;
        case Group3:
        case Group4:
        	score = 4;
        	break;
        default:
        	// Solo ocurre cuando el group es null
        	score = 0;
        }
    }

    public int getScore() {
        return score;
    }

    public void setTitle(String title) {
        if (!Validation.notEmpty(title)) {
            throw new IllegalArgumentException("El tï¿½tulo del artï¿½culo no puede estar vacï¿½o");
        }

        this.title = title;
    }

    public void setNo(int no) {
        if (no < 0) {
            throw new IllegalArgumentException("El nï¿½mero del artï¿½culo no puede estar vacï¿½o");
        }

        this.no = no;
    }

    public void setVolume(int volume) {
        if (volume < 0) {
            throw new IllegalArgumentException("El volumen del artï¿½culo no puede estar vacï¿½o");
        }

        this.volume = volume;
    }

    public void setYear(int year) {
        if (year < 1) {
            throw new IllegalArgumentException("El año no puede ser negativo");
        }

        this.year = year;
    }

    public void setGroup(TargetedGroup group) {
        this.group = group;
    }

    public String getTitle() {
        return title;
    }

    public int getNo() {
        return no;
    }

    public int getVolume() {
        return volume;
    }

    public int getYear() {
        return year;
    }

    public TargetedGroup getGroup() {
        return group;
    }
}