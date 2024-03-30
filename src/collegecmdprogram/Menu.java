/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collegecmdprogram;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hussa
 */
public class Menu {

    DBConnection db = new DBConnection();
    private User loggedUser;
    private ArrayList<User> users = new ArrayList();
    Scanner sc = new Scanner(System.in);
    int option;

    public Menu() {
        users.add(new User("admin", "java", UserRole.ADMIN));
    }

    public void display() throws SQLException {

        while (true) {
            while (loggedUser == null) {
                System.out.println("Login");
                System.out.println("Enter User Name");
                String username = sc.next();
                System.out.println("Enter Password");
                String password = sc.next();

                for (User user : users) {
                    if (user.getUsername().equals(username)) {
                        if (user.getPassword().equals(password)) {
                            loggedUser = user;
                        } else {
                            System.out.println("Incorrect password.");
                            break;
                        }
                    }
                }
                System.out.println("The user " + username + " doesn't exits.");
            }

            if (loggedUser.getRole() == UserRole.ADMIN) {
                
            } else if (loggedUser.getRole() == UserRole.OFFICE) {
                
            } else {
                
            }
            
            loggedUser = null;
        }

    }

    public void adminMenu() throws SQLException {
        while (true) {
            System.out.println("Please Choose Option");
            System.out.println("1- Add User");
            System.out.println("2- Modify User");
            System.out.println("3- Remove user");
            System.out.println("4- Change password");
            System.out.println("5- Exit");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter new Username");
                    String addUsername = sc.next();
                    System.out.println("Enter new Password");
                    String addPassword = sc.next();
                    System.out.println("Enter The User Role: (ADMIN, OFFICE, LECTURER");
                    String addRole = sc.next();
                    loggedUser.addUser(users, addUsername, addPassword, UserRole.valueOf(addRole.toUpperCase()));
                    break;
                case 2:
                    System.out.println("Enter Old Username to modify");
                    String oldUsername = sc.next();
                    System.out.println("Enter New Username");
                    String newUsername = sc.next();
                    System.out.println("Enter New Password");
                    String newPassword = sc.next();
                    System.out.println("Enter New Role");
                    String newRole = sc.next();
                    loggedUser.modifyUser(users, oldUsername, newUsername, newPassword, UserRole.valueOf(newRole.toUpperCase()));
                    break;
                case 3:
                    System.out.println(" Enter Username to remove");
                    String removeUser = sc.next();
                    loggedUser.removeUser(users, removeUser);
                    break;
                case 4:
                    System.out.println(" Change Admin Username");
                    String changeUsername = sc.next();
                    System.out.println("Change Admin Password");
                    String changePassword = sc.next();
                    loggedUser.changeUsernamePassword(changeUsername, changePassword);
                    break;
                case 5:
                    System.out.println("Looged out.");
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;

            }

        }

    }
}
