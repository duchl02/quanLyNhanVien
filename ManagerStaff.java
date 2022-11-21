package quanLyNhanVien;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerStaff {

    private List<Staff> staffs;


    public ManagerStaff() {
        staffs = new ArrayList<>();
    }

    public void add(Staff staff) {
        this.staffs.add(staff);

    }

    public boolean delete(String id) {
        Staff staff = this.staffs.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
        if (staff == null) {
            return false;
        } else {
            this.staffs.remove(staff);
            return true;
        }
    }
    public Staff searchStaffById(String id) {
        Staff currentStaff = null;
        int size = staffs.size();
        for (int i = 0; i < size; i++) {
            if (staffs.get(i).getId().equals(id)) {
                currentStaff= staffs.get(i);
                break;
            }
        }
        return currentStaff;
//        return this.staffs.stream().filter(staff -> staff.getId().contains(id)).collect(Collectors.toList());
    }
    public boolean editStaffById(String id, String name, int age, String address,String birthDate, String position,Project project, Task task) {
        boolean isExisted = false;
        int size = staffs.size();
         for (int i = 0; i < size; i++) {
            if (staffs.get(i).getId().equals(id)) {
                isExisted = true;
                staffs.get(i).setAge(age);
                staffs.get(i).setAddress(address);
                staffs.get(i).setName(name);
                staffs.get(i).setBirthDate(birthDate);
                staffs.get(i).setPosition(position);
                break;
            }
        }
        return isExisted;
    }

    public boolean checkStaffById(String id){
        boolean isExisted = false;
        int size = staffs.size();
        for (int i = 0; i < size; i++) {
            if (staffs.get(i).getId().equals(id)) {
                isExisted = true;
                break;
            }
        }
        return isExisted;
    }

    public void show() {
        this.staffs.forEach(p -> System.out.println(p.toString()));
    }
}
