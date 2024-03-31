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
// creating connection with the sql database
    private final String DB_URL = "jdbc:mysql://localhost/?user=root&password=1989";

    private final String USER = "root";
    private final String PASSWORD = "1989";


// array lists of courses, student, lecturers that will read from the database and save it in the arraylist
    public ArrayList<Courses> getCourseArray() throws SQLException {

        ArrayList<Courses> coursesList;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            PreparedStatement PreparedStatement = conn.prepareStatement("SELECT * FROM courses ");
            PreparedStatement.execute("USE CourseManagementSystem;");
            ResultSet rs = PreparedStatement.executeQuery();
            coursesList = new ArrayList<>();
            while (rs.next()) {
                String moduleId=rs.getString("module_id");
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


// this method will create connection with the database and allow to add  data to courses table in the database
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
// this method will create connection with the database and allow to add data to students table in the database
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
// this method will create connection with the database and allow to add  data to lecturers table in the database
    public void addToLecturer(Lecturers lectr) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            stmt.execute("USE CourseManagementSystem;");
            stmt.execute(String.format("INSERT INTO Lecturers(lecturer_id,lecturer_name,lecturer_role,semester_module,number_of_students_enrolled,lecturer_skills) VALUES('%s','%s','%s','%s',%d,'%s');",
                    lectr.getLecturerId(), lectr.getLectureName(), lectr.getLectureRoll(), lectr.getModuleInSemester(), lectr.getStudentEnrolledNum(), lectr.getLectureSkills()));
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
