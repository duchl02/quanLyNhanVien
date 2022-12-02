package quanLyNhanVien;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

public class MyMap<K, V> implements Map<K, V> {
    private ArrayList<MyEntry<K, V>>[] table;
    private final int defaultSize = 10;
    private int size = 0;

    private static class MyEntry<K, V> implements Map.Entry<K, V> {
        K key;
        V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            V temp = this.value;
            this.value = value;
            return temp;
        }
    }

    private int indexFor(Object key) {

        System.out.println(key.hashCode());

        return key.hashCode() % table.length;
    }

    @SuppressWarnings("unchecked")
    public MyMap() {
        table = new ArrayList[defaultSize];
        for (int i = 0; i < defaultSize; i++) {
            table[i] = new ArrayList<>();
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public boolean containsKey(Object key) {
        requireNonNull(key);

        int index = indexFor(key);

        return table[index].stream()
                .anyMatch((e) -> e.getKey().equals(key));
    }


    @Override
    public boolean containsValue(Object value) {
        requireNonNull(value);

        return Arrays.stream(table)
                .anyMatch((l) -> l.stream()
                        .anyMatch((e) -> e.getValue().equals(value)));
    }

    @Override
    public V get(Object key) {
        requireNonNull(key);

        int index = indexFor(key);

        for (MyEntry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }


    @Override
    public V put(K key, V value) {
        requireNonNull(key);
        requireNonNull(value);

        int index = indexFor(key);

        for (MyEntry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                V oldValue = entry.getValue();
                entry.setValue(value);
                return oldValue;
            }
        }
        table[index].add(new MyEntry<K, V>(key, value));
        size++;
        return null;
    }


    @Override
    public V remove(Object key) {
        requireNonNull(key);

        int index = indexFor(key);

        for (MyEntry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                V oldValue = entry.getValue();
                table[index].remove(entry);
                return oldValue;
            }
        }
        return null;
    }


    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        requireNonNull(m);

        if (!m.isEmpty()) {
            m.keySet().stream()
                    .forEach((k) -> put(k, m.get(k)));
        }
    }

    @Override
    public void clear() {
        Arrays.stream(table)
                .forEach((l) -> l.clear());
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = Arrays.stream(table)
                .flatMap((l) -> l.stream()
                        .map((e) -> e.getKey()))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return set;
    }


    @Override
    public Collection<V> values() {
        Collection<V> collection = Arrays.stream(table)
                .flatMap((l) -> l.stream()
                        .map((e) -> e.getValue()))
                .collect(Collectors.toCollection(ArrayList::new));
        return collection;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = Arrays.stream(table)
                .flatMap((l) -> l.stream()
                        .map((e) -> new AbstractMap.SimpleEntry<K, V>(e.getKey(), e.getValue())))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        return set;
    }


    @Override
    public String toString() {
        Set<Map.Entry<K, V>> set = entrySet();

        String result = "{";
        result += set.stream()
                .map((e) -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining(", "));
        result += "}";

        return result;
    }
}