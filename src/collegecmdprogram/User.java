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

    public void generateCourseReport(OutputType outputType) throws SQLException {
        if (this.role != UserRole.OFFICE) {
            System.out.println("Only OFFICE users can generate Course Reports");
            return;
        }

        try {
            BufferedWriter wr;
            if (outputType == OutputType.CSV) {
                wr = new BufferedWriter(new FileWriter("output.csv", true));
            } else {
                wr = new BufferedWriter(new FileWriter("output.txt", true));
            }

            ArrayList<Courses> courses = new DBConnection().getCourseArray();
            wr.write("Module, programme, Number Of Student Enrolled, Lecturer Name, Room Type");
            wr.newLine();
            for (Courses courseTable : courses) {
                String outputLine = String.format("'%s', '%s', %d, '%s', '%s'",
                        courseTable.getModule(), courseTable.getInprogramm(), courseTable.getStudentsNum(), courseTable.getLecturer(), courseTable.getRoomType());
                wr.write(outputLine);
                wr.newLine();

            }

            wr.close();

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void generateStudentReport(OutputType outputType) throws SQLException {
        if (this.role != UserRole.OFFICE) {
            System.out.println("Only OFFICE users can generate Student Reports");
            return;
        }

        try {
            BufferedWriter wr;
            if (outputType == OutputType.CSV) {
                wr = new BufferedWriter(new FileWriter("output.csv", true));
            } else {
                wr = new BufferedWriter(new FileWriter("output.txt", true));
            }

            ArrayList<Student> students = new DBConnection().getStudentArray();
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

    public void generateLecturerReport(OutputType outputType) throws SQLException {
        if (this.role == UserRole.ADMIN) {
            System.out.println("ADMIN user cannot generate Lecture Reports");
            return;
        }

        try {
            BufferedWriter wr;
            if (outputType == OutputType.CSV) {
                wr = new BufferedWriter(new FileWriter("output.csv", true));
            } else {
                wr = new BufferedWriter(new FileWriter("output.txt", true));
            }

            ArrayList<Lecturers> lecturer;

            if (this.role == UserRole.OFFICE) {
                lecturer = new DBConnection().getLecturerArray();
            } else {
                // TODO: Create a custom method for LECTURE
                lecturer = new DBConnection().getLecturerArray();
            }

            wr.newLine();
            wr.write("Lecture Name,Lecture Roll,Modules In Semester,Number Of Student Enrolled ,Lecture Skills");
            wr.newLine();
            for (Lecturers lTable : lecturer) {
                String outputLine = String.format("'%s', '%s', '%s', %d,'%s'",
                        lTable.getLectureName(),
                        lTable.getLectureRoll(),
                        lTable.getModuleInSemester(),
                        lTable.getStudentEnrolledNum(),
                        lTable.getLectureSkills());

                wr.write(outputLine);
                wr.newLine();
            }
            wr.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
