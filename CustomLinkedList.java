package quanLyNhanVien;

public class CustomLinkedList<E> {

    private Node<E> head;

    public CustomLinkedList() {
    }

    public void add(E data) {
        System.out.println(data);

        Node<E> newNode = new Node<E>();
        if (this.head == null) {
            System.out.println("vao den day ");
            head = newNode;
            // newNode.setData(data);

        } else {
            System.out.println("neu co head");
            Node<E> currentNode = head;
            System.out.println(currentNode + "acb");
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
                System.out.println(currentNode);
            }
            currentNode.setNextNode(newNode);
            // newNode.setData(data);
            System.out.println(currentNode + "end");
        }
    }

    public void insertHead(E data) {
        Node<E> newNode = new Node<E>();
        newNode.setNextNode(head);
        head = newNode;

    }

    public void display() {
        if (head != null) {
            Node<E> currentNode = head;
            System.out.println(currentNode + "củuee");
            while (currentNode.getNextNode() != null) {
                System.out.println(currentNode.getData() + " get data");
                currentNode = currentNode.getNextNode();
            }
            System.out.println(currentNode.getData());
        }
    }
}
