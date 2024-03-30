/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collegecmdprogram;

/**
 *
 * @author hussa
 */
public class Student {

    private String studentId;
    private String name;
    private String studentProgramme;
    private String studentStatus;
    private int studentGrade;

    public Student(String studentId, String name, String studentProgramme, String studentStatus, int studentGrade) {
        this.studentId = studentId;
        this.name = name;
        this.studentProgramme = studentProgramme;
        this.studentStatus = studentStatus;
        this.studentGrade = studentGrade;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getStudentProgramme() {
        return studentProgramme;
    }

    public String getStudentStatus() {
        return studentStatus;
    }

    public int getStudentGrade() {
        return studentGrade;
    }

}
