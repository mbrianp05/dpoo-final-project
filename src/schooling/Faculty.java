package schooling;

import java.util.ArrayList;

public class Faculty {
    private ArrayList<ResearchLine> researchLines;
    private ArrayList<Researcher> researchers;

    public ArrayList<Profesor> getProfesors() {
        ArrayList<Profesor> profesors = new ArrayList<>();

        for (Researcher r : researchers) {
            if (r instanceof Profesor) {
                profesors.add((Profesor) r);
            }
        }

        return profesors;
    }

    // REPORTE 1: (Brian): Los investigadores con m�s puntos por
    // ponencias/cap�tulos/art�culos
    public ArrayList<Researcher> bestResearchers() {
        ArrayList<Researcher> researchers = new ArrayList<>();
        int highestScore = -1;

        for (Researcher r : researchers) {
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
            total += line.getMasteryPlan().getCourses().size();
        }

        return total;
    }
}