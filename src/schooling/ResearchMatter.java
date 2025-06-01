package schooling;

import java.util.ArrayList;

import utils.Validation;

public class ResearchMatter {
    private String name;
    private ArrayList<Researcher> researchers;

    public ResearchMatter(String name) {
        setName(name);
        researchers = new ArrayList<>();
    }

    public void setName(String name) {
        if (!Validation.notEmpty(name)) {
        	throw new IllegalArgumentException("Matter name cannot be empty");
        }

        if (!Validation.unique(getClass().getSimpleName() + ".name", name)) {
        	throw new IllegalArgumentException("There is already a matter with that name");
        }
        
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addResearcher(Researcher researcher) {
        researchers.add(researcher);
    }

    public ArrayList<Researcher> getResearchers() {
        return researchers;
    }
}