package quanLyNhanVien;
public class LinkedListRunner {

    public static void main(String [] args){
        CustomQueue<Integer> customLinkedList = new CustomQueue<Integer>();
        customLinkedList.add(5);
        customLinkedList.add(10);
        customLinkedList.add(15);
        customLinkedList.add(20);

        // customLinkedList.display();

        // customLinkedList.insertAt(2, 100);
        // System.out.println("********");
        // customLinkedList.display();

        System.out.println("********");
        // System.out.println(customLinkedList.remove()+ "xx");
        customLinkedList.display();

        // System.out.println("********");
        // customLinkedList.getNodeAt(2);

    }
}
