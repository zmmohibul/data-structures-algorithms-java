import javax.management.openmbean.KeyAlreadyExistsException;

public class ArraySet<T> {
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public boolean contains(T item) {
        if (size == 0) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (items[i] == null && item == null) {
                return true;
            }

            if (items[i] == null) {
                continue;
            }

            if (items[i].equals(item)) {
                return true;
            }
        }

        return false;
    }

    public void add(T item) {
        if (!contains(item)) {
            items[size] = item;
            size += 1;
        }
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArraySet<Integer> set = new ArraySet<>();
        set.add(10);
        set.add(11);
        set.add(11);
        set.add(12);
        set.add(12);
        set.add(null);
        System.out.println(set.contains(12));
        System.out.println(set.contains(13));
        System.out.println(set.contains(null));
        System.out.println(set.size());
    }
}
