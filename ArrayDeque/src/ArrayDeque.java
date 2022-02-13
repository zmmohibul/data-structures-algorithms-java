public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int first;
    private int nextFirst;
    private int last;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 8;
        first = nextFirst = 4;
        last = nextLast = 5;
    }

    public void addFirst(T item) {
        if (items[nextFirst] != null) {
            //resize
        } else {
            items[nextFirst] = item;
            if (nextFirst - 1 == -1) {
                nextFirst = size - 1;
            } else {
                nextFirst -= 1;
            }
        }
    }

    public void addLast(T item) {
        if (items[nextLast] != null) {
            //resize
        } else {
            items[nextLast] = item;
            if (nextLast + 1 == size) {
                nextLast = 0;
            } else {
                nextLast += 1;
            }
        }
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addFirst(11);
        arr.addFirst(11);
        arr.addFirst(11);
        arr.addFirst(11);
        arr.addLast(12);
        arr.addLast(12);
        arr.addFirst(11);
    }
}
