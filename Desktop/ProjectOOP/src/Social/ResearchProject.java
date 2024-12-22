package Social;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import Exception.*;
import Users.Researcher;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResearchProject that = (ResearchProject) o;
        return Objects.equals(topic, that.topic) && Objects.equals(participants, that.participants) && Objects.equals(publishedPapers, that.publishedPapers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, participants, publishedPapers);
    }

    @Override
    public String toString() {
        return "ResearchProject{" +
                "topic='" + topic + '\'' +
                ", participants=" + participants +
                ", publishedPapers=" + publishedPapers +
                '}';
    }
}

