package Courses;
import Users.*;
import Enums.*;

import java.util.HashMap;
import java.util.Map;

public class Transcript {
    private Student student;
    private Map<Course, Mark> courseMark;

    public Transcript(Student student) {
        this.student = student;
        this.courseMark = new HashMap<>();
    }

    public void addCourseMark(Course course, Mark mark) {
        this.courseMark.put(course, mark);
    }

    // Проверка лимита по кредитам
    public boolean checkCreditLimit() {
        int totalCredits = courseMark.keySet().stream()
                .mapToInt(Course::getCredits)
                .sum();
        return totalCredits <= 21;
    }

    // Подсчёт числа не сданных предметов
    public int countFailures() {
        return (int) courseMark.values().stream()
                .filter(mark -> mark.getMarkOfLiteral().equals("F"))
                .count();
    }

    // Подсчёт GPA
    public double calculateGPA() {
        double totalCredits = 0;
        double weightedGPA = 0;
        for (Map.Entry<Course, Mark> entry : courseMark.entrySet()) {
            Course course = entry.getKey();
            Mark mark = entry.getValue();
            totalCredits += course.getCredits();
            weightedGPA += mark.getMarkOfDigit() * course.getCredits();
        }
        return totalCredits == 0 ? 0 : weightedGPA / totalCredits;
    }

    // Отображение информации о транскрипте
    @Override
    public String toString() {
        StringBuilder transcriptInfo = new StringBuilder();
        transcriptInfo.append("Transcript for: ").append(student.getName() + " " + student.getLastName()).append("\n");
        for (Map.Entry<Course, Mark> entry : courseMark.entrySet()) {
            Course course = entry.getKey();
            Mark mark = entry.getValue();
            transcriptInfo.append(course.getId())
                    .append(" - ").append(course.getTitle())
                    .append(" | Credits: ").append(course.getCredits())
                    .append(" | Mark: ").append(mark.getMarkOfLiteral())
                    .append(" | GPA: ").append(mark.getMarkOfDigit())
                    .append("\n");
        }

        transcriptInfo.append("Total Credits: ").append(calculateTotalCredits()).append("\n");
        transcriptInfo.append("Total GPA: ").append(calculateGPA()).append("\n");
        return transcriptInfo.toString();
    }

    private int calculateTotalCredits() {
        return courseMark.keySet().stream()
                .mapToInt(Course::getCredits)
                .sum();
    }
}
