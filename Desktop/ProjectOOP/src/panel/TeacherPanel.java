package panel;

import Pattern.ObserverTeacher;
import Pattern.TeacherPanelObservable;
import Users.*;
import Courses.*;
import java.util.Scanner;

public class TeacherPanel implements ObserverTeacher {
    private Teacher teacher;
    private Scanner scanner;
    private static Language currentLanguage = Language.EN;
    private TeacherPanelObservable observable;

    public TeacherPanel(Teacher teacher, TeacherPanelObservable observable) {
        this.teacher = teacher;
        this.observable = observable;
        this.scanner = new Scanner(System.in);
        observable.addObserver(this); // Subscribe to updates
    }

    // Implementation of the update method to receive notifications
    @Override
    public void update(String message) {
        System.out.println("Notification: " + message);
    }

    // Change language method
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

    // Main menu method
    public void menu() {
        boolean exit = false;
        while (!exit) {
            // Print menu items in the selected language
            for (int i = 1; i <= 10; i++) {
                System.out.println(Language.getMenuTeacher(i, currentLanguage));
            }

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> viewCourses();
                case 2 -> manageCourses();
                case 3 -> viewStudentsInfo();
                case 4 -> putMarks();
                case 5 -> sendMessageToEmployees();
                case 6 -> sendComplaints();
                case 10 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Methods to handle menu options
    @Override
    public void viewCourses() { // Make sure this is public to match the interface
        if (teacher != null) {
            teacher.viewCourses();
        } else {
            System.out.println("No teacher found.");
        }
    }

    @Override
    public void manageCourses() {
        if (teacher != null) {
            teacher.manageCourses();
        } else {
            System.out.println("No teacher found.");
        }
    }

    @Override
    public void viewStudentsInfo() {
        if (teacher != null) {
            System.out.println("Enter the course code to view student information:");
            String courseCode = scanner.nextLine();

            Course course = Course.getCourseRegistry().get(courseCode);
            if (course != null) {
                teacher.viewStudentsInfo(course);
            } else {
                System.out.println("Course not found.");
            }
        } else {
            System.out.println("No teacher found.");
        }
    }

    @Override
    public void putMarks() {
        if (teacher != null) {
            System.out.println("Enter the course code:");
            String courseCode = scanner.nextLine();

            Course course = Course.getCourseRegistry().get(courseCode);
            if (course != null) {
                System.out.println("Enter the student ID:");
                String studentId = scanner.nextLine();

                Student student = course.getEnrolledStudents()
                        .stream()
                        .filter(s -> s.getId().equals(studentId))
                        .findFirst()
                        .orElse(null);

                if (student != null) {
                    System.out.println("Enter the marks:");
                    double marks = scanner.nextDouble();
                    scanner.nextLine(); // Clear buffer

                    teacher.putMarks(student, marks, course);
                } else {
                    System.out.println("Student not found.");
                }
            } else {
                System.out.println("Course not found.");
            }
        } else {
            System.out.println("No teacher found.");
        }
    }
    public void sendMessages() {
        System.out.println("Sending messages to employees...");
        // Implement the actual message sending logic here
    }

    private void sendMessageToEmployees() {
        System.out.println("This feature is not yet implemented.");
    }

    private void sendComplaints() {
        System.out.println("This feature is not yet implemented.");
    }
}
