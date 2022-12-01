package quanLyNhanVien;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManagerStaff managerStaff = new ManagerStaff();
        ManagerProject managerProject = new ManagerProject();
        ManagerTask managerTask = new ManagerTask();
        while (true) {
            System.out.println("Nhấn 1 để thêm nhân viên vào công ty");
            System.out.println("Nhấn 2 để sửa nhân viên theo id");
            System.out.println("Nhấn 3 để xóa nhân viên bằng id");
            System.out.println("Nhấn 4 để hiển thị tất cả nhân viên");
            System.out.println("Nhấn 5 để thêm dự án");
            System.out.println("Nhấn 6 để hiên thị tất cả dự án");
            System.out.println("Nhấn 7 thêm nhân viên vào dự án");
            System.out.println("Nhấn 8 thêm task");
            System.out.println("Nhấn 9 sửa trạng thái task");
            System.out.println("Nhấn 10 xem tất cả task");
            System.out.println("Nhấn 11 xem nhân viên theo dự án");
            System.out.println("Nhấn 12 xem dự án theo nhân viên");
            System.out.println("Nhấn 13 xem task theo nhân viên");
            System.out.println("Nhấn 14 tìm nhân viên theo id");
            System.out.println("Nhấn 15 xem task theo trạng thái");
            System.out.println("Nhấn 16 để xem nhân viên đã sắp xếp bằng id");
            System.out.println("Nhấn 17 để xem nhân viên đã sắp xếp bằng tên");
            System.out.println("Nhấn 18  tìm nhân viên theo tên");
            System.out.println("Nhấn x để thoát");
            String line = scanner.nextLine();
            switch (line) {
                case "1": {
                    System.out.print("Nhập id: ");
                    String id = scanner.nextLine();
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập tuổi: ");
                    int age = scanner.nextInt();
                    System.out.print("Nhập địa chỉ: ");
                    scanner.nextLine();
                    String address = scanner.nextLine();
                    System.out.print("Nhập ngày sinh: ");
                    String birthDate = scanner.nextLine();
                    System.out.print("Nhập vị trí(s1 = nhân viên , s2 = phó phòng ,s3 = trưởng phòng):");
                    String position = scanner.nextLine();
                    Staff staff = new Staff(id, name, age, address, birthDate, position, null, null);
                    managerStaff.add(staff);
                    System.out.println(staff.toString());
                    break;
                }
                case "2": {
                    System.out.print("Nhập id: ");
                    String id = scanner.nextLine();
                    if (managerStaff.checkStaffById(id)) {
                        System.out.print("Nhập tên: ");
                        String name = scanner.nextLine();
                        System.out.print("Nhập tuổi: ");
                        int age = scanner.nextInt();
                        System.out.print("Nhập địa chỉ: ");
                        scanner.nextLine();
                        String address = scanner.nextLine();
                        System.out.print("Nhập ngày sinh: ");
                        String birthDate = scanner.nextLine();
                        System.out.print("Nhập vị trí(s1 = nhân viên , s2 = phó phòng ,s3 = trưởng phòng) ");
                        String position = scanner.nextLine();
                        editStaffObj obj = new editStaffObj(id, name, age, address, birthDate, position, null, null);
                        if (managerStaff.editStaffById(obj)) {
                            System.out.println("Sửa nhân viên thành công!");
                        } else {
                            System.out.println("Đã có lỗi xảy ra!");
                        }
                        break;
                    } else {
                        System.out.println("Không tìm thấy Id, xin hãy thử lại.");
                        break;
                    }
                }
                case "3": {
                    System.out.print("Nhập id: ");
                    String id = scanner.nextLine();
                    if (managerStaff.checkStaffById(id)) {
                        if (managerStaff.delete(id)) {
                            System.out.println("Xóa nhân viên thành công!");
                        } else {
                            System.out.println("Đã có lỗi xảy ra!");
                        }
                    } else {
                        System.out.println("Không tìm thấy Id, xin hãy thử lại.");
                    }
                    break;
                }
                case "4": {
                    managerStaff.show();
                    break;
                }
                case "5": {
                    System.out.print("Nhập id: ");
                    Integer id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập tên dự án: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập mô tả: ");
                    String description = scanner.nextLine();
                    Project project = new Project(id, name, description, null, null);
                    managerProject.add(project, id);
                    System.out.println(project.showProject());
                    break;
                }
                case "6": {
                    managerProject.show();
                    break;
                }
                case "7": {
                    System.out.println("Nhập id nhân viên ");
                    String staffId = scanner.nextLine();

                    if (managerStaff.checkStaffById(staffId)) {
                        System.out.println("Nhập id dự án ");
                        Integer projectId = scanner.nextInt();
                        if (managerProject.checkProjectById(projectId)) {
                            Staff staff = managerStaff.searchStaffById(staffId);
                            Project project = managerProject.searchProjectById(projectId);
                            staff.addProject(project);
                            System.out.println(project);
                            project.addStaff(staff);
                            System.out.println("Thêm thành công!");
                            break;
                        } else {
                            System.out.println("Không tìm thấy Id dự án, xin hãy thử lại.");
                            break;
                        }
                    } else {
                        System.out.println("Không tìm thấy Id nhân viên, xin hãy thử lại.");
                    }
                    break;
                }
                case "8": {
                    System.out.print("Nhập id: ");
                    String id = scanner.nextLine();
                    System.out.print("Nhập tên task: ");
                    String taskName = scanner.nextLine();
                    System.out.print("Nhập mô tả: ");
                    String description = scanner.nextLine();
                    System.out.print("Nhập thời gian hoàn thành: ");
                    String timeDo = scanner.nextLine();
                    System.out.print("Nhập trạng thái(s1 = coding,s2 = test,s3 = done): ");
                    String status = scanner.nextLine();
                    System.out.println("Nhập id nhân viên thực hiện: ");
                    String staffId = scanner.nextLine();

                    if (managerStaff.checkStaffById(staffId)) {
                        System.out.println("Nhập id dự án nhân viên được giao ");
                        Staff staff = managerStaff.searchStaffById(staffId);
                        System.out.println(staff.getProject());
                        Integer projectId = scanner.nextInt();
                        if (managerProject.checkProjectById(projectId)) {
                            Project project = managerProject.searchProjectById(projectId);
                            Task task = new Task(id, taskName, description, timeDo, status, staff, project);
                            managerTask.add(task);
                            project.addTask(task);
                            staff.addTask(task);
                            System.out.println("Thêm thành công!");
                            break;
                        } else {
                            System.out.println("Không tìm thấy Id dự án, xin hãy thử lại.");
                        }
                    } else {
                        System.out.println("Không tìm thấy Id nhân viên, xin hãy thử lại.");
                    }
                    break;
                }
                case "9": {
                    System.out.println("Nhập id task");
                    String id = scanner.nextLine();
                    if (managerTask.checkTaskById(id)) {
                        Task task = managerTask.searchTaskById(id);
                        System.out.println(task);
                        System.out.println("Nhập trạng thái(s1 = coding,s2 = test,s3 = done):");
                        String status = scanner.nextLine();
                        task.setStatus(status);
                        System.out.println("Sửa trạng thái thành công");
                    } else {
                        System.out.println("Không tìm thấy id task");
                    }
                    break;
                }
                case "10": {
                    managerTask.show();
                    break;
                }
                case "11": {
                    System.out.println("Nhập id dự án ");
                    Integer projectId = scanner.nextInt();
                    if (managerProject.checkProjectById(projectId)) {
                        Project project = managerProject.searchProjectById(projectId);
                        System.out.println(project.getStaff());
                        break;
                    } else {
                        System.out.println("Không tìm thấy Id dự án, xin hãy thử lại.");
                    }
                    break;
                }
                case "12": {
                    System.out.println("Nhập id nhân viên:");
                    String staffId = scanner.nextLine();
                    if (managerStaff.checkStaffById(staffId)) {
                        Staff staff = managerStaff.searchStaffById(staffId);
                        System.out.println(staff.getProject());
                    } else {
                        System.out.println("Không tìm thấy Id nhân viên, xin hãy thử lại.");
                    }
                    break;
                }
                case "13": {
                    System.out.println("Nhập id nhân viên:");
                    String staffId = scanner.nextLine();
                    if (managerStaff.checkStaffById(staffId)) {
                        Staff staff = managerStaff.searchStaffById(staffId);
                        System.out.println(staff.getTasks());
                    } else {
                        System.out.println("Không tìm thấy Id nhân viên, xin hãy thử lại.");
                    }
                    break;
                }
                case "14": {
                    System.out.print("Nhập id: ");
                    String id = scanner.nextLine();
                    if (managerStaff.checkStaffById(id)) {
                        System.out.println(managerStaff.searchStaffById(id));
                    } else {
                        System.out.println("Không tìm thấy Id, xin hãy thử lại.");
                    }
                    break;
                }
                case "15": {
                    System.out.println("Lọc task theo trạng thái");
                    System.out.println("Nhập trạng thái(s1 = coding,s2 = test,s3 = done):");
                    String status = scanner.nextLine();
                    managerTask.filterByStatus(status);
                    break;
                }
                case "16": {
                    managerStaff.sortStaffById().forEach(p -> System.out.println(p.toString()));
                    break;
                }
                case "17":{
                    managerStaff.sortStaffByName();
                    break;
                }
                case "18":{
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    System.out.println(managerStaff.searchStaffByName(name).toString());
                    break;
                }
                case "x":
                    return;
                default:
                    System.out.println("Lỗi");
                    continue;
            }
        }

    }
}
