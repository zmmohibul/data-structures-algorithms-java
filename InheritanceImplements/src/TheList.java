public interface TheList<T> {
    public void insert(T item, int position);

    /** Adds x to the front of the list. */
    public void addFirst(T x);

    /** Adds x to the end of the list. */
    public void addLast(T x);

    /** Returns the first item in the list. */
    public T getFirst();

    /** Returns last item */
    public T getLast();

    /** Returns the ith item in the list. */
    public T get(int i);

    /** Returns the size of the list. */
    public int size();

    /** Deletes and returns last item. */
    public T removeLast();

    default public void print() {
        for (int i = 0; i < size(); i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
}
