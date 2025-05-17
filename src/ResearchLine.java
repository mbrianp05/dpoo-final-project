import java.util.ArrayList;

public class ResearchLine {
    private String name;
    private Profesor leader;
    private ArrayList<ResearchMatter> matters;
    private ArrayList<MasteryPlan> mastPlans;

	public ArrayList<MasteryPlan> getMastPlans() {
		return mastPlans;
	}	
    
    public ArrayList<ResearchMatter> getMatters() {
        return matters;
    }
}