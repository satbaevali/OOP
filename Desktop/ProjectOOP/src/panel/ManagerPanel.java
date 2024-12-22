package panel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Enums.TeacherTitle;
import Users.*;
import Courses.*;
import Social.*;

import static Users.User.findUser;  // This is already imported

public class ManagerPanel extends ViewBase {

    private Manager manager;
    private Scanner scanner;
    private static Language currentLanguage = Language.EN;
    private List<User> users;

    // Constructor
    public ManagerPanel(Manager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
        this.users = new ArrayList<User>();
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

    // Main menu
    public void menu() {
        boolean exit = false;
        while (!exit) {
            // Print menu options in the selected language
            for (int i = 1; i <= 10; i++) {
                System.out.println(Language.getMenuManager(i, currentLanguage));
            }

            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (choice) {
                case 1 -> addUser();
                case 2 -> removeUser();
                case 3 -> updateUser();
                case 4 -> viewNews();
                case 5 -> manageCourses();
                case 6 -> assignTeacherToCourse();
                case 9 -> changeManagerPassword();
                case 10 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Add user method
    public void addUser() {
        System.out.println("Enter user details to add:");
        System.out.println("Enter user ID:");
        String userId = scanner.nextLine();

        System.out.println("Enter user name:");
        String name = scanner.nextLine();

        System.out.println("Enter user role (Student/Teacher):");
        String role = scanner.nextLine().toLowerCase();

        if (role.equals("student")) {
            System.out.println("Enter student last name:");
            String lastName = scanner.nextLine();

            System.out.println("Enter student email:");
            String email = scanner.nextLine();

            System.out.println("Enter student password:");
            String password = scanner.nextLine();

            System.out.println("Enter year of study:");
            int yearOfStudy = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            System.out.println("Enter student major:");
            String major = scanner.nextLine();

            // Create a new Student object
            Student student = new Student(userId, name, lastName, password, email, yearOfStudy, major);
            users.add(student); // Add student to the list
            System.out.println("Student added successfully.");
        } else if (role.equals("teacher")) {
            // Запрашиваем дополнительные данные для учителя
            System.out.println("Enter teacher's last name:");
            String lastName = scanner.nextLine();

            System.out.println("Enter teacher's email:");
            String email = scanner.nextLine();

            System.out.println("Enter teacher's password:");
            String password = scanner.nextLine();

            System.out.println("Enter teacher's experience (in years):");
            int experience = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            System.out.println("Enter teacher's department:");
            String department = scanner.nextLine();

            System.out.println("Enter teacher's title (e.g., Professor, Associate Professor):");
            String titleInput = scanner.nextLine();
            TeacherTitle title = TeacherTitle.valueOf(titleInput.toUpperCase()); // Assuming TeacherTitle is an enum

            Teacher teacher = new Teacher(userId, name, lastName, email, password, experience, department, title);
            users.add(teacher); // Add teacher to the list
            System.out.println("Teacher added successfully.");
        } else {
            System.out.println("Invalid role entered.");
        }
    }

    // Remove user method
    public void removeUser() {
        System.out.println("Enter user ID to remove:");
        String userId = scanner.nextLine();

        if (users.removeIf(user -> user.getId().equals(userId))) {
            System.out.println("User removed successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    // Update user information
    public void updateUser() {
        System.out.println("Enter user ID to update:");
        String userId = scanner.nextLine();
        User user = findUser(userId);  // Use findUser method to get the user by ID

        if (user != null) {
            System.out.println("Enter new name:");
            String newName = scanner.nextLine();
            user.setName(newName);

            System.out.println("User updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }

    // View news method
    public void viewNews() {
        System.out.println("Viewing news:");
        for (News news : News.getNewsList()) {
            System.out.println(news);
        }
    }

    // Manage courses method
    public void manageCourses() {
        System.out.println("Enter the course code to manage:");
        String courseCode = scanner.nextLine();

        Course course = Course.getCourseRegistry().get(courseCode);

        if (course != null) {
            System.out.println("Managing course: " + course.getTitle());
            // Additional course management logic can be implemented here
        } else {
            System.out.println("Course not found.");
        }
    }

    // Assign teacher to course method
    public void assignTeacherToCourse() {
        System.out.println("Enter the course code to assign a teacher to:");
        String courseCode = scanner.nextLine();

        System.out.println("Enter the teacher ID:");
        String teacherId = scanner.nextLine();

        Course course = Course.getCourseRegistry().get(courseCode);
        Teacher teacher = Teacher.getTeacherById(teacherId);

        if (course != null && teacher != null) {
            course.assignTeacher(teacher);
            System.out.println("Successfully assigned " + teacher.getName() + " to course " + course.getTitle() + ".");
        } else {
            System.out.println("Course or teacher not found.");
        }
    }

    // Change manager password method
    public void changeManagerPassword() {
        System.out.println("Enter your current password:");
        String oldPassword = scanner.nextLine();

        System.out.println("Enter your new password:");
        String newPassword = scanner.nextLine();

        if (manager.changePassword(oldPassword, newPassword)) {
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Failed to change password. Please try again.");
        }
    }
}
