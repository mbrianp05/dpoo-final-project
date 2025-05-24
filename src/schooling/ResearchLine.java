package schooling;

import java.util.ArrayList;

import utils.Validation;

public class ResearchLine {
    private String name;
    private Profesor chief;
    private MasteryPlan masteryPlan;
    private ArrayList<ResearchMatter> matters;
    
	public ResearchLine(String name, Profesor chief, MasteryPlan masteryPlan) {
		setName(name);
		setChief(chief);
		setMasteryPlan(masteryPlan);
		matters = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!Validation.notEmpty(name)) throw new IllegalArgumentException("El nombre no puede estar vacío");
		
		this.name = name;
	}

	public Profesor getChief() {
		return chief;
	}

	public void setChief(Profesor chief) {
		this.chief = chief;
	}

	public void addMatter(ResearchMatter matter) {
		matters.add(matter);
	}

	public void setMasteryPlan(MasteryPlan mastPlan) {
		masteryPlan = mastPlan;
	}

	public MasteryPlan getMasteryPlan() {
		return masteryPlan;
	}	
    
    public ArrayList<ResearchMatter> getMatters() {
        return matters;
    }
}