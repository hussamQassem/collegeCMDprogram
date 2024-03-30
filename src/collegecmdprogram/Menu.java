/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collegecmdprogram;

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

    public void display() {

        while (true) {
            System.out.println("Admin Login");
            System.out.println("Enter User Name");
            String adminUsernameInput = sc.nextLine();
            System.out.println("Enter Password");
            String adminPasswordInput = sc.nextLine();

            if (adminUsernameInput.equals("admin") && adminPasswordInput.equals("java")) {
                AdminMenu();

            } else {
                System.out.println(" incorrect login");
            }
        }

    }

    public void AdminMenu() {
        System.out.println("Please Choose Option");
        System.out.println("1- Add User");
        System.out.println("2- Modify User");
        System.out.println("3- Remove user");
        System.out.println("4- Change password");
        System.out.println("5- Acsses Other Users");
        System.out.println("6- Exit");
        option = sc.nextInt();

        while (true) {

            switch (option) {
                case 1:
                    System.out.println("Enter new Username");
                    String addUsername = sc.nextLine();
                    System.out.println("Enter new Password");
                    String addPassword = sc.nextLine();
                    System.out.println("Enter The User Role");
                    String addRole = sc.nextLine();
                    loggedUser.addUser(users, addUsername, addPassword, UserRole.valueOf(addRole.toUpperCase()));
                    break;
                case 2:
                    System.out.println("Enter Old Username to modify");
                    String oldUsername = sc.nextLine();
                    System.out.println("Enter New Username");
                    String newUsername = sc.nextLine();
                    System.out.println("Enter New Password");
                    String newPassword = sc.nextLine();
                    System.out.println("Enter New Role");
                    String newRole = sc.nextLine();
                    loggedUser.modifyUser(users, oldUsername, newUsername, newPassword, UserRole.valueOf(newRole.toUpperCase()));
                    break;
                case 3:
                    System.out.println(" Enter Username to remove");
                    String removeUser = sc.nextLine();
                      loggedUser.removeUser(users, removeUser);
                    break;
                case 4:
                    System.out.println(" Change Admin Username");
                    String changeUsername = sc.nextLine();
                    System.out.println("Change Admin Password");
                    String changePassword = sc.nextLine();
                    loggedUser.changeUsernamePassword(changeUsername, changePassword);
                    break;
                case 5:
                case 6:
            }
        }
    }
}
