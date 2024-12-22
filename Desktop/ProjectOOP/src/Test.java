import Courses.Course;
import Courses.Mark;
import Courses.Transcript;
import Enums.*;
import Enums.TeacherTitle;
import Enums.TypeOfMark;
import Social.News;
import Users.Student;
import Users.Teacher;
import panel.ViewStudent;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        // Добавление новостей
        News.addNews(new News("Title 1", "Professor Alikhan can't learn", new Date()));
        News.addNews(new News("Title 2", "Alikhan krasava", new Date()));

        // Создание студента
        Student student = new Student("23B0", "Alikhan", "Satbai", "Alisatbai99", "a_satbay@gmail.com", 2, "IT");

        // Регистрация курсов
        Course course1 = new Course("CS101", "Computer Programming", 4);
        Course course2 = new Course("CS102", "Computer Science", 4);

        Course.getCourseRegistry().put("CS101", course1);
        Course.getCourseRegistry().put("CS102", course2);
        Teacher teacher1=new Teacher("23b90","Alina","Juma","juma@gmail.com","juma2112",3,"FIT", TeacherTitle.PROFESSOR);
        teacher1.addCourse(course1);
        teacher1.addCourse(course2);
        course1.addTeacher(teacher1);
        student.addMark(new Mark(course1,22,23,22,student));
        Transcript transcript=new Transcript(student);
        Mark mark=new Mark(course1,22,23,22,student);
        mark.putMark(TypeOfMark.FINAL_ATT,24);
        mark.checkFailureOrRetake();
        transcript.addCourseMark(course1,mark);

        student.viewTranscript();


        // Инициализация интерфейса студента
        ViewStudent viewStudent = new ViewStudent(student);

        // Запуск меню
        viewStudent.changeLanguage();
        viewStudent.menu();

        // Тестирование функционала после выполнения меню
        student.addStudentCourse(course1);  // Добавление курса вручную для проверки

        // Отображение курсов после добавления
        System.out.println("\nRegistered Courses:");
        student.getStudentCourses().forEach(course ->
                System.out.println(course.getId() + ": " + course.getTitle())
        );
    }
}
