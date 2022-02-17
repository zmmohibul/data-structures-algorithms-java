public class ArrayDeque<T> {
    private T items[];
    private int size;
    private int first;
    private int nextFirst;
    private int last;
    private int nextLast;

    public ArrayDeque() {
        size = 8;
        items = (T[])new Object[size];
        first = nextFirst = size / 2 - 1;
        last = nextLast = size / 2;
    }

    public void addFirst(T item) {
        if (items[nextFirst] != null) {
            // need to resize
            System.out.println("Need To Resize");
            return;
        }

        items[nextFirst] = item;

        if (nextFirst - 1 < 0) {
            nextFirst = size - 1;
        } else {
            nextFirst -= 1;
        }
    }

    public void addLast(T item) {
        if (items[nextLast] != null) {
            System.out.println("Need To Resize");
            return;
        }

        items[nextLast] = item;

        if (nextLast + 1 >= size) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> AD = new ArrayDeque<>();
//        AD.addFirst(11);
//        AD.addFirst(11);
//        AD.addFirst(11);
//        AD.addFirst(11);
//        AD.addFirst(11);
//        AD.addFirst(11);
//        AD.addFirst(11);
//        AD.addFirst(11);
//        AD.addFirst(11);

        AD.addLast(12);
        AD.addLast(12);
        AD.addLast(12);
        AD.addLast(12);
        AD.addLast(12);
        AD.addLast(12);
        AD.addLast(12);
        AD.addLast(12);
        AD.addLast(12);
    }
}
