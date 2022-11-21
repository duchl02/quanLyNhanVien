package quanLyNhanVien;

import java.util.ArrayList;
import java.util.List;

public class ManagerTask {
    private List<Task> tasks;



    public ManagerTask() {
        tasks = new ArrayList<>();
    }

    public void add(Task task) {
        this.tasks.add(task);
    }

    public Task searchTaskById(String id) {
        Task currentTask = null;
        int size = tasks.size();
        for (int i = 0; i < size; i++) {
            if (tasks.get(i).getId().equals(id)) {
                currentTask= tasks.get(i);
                break;
            }
        }
        return currentTask;
    }
    public boolean checkTaskById(String id){
        boolean isExisted = false;
        int size = tasks.size();
        for (int i = 0; i < size; i++) {
            if (tasks.get(i).getId().equals(id)) {
                isExisted = true;
                break;
            }
        }
        return isExisted;
    }
    public void filterByStatus(String status){
        Task currentTask = null;
        int size = tasks.size();
        for (int i = 0; i < size; i++) {
            if (tasks.get(i).getStatus().equals(status)) {
                currentTask= tasks.get(i);
                System.out.println(currentTask);
            }
        }
    }
    public void show() {
        this.tasks.forEach(p -> System.out.println(p.toString()));
    }
}
