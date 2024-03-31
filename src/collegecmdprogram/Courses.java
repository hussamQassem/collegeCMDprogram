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
String moduleId;
    private String module;
    private String inprogramm;
    private int studentsNum;
    private String roomType;

    public Courses(String moduleId,String module, String inprogramm, int studentsNum, String lecturer, String roomType) {
        this.moduleId = moduleId;
        this.module = module;
        this.inprogramm = inprogramm;
        this.studentsNum = studentsNum;
        this.lecturer = lecturer;
    }

  

    public String getModuleId() {
        return moduleId;
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

    public String getRoomType() {
        return roomType;
    }

}
