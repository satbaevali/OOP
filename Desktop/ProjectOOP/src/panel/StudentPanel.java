package panel;

import java.util.Scanner;

import Users.*;
import Courses.*;

public class StudentPanel extends ViewBase {
    private Student student;
    private Scanner scanner;
    private static Language currentLanguage = Language.EN;

    public StudentPanel(Student student) {
        this.student = student;
        this.scanner = new Scanner(System.in);
    }

    // Изменение языка
    public static void changeLanguage() {
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

    // Основное меню
    public void menu() {
        boolean exit = false;
        while (!exit) {
            // Print menu options in the selected language
            for (int i = 1; i <= 10; i++) {
                System.out.println(Language.getMenuStudent(i, currentLanguage));
            }

            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (choice) {
                case 1 -> viewNews();
                case 2 -> viewCourses();
                case 3 -> addStudentCourse();
                case 4 -> viewTeacherInfo();
                case 5 -> viewMarks();
                case 6 -> viewTranscript();
                case 7 -> rateTeachers();
                case 8 -> viewTranscript();
                case 9 -> changeStudentPassword();
                case 10 ->viewOrganization();
                case 0 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Методы для работы с курсами, оценками и так далее
    public void viewCourses() {
        if (student != null) {
            student.viewCourses();
        } else {
            System.out.println("No student found.");
        }
    }

    public void addStudentCourse() {
        if (student != null) {
            System.out.println("Enter the course code to register for:");
            String courseCode = scanner.nextLine();

            Course course = Course.getCourseRegistry().get(courseCode);

            if (course != null) {
                student.addStudentCourse(course);
                System.out.println("Successfully added " + course.getTitle() + " to your courses.");
            } else {
                System.out.println("Course not found.");
            }
        } else {
            System.out.println("No student found.");
        }
    }

    public void viewTeacherInfo() {
        if (student != null) {
            student.viewTeacherInfo();
        } else {
            System.out.println("No teacher found.");
        }
    }

    public void viewMarks() {
        if (student != null) {
            student.viewMarks();
        } else {
            System.out.println("No marks found.");
        }
    }

    public void viewTranscript() {
        if (student != null) {
            Transcript transcript = student.getTranscript();
            if (transcript != null) {
                System.out.println(transcript.toString());
            } else {
                System.out.println("Transcript not available for this student.");
            }
        } else {
            System.out.println("No student found.");
        }
    }

    public void rateTeachers() {
        if (student != null) {
            System.out.println("Teacher rating feature is not yet implemented.");
        } else {
            System.out.println("Unable to rate teachers as student is not found.");
        }
    }
    public void changeStudentPassword() {
        System.out.println("Enter your current password:");
        String oldPassword = scanner.nextLine();

        System.out.println("Enter your new password:");
        String newPassword = scanner.nextLine();

        if (student.changePassword(oldPassword, newPassword)) {
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Failed to change password. Please try again.");
        }
    }

}
