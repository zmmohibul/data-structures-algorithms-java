public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int first;
    private int last;

    public ArrayDeque() {
        size = 8;
        first = size / 2 - 1;
        last = size / 2;
        items = (T[]) new Object[size];
    }

    public void addFirst(T item) {
        if (items[first] != null) {
            // resize
        }

        items[first] = item;

        if (first < 0) {
            first = size - 1;
        } else  {
            first -= 1;
        }
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> AD = new ArrayDeque<>();
        AD.addFirst(9);
        AD.addFirst(5);
        AD.addFirst(1);
    }
}
