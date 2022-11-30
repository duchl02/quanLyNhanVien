package quanLyNhanVien;



class editStaffObj{
    String id; String name; int age; String address;String birthDate; String position;Project project; Task task;
    public editStaffObj(String id, String name, int age, String address,String birthDate, String position,Project project, Task task){
        this.task = task;
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.birthDate = birthDate;
        this.position = position;
        this.project = project;
    }
}
public class ManagerStaff {

    private Queue<Staff> staffs;


    public ManagerStaff() {
        staffs = new Queue<Staff>();
    }

    public void add(Staff staff) {
        this.staffs.add(staff);
    }

    public boolean delete(String id) {
        boolean check = false;
        for (int i = 0; i < staffs.size(); i++) {
            if (staffs.get(i).getId().equals(id)) {
                this.staffs.delete(i);
                check= true;
                break;
            }
        }
        return check;
    }
    /**
     * @param id
     * @return
     */
    public Staff searchStaffById(String id) {
        Staff currentStaff = null;
        int size = staffs.size();
        int index = Integer.parseInt(id); 
        for (int i = 0; i < size; i++) {
            if (staffs.get(i).getId().equals(id)) {
                currentStaff= staffs.get(i);
                break;
            }
        }
        return currentStaff;
    }
    public boolean editStaffById(editStaffObj data) {
        boolean isExisted = false;
        int size = staffs.size();
         for (int i = 0; i < size; i++) {
            if (staffs.get(i).getId().equals(data.id)) {
                isExisted = true;
                staffs.get(i).setAge(data.age);
                staffs.get(i).setAddress(data.address);
                staffs.get(i).setName(data.name);
                staffs.get(i).setBirthDate(data.birthDate);
                staffs.get(i).setPosition(data.position);
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

    public void sortStaffById(){
        
    }

    public void show() {
        this.staffs.show();
    }
}
