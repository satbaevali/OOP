package Courses;
import Users.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {
    private static final Map<String, Course> courseRegistry = new HashMap<>(); // Static registry of all courses

    private String id;
    private String title;
    private int credits;
    private String major;
    private int year;
    private List<Student> enrolledStudents;
    private Teacher teacher;

    // Constructor
    public Course(String id, String title, int credits) {
        this.id = id;
        this.title = title;
        this.credits = credits;
        this.enrolledStudents = new ArrayList<>();
    }
    public static Map<String, Course> getCourseRegistry() {
        return courseRegistry;
    }

    // Add course to the registry
    public static void addCourseToRegistry(Course course) {
        if (!courseRegistry.containsKey(course.id)) {
            courseRegistry.put(course.id, course);
            System.out.println("Course added to registry: " + course.title);
        } else {
            System.out.println("Course already exists in the registry.");
        }
    }

    // Remove course from the registry
    public static void removeCourseFromRegistry(Course course) {
        if (courseRegistry.remove(course.id) != null) {
            System.out.println("Course removed from registry: " + course.title);
        } else {
            System.out.println("Course not found in the registry.");
        }
    }

    // Find a course by its ID
    public static Course findById(String courseId) {
        return courseRegistry.get(courseId);
    }

    // Assign an instructor to the course
    public void addTeacher(Teacher teacher) {
        this.teacher = teacher;
        System.out.println("Instructor " + teacher.getName() + " assigned to course: " + title);
    }

    // Enroll a student in the course
    public void addStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            System.out.println("Student " + student.getName() + " enrolled in course: " + title);
        } else {
            System.out.println("Student is already enrolled in this course.");
        }
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<Student> getEnrolledStudents() {
        return new ArrayList<>(enrolledStudents); // Return a copy of the list to preserve encapsulation
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", credits=" + credits +
                ", major='" + major + '\'' +
                ", year=" + year +
                ", instructor=" + (teacher!= null ? teacher.getName() : "None") +
                ", enrolledStudents=" + enrolledStudents.size() +
                '}';
    }
}
