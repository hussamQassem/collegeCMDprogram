package collegecmdprogram;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author hussa
 */
public class Lecturers {

    String lecturerId;
    String lectureName;
    String lectureRoll;
    String moduleInSemester;
    int studentEnrolledNum;
    String lectureSkills;

    public Lecturers(String lecturerId, String lectureName, String lectureRoll, String moduleInSemester, int studentEnrolledNum, String lectureSkills) {
        this.lecturerId = lecturerId;
        this.lectureName = lectureName;
        this.lectureRoll = lectureRoll;
        this.moduleInSemester = moduleInSemester;
        this.studentEnrolledNum = studentEnrolledNum;
        this.lectureSkills = lectureSkills;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public String getLectureName() {
        return lectureName;
    }

    public String getLectureRoll() {
        return lectureRoll;
    }

    public String getModuleInSemester() {
        return moduleInSemester;
    }

    public int getStudentEnrolledNum() {
        return studentEnrolledNum;
    }

    public String getLectureSkills() {
        return lectureSkills;
    }

}
