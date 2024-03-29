/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collegecmdprogram;

import java.util.ArrayList;

/**
 *
 * @author hussa
 */
public class User {

    private String username;
    private String password;
    private UserRole role;
    private ArrayList<User> users = new ArrayList();

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

    public void addUser(String username, String password, UserRole role) {
        if (this.role != UserRole.ADMIN) {
            System.out.println("Only ADMIN user can add new users");
            return;
        }

        for (User user : this.users) {
            if (user.username.equals(username)) {
                System.out.println("There is already an user with " + username + " username.");
                return;
            }
        }

        this.users.add(new User(username, password, role));
        System.out.println("User " + username + " with role " + role + " created.");
    }
}
