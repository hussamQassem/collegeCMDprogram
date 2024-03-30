/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collegecmdprogram;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hussa
 */
public class User {

    private String username;
    private String password;
    private UserRole role;

   

    public User(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void addUser(ArrayList<User> users, String username, String password, UserRole role) {
        if (this.role != UserRole.ADMIN) {
            System.out.println("Only ADMIN user can add new users");
            return;
        }

        for (User user : users) {
            if (user.username.equals(username)) {
                System.out.println("There is already an user with " + username + " username.");
                return;
            }
        }

        users.add(new User(username, password, role));
        System.out.println("User " + username + " with role " + role + " created.");
    }

    public void modifyUser(ArrayList<User> users, String oldUsername, String newUsername, String newPassword, UserRole newUserRole) {
        if (this.role != UserRole.ADMIN) {
            System.out.println("Only ADMIN user can modify users");
            return;
        }

        if (users.isEmpty()) {
            System.out.println("There are no users on the system for the moment.");
            return;
        }

        for (User user : users) {
            if (user.username.equals(oldUsername)) {
                user.username = newUsername;
                user.password = newPassword;
                user.role = newUserRole;
                System.out.println("User " + oldUsername + " modified");
                return;
            }
        }

        System.out.println("No user with " + oldUsername + " username found.");
    }

    public void removeUser(ArrayList<User> users, String username) {
        if (this.role != UserRole.ADMIN) {
            System.out.println("Only ADMIN user can remove users");
            return;
        }

        if (users.isEmpty()) {
            System.out.println("There are no users on the system for the moment.");
            return;
        }

        for (User user : users) {
            if (user.username.equals(username)) {
                users.remove(user);
                System.out.println(username + " username has been removed.");
                return;
            }
        }

        System.out.println("No user with " + username + " username found.");
    }
    
    public void changeUsernamePassword(String newUsername, String newPassword) {
        this.username = newUsername;
        this.password = newPassword;
    }

    
    
    
    
    
    
    
    
    
}
