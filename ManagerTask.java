package quanLyNhanVien;

public class ManagerTask {
  private Stack<Task> tasks;

  public ManagerTask() {
    tasks = new Stack<Task>();
  }

  public void add(Task task) {
    this.tasks.push(task);
  }

  public Task searchTaskById(String id) {
    Task currentTask = null;
    for (int i = 0; i < tasks.size(); i++) {
      if (tasks.get(i).getId().equals(id)) {
        currentTask = tasks.get(i);
        break;
      }
    }
    System.out.println(currentTask);
    return currentTask;
  }

  public boolean checkTaskById(String id) {
    boolean isExisted = false;
    for (int i = 0; i < tasks.size(); i++) {
      if (tasks.get(i).getId().equals(id)) {
        isExisted = true;
        break;
      }
    }
    return isExisted;
  }

  public void filterByStatus(String status) {
    Task currentTask = null;
    for (int i = 0; i < tasks.size(); i++) {
      if (tasks.get(i).getStatus().equals(status)) {
        currentTask = tasks.get(i);
        System.out.println(currentTask);
        break;
      }
    }
  }

  public void show() {
    this.tasks.show();
  }
}
