import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>{
    private class Node {
        K key;
        V value;
        Node left;
        Node right;
    }

    private Node root;

    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(K key) {
        return containsKey(this.root, key);
    }

    private boolean containsKey(Node root, K key) {
        if (root == null) {
            return false;
        }

        int cmp = root.key.compareTo(key);

        if (cmp < 0) {
            return containsKey(root.left, key);
        } else if (cmp > 0) {
            return containsKey(root.right, key);
        } else {
            return true;
        }
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException();
    }
}
