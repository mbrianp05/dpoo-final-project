package schooling;

import java.util.ArrayList;

public class Faculty {
    private ArrayList<ResearchLine> researchLines;
    private ArrayList<Researcher> researchers;

    public Faculty() {
    	researchers = new ArrayList<>();
    	researchLines = new ArrayList<>();
    }
    
    public Profesor addProfesor(String name, Degree degree, ProfesorCategory cat) {
    	Profesor profesor = new Profesor(name, degree, cat);
    	this.researchers.add(profesor);
    	
    	return profesor;
    }
    
    public Student addStudent(String name) {
    	Student student = new Student(name);
    	researchers.add(student);
    	
    	return student;
    }
    
    public void addResearchLine(String name, Profesor chief, MasteryPlan plan) {
    	researchLines.add(new ResearchLine(name, chief, plan));
    }
    
    public ArrayList<ResearchLine> getReseachLines() {
    	return researchLines;
    }
    
    public ArrayList<Researcher> getResearchers() {
    	return researchers;
    }
    
    public ArrayList<Profesor> getProfesors() {
        ArrayList<Profesor> profesors = new ArrayList<>();

        for (Researcher r : researchers) {
            if (r instanceof Profesor) {
                profesors.add((Profesor) r);
            }
        }

        return profesors;
    }
    
    public ArrayList<String> getResearchMattersNames() {
    	ArrayList<String> matters = new ArrayList<>();
    	
    	for (ResearchLine line: researchLines) {
    		for (ResearchMatter matter: line.getMatters()) {
    			matters.add(matter.getName());
    		}
    	}
    	
    	return matters;
    }
    
    public Profesor findProfesorByName(String name) {
    	Profesor profesor = null;
    	ArrayList<Profesor> profesors = getProfesors();
    	int i = 0;
    	
    	while (profesor == null && i < profesors.size()) {
    		Profesor p = profesors.get(i);
    		
    		if (p.getName().equals(name)) {
    			profesor = p;
    		}
    	}
    	
    	return profesor;
    }
    
    public ResearchMatter findMatterOf(String name) {
    	ResearchMatter matter = null;
    	
    	for (ResearchLine line: researchLines) {
    		for (ResearchMatter m: line.getMatters()) {
    			for (Researcher researcher: m.getResearchers()) {
    				if (researcher.getName().equals(name)) {
    					matter = m;
    				}
    			}
    		}
    	}
    	
    	return matter;
    }
    
    public ResearchMatter findResearchMatter(String name) {
		ResearchMatter matter = null;
    	
    	int i = 0;
    	while (matter == null && i < researchLines.size()) {
    		ResearchLine line = researchLines.get(i);
    		
    		int j = 0;
    		while (matter == null && j < line.getMatters().size()) {
    			if (line.getMatters().get(j).getName().equals(name)) {
    				matter = line.getMatters().get(j);
    			}
    			
    			j++;
    		}
    	}
    	
    	return matter;
    }

    public ArrayList<Researcher> bestResearchers() {
        ArrayList<Researcher> researchers = new ArrayList<>();
        int highestScore = Integer.MIN_VALUE;

        for (Researcher r : getResearchers()) {
            int score = r.getScore();
            
            if (score > highestScore) {
                highestScore = score;
                researchers.clear();
            }

            if (score == highestScore) {
                researchers.add(r);
            }
        }

        return researchers;
    }

    // REPORTE 2: (Brian): Los temas de investigaci�n con m�s investigadores
    public ArrayList<ResearchMatter> trendingMatters() {
        ArrayList<ResearchMatter> matters = new ArrayList<>();
        int mostResearchers = -1;

        for (ResearchLine line : researchLines) {
            for (ResearchMatter matter : line.getMatters()) {
                int researchersCount = matter.getResearchers().size();

                if (researchersCount > mostResearchers) {
                    mostResearchers = researchersCount;
                    matters.clear();
                }

                if (researchersCount == mostResearchers) {
                    matters.add(matter);
                }
            }
        }

        return matters;
    }

    // REPORTE 3: (Brian): La mayor cantidad de art�culos publicado por un mismo
    // investigador
    public int mostPaperPublished() {
        int highest = 0;

        for (Researcher r : researchers) {
            if (r.getPapers().size() > highest) {
                highest = r.getPapers().size();
            }
        }

        return highest;
    }

    // REPORTE 4: (Aleksandr): Los profesores que tienen los cr�ditos necesarios
    // para aprobar su maestr�a
    public ArrayList<Profesor> pendingAprovals() {
        ArrayList<Profesor> aprovalPendings = new ArrayList<>();

        for (ResearchLine line : researchLines) {
            aprovalPendings.addAll(line.getMasteryPlan().profesorsToAproveMastery());
        }

        return aprovalPendings;
    }

    // REPORTE 5: (Aleksandr): Total de cursos de postgrado proporcionados por el
    // vicedecanato
    public int totalPostgradeCourses() {
        int total = 0;

        for (ResearchLine line : researchLines) {
        	MasteryPlan plan = line.getMasteryPlan();
        	
        	if (plan != null)
        		total += plan.getCourses().size();
        }

        return total;
    }
}