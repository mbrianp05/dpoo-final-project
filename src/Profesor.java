public class Profesor extends Researcher {
	private int credits;
	private Degree degree;
    private ProfesorCategory category;
	
	public Profesor(String name) {
		super(name);

        setCredits(0);
	}

    public void setCredits(int credits) {
    	if (credits < 0) {
    		throw new IllegalArgumentException("Los créditos no pueden ser un número negativo");
    	}
    	
    	this.credits = credits;
    }
}