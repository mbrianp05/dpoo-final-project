import java.util.ArrayList;

public class MasteryPlan {
    private int minCredit;
    private ArrayList<PostgraduateCourse> courses;
    
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