package quanLyNhanVien;

import java.util.ArrayList;
import java.util.Collections;

class editStaffObj {
    String id;
    String name;
    int age;
    String address;
    String birthDate;
    String position;
    Project project;
    Task task;

    public editStaffObj(String id, String name, int age, String address, String birthDate, String position,
            Project project, Task task) {
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

    private ArrayList<Staff> sortedStaff = new ArrayList<Staff>();
    private ArrayList<Integer> sortedStaffId = new ArrayList<Integer>();

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
                check = true;
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
        sortStaffById();
        Staff currentStaff = null;
        int index = Integer.parseInt(id);
        BinarySearch ob = new BinarySearch();
        int result = ob.binarySearch(sortedStaffId, index);
        if (result == -1)
            System.out.println("Không tìm thấy nhấn viên nào");

        else {
            currentStaff = sortedStaff.get(result);
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

    public boolean checkStaffById(String id) {
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

    public ArrayList<Staff> sortStaffById() {
        ArrayList<Integer> listID = new ArrayList<Integer>();
        int size = staffs.size();
        for (int i = 0; i < size; i++) {
            listID.add(Integer.parseInt(staffs.get(i).getId()));
        }
        MergeSort ms = new MergeSort(listID);
        ms.sortGivenArray();

        ArrayList<Staff> currentStaff = new ArrayList<Staff>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (listID.get(i) == Integer.parseInt(staffs.get(j).getId())) {
                    currentStaff.add(staffs.get(j));
                }
            }
        }
        sortedStaffId = listID;
        sortedStaff = currentStaff;
        return currentStaff;
    }
    
    public void sortStaffByName(){
        sortStaffById();
        sortedStaff.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).forEach(p -> System.out.printf("%s%n", p));
    }
    
    public ArrayList<Staff> searchStaffByName(String name){ 
        int size = staffs.size();
        ArrayList<Staff> currentStaff = new ArrayList<Staff>();

        for (int i = 0; i < size; i++) {
            if (staffs.get(i).getName().contains(name)) {
                currentStaff.add(staffs.get(i));
            }
        }
        return currentStaff;
    }

    public class MergeSort {
        private ArrayList<Integer> inputArray;

        public ArrayList<Integer> getSortedArray() {
            return inputArray;
        }

        public MergeSort(ArrayList<Integer> inputArray) {
            this.inputArray = inputArray;
        }

        public void sortGivenArray() {
            divide(0, this.inputArray.size() - 1);
        }

        public void divide(int startIndex, int endIndex) {

            // Divide till you breakdown your list to single element
            if (startIndex < endIndex && (endIndex - startIndex) >= 1) {
                int mid = (endIndex + startIndex) / 2;
                divide(startIndex, mid);
                divide(mid + 1, endIndex);

                // merging Sorted array produce above into one sorted array
                merger(startIndex, mid, endIndex);
            }
        }

        public void merger(int startIndex, int midIndex, int endIndex) {

            // Below is the mergedarray that will be sorted array Array[i-midIndex] ,
            // Array[(midIndex+1)-endIndex]
            ArrayList<Integer> mergedSortedArray = new ArrayList<Integer>();

            int leftIndex = startIndex;
            int rightIndex = midIndex + 1;

            while (leftIndex <= midIndex && rightIndex <= endIndex) {
                if (inputArray.get(leftIndex) <= inputArray.get(rightIndex)) {
                    mergedSortedArray.add(inputArray.get(leftIndex));
                    leftIndex++;
                } else {
                    mergedSortedArray.add(inputArray.get(rightIndex));
                    rightIndex++;
                }
            }

            // Either of below while loop will execute
            while (leftIndex <= midIndex) {
                mergedSortedArray.add(inputArray.get(leftIndex));
                leftIndex++;
            }

            while (rightIndex <= endIndex) {
                mergedSortedArray.add(inputArray.get(rightIndex));
                rightIndex++;
            }

            int i = 0;
            int j = startIndex;
            // Setting sorted array to original one
            while (i < mergedSortedArray.size()) {
                inputArray.set(j, mergedSortedArray.get(i++));
                j++;
            }
        }
    }

    class BinarySearch {
        // Returns index of x if it is present in arr[],
        // else return -1
        int binarySearch(ArrayList<Integer> arr, int x) {
            int left = 0, right = arr.size() - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                // Check if x is present at mid
                if (arr.get(mid) == x)
                    return mid;

                // If x greater, ignore left half
                if (arr.get(mid) < x)
                    left = mid + 1;

                // If x is smaller, ignore right half
                else
                    right = mid - 1;
            }

            // if we reach here, then element was
            // not present
            return -1;
        }
    }

    public void show() {
        this.staffs.show();
    }
}
