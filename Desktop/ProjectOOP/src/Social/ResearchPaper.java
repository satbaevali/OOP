package Social;
import java.util.*;
import Enums.*;
import java.util.Date;

public class ResearchPaper {
    private String title;
    private String author;
    private String journal;
    private int year;
    private Date publicationDate;
    private int citations;
    private String doi;

    public ResearchPaper(String title, String author, String journal, int year, Date publicationDate, int citations, String doi) {
        this.title = title;
        this.author = author;
        this.journal = journal;
        this.year = year;
        this.publicationDate = publicationDate;
        this.citations = citations;
        this.doi = doi;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getJournal() {
        return journal;
    }

    public int getCitations() {
        return citations;
    }

    public String getDoi() {
        return doi;
    }

    // Method to get citation in different formats
    public String getCitation(Format f) {
        switch (f) {
            case PLAIN_TEXT:
                return getPlainTextCitation();
            case BIBTEX:
                return getBibtexCitation();
            default:
                return "";
        }
    }

    // Citation format in Plain Text
    private String getPlainTextCitation() {
        return String.format("%s. %s. %s. %d. DOI: %s. %d citations.",
                author, title, journal, year, doi, citations);
    }

    // Citation format in Bibtex
    private String getBibtexCitation() {
        return String.format("@article{%s,\n" +
                        "  author = {%s},\n" +
                        "  title = {%s},\n" +
                        "  journal = {%s},\n" +
                        "  year = {%d},\n" +
                        "  doi = {%s},\n" +
                        "  citations = {%d}\n" +
                        "}",
                doi, author, title, journal, year, doi, citations);
    }

    @Override
    public String toString() {
        return "ResearchPaper{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", journal='" + journal + '\'' +
                ", year=" + year +
                ", citations=" + citations +
                ", doi='" + doi + '\'' +
                '}';
    }
}
