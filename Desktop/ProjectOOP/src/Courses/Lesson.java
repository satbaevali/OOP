package Courses;

import java.util.Objects;
import Users.*;
import Enums.*;


public class Lesson {
    private Course course;
    private LessonType lessonType;
    private int roomForLesson;
    public Lesson(Course course, LessonType lessonType, int roomForLesson) {
        this.course = course;
        this.lessonType = lessonType;
        this.roomForLesson = roomForLesson;
    }
    public Course getCourse() {
        return course;
    }
    public void setCourse(Course course) {
        this.course = course;
    }

    public LessonType getLessonType() {
        return lessonType;
    }
    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }

    public int getRoomForLesson() {
        return roomForLesson;

    }
    public void setRoomForLesson(int roomForLesson) {
        this.roomForLesson = roomForLesson;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "course=" + course +
                ", LessonType=" +lessonType +
                ", roomForLesson=" + roomForLesson +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return roomForLesson == lesson.roomForLesson && Objects.equals(course, lesson.course) && lessonType == lesson.lessonType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, lessonType, roomForLesson);
    }

}
