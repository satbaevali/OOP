package Social;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class News implements Comparable<News> {
    private static final List<News> newsList = new ArrayList<News>();
    private String title;
    private String content;
    private Date date;
    public News(String title, String content, Date date) {
        this.title = title;
        this.content = content;
        this.date = date;

    }
    public String getTitle() {
        return title;
    }
    public String getContent() {
        return content;
    }
    public Date getDate() {
        return date;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public static void addNews(News news) {
        newsList.add(news);
    }

    public static List<News> getNewsList() {
        return newsList;
    }

    public static void removeNews(News news) {
        newsList.remove(news);
    }

    @Override
    public int compareTo(News o) {
        return 0;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return "News{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + sdf.format(date) +
                '}';
    }
}