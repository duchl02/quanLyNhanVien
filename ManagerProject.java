package quanLyNhanVien;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerProject {
    private List<Project> projects;

    public ManagerProject() {
        projects = new ArrayList<>();
    }

    public void add(Project project) {
        this.projects.add(project);
    }

//    public boolean delete(String id) {
//        Project project = this.projects.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
//        if (project == null) {
//            return false;
//        } else {
//            this.projects.remove(project);
//            return true;
//        }
//    }
    public Project searchProjectById(String id) {
        Project currentProject = null;
        int size = projects.size();
        for (int i = 0; i < size; i++) {
            if (projects.get(i).getId().equals(id)) {
                currentProject= projects.get(i);
                break;
            }
        }
        return currentProject;    }
//    public boolean editProjectById(String id, String name, String description) {
//        boolean isExisted = false;
//        int size = projects.size();
//        for (int i = 0; i < size; i++) {
//            if (projects.get(i).getId().equals(id)) {
//                isExisted = true;
//                projects.get(i).setProjectName(name);
//                projects.get(i).setDescription(description);
//                break;
//            }
//        }
//        return isExisted;
//    }

    public boolean checkProjectById(String id){
        boolean isExisted = false;
        int size = projects.size();
        for (int i = 0; i < size; i++) {
            if (projects.get(i).getId().equals(id)) {
                isExisted = true;
                break;
            }
        }
        return isExisted;
    }

    public void show() {
        this.projects.forEach(p -> System.out.println(p.showProject()));
    }
}
