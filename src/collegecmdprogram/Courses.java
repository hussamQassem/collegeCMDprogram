package collegecmdprogram;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author hussa
 */
// courses class with constructors, and getters 
public class Courses {
String moduleId;
    String module;
    String inprogramm;
    int studentsNum;
    String lecturer;
    String roomType;

    public Courses(String moduleId, String module, String inprogramm, int studentsNum, String lecturer, String roomType) {
        this.moduleId = moduleId;
        this.module = module;
        this.inprogramm = inprogramm;
        this.studentsNum = studentsNum;
        this.lecturer = lecturer;
        this.roomType = roomType;
    }

    public String getModuleId() {
        return moduleId;
    }

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
