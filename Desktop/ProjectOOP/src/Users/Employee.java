package Users;

import Enums.*;
import Social.EmployeeRequest;

import java.util.List;
import java.util.Objects;

public abstract class Employee extends User {
    private int experience;
    private String department;
    private List<EmployeeRequest> requests;

    public Employee(String id, String name, String lastName, String password, String email, int experience, String department) {
        super(id, name, lastName, password, email);
        this.experience = experience;
        this.department = department;
    }
    public int getExperience() {
        return experience;

    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public boolean isSignedByDeanOrRector() {
        return requests.stream()
                .anyMatch(request -> request.isSignedOff() && request.getRequester() instanceof Manager); // Example check
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return experience == employee.experience && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(experience, department);
    }
    @Override
    public String toString() {
        return "Employee{" +
                "experience=" + experience +
                ", department='" + department + '\'' +
                '}';
    }

}
