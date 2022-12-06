package quanLyNhanVien;

import java.util.Map;
import java.util.NoSuchElementException;

public class CustomMap<K, V> {
    private class Node<K, V> {
        K key;
        V value;

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        };

        public Node<K, V> getPrev() {
            return prev;
        };

        Node<K, V> prev;

        @Override
        public String toString() {
            return key +
                    "-" + value +
                    "->" + prev;
        }

        public Node() {
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = prev;
        }

    }

    private Node<K, V> node;

    public CustomMap() {

    }
    public void add(K key, V value) throws NoSuchElementException {
        Node<K, V> newNode = new Node<K, V>();
        if (this.node == null) {
            node = newNode;
            newNode.setKey(key);
            newNode.setValue(value);
        } else {
            if (!checkKeyExisted(key)) {
                Node<K, V> currentNode = node;
                System.out.println("Check currentNode: " + currentNode);
                while (currentNode.getPrev() != null) {
                    currentNode = currentNode.getPrev();
                }
                currentNode.setPrev(node);
                newNode.setKey(key);
                newNode.setValue(value);
                System.out.println("check node new node" + newNode);
            System.out.println("Check currentNode after : " + currentNode);

            }

        }
    }

    public boolean checkKeyExisted(K key) {
        boolean result = false;
        for (Node<K, V> n = node; n != null; n = n.prev) {
            if (key == n.getKey()) {
                result = true;
            }
        }
        return result;
    }

    public V get(K key) {
        for (Node<K, V> n = node; node != null; n = n.prev) {
            if (key.equals(n.key)) {
                System.out.println(n.value);
                return (V) n.value;
            }
        }
        return null;
    }

    V remove(K key) {

        for (Node<K, V> n = node; node != null; n = node.prev) {
            if (n.prev != null && n.prev.key == key) {
                n.prev = n.prev.prev;
                return (V) n.prev;
            }
            if (n.prev == null && n.key == key) {
                node = null;
                return (V) n;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return node + " ";
    }


    public void display() {
        if (node != null) {
            Node<K,V> currentNode = node;
            System.out.println(node.getValue());
            while (currentNode.getPrev() != null) {
                currentNode = currentNode.getPrev();
                System.out.println(currentNode.getValue());
            }
        }
    }
    public static void main(String[] args) {
        CustomMap<Integer, String> map = new CustomMap<>();
        map.add(1, "111");
        map.add(2, "222");
        map.add(3, "333");
        // map.get(1);
        // map.remove(2);
       map.display();
        // map.remove(1);
        // System.out.println(map);
        // map.remove(1);
        // System.out.println(map);
    }
}