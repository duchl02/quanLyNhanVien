package quanLyNhanVien;

import java.util.ArrayList;
import java.util.List;

public class Project {
    protected String projectName;
    protected Integer id;

    protected String description;
    protected List<Staff> staff = new ArrayList<>();

    protected List<Task> task = new ArrayList<>();

    public Project(Integer id,String projectName,String description, Staff staff, Task task ) {
        this.projectName = projectName;
        this.id = id;
        this.description = description;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void addStaff(Staff staff){
        this.staff.add(staff);
    }
    public void addTask(Task task){
        this.task.add(task);
    }
   public String toString() {
       return "Dự án{" +
               "id='" + id + '\'' +
               "tên dự án='" + projectName + '\'' +
               ", mô tả=" + description +
               '}';
   }
public String showProject(){
    return "Dự án{" +
                "id='" + id + '\'' +
                "tên dự án='" + projectName + '\'' +
                ", mô tả=" + description + "}";
}
}
