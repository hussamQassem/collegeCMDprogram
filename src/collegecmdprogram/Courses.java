/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collegecmdprogram;

/**
 *
 * @author hussa
 */
public class Courses {

    private String module;
    private String inprogramm;
    private int studentsNum;

    public Courses(String module, String inprogramm, int studentsNum, String lecturer) {
        this.module = module;
        this.inprogramm = inprogramm;
        this.studentsNum = studentsNum;
        this.lecturer = lecturer;
    }
    private String lecturer;

    public String getModule() {
        return module;
    }

    public String getInprogramm() {
        return inprogramm;
    }

    public int getStudentsNum() {
        return studentsNum;
    }

    public String getLecturer() {
        return lecturer;
    }

}
