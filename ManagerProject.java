package quanLyNhanVien;

import java.util.Map;

public class ManagerProject {

    private MyMap<Integer,Project> projects;

    public ManagerProject() {
        projects = new MyMap<Integer,Project>();
    }

    public void add(Project project, int id) {
        this.projects.put(id,project);
    }

    public Project searchProjectById(Integer id) {
        Project currentProject = null;
            if (projects.containsKey(id)) {
                currentProject= projects.get(id);
            }
        return currentProject;  
      }
   public boolean editProjectById(Integer id, String name, String description) {
       boolean isExisted = false;
           if (projects.containsKey(id)) {
               isExisted = true;
               projects.get(id).setProjectName(name);
               projects.get(id).setDescription(description);
           }
       return isExisted;
   }

    public boolean checkProjectById(Integer id){
        boolean isExisted = false;
            if (projects.containsKey(id)) {
                isExisted = true;
            }
        return isExisted;
    }

    public void show() {
        // this.projects.forEach(p -> System.out.println(p.showProject()));
       for (Map.Entry<Integer, Project> entry : projects.entrySet()){
        System.out.println(entry.getKey() +" " + entry.getValue());
       }
    }
}
