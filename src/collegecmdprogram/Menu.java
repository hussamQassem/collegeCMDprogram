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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void officeMenu() throws SQLException {
        while (true) {
            System.out.println("1- Generate Courses Report");
            System.out.println("2- Generate Student Report");
            System.out.println("3- Generate Lecturer Report");
            System.out.println("4- Change Username And Password");
            System.out.println("5- Exit");
            option = sc.nextInt();
            int type;

            switch (option) {

                case 1:
                    type = 1;
                    saveTypeTo(type);
                    break;
                case 2:
                    type = 2;
                    saveTypeTo(type);
                    break;
                case 3:
                    type = 3;
                    saveTypeTo(type);
                    break;
                case 4:
                    System.out.println(" Change Office Username");
                    String changeUsername = sc.next();
                    System.out.println("Change Office Password");
                    String changePassword = sc.next();
                    loggedUser.changeUsernamePassword(changeUsername, changePassword);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;

            }

        }
    }

    public void saveTypeTo(int type) throws SQLException {
        while (true) {
            System.out.println("1- Save To TXT File");
            System.out.println("2- Save To CSV File");
            System.out.println("3- Display On Console");
            System.out.println("4- Exit");

            int fileOption = sc.nextInt();
            if (type == 1) {
                switch (fileOption) {
                    case 1:
                        loggedUser.generateCourseReport(OutputType.TXT);
                        System.out.println("TXT File Saved");
                        break;
                    case 2:
                        loggedUser.generateCourseReport(OutputType.CSV);
                        System.out.println("CSV File Saved");
                        break;
                    case 3:
                        displayCoursesOnConsole();

                        
                        break;
                    case 4:
                        System.out.println("Exit");
                        return;
                    default:
                        System.out.println("Please Enter Valid Option");
                        break;
                }
            } else if (type == 2) {
                switch (fileOption) {
                    case 1:
                        loggedUser.generateStudentReport(OutputType.TXT);
                        System.out.println("TXT File Saved");
                        break;
                    case 2:
                        loggedUser.generateStudentReport(OutputType.CSV);
                        System.out.println("CSV File Saved");
                        break;
                    case 3:

                        displayStudentOnConsole();
                        break;
                    case 4:
                        System.out.println("Exit");
                        return;
                    default:
                        System.out.println("Please Enter Valid Option");
                        break;
                }
            } else if (type == 3) {
                switch (fileOption) {
                    case 1:
                        loggedUser.generateLecturerReport(OutputType.TXT);
                        System.out.println("TXT File Saved");
                        break;
                    case 2:
                        loggedUser.generateLecturerReport(OutputType.CSV);
                        System.out.println("CSV File Saved");
                        break;
                    case 3:

                        displayLecturerOnConsole();
                        break;
                    case 4:
                        System.out.println("Exit");
                        return;
                    default:
                        System.out.println("Please Enter Valid Option");
                        break;
                }
            }

        }
    }

    public void lecturerMenu() throws SQLException {
        while (true) {
            System.out.println("1- Generate Lecturer Report");
            System.out.println("2- Change Username And Password");
            System.out.println("3- Exit");
            option = sc.nextInt();

            switch (option) {

                case 1:
                    System.out.println("1- Save To TXT File");
                    System.out.println("2- Save To CSV File");
                    System.out.println("3- Display On Console");

                    int reportOption = sc.nextInt();
                    if (reportOption == 1) {
                        loggedUser.generateLecturerReport(OutputType.TXT);
                        System.out.println("TXT File Saved");
                    } else if (reportOption == 2) {
                        loggedUser.generateLecturerReport(OutputType.CSV);
                        System.out.println("CSV File Saved");
                    } else if (reportOption == 3) {
                        System.out.println("Dispaly On Console");
                    } else {
                        System.out.println("Please Enter Valid Option");
                    }
                    break;
                case 2:
                    System.out.println(" Change Lecturer Username");
                    String changeUsername = sc.next();
                    System.out.println("Change Lecturer Password");
                    String changePassword = sc.next();
                    loggedUser.changeUsernamePassword(changeUsername, changePassword);
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;

            }

        }

    }
        public void displayStudentOnConsole() {
        try {
            ArrayList<Student> studentsTable = db.getStudentArray();

            for (Student sTable : studentsTable) {
                System.out.println(String.format("'%s', '%s', '%s', '%s', %d;",
                        sTable.getStudentId(), sTable.getName(), sTable.getStudentProgramme(), sTable.getStudentStatus(), sTable.getStudentGrade()));

            }
            System.out.println("------------------------------------------------------------------------");
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayCoursesOnConsole() {
        try {

            ArrayList<Courses> courses = db.getCourseArray();
            for (Courses courseTable : courses) {
                System.out.println(String.format("'%s', '%s', %d, '%s', '%s';",
                        courseTable.getModule(), courseTable.getInprogramm(), courseTable.getStudentsNum(), courseTable.getLecturer(), courseTable.getRoomType()));

            }
            System.out.println("------------------------------------------------------------------------");

        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void displayLecturerOnConsole() {
        try {
            ArrayList<Lecturers> lecturer = db.getLecturerArray();
            for (Lecturers lTable : lecturer) {
                System.out.println(String.format("'%s', '%s', '%s', %d,'%s', ;",
                        lTable.getLectureName(), lTable.getLectureRoll(), lTable.getModuleInSemester(), lTable.getStudentEnrolledNum(), lTable.getLectureSkills()));

            }
            System.out.println("------------------------------------------------------------------------");

        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void writeStudentsTo(OutputType outputType) throws SQLException {

        try {
            BufferedWriter wr;
            if (outputType == OutputType.CSV) {
                wr = new BufferedWriter(new FileWriter("output.csv", true));
            } else {
                wr = new BufferedWriter(new FileWriter("output.txt", true));
            }

            ArrayList<Student> students = db.getStudentArray();
            wr.newLine();
            wr.write("Student ID, Student Name, Student Programme, Student Status, Student Grade");
            wr.newLine();
            for (Student sTable : students) {
                String outputLine = String.format("'%s', '%s', '%s', '%s', %d",
                        sTable.getStudentId(), sTable.getName(), sTable.getStudentProgramme(), sTable.getStudentStatus(), sTable.getStudentGrade());
                wr.write(outputLine);
                wr.newLine();
            }

            wr.close();
            System.out.println("saved to txt file");

        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
