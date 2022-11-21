package quanLyNhanVien;

import java.util.ArrayList;
import java.util.List;

public class Project {
    protected String projectName;
    protected String id;

    protected String description;
    protected List<Staff> staff = new ArrayList<>();

    protected List<Task> task = new ArrayList<>();

    public Project(String id,String projectName,String description, Staff staff, Task task ) {
        this.projectName = projectName;
        this.id = id;
        this.description = description;
//        this.staff = staff;
//        this.task = task;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public List<Staff> getStaff(){
        return this.staff;
    }
//
//    public void setStaff(Staff staff){
//        this.staff = staff;
//    }

    public void addStaff(Staff staff){
        this.staff.add(staff);
    }
    public void addTask(Task task){
        this.task.add(task);
    }
//    public String toString() {
////        Staff currentStaff;
////        if (staff != null){
////            currentStaff = staff;
////        } else {
////            currentStaff=null;
////        }
////        Task currentTask;
////        if (task != null){
////            currentTask = task;
////        } else {
////            currentTask = null;
////        }
//        return "Dự án{" +
//                "id='" + id + '\'' +
//                "tên dự án='" + projectName + '\'' +
//                ", mô tả=" + description +
//                ", nhân viên='" + staff + '\'' +  ", Task"+ task +
//                '}';
//    }
public String showProject(){
    return "Dự án{" +
                "id='" + id + '\'' +
                "tên dự án='" + projectName + '\'' +
                ", mô tả=" + description + "}";
}
}
