package Social;

import java.util.ArrayList;
import java.util.List;
import Exception.*;

public class ResearchProject {
    private String topic;
    private List<Researcher> participants;
    private List<ResearchPaper> publishedPapers;

    public ResearchProject(String topic) {
        this.topic = topic;
        this.participants = new ArrayList<>();
        this.publishedPapers = new ArrayList<>();
    }

    public void addParticipant(Researcher researcher) throws NonResearcherException {
        if (researcher instanceof Researcher) {
            participants.add(researcher);
        } else {
            throw new NonResearcherException("Only researchers can join the project.");
        }
    }

    public void addPublishedPaper(ResearchPaper paper) {
        publishedPapers.add(paper);
    }

    public String getTopic() {
        return topic;
    }

    public List<Researcher> getParticipants() {
        return participants;
    }
}

