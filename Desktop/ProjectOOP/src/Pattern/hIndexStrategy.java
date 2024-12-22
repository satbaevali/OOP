package Pattern;

import Social.ResearchPaper;
import java.util.*;
import Pattern.*;
public class hIndexStrategy implements hIndexCalculation {
    @Override
    public int calculateHIndex(List<ResearchPaper> papers) {
        papers.sort(Comparator.comparingInt(ResearchPaper::getCitations).reversed());
        int hIndex = 0;
        for (int i = 0; i < papers.size(); i++) {
            if (papers.get(i).getCitations() >= i + 1) {
                hIndex = i + 1;
            } else {
                break;
            }
        }
        return hIndex;
    }
}