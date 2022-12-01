package quanLyNhanVien;
public class LinkedListRunner {

    public static void main(String [] args){
        CustomLinkedList<Integer> customLinkedList = new CustomLinkedList<Integer>();
        customLinkedList.add(5);
        customLinkedList.add(10);
        customLinkedList.add(15);
        customLinkedList.add(20);

        customLinkedList.display();
    }
}
