package Users;
import java.io.Serializable;
import java.util.*;

import Enums.*;
import Social.*;
import Users.Student;


public class Librarian extends Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private Map<Student, List<Book>> listOfStudents;
    private Map<Book, Integer> countOfBooks;

    public Librarian(String id, String name, String lastName, String password, String email, int experience, String department) {
        super(id, name, lastName, password, email,experience, department);
        listOfStudents = new HashMap<>();
        countOfBooks = new HashMap<>();
    }

    public void addBook(Book book, Integer countOfBook) {
        if (book == null || countOfBook == null || countOfBook < 0) {
            throw new IllegalArgumentException("Book and count must be valid and count must be non-negative.");
        }
        countOfBooks.put(book, countOfBook);
    }

    public void writeStudent(Student student, Book takenBook) {
        if (student == null || takenBook == null) {
            throw new IllegalArgumentException("Student and book must not be null.");
        }

        if (countOfBooks.containsKey(takenBook) && countOfBooks.get(takenBook) > 0) {
            countOfBooks.put(takenBook, countOfBooks.get(takenBook) - 1);

            listOfStudents.putIfAbsent(student, new ArrayList<>());
            listOfStudents.get(student).add(takenBook);
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void returnBook(Student student, Book returnedBook) {
        if (student == null || returnedBook == null) {
            throw new IllegalArgumentException("Student and book must not be null.");
        }

        if (listOfStudents.containsKey(student) && listOfStudents.get(student).contains(returnedBook)) {
            listOfStudents.get(student).remove(returnedBook);
            countOfBooks.put(returnedBook, countOfBooks.getOrDefault(returnedBook, 0) + 1);
        } else {
            System.out.println("The student did not borrow this book.");
        }
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (Map.Entry<Book, Integer> entry : countOfBooks.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " copies available");
        }
    }

    public Map<Student, List<Book>> getListOfStudents() {
        return listOfStudents;
    }

    public Map<Book, Integer> getCountOfBooks() {
        return countOfBooks;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "listOfStudents=" + listOfStudents +
                ", countOfBooks=" + countOfBooks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Librarian librarian = (Librarian) o;
        return Objects.equals(listOfStudents, librarian.listOfStudents) && Objects.equals(countOfBooks, librarian.countOfBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), listOfStudents, countOfBooks);
    }
}