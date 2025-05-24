package schooling;

import java.util.ArrayList;

public class ResearchMatter {
    private String name;
    private ArrayList<Researcher> researchers;
    
    public ResearchMatter(String name) {
    	setName(name);
    	researchers = new ArrayList<>();
    }
    
    public void setName(String name) {
    	if (name.trim().isEmpty()) throw new IllegalArgumentException("El nombre no puede estar vacío");
    	
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