import java.util.Scanner;

import Courses.Course;
import Enums.TeacherTitle;
import panel.*;
import Users.*;
import javax.swing.*;
import java.util.*;
public class TestTeacher {
    public static void main(String[] args) {
        Teacher teacher=new Teacher("1","Dr","Ivanovvna","ivanovna@email.com","jkshdffs1",2,"It", TeacherTitle.LECTOR);
        Course course1=new Course("CS102","ICT",5);
        Course course2=new Course("CS103","Database",5);Student student = new Student("23B0", "Alikhan", "Satbai", "Alisatbai99", "a_satbay@gmail.com", 2, "IT");
        Student st1 = new Student("23B0", "Alikhan", "Satbai", "Alisatbai99", "a_satbay@gmail.com", 2, "IT");
        Student st2=new Student("22B003","Ali","sat","Alisa","alisatbai88",3,"it");
        st1.addStudentCourse(course1);
        st1.addStudentCourse(course2);
        st2.addStudentCourse(course1);
        teacher.addCourse(course1);

    }
}
