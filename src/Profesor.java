public class Profesor extends Researcher {
	private int credits;
	private Degree degree;
    private ProfesorCategory category;
	
	public Profesor(String name, Degree degree, ProfesorCategory profesorCategory) {
		super(name);

        setCredits(0);
        setDegree(degree);
        setCategory(profesorCategory);
	}

    public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public ProfesorCategory getCategory() {
		return category;
	}

	public void setCategory(ProfesorCategory category) {
		this.category = category;
	}

	public void setCredits(int credits) {
    	if (credits < 0) {
    		throw new IllegalArgumentException("Los cr�ditos no pueden ser un n�mero negativo");
    	}
    	
    	this.credits = credits;
    }

	public int getCredits() {
		return credits;
	}
}