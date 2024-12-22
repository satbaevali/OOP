package Social;
public class ResearchPaper {
    private String title;
    private int citations;
    private String authors;
    private String journal;
    private String pages;
    private String date;
    private String doi;

    public ResearchPaper(String title, int citations) {
        this.title = title;
        this.citations = citations;
    }

    public String getTitle() {
        return title;
    }

    public int getCitations() {
        return citations;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }
}