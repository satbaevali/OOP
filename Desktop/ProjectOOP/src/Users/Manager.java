package Users;

import Enums.*;
import Courses.*;
import Social.*;
import java.util.*;

public class Manager extends Employee {
    private final ManagerType managerType;

    // Constructor
    public Manager(String id, String name, String lastName, String password, String email, int experience, String department, ManagerType managerType) {
        super(id, name, lastName, email, password,  experience, department);
        this.managerType = managerType;
    }

    // Approve student registration for a specific course
    public void approveStudentRegistration(Course course, Student student) {
        course.addStudent(student);  // Adds the student to the course
        student.addStudentCourse(course);  // Adds the course to the student's list of courses
    }


    // Add course for registration (specific to major and year of study)
    public void addCourseForRegistration(Course course, String major, int yearOfStudy) {
        course.setMajor(major);
        course.setYear(yearOfStudy);
        Course.addCourseToRegistry(course);
    }

    // Assign a course to a teacher
    public void assignCourseToTeacher(Course course, Teacher teacher) {
        course.addTeacher(teacher);
    }

    // Create statistical report on academic performance (sorted by GPA)
    public void createAcademicPerformanceReport(List<Student> students) {
        students.stream()
                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                .forEach(student -> System.out.println(student.getName()+" "+student.getLastName()+ " - GPA: " + student.getGpa()));
    }

    // Manage news (add or remove news)
    public void manageNews(News news, boolean isAdd) {
        if (isAdd) {
            News.addNews(news);
        } else {
            News.removeNews(news);
        }
    }

    // View info about students (sorted by GPA or alphabetically)
    public void viewStudentInfo(List<Student> students, boolean sortByGPA) {
        if (sortByGPA) {
            students.stream()
                    .sorted(Comparator.comparingDouble(Student::getGpa).reversed()) // Sorted by GPA
                    .forEach(student -> System.out.println(student.getName() + " - GPA: " + student.getGpa()));
        } else {
            students.stream()
                    .sorted(Comparator.comparing(Student::getName)) // Alphabetically sorted
                    .forEach(student -> System.out.println(student.getName()));
        }
    }

    // View info about teachers (sorted alphabetically)
    public void viewTeacherInfo(List<Teacher> teachers) {
        teachers.stream()
                .sorted(Comparator.comparing(Teacher::getName)) // Alphabetically sorted
                .forEach(teacher -> System.out.println(teacher.getName()));
    }

    // View requests from employees (signed by dean/rector)
    public void viewEmployeeRequests(List<Employee> employees) {
        employees.stream()
                .filter(employee -> employee.isSignedByDeanOrRector()) // Check if the request is signed by the dean or rector
                .forEach(employee -> System.out.println(employee.getName() + " has signed requests."));
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerType=" + managerType +
                '}'+super.toString();
    }
}
