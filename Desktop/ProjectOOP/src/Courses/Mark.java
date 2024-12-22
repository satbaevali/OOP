package Courses;

import Enums.*;
import Users.*;

public class Mark {
    private Course course;
    private double firstAtt;
    private double secondAtt;
    private double finalAtt;
    private double totalAtt;
    private double gpa;
    private String markOfLiteral;
    private double markOfDigit;
    private Student student;

    public Mark(Course course, double firstAtt, double secondAtt, double finalAtt, Student student) {
        this.course = course;
        this.firstAtt = firstAtt;
        this.secondAtt = secondAtt;
        this.finalAtt = finalAtt;
        this.student = student;
        updateMarks();
    }

    // Getters and Setters
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getFirstAtt() {
        return firstAtt;
    }

    public void setFirstAtt(double firstAtt) {
        this.firstAtt = firstAtt;
        updateMarks();
    }

    public double getSecondAtt() {
        return secondAtt;
    }

    public void setSecondAtt(double secondAtt) {
        this.secondAtt = secondAtt;
        updateMarks();
    }

    public double getFinalAtt() {
        return finalAtt;
    }

    public void setFinalAtt(double finalAtt) {
        this.finalAtt = finalAtt;
        updateMarks();
    }

    public double getTotalAtt() {
        return totalAtt;
    }

    public double getGpa() {
        return gpa;
    }

    public String getMarkOfLiteral() {
        return markOfLiteral;
    }

    public double getMarkOfDigit() {
        return markOfDigit;
    }

    public Student getStudent() {
        return student;
    }

    // Methods
    private void updateMarks() {
        totalAtt = firstAtt + secondAtt + finalAtt;
        calculateGpaAndLiteralMark();
    }

    private void calculateGpaAndLiteralMark() {
        int range = (int) Math.floor(totalAtt / 5);
        switch (range) {
            case 20, 19 -> { // 94.5 - 100
                markOfLiteral = "A";
                markOfDigit = 4.0;
            }
            case 18 -> { // 89.5 - 94.4
                markOfLiteral = "A-";
                markOfDigit = 3.67;
            }
            case 17 -> { // 84.5 - 89.4
                markOfLiteral = "B+";
                markOfDigit = 3.33;
            }
            case 16 -> { // 79.5 - 84.4
                markOfLiteral = "B";
                markOfDigit = 3.0;
            }
            case 15 -> { // 74.5 - 79.4
                markOfLiteral = "B-";
                markOfDigit = 2.67;
            }
            case 14 -> { // 69.5 - 74.4
                markOfLiteral = "C+";
                markOfDigit = 2.33;
            }
            case 13 -> { // 64.5 - 69.4
                markOfLiteral = "C";
                markOfDigit = 2.0;
            }
            case 12 -> { // 59.5 - 64.4
                markOfLiteral = "C-";
                markOfDigit = 1.67;
            }
            case 11 -> { // 54.5 - 59.4
                markOfLiteral = "D+";
                markOfDigit = 1.33;
            }
            case 10 -> { // 50.0 - 54.4
                markOfLiteral = "D";
                markOfDigit = 1.0;
            }
            default -> { // Below 50.0
                markOfLiteral = "F";
                markOfDigit = 0.0;
            }
        }
        gpa = markOfDigit;
    }

    public String checkFailureOrRetake() {
        if (totalAtt < 50) {
            return "Failed the course.";
        } else if (finalAtt < 20) {
            return "Eligible for retake (Fee: 35,000 KZT).";
        } else {
            return "Passed the course.";
        }
    }

    public void putMark(TypeOfMark typeOfMark, double points) {
        switch (typeOfMark) {
            case FIRST_ATT -> setFirstAtt(points);
            case SECOND_ATT -> setSecondAtt(points);
            case FINAL_ATT -> setFinalAtt(points);
        }
    }

    @Override
    public String toString() {
        return String.format("Course: %s, GPA: %.2f, Literal Mark: %s, Total: %.1f",
                course.getTitle(), gpa, markOfLiteral, totalAtt);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Mark mark = (Mark) obj;
        return Double.compare(mark.totalAtt, totalAtt) == 0 && course.equals(mark.course);
    }

    @Override
    public int hashCode() {
        return course.hashCode() + (int) totalAtt;
    }

}
