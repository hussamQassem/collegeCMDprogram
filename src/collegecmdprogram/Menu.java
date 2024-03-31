package collegecmdprogram;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


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
// menu method will add the admin username and password
    public Menu() {
        users.add(new User("admin", "java", UserRole.ADMIN));
    }
// display method that will allow only admin log in as start
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
                //System.out.println("The user " + username + " doesn't exits.");
            }

            if (loggedUser.getRole() == UserRole.ADMIN) {
                adminMenu();
            } else if (loggedUser.getRole() == UserRole.OFFICE) {
                officeMenu();
            } else {
                lecturerMenu();
            }

            loggedUser = null;
        }

    }
// this admin menu will display the admin options
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
// office menu that dispaly the office options
    public void officeMenu() throws SQLException {
        while (true) {
            System.out.println("1- Generate Courses Report");
            System.out.println("2- Generate Student Report");
            System.out.println("3- Generate Lecturer Report");
            System.out.println("4- Generate New Report");
            System.out.println("5- Change Username And Password");
            System.out.println("6- Exit");
            option = sc.nextInt();
            int reportType;

            switch (option) {

                case 1:
                    reportType = 1;
                    saveTypeTo(reportType);
                    break;
                case 2:
                    reportType = 2;
                    saveTypeTo(reportType);
                    break;
                case 3:
                    reportType = 3;
                    saveTypeTo(reportType);
                    break;
                case 4:
                    addToreport();
                case 5:
                    System.out.println(" Change Office Username");
                    String changeUsername = sc.next();
                    System.out.println("Change Office Password");
                    String changePassword = sc.next();
                    loggedUser.changeUsernamePassword(changeUsername, changePassword);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;

            }

        }
    }
// lecturer menu will display only lecturer users option
    public void lecturerMenu() throws SQLException {
        while (true) {
            System.out.println("1- Generate Lecturer Report");
            System.out.println("2- Change Username And Password");
            System.out.println("3- generate New Lecturer Report.");
            System.out.println("4- Exit");
            option = sc.nextInt();

            switch (option) {

                case 1:
                    System.out.println("1- Save To TXT File");
                    System.out.println("2- Save To CSV File");
                    System.out.println("3- Display On Console");
                    System.out.println("4- Exit");

                    int reportOption = sc.nextInt();
                    if (reportOption == 1) {
                        loggedUser.generateLecturerReport(OutputType.TXT);
                        System.out.println("TXT File Saved");
                    } else if (reportOption == 2) {
                        loggedUser.generateLecturerReport(OutputType.CSV);
                        System.out.println("CSV File Saved");
                    } else if (reportOption == 3) {
                        displayLecturerOnConsole();
                    } else {
                        System.out.println("Eixt");
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
                    System.out.println("Enter The Lecturer ID.");
                    String lecturerID = sc.next();
                    System.out.println("Enter The Lecturer Name.");
                    String lecturerName1 = sc.next();
                    System.out.println("Enter The lecturer Teaching Role.");
                    String lecturerRole = sc.next();
                    System.out.println("What Is The Modules In This Semester?.");
                    String semesterModules = sc.next();
                    System.out.println("How Many Students Enrolled With This Lecturer?.");
                    int lecturerStudentNum = sc.nextInt();
                    System.out.println("Enter The Lecturer Skills.");
                    String LecturerSkills = sc.next();
                    db.addToLecturer(new Lecturers(lecturerID, lecturerName1, lecturerRole, semesterModules, lecturerStudentNum, LecturerSkills));

                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;

            }

        }

    }
// menu that can be accessed by office and lecturers users that display options of file type to save reports
    public void saveTypeTo(int reportType) throws SQLException {
        while (true) {
            System.out.println("1- Save To TXT File");
            System.out.println("2- Save To CSV File");
            System.out.println("3- Display On Console");
            System.out.println("4- Exit");

            int fileOption = sc.nextInt();
            if (reportType == 1) {
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
                        System.out.println("Dispaly On Console");
                        break;
                    case 4:
                        System.out.println("Exit");
                        return;
                    default:
                        System.out.println("Please Enter Valid Option");
                        break;
                }
            } else if (reportType == 2) {
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
                        System.out.println("Dispaly On Console");
                        break;
                    case 4:
                        System.out.println("Exit");
                        return;
                    default:
                        System.out.println("Please Enter Valid Option");
                        break;
                }
            } else if (reportType == 3) {
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
                        System.out.println("Dispaly On Console");
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
// method that will invoke data from the student table and display it on the console
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
// method that will invoke data from the course table and display it on the console
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
// method that will invoke data from the lecturers table and display it on the console
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

// method will allow office users to add to the tables 
    public void addToreport() throws SQLException {
        while (true) {

            System.out.println("Please choose the report to generait more data");
            System.out.println("1- Courses");
            System.out.println("2- Student");
            System.out.println("3- Lecturer");
            System.out.println("4- Exit");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter The Module ID.");
                    String moduleID = sc.next();
                    System.out.println("Enter The Module Name.");
                    String moduleName = sc.next();
                    System.out.println("Enter The programme Name.");
                    String courseProgramme = sc.next();
                    System.out.println("How Many Students Enrolled.");
                    int studentsEnrolled = sc.nextInt();
                    System.out.println("Enter The Lecturer Name.");
                    String lecturerName = sc.next();
                    System.out.println("Enter Room Or Location.");
                    String roomOrLocation = sc.next();
                    db.addToCourses(new Courses(moduleID, moduleName, courseProgramme, studentsEnrolled, lecturerName, roomOrLocation));
                case 2:
                    System.out.println("Enter The Student ID.");
                    String studentID = sc.next();
                    System.out.println("Enter The Student Name.");
                    String studentName = sc.next();
                    System.out.println("Enter The Student programme Name.");
                    String studentProgramme = sc.next();
                    System.out.println("Enter The Student Status.");
                    String studentStatus = sc.next();
                    System.out.println("Enter The Student Grade.");
                    int studentGrade = sc.nextInt();
                    db.addToStudent(new Student(studentID, studentName, studentProgramme, studentStatus, studentGrade));

                case 3:
                    System.out.println("Enter The Lecturer ID.");
                    String lecturerID = sc.next();
                    System.out.println("Enter The Lecturer Name.");
                    String lecturerName1 = sc.next();
                    System.out.println("Enter The lecturer Teaching Role.");
                    String lecturerRole = sc.next();
                    System.out.println("What Is The Modules In This Semester?.");
                    String semesterModules = sc.next();
                    System.out.println("How Many Students Enrolled With This Lecturer?.");
                    int lecturerStudentNum = sc.nextInt();
                    System.out.println("Enter The Lecturer Skills.");
                    String LecturerSkills = sc.next();
                    db.addToLecturer(new Lecturers(lecturerID, lecturerName1, lecturerRole, semesterModules, lecturerStudentNum, LecturerSkills));
                case 4:
                    return;

            }
        }

    }

}
