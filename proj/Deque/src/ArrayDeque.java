public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int first;
    private int last;

    public ArrayDeque() {
        size = 8;
        first = nextFirst = size / 2 - 1;
        last = nextLast = size / 2;
        items = (T[]) new Object[size];
    }

    public void addFirst(T item) {
        if (items[nextFirst] != null) {
            // resize
        }

        items[nextFirst] = item;

        if (nextFirst == 0) {
            nextFirst = size - 1;
        } else  {
            nextFirst -= 1;
        }
    }

    public void addLast(T item) {
        if (items[nextLast] != null) {
            resize();
        }

        items[nextLast] = item;

        if (nextLast == size - 1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
    }

    public void resize() {
        int newSize = size * 2;
        T[] newItems = (T[]) new Object[size * 2];

        int newFirst = newSize / 2 - 1;
        int newNextFirst = newFirst;

        int newLast = newSize / 2;
        int newNextLast = newLast;

        if (nextLast <= last) {
            int noOfItemsToCopy = size / 2;
            System.arraycopy(items, last, newItems, newNextLast, noOfItemsToCopy);
            newNextLast += size / 2;
            noOfItemsToCopy = nextLast;
            System.arraycopy(items, 0, newItems, newNextLast, noOfItemsToCopy);
            newNextLast += noOfItemsToCopy;
        }

        items = newItems;
        size = newSize;

        first = newFirst;
        nextFirst = newNextFirst;

        last = newLast;
        nextLast = newNextLast;

        if (nextLast >= size) {
            nextLast = 0;
        }
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> AD = new ArrayDeque<>();
        AD.addLast(9);
        AD.addLast(5);
        AD.addLast(1);
        AD.addLast(-1);
        AD.addLast(-3);
        AD.addLast(-6);
        AD.addLast(-8);
        AD.addLast(-11);
        AD.addLast(-13);
        AD.addLast(-22);
    }
}
