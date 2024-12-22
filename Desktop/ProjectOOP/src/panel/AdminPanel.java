package panel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Courses.*;
import Enums.TeacherTitle;
import Users.*;
import Users.*;

import static Users.User.*;


public class AdminPanel extends ViewBase {
    private Admin admin;
    private Scanner scanner;
    private static Language currentLanguage = Language.EN;
    private List<User> users;
    public AdminPanel(Admin admin) {
        this.admin = admin;
        this.scanner = new Scanner(System.in);
        this.users = new ArrayList<User>();
    }

    // Change language
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
                System.out.println(Language.getMenuAdmin(i, currentLanguage));
            }

            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (choice) {
                case 1 -> viewAllUsers();
                case 2 -> addUser();
                case 3 -> removeUser();
                case 4 -> manageSupportRequests();
                case 5 -> changeAdminPassword();
                case 6 -> manageCourses();
                case 7 -> changeLanguage();
                case 8 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // View all users in the system
    public void viewAllUsers() {
        if (admin != null) {
            admin.getAllUsers();
        } else {
            System.out.println("No admin found.");
        }
    }


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

        // Search for the user in the users list and remove
        boolean userFound = false;
        for (User user : users) {
            if (user.getId().equals(userId)) {
                users.remove(user);
                userFound = true;
                System.out.println("User removed successfully.");
                break;
            }
        }

        if (!userFound) {
            System.out.println("User not found.");
        }
    }


    // Manage system support requests
    public void manageSupportRequests() {
        System.out.println("Managing support requests...");
        // Implement functionality to view and resolve support requests
    }

    // Change admin password
    public void changeAdminPassword() {
        System.out.println("Enter your current password:");
        String oldPassword = scanner.nextLine();

        System.out.println("Enter your new password:");
        String newPassword = scanner.nextLine();

        if (admin.changePassword(oldPassword, newPassword)) {
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Failed to change password. Please try again.");
        }
    }
    // Manage courses (add/remove courses)
    public void manageCourses() {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add a new course");
            System.out.println("2. Remove an existing course");
            System.out.println("3. View all courses");
            System.out.println("4. Return to main menu");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (choice) {
                case 1 -> addCourse();
                case 2 -> removeCourse();
                case 3 -> viewCourses();
                case 4 -> exit = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Add a new course
    public void addCourse() {
        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine();

        System.out.print("Enter course title: ");
        String title = scanner.nextLine();

        System.out.print("Enter course credits: ");
        int credits = scanner.nextInt();
        scanner.nextLine();  // Clear the buffer

        Course newCourse = new Course(courseId, title, credits);
        Course.addCourseToRegistry(newCourse);
    }

    // Remove an existing course
    public void removeCourse() {
        System.out.print("Enter course ID to remove: ");
        String courseId = scanner.nextLine();

        Course course = Course.findById(courseId);
        if (course != null) {
            Course.removeCourseFromRegistry(course);
        } else {
            System.out.println("Course not found.");
        }
    }

    // View all courses
    public void viewCourses() {
        if (Course.getCourseRegistry().isEmpty()) {
            System.out.println("No courses available.");
        } else {
            System.out.println("Courses in registry:");
            for (Course course : Course.getCourseRegistry().values()) {
                System.out.println(course);
            }
        }
    }

    // Manage user types (view/edit user types)
    public void manageUserTypes() {
        System.out.println("Manage user types...");
        // Implement functionality to manage user types
    }
}
