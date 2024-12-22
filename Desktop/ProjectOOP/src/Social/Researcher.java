package Social;

import java.util.List;

public interface Researcher {
    void addResearchPaper(ResearchPaper paper);
    void calculateHIndex();
    int getHIndex();
    List<ResearchPaper> getResearchPapers();
    void setHIndexCalculationStrategy(hIndexCalculation strategy);
    void joinResearchProject(ResearchProject project);
}
