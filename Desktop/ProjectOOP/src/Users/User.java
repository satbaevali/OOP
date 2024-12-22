package Users;
import Enums.*;
import Social.*;

import java.util.*;

public class User implements Comparable<User> {
    private String id;
    private String name;
    private String lastName;
    private String password;
    private String email;
    private static Set<User> users = new HashSet<>();
    private  Vector<Message> messages;
    public User(String id, String name, String lastName, String password, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        users.add(this);
    }
    public void sendMessage(String itTo, String content) {
        Message.sendMessage(this.getId(), itTo, content);
    }
    public void receiveMessage(Message message) {
        messages.add(message);
    }

    public void printMessages() {
        System.out.println(messages);
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
    public static User getUserById(String id) {
        return findUser(id);
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public boolean changePassword(String oldPassword, String newPassword) {
        if (!this.password.equals(oldPassword)) {
            System.out.println("Incorrect old password.");
            return false;
        }
        if (!isValidPassword(newPassword)) {
            System.out.println("The new password does not meet security requirements.");
            return false;
        }
        this.password = newPassword;
        System.out.println("Password changed successfully.");
        return true;
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8
                && password.matches(".*\\d.*")
                && password.matches(".*[!@#$%^&*].*");
    }




    public static List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public int compareTo(User other) {
        return this.id.compareTo(other.id);
    }
    public static User findUser(String id) {
        for (User u : users) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'';
    }
}
