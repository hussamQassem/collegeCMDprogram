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
    
    Scanner sc= new Scanner(System.in);
        public void display() {
        int option;
        while (true) {
            System.out.println("Admin Login");
            System.out.println("Enter User Name");
            String adminUsernameInput = sc.nextLine();
            System.out.println("Enter Password");
            String adminPasswordInput = sc.nextLine();

            if (adminUsernameInput.equals("admin") && adminPasswordInput.equals("java")) {

              
            } else {
                System.out.println(" incorrect login");
            }
        }

    }
}
