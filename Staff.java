package quanLyNhanVien;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Staff {
    private String name;
    private int age;
    private String id;
    private List<Project> project = new ArrayList<>();

    private List<Task> task;
    private String address;

    private String position;

    private String birthDate;
    public Staff(String id, String name, int age, String address, String birthDate, String position, Project project, Task task) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.address = address;
        this.position = position;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }

    public String getPosition(){
        return position;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public void addProject(Project project){
        this.project.add(project);
    }
    public void addTask(Task task){
        this.task.add(task);
    }


    public String getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public List<Project> getProject() {
        return project;
    }

    public void setProject(List<Project> project) {
        this.project = project;
    }
    public List<Task> getTasks() {
        return task;
    }

    public void setTask(List<Task> tasks) {
        this.task = tasks;
    }
    public void showProject(){
        this.project.forEach(p -> System.out.println(p.showProject()));
    }


    @Override
    public String toString() {
        return "Nhân viên{" +
                "id='" + id + '\'' +
                "tên nhân viên='" + name + '\'' +
                ", tuổi=" + age +
        ", địa chỉ='" + address + '\'' + ", ngày sinh=" + birthDate + ", vị trí=" + position +
                '}';
    }


}
