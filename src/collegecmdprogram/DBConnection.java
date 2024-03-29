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
import java.util.ArrayList;

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

                String module = rs.getString("module_name");
                String inprogramm = rs.getString("programme");
                int studentsNum = rs.getInt("number_of_students_enrolled");
                String lecturer = rs.getString("lecturer_name");
                String roomType = rs.getString("room_or_location");
                coursesList.add(new Courses(module, inprogramm, studentsNum, lecturer, roomType));

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
                lectureList.add(new Lecturers(lecturerId,lectureName, lectureRoll, moduleInSemester, studentEnrolledNum, lectureSkills));

            }
        }
        return lectureList;

    }  
}


