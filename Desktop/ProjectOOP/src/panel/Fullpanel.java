package panel;

import Enums.*;
import java.util.Scanner;

public class Fullpanel {

    private static Language currentLanguage = Language.EN;

    public static void chooseLanguage() {
        Scanner scan = new Scanner(System.in);
        System.out.println("=====================================");
        System.out.println("   Select your language / Выберите язык / Тілді таңдаңыз:");
        System.out.println("=====================================");
        System.out.println("1. English");
        System.out.println("2. Русский");
        System.out.println("3. Қазақ тілі");
        System.out.println("=====================================");
        System.out.print("Enter your choice: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1 -> currentLanguage = Language.EN;
            case 2 -> currentLanguage = Language.RU;
            case 3 -> currentLanguage = Language.KZ;
            default -> System.out.println("Invalid choice. Defaulting to English.");
        }
        System.out.println("=====================================\n");
    }

    public static void menu() {
        System.out.println("=====================================");
        switch (currentLanguage) {
            case EN -> {
                System.out.println("    Welcome to WSP!");
                System.out.println("    Select the option:");
                System.out.println("=====================================");
                System.out.println("1. News");
                System.out.println("2. View complaints");
                System.out.println("3. View requests");
                System.out.println("4. Research Projects");
            }
            case RU -> {
                System.out.println("    Добро пожаловать в WSP!");
                System.out.println("    Выберите опцию:");
                System.out.println("=====================================");
                System.out.println("1. Новости");
                System.out.println("2. Просмотр жалоб");
                System.out.println("3. Просмотр запросов");
                System.out.println("4. Журнал научных статей");
            }
            case KZ -> {
                System.out.println("    WSP-ға қош келдіңіз!");
                System.out.println("    Опцияны таңдаңыз:");
                System.out.println("=====================================");
                System.out.println("1. Жаңалықтар");
                System.out.println("2. Шағымдарды қарастыру");
                System.out.println("3. Сұраныстарды қарастыру");
                System.out.println("4. Ғылыми мақалалар");
            }
        }
        System.out.println("=====================================");
    }
}
