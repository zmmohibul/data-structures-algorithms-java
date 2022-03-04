import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.Arrays;
import java.util.Iterator;

public class ArraySet<T> implements Iterable<T> {
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

    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int position;

        public ArraySetIterator() {
            this.position = 0;
        }

        @Override
        public boolean hasNext() {
            return position < size();
        }

        @Override
        public T next() {
            T itemToReturn = items[position];
            position += 1;
            return itemToReturn;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");

        for (int i = 0; i < size() - 1; i++) {
            sb.append(items[i]);
            sb.append(", ");
        }
        sb.append(items[size() - 1]);

        sb.append("}");

        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (object.getClass() != this.getClass()) {
            return false;
        }

        ArraySet<T> o = (ArraySet<T>) object;

        if (o.size() != this.size()) {
            return false;
        }

        for (T item : this) {
            if (!o.contains(item)) {
                return false;
            }
        }

        return true;
    }

    public static <T> ArraySet<T> of(T... items) {
        ArraySet<T> returnSet = new ArraySet<>();
        for (T item : items) {
            returnSet.add(item);
        }
        return returnSet;
    }

    public static void main(String[] args) {
        ArraySet<Integer> set = new ArraySet<>();
        set.add(10);
        set.add(11);
        set.add(11);
        set.add(12);
        set.add(12);
        set.add(null);
        set.add(13);
        set.add(99);

        System.out.println("Set contains 12: " + set.contains(12));
        System.out.println("Set contains 101: " + set.contains(101));
        System.out.println("Set contains null: " + set.contains(null));
        System.out.println("No of items in Set: " + set.size());

//        Iterator<Integer> iter = set.iterator();
//        while (iter.hasNext()) {
//            System.out.println(iter.next());
//        }
//
//        for (Integer item : set) {
//            System.out.println(item);
//        }

        System.out.println(set);


        ArraySet<Integer> set2 = ArraySet.of(10, 11, 12, null, 13, 99);
        System.out.println(set + " == " + set2 + ": " + set.equals(set2));

        ArraySet<Integer> set3 = ArraySet.of(10, 11, 12, null, 13, 99, 1);
        System.out.println(set + " == " + set3 + ": " + set.equals(set3));

        ArraySet<Integer> set4 = ArraySet.of(10, 11, 12, null, 13, 9);
        System.out.println(set + " == " + set4 + ": " + set.equals(set4));

        System.out.println(ArraySet.of(1, 2, 3, 4));
    }
}
