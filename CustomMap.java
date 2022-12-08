package quanLyNhanVien;

import java.util.NoSuchElementException;
import static java.util.Objects.requireNonNull;


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

        public void setPrev(Node<K, V> prev) {
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

        // public Node(K key, V value) {
        // this.key = key;
        // this.value = value;
        // this.prev = prev;
        // }

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
            if (checkKeyExisted(key)) {
                newNode.setKey(key);
                newNode.setValue(value);
                newNode.setPrev(node);
                node = newNode;
            }
        }
    }

    public boolean checkKeyExisted(K key) {
        boolean result = true;
        for (Node<K, V> currentNode = node; currentNode != null; currentNode = currentNode.prev) {
            if (key == currentNode.getKey()) {
                result = false;
            }
        }
        return result;
    }

    public V get(K key) {
        for (Node<K, V> currentNode = node; currentNode != null; currentNode = currentNode.prev) {
            if (key.equals(currentNode.key)) {
                System.out.println(currentNode.value);
                return (V) currentNode.value;
            }
        }
        return null;
    }

    V remove(K key) {
        requireNonNull(node);
        for (Node<K, V> currentNode = node; currentNode != null; currentNode = currentNode.prev) {
            if (currentNode.prev == null && currentNode.key == key) {
                node = null;
                return (V) currentNode.getValue();
            }
            if (currentNode.prev != null && currentNode.prev.key == key) {
                currentNode.prev = currentNode.prev.prev;
                return (V) currentNode.prev.getValue();
            }
            if (currentNode.prev != null && currentNode.key == key) {
                node = currentNode.getPrev();
                return (V) currentNode.getValue();
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
            Node<K, V> currentNode = node;
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
        map.remove(1);
        map.display();
        // map.remove(1);
        // System.out.println(map);
        // map.remove(1);
        // System.out.println(map);
    }
}