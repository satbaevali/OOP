package panel;

import java.util.Scanner;
import Courses.*;
import Users.*;
import Social.*;

public class ViewTeacher extends ViewBase {
    private Teacher teacher;
    private Scanner scanner;
    private static Language currentLanguage = Language.EN;

    public ViewTeacher(Teacher teacher) {
        this.teacher = teacher;
        this.scanner = new Scanner(System.in);
    }

    // Метод для изменения языка
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

    // Основное меню для преподавателя
    public void menu() {
        boolean exit = false;
        while (!exit) {
            // Print menu options in the selected language
            for (int i = 1; i <= 10; i++) {
                System.out.println(Language.getMenuStudent(i, currentLanguage)); // Modify this to show teacher's options
            }

            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (choice) {
                case 1 -> viewCourses();
                case 2 -> manageCourses();
                case 3 -> viewStudentsInfo();
                case 4 -> putMarks();
                case 5 -> sendMessages();
                case 10 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // View courses taught by the teacher
    public void viewCourses() {
        if (teacher != null) {
            teacher.viewCourses();
        } else {
            System.out.println("No teacher found.");
        }
    }

    // Manage courses (add/remove courses)
    public void manageCourses() {
        if (teacher != null) {
            System.out.println("1. Add course");
            System.out.println("2. Remove course");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> addCourse();
                case 2 -> removeCourse();
                default -> System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("No teacher found.");
        }
    }

    // Add a course to the teacher's course list
    public void addCourse() {
        System.out.print("Enter the course title to add: ");
        String courseTitle1 = scanner.nextLine();
        Course course = new Course(courseTitle1); // Assuming Course constructor exists
        teacher.addCourse(course);
        System.out.println("Course added: " + courseTitle1);
    }
    // Remove a course from the teacher's course list
    public void removeCourse() {
        System.out.print("Enter the course title to remove: ");
        String courseTitle = scanner.nextLine();
        Course course = new Course(courseTitle); // Assuming Course constructor exists
        teacher.removeCourse(course);
        System.out.println("Course removed: " + courseTitle);
    }

    // View students info for a specific course
    public void viewStudentsInfo() {
        System.out.print("Enter the course title to view students: ");
        String courseTitle = scanner.nextLine();
        Course course = new Course(courseTitle); // Assuming Course constructor exists
        teacher.viewStudentsInfo(course);
    }

    // Put marks for a student
    public void putMarks() {
        System.out.print("Enter the student ID: ");
        String studentId = scanner.nextLine();
        Student student = Student.getStudentById(studentId); // Assuming getStudentById method exists
        if (student != null) {
            System.out.print("Enter the course title: ");
            String courseTitle = scanner.nextLine();
            Course course = new Course(courseTitle); // Assuming Course constructor exists
            System.out.print("Enter marks: ");
            double marks = scanner.nextDouble();
            scanner.nextLine(); // Clear buffer
            teacher.putMarks(student, marks, course);
        } else {
            System.out.println("Student not found.");
        }
    }

    // Send messages (this is a placeholder, implement as needed)
    public void sendMessages() {
        System.out.println("Sending messages functionality is not yet implemented.");
    }
}
