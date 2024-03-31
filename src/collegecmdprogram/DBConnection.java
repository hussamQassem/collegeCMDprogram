/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collegecmdprogram;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hussa
 */
public class DBConnection {

    private final String DB_URL = "jdbc:mysql://localhost/?user=pooa2024&password=pooa2024";
    private final String USER = "pooa2024";
    private final String PASSWORD = "pooa2024";

    public ArrayList<Courses> getCourseArray() throws SQLException {

        ArrayList<Courses> coursesList;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            PreparedStatement PreparedStatement = conn.prepareStatement("SELECT * FROM courses ");
            PreparedStatement.execute("USE CourseManagementSystem;");
            ResultSet rs = PreparedStatement.executeQuery();
            coursesList = new ArrayList<>();
            while (rs.next()) {
                String moduleId = rs.getString("module_id");
                String module = rs.getString("module_name");
                String inprogramm = rs.getString("programme");
                int studentsNum = rs.getInt("number_of_students_enrolled");
                String lecturer = rs.getString("lecturer_name");
                String roomType = rs.getString("room_or_location");
                coursesList.add(new Courses(moduleId,module, inprogramm, studentsNum, lecturer, roomType));

            }
        }
        return coursesList;

    }

    public ArrayList<Student> getStudentArray() throws SQLException {

        ArrayList<Student> studentsList;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            PreparedStatement PreparedStatement = conn.prepareStatement("SELECT * FROM Students ");
            PreparedStatement.execute("USE CourseManagementSystem;");
            ResultSet rs = PreparedStatement.executeQuery();
            studentsList = new ArrayList<>();
            while (rs.next()) {

                String studentId = rs.getString("student_id");
                String name = rs.getString("student_name");
                String studentProgramme = rs.getString("programme");
                String studentStatus = rs.getString("student_status");
                int studentGrade = rs.getInt("grade");
                studentsList.add(new Student(studentId, name, studentProgramme, studentStatus, studentGrade));

            }
        }
        return studentsList;

    }

    public ArrayList<Lecturers> getLecturerArray() throws SQLException {

        ArrayList<Lecturers> lectureList;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            PreparedStatement PreparedStatement = conn.prepareStatement("SELECT * FROM Lecturers ");
            PreparedStatement.execute("USE CourseManagementSystem;");
            ResultSet rs = PreparedStatement.executeQuery();
            lectureList = new ArrayList<>();
            while (rs.next()) {
                String lecturerId = rs.getString("lecturer_id");
                String lectureName = rs.getString("lecturer_name");
                String lectureRoll = rs.getString("lecturer_role");
                String moduleInSemester = rs.getString("semester_module");
                int studentEnrolledNum = rs.getInt("number_of_students_enrolled");
                String lectureSkills = rs.getString("lecturer_skills");
                lectureList.add(new Lecturers(lecturerId, lectureName, lectureRoll, moduleInSemester, studentEnrolledNum, lectureSkills));

            }
        }
        return lectureList;

    }

    public void addToCourses(Courses cors) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            stmt.execute("USE CourseManagementSystem;");
            stmt.execute(String.format("INSERT INTO Courses(module_id,module_name,programme,number_of_students_enrolled,lecturer_name,room_or_location) VALUES('%s','%s','%s',%d,'%s','%s');",
                    cors.getModuleId(), cors.getModule(), cors.getInprogramm(), cors.getStudentsNum(), cors.getLecturer(), cors.getRoomType()));

        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
        public void addToStudent(Student stdnt) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            stmt.execute("USE CourseManagementSystem;");
            stmt.execute(String.format("INSERT INTO Student(student_id,student_name,programme,student_status,grade) VALUES('%s','%s','%s','%s',%d);",
                    stdnt.getStudentId(), stdnt.getName(), stdnt.getStudentProgramme(), stdnt.getStudentStatus(), stdnt.getStudentGrade()));
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
