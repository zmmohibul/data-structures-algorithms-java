public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private int first;
    private int last;
    private boolean hasLast;
    private boolean hasFirst;

    public ArrayDeque() {
        size = 8;
        first = nextFirst = size / 2 - 1;
        last = nextLast = size / 2;
        items = (T[]) new Object[size];
        hasLast = hasFirst = false;
    }

    public void addFirst(T item) {
        if (items[nextFirst] != null) {
            resize();
        }

        items[nextFirst] = item;
        hasFirst = true;

        if (nextFirst == 0) {
            nextFirst = size - 1;
        } else {
            nextFirst -= 1;
        }
    }

    public void addLast(T item) {
        if (items[nextLast] != null) {
            resize();
        }

        items[nextLast] = item;
        hasLast = true;

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

        if (nextLast <= last && hasLast) {
            int noOfItemsToCopy = size / 2;
            System.arraycopy(items, last, newItems, newNextLast, noOfItemsToCopy);
            newNextLast += size / 2;
            noOfItemsToCopy = nextLast;
            System.arraycopy(items, 0, newItems, newNextLast, noOfItemsToCopy);
            newNextLast += noOfItemsToCopy;
        } else if (hasLast) {
            int noOfItemsToCopy = nextLast - last;
            System.arraycopy(items, last, newItems, newNextLast, noOfItemsToCopy);
            newNextLast += noOfItemsToCopy;
        }

        if (nextFirst >= first && hasFirst) {
            int noOfItemsToCopy = size / 2;
            System.arraycopy(items, 0, newItems, newNextFirst - noOfItemsToCopy + 1, noOfItemsToCopy);
            newNextFirst -= noOfItemsToCopy;
            noOfItemsToCopy = size - 1 - nextFirst;
            System.arraycopy(items, nextFirst + 1, newItems, newNextFirst - noOfItemsToCopy + 1, noOfItemsToCopy);
            newNextFirst -= noOfItemsToCopy;
        } else if (hasFirst) {
            int noOfItemsToCopy = first - nextFirst;
            System.arraycopy(items, nextFirst + 1, newItems, newNextFirst - noOfItemsToCopy + 1, noOfItemsToCopy);
            newNextFirst -= noOfItemsToCopy;
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

        if (nextFirst <= 0) {
            nextFirst = size - 1;
        }
    }


    public static void main(String[] args) {
        ArrayDeque<Integer> AD = new ArrayDeque<>();
        AD.addFirst(9);
        AD.addFirst(5);
        AD.addFirst(1);
        AD.addFirst(-1);
        AD.addFirst(-3);
        AD.addFirst(-6);
        AD.addFirst(-8);
        AD.addFirst(-11);
        AD.addFirst(-13);
        AD.addFirst(-22);
        AD.addLast(11);
        AD.addLast(12);
        AD.addLast(14);
        AD.addLast(15);
        AD.addLast(16);
        AD.addLast(165);
        AD.addLast(167);
        AD.addLast(1678);
        AD.addLast(1672);
        AD.addLast(1123);
        AD.addLast(11231);
        AD.addLast(122233);
        AD.addLast(1244);
        AD.addLast(1);
        AD.addLast(1);
        AD.addLast(1);
        AD.addLast(1);
        AD.addLast(1);
        AD.addLast(1);
        AD.addLast(1);
        AD.addLast(1);
        AD.addLast(1);
        AD.addLast(1);
        AD.addLast(1);
        AD.addLast(1);
        AD.addLast(1);
        AD.addLast(1);
        AD.addLast(1);
    }
}
