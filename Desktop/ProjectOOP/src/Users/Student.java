package Users;
import Courses.*;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import Users.*;

public class Student extends User {
    private int yearOfStudy;
    private String major;
    private List<Course> studentCourses;
    private List<Mark> marks;  // New list to store marks for courses
    private int failedCourses;
    private int totalCredits;
    private Transcript transcript;

    // Initializing the list of enrolled courses and marks
    {
        this.studentCourses = new ArrayList<>();
        this.marks = new ArrayList<>();  // Initialize the marks list
        this.failedCourses = 0;
        this.totalCredits = 0;


    }

    private static final Scanner scanner = new Scanner(System.in);  // Declare Scanner as a member variable

    public Student(String id, String name, String lastName, String password, String email, int yearOfStudy, String major) {
        super(id, name, lastName, password, email);
        this.yearOfStudy = yearOfStudy;
        this.major = major;
        this.transcript = new Transcript(this);

    }

    public Student(String userId, String name) {
        super();
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        if (!this.getPassword().equals(oldPassword)) {
            System.out.println("Incorrect old password.");
            return false;
        }
        if (!isValidPassword(newPassword)) {
            System.out.println("The new password does not meet security requirements.");
            return false;
        }
        this.setPassword(newPassword);
        System.out.println("Password changed successfully.");
        return true;
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8
                && password.matches(".*\\d.*")
                && password.matches(".*[!@#$%^&*].*");
    }




    public List<Course> getStudentCourses() {
        return studentCourses;
    }

    public void addStudentCourse(Course course) {
        System.out.println("Enter the course code to register for:");
        String courseCode = scanner.nextLine();  // Use the instance of Scanner

        // Fetch the course from the course registry based on the course code
        Course selectedCourse = Course.getCourseRegistry().get(courseCode);

        if (course != null) {
            this.studentCourses.add(selectedCourse);  // Add course to this student's course list
            this.totalCredits += course.getCredits();  // Update total credits
            System.out.println("Successfully added " + selectedCourse.getTitle() + " to your courses.");
        } else {
            System.out.println("Course not found.");
        }
    }

    public void viewCourses() {
        System.out.println("Available courses:");
        // Iterate through the static course registry and display the courses
        for (Course course : Course.getCourseRegistry().values()) {
            System.out.println(course); // This will call the toString method of Course class
        }
    }
    public void viewTeacherInfo() {
        System.out.println("Enter course code to view teacher info:");
        String courseCode = scanner.nextLine();

        Course course = Course.getCourseRegistry().get(courseCode);
        if (course != null && course.getTeacher() != null) {
            System.out.println("Teacher for " + course.getTitle() + ": " + course.getTeacher());
        } else {
            System.out.println("Teacher info not available for this course.");
        }
    }
    public boolean viewTranscript() {
        if (studentCourses.isEmpty()) {
            System.out.println("No courses found.");
        } else {
            System.out.println("Transcript:");
            for (Course course : studentCourses) {
                System.out.println(course.getTitle() + ": " + getMarkForCourse(course));  // Assuming a method to get marks for a course
            }
        }
        return false;
    }


    private String getMarkForCourse(Course course) {
        // Find the mark corresponding to the given course
        for (Mark mark : marks) {
            if (mark.getCourse().equals(course)) {  // Assuming Mark class has a getCourse() method
                return String.valueOf(mark.getMarkOfDigit());
            }
        }
        return "No mark available";
    }



    public void failCourse() {
        this.failedCourses++;
        if (this.failedCourses > 3) {
            System.out.println("Error: You cannot fail more than 3 courses.");
        }
    }
    public Transcript getTranscript() {
        return this.transcript;
    }
    public void viewMarks() {
        if (marks.isEmpty()) {
            System.out.println("No marks available.");
        } else {
            System.out.println("Marks:");
            for (Mark mark : marks) {
                System.out.println(mark);  // Assuming Mark class has a meaningful toString() method
            }
        }
    }


    public double getGpa() {
        double totalGpa = 0.0;
        int totalCourses = marks.size();

        if (totalCourses == 0) {
            return 0.0;
        }

        for (Mark mark : marks) {
            totalGpa += mark.getMarkOfDigit();
        }

        return totalGpa / totalCourses;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getFailedCourses() {
        return failedCourses;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void addMark(Mark mark) {
        marks.add(mark);
    }

    @Override
    public String toString() {
        return "Student{" + getName() + " " + getLastName() +
                " yearOfStudy=" + yearOfStudy +
                ", major='" + major + '\'' +
                ", studentCourses=" + studentCourses +
                ", failedCourses=" + failedCourses +
                ", totalCredits=" + totalCredits +
                '}';
    }
}
