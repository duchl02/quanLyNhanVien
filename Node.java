package quanLyNhanVien;


public class Node<E> {

    private E data;
    private Node<E> nextNode;

    public Node(E data){
        this.data = data;
    }

    public Node() {
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }

}