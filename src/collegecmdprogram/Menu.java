/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collegecmdprogram;

import java.util.Scanner;

/**
 *
 * @author hussa
 */
public class Menu {

    Scanner sc = new Scanner(System.in);
    private User user = new User("admin", "java", UserRole.ADMIN);
    int option;

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
                    user.addUser(addUsername, addPassword, UserRole.valueOf(addRole.toUpperCase()));
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
            }
        }
    }
}
