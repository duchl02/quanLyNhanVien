package quanLyNhanVien;

public class Task {
    protected Staff staff;

    protected Project project;
    protected String timeDo;
    protected String status;
    protected String description;
    protected String id;

    protected String taskNAme;

    public Task(String id, String taskNAme,String description,  String timeDo , String status, Staff staff,Project project){
        this.id = id;
        this.timeDo = timeDo;
        this.status = status;
        this.description= description;
        this.staff= staff;
        this.taskNAme = taskNAme;
        this.project = project;
    }


    public String getTimeDo(){
        return timeDo;
    }

    public void setTimeDo(String timeDo){
        this.timeDo = timeDo;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                "tên task='" + taskNAme + '\'' +
                ", thời gian='" + timeDo + "', trạng thái= '" + status +
                "',mô tả='" + description +
                '}';
    }
}
