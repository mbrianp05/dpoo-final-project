package schooling;

import java.util.ArrayList;

import utils.Validation;

public class ResearchLine {
	private String name;
	private Profesor chief;
	private MasteryPlan masteryPlan;
	private ArrayList<ResearchMatter> matters;

	public ResearchLine(String name, Profesor chief, int credits) {
		setName(name);
		setChief(chief);
		setMasteryPlan(credits);
		matters = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (!Validation.notEmpty(name))
			throw new IllegalArgumentException("El nombre no puede estar vac�o");

		this.name = name;
	}

	public Profesor getChief() {
		return chief;
	}

	public void setChief(Profesor chief) {
		this.chief = chief;
	}

	public void addMatter(String name) {
		matters.add(new ResearchMatter(name));
	}

	public void setMasteryPlan(int credits) {
		masteryPlan = new MasteryPlan(credits);
	}

	public MasteryPlan getMasteryPlan() {
		return masteryPlan;
	}

	public ArrayList<ResearchMatter> getMatters() {
		return matters;
	}
}