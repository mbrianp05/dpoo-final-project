package schooling;

import java.util.ArrayList;

public class MasteryPlan {
    private int minCredit;
    
	private ArrayList<Matriculation> matriculations;
    private ArrayList<PostgraduateCourse> courses;
    
    public MasteryPlan(int minCredit) {
    	setMinCredit(minCredit);
    	
    	matriculations = new ArrayList<>();
    	courses = new ArrayList<>();
    }
    
    public void addMatriculation(Profesor profesor, PostgraduateCourse course) {
    	matriculations.add(new Matriculation(profesor, course));
    }
    
    public ArrayList<Matriculation> getMatriculations() {
    	return matriculations;
    }
    
    public void addCourse(String name, String description, Profesor instructor, int credits) {
    	courses.add(new PostgraduateCourse(name, description, instructor, credits));
    }
    
	public ArrayList<PostgraduateCourse> getCourses() {
		return courses;
	}

	public int getMinCredit() {
		return minCredit;
	}

	public void setMinCredit(int minCredit) {
		if (minCredit < 1) throw new IllegalArgumentException("El crédito necesario tiene que ser mayor que 0");
		
		this.minCredit = minCredit;
	}
}