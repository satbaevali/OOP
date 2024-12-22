package panel;
import Social.News;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public abstract class ViewBase {
    protected Scanner scanner = new Scanner(System.in);

    public void chooseLanguage() {
        System.out.println("Select your language / Выберите язык / Тілді таңдаңыз:");
        System.out.println("1. English");
        System.out.println("2. Русский");
        System.out.println("3. Қазақ тілі");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
    }

    public void viewNews() {
        List<News> newsList = News.getNewsList();
        if (newsList.isEmpty()) {
            System.out.println("No news available.");
            return;
        }
        for (News news : newsList) {
            System.out.println(news);
        }
    }

    public abstract void menu();
}