package quanLyNhanVien;

public class CustomLinkedList<E> {

    private Node<E> head;

    public CustomLinkedList() {
    }

    public void add(E data) {
        Node<E> newNode = new Node<E>();
        if (this.head == null) {
            head = newNode;
            newNode.setData(data);
        } else {
            Node<E> currentNode = head;
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
            newNode.setData(data);
        }
    }

    public void insertAt(int index, E data){
        Node<E> nodeToBeInserted = new Node<E>();
        Node<E> node = head;
        for(int i = 0; i< index -1; i++){
            node = node.getNextNode(); // 10
        }
        nodeToBeInserted.setNextNode(node.getNextNode());
        nodeToBeInserted.setData(data);
        node.setNextNode(nodeToBeInserted);
    }

    public void deleteNodeAt(int index){
        Node<E> node = head;
        for(int i = 0; i< index -1; i++){
            node = node.getNextNode();
        }
        node.setNextNode(node.getNextNode().getNextNode());
    }

    public Node<E> getNodeAt(int index){
        Node<E> node = head;
        for(int i = 0; i< index -1; i++){
            node = node.getNextNode();
        }
        System.out.println(node.getNextNode().getData());
        return node;
    }

    public void display() {
        if (head != null) {
            Node<E> currentNode = head;
            System.out.println(head.getData());
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
                System.out.println(currentNode.getData());
            }
        }
    }
}
