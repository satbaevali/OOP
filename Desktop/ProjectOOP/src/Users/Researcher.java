package Users;

import Pattern.hIndexCalculation;
import java.util.List;
import java.util.Scanner;
import Users.*;
import Social.*;



public class Researcher {
    private String name;
    private List<ResearchPaper> papers;
    private hIndexCalculation hIndexCalculator;

    public Researcher(String name, List<ResearchPaper> papers, hIndexCalculation hIndexCalculator) {
        this.name = name;
        this.papers = papers;
        this.hIndexCalculator = hIndexCalculator;
    }

    public String getName() {
        return name;
    }

    public int getHIndex() {
        return hIndexCalculator.calculateHIndex(papers);
    }

    public List<ResearchPaper> getPapers() {
        return papers;
    }

    public void setPapers(List<ResearchPaper> papers) {
        this.papers = papers;
    }

    public void setHIndexCalculator(hIndexCalculation hIndexCalculator) {
        this.hIndexCalculator = hIndexCalculator;
    }

    public void viewPapers() {
        if (papers.isEmpty()) {
            System.out.println("No publications available.");
        } else {
            papers.forEach(paper -> {
                System.out.println("Title: " + paper.getTitle() + ", Citations: " + paper.getCitations());
            });
        }
    }

    public void addNewPaper(String title, int citations) {
        ResearchPaper newPaper = new ResearchPaper(title, citations);
        papers.add(newPaper);
        System.out.println("New paper added: " + title);
    }
}