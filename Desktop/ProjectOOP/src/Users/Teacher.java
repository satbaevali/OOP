package Users;

import Courses.*;
import Enums.*;
import Social.*;
import Pattern.ObserverTeacher;
import Social.ResearchPaper;
import Social.Researcher;
import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public  class Teacher extends Employee implements Researcher {
    private List<Course> courseList;
    private TeacherTitle title;
    private boolean isProfessor;
    private List<ResearchPaper> researchPapers;
    private int hIndex;
    {
        courseList = new ArrayList<>();
        researchPapers = new ArrayList<>();
    }

    public Teacher(String id, String name, String lastName, String email, String password,int experience, String department, TeacherTitle title) {
        super(id, name, lastName, email, password,  experience, department);
        this.title = title;
    }
    public void viewStudents(Course course) {
        List<Student> enrolledStudents = course.getEnrolledStudents();  // Получаем список студентов, записанных на курс

        if (enrolledStudents.isEmpty()) {
            System.out.println("No students are enrolled in this course.");
        } else {
            System.out.println("Students enrolled in " + course.getTitle() + ":");
            for (Student student : enrolledStudents) {
                System.out.println(student.getName() + " " + student.getLastName() + ", ID: " + student.getId());
                // Вы можете добавить дополнительные поля для вывода, если нужно
            }
        }
    }
    public void calculateHIndex() {
        // Step 1: Sort the papers by citations in descending order
        Collections.sort(researchPapers, (paper1, paper2) -> Integer.compare(paper2.getCitations(), paper1.getCitations()));

        // Step 2: Calculate the H-index
        int hIndex = 0;
        for (int i = 0; i < researchPapers.size(); i++) {
            // If the paper has at least 'i + 1' citations, it is part of the h-index
            if (researchPapers.get(i).getCitations() >= i + 1) {
                hIndex++;
            } else {
                break;
            }
        }

        System.out.println("H-index for " + getName() + " " + getLastName() + ": " + hIndex);
    }


    public int getHIndex() {
        return hIndex;
    }

    public TeacherTitle getTitle() {
        return title;
    }
    public void manageCourses() {
        System.out.println("Managing course for teacher " + getName());

    }
    public void setTitle(TeacherTitle title) {
        this.title = title;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void addResearchPaper(ResearchPaper paper) {
        researchPapers.add(paper);
    }
    @Override
    public List<ResearchPaper> getResearchPapers() {
        return researchPapers;
    }
    @Override
    public void setHIndexCalculationStrategy(hIndexCalculation strategy) {

    }

    @Override
    public void joinResearchProject(ResearchProject project) {

    }


    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void addCourse(Course course) {
        if (course != null) {
            courseList.add(course);
        }
    }

    public void removeCourse(Course course) {
        if (course != null) {
            courseList.remove(course);
        }
    }

    public void viewCourses() {
        System.out.println("Courses taught by " + getName() + ":");
        if (courseList.isEmpty()) {
            System.out.println("No courses assigned.");
        } else {
            courseList.forEach(course -> System.out.println(course.getTitle()));
        }
    }

    public void viewStudentsInfo(Course course) {
        if (courseList.contains(course)) {
            System.out.println("Students enrolled in " + course.getTitle() + ":");
            course.getEnrolledStudents().forEach(student ->
                    System.out.println(student.getName() + " " + student.getLastName() + " (" + student.getId() + ")")
            );
        } else {
            System.out.println("You are not teaching this course.");
        }
    }

    public void putMarks(Student student, double marks, Course course) {
        if (courseList.contains(course)) {
            Mark newMark = new Mark(course, marks, marks, marks, student);
            student.addMark(newMark);
            System.out.println("Marks for " + student.getName() + " updated to: " + marks);
        } else {
            System.out.println("You are not teaching this course.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(courseList, teacher.courseList) && title == teacher.title;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), courseList, title);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "title=" + title + ", " +
                "courseList=" + courseList +
                '}';
    }
}
