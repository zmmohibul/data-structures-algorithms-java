public class AList<T> {
    private T[] items;
    private int size;

    /** Creates an empty list. */
    public AList() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /** Inserts item into given position.
     * Code from discussion #3 */
    public void insert(T x, int position) {
        T[] newTs = (T[]) new Object[items.length + 1];

        System.arraycopy(items, 0, newTs, 0, position);
        newTs[position] = x;

        System.arraycopy(items, position, newTs, position + 1, items.length - position);
        items = newTs;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /** Inserts an item at the front. */
    public void addFirst(T x) {
        insert(x, 0);
    }

    /** Inserts X into the back of the list. */
    public void addLast(T x) {
        if (size == items.length) {
            resize(size + 1);
        }

        items[size] = x;
        size = size + 1;
    }

    /** Gets an item from the front. */
    public T getFirst() {
        return get(0);
    }

    /** Returns the item from the back of the list. */
    public T getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public T get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        T x = getLast();
        items[size - 1] = null;
        size = size - 1;
        return x;
    }
}