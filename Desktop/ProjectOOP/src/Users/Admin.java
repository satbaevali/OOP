

package Users;

import Enums.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Admin extends Employee {
    private List<User> managedUsers;

    public Admin(String id, String name, String lastName, String password, String email,int experience) {
        super(id, name, lastName, password, email,experience, "Admin Department");
        this.managedUsers = new ArrayList<>();

    }
    public void addUser(User user) {
        if(!managedUsers.contains(user)) {
            managedUsers.add(user);
            System.out.println("User added: "+user.getName());

        }else{
            System.out.println("User already exists");
        }
    }
    public void removeUser(User user) {
        if(managedUsers.contains(user)) {
            managedUsers.remove(user);
            System.out.println("User removed: "+user.getName());
        }
        else{
            System.out.println("User does not found");
        }
    }
    public void updateUser(User user,String newEmail) {
        if (managedUsers.contains(user)) {
            user.setEmail(newEmail);
            System.out.println("User's email updated: " + user.getName());
        } else {
            System.out.println("User not found.");
        }

    }
    public void displayManagedUsers() {
        if (managedUsers.isEmpty()) {
            System.out.println("No users are managed by this admin.");
        } else {
            System.out.println("Managed users:");
            for (User user : managedUsers) {
                System.out.println(user);
            }
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(managedUsers, admin.managedUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(managedUsers);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "managedUsers=" + managedUsers +
                '}';
    }
}

