package quanLyNhanVien;

import static java.util.Objects.requireNonNull;

public class CustomQueue<E> {

    private Node<E> head;

    public CustomQueue() {
    }

    // public void add(E data) {
    // Node<E> newNode = new Node<E>();
    // if (this.head == null) {
    // head = newNode;
    // newNode.setData(data);
    // } else {
    // Node<E> currentNode = head;
    // while (currentNode.getNextNode() != null) {
    // currentNode = currentNode.getNextNode();
    // }
    // currentNode.setNextNode(newNode);
    // newNode.setData(data);
    // }
    // }

    public void add(E data) {
        Node<E> newNode = new Node<E>();
        if (this.head == null) {
            head = newNode;
            newNode.setData(data);
        } else {
            Node<E> currentNode = findLastNode(head);
            currentNode.setNextNode(newNode);
            newNode.setData(data);
        }
    }

    
    private Node<E> findLastNode(Node<E> currentNode) {
        if (currentNode.getNextNode() != null) {
            currentNode = findLastNode(currentNode.getNextNode());
        }
        return currentNode;
    }

    public Node<E> poll() {
        Node<E> currentNode = head;
        if (head == null) {
            return null;
        }
        currentNode = head;
        head = head.getNextNode();
        return currentNode;
    }

    public Node<E> peek() {
        Node<E> node = null;
        if (head == null) {
            node = null;
        } else {
            node = head;
        }
        return node;
    }

    /**
     * @return
     */
    public E remove() {
        requireNonNull(head);
        Node<E> node = head;
        head = head.getNextNode();
        return node.getData();
    }

    /**
     * @param index
     */
    public void deleteNodeAt(int index) {
        Node<E> node = head;
        for (int i = 0; i < index - 1; i++) {
            node = node.getNextNode();
        }
        node.setNextNode(node.getNextNode().getNextNode());
    }

    /**
     * @param index
     * @return
     */
    public Node<E> getNodeAt(int index) {
        Node<E> node = head;
        for (int i = 0; i < index - 1; i++) {
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
