package schooling;

import java.util.ArrayList;

public class MasteryPlan {
    private int minCredit;
	private ArrayList<Matriculation> matriculations;
    private ArrayList<PostgraduateCourse> courses;
    
    public MasteryPlan() {
    	matriculations = new ArrayList<>();
    	courses = new ArrayList<>();
    }
    
    public void addMatriculation(Profesor profesor, PostgraduateCourse course) {
    	matriculations.add(new Matriculation(profesor, course));
    }
    
    public ArrayList<Matriculation> getMatriculations() {
    	return matriculations;
    }
    
    public void addCourse() {
    	
    }
    
	public ArrayList<PostgraduateCourse> getCourses() {
		return courses;
	}

	public int getMinCredit() {
		return minCredit;
	}

	public void setMinCredit(int minCredit) {
		this.minCredit = minCredit;
	}
}