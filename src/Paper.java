public class Paper {
    private String title;
    private int no;
    private int volume;
    private int year;
    private TargetedGroup group;

    public Paper(String title, int no, int volume, int year, TargetedGroup group) {
        this.title = title;
        this.no = no;
        this.volume = volume;
        this.year = year;
        this.group = group;
    }

    public void setTitle(String title) {
        if (title.trim().isEmpty()) {
            throw new IllegalArgumentException("El título del artículo no puede estar vacío");
        }

        this.title = title;
    }

    public void setNo(int no) {
        if (no < 0) {
            throw new IllegalArgumentException("El número del artículo no puede estar vacío");
        }

        this.no = no;
    }

    public void setVolume(int volume) {
        if (volume < 0) {
            throw new IllegalArgumentException("El volumen del artículo no puede estar vacío");
        }

        this.volume = volume;
    }

    public void setYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("El año del artículo no puede estar vacío");
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