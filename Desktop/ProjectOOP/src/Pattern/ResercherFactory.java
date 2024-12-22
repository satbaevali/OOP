package Pattern;

import Pattern.hIndexCalculation;
import Pattern.hIndexStrategy;
import java.util.List;
import Social.*;
import Users.Researcher;


public class ResercherFactory {
    public static Researcher createResearcher(String name, List<ResearchPaper> papers) {
        hIndexCalculation hIndexStrategy = new hIndexStrategy();
        return new Researcher(name, papers, hIndexStrategy);
    }
}
