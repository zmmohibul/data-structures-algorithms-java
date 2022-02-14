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
            resize();
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
            resize();
        } else {
            items[nextLast] = item;
            if (nextLast + 1 == size) {
                nextLast = 0;
            } else {
                nextLast += 1;
            }
        }
    }

    public void resize() {
        T[] newItems = (T[]) new Object[size * 2];
        int newFirst = size;
        int newLast = size + 1;

        if (nextFirst < first) {
            int numberOfItemsToCopy = first - nextFirst;
            System.arraycopy(items, nextFirst + 1, newItems, newFirst - numberOfItemsToCopy + 1, numberOfItemsToCopy);
            newFirst -= numberOfItemsToCopy;
        } else {
            System.arraycopy(items, 0, newItems, newFirst - first, first + 1);
            newFirst = newFirst - first - 1;
            if (nextFirst + 1 == size) {
                // do nothing
            } else {
                int numberOfItemsToCopy = size - nextFirst - 1;
                System.arraycopy(items, nextFirst + 1, newItems, newFirst - numberOfItemsToCopy + 1, numberOfItemsToCopy);
                newFirst -= numberOfItemsToCopy;
            }
        }

        if (last < nextLast) {
            System.arraycopy(items, last, newItems, newLast, nextLast - last);
        } else {
            int numberOfItemsToCopy = size - last;
            System.arraycopy(items, last, newItems, newLast, numberOfItemsToCopy);
            newLast += numberOfItemsToCopy;
            if (nextLast > 0) {
                System.arraycopy(items, 0, newItems, newLast, nextLast);
                newLast += nextLast;
            }
        }

        first = size;
        last = size + 1;
        nextFirst = newFirst;
        nextLast = newLast;
        items = newItems;
        size = size * 2;
    }

    public T removeFirst() {
        if (items[first] == null) {
            return null;
        }

        if (nextFirst + 1 == size) {
            nextFirst = 0;
            T val = items[nextFirst];
            items[nextFirst] = null;
            return val;
        }

        if (items[nextFirst + 1] != null) {
            nextFirst += 1;
            T val = items[nextFirst];
            items[nextFirst] = null;
            return val;
        } else {
            return null;
        }
    }

    public void printDeque() {
        System.out.print("[ ");
        if (nextFirst > first) {
            for (int i = nextFirst + 1; i < size; i++) {
                System.out.print(items[i] + " ");
            }

            for (int i = 0; i <= first; i++) {
                System.out.print(items[i] + " ");
            }
        } else {
            for (int i = nextFirst + 1; i <= first; i++) {
                System.out.print(items[i] + " ");
            }
        }

        if (nextLast < last) {
            for (int i = last; i < size; i++) {
                System.out.print(items[i] + " ");
            }

            for (int i = 0; i < nextLast; i++) {
                System.out.print(items[i] + " ");
            }
        } else {
            for (int i = last; i < nextLast; i++) {
                System.out.print(items[i] + " ");
            }
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addFirst(11);
        arr.addFirst(11);
        arr.addFirst(11);
        arr.addLast(12);
        arr.addLast(12);
        arr.addLast(12);
        arr.addLast(13);
        arr.addFirst(11);
        arr.addFirst(11);
        arr.addFirst(11);
        arr.addFirst(10);
        arr.addFirst(9);
        arr.addFirst(8);
        arr.addFirst(7);
        arr.addFirst(6);
        arr.addFirst(5);
        System.out.println(arr.removeFirst());
        System.out.println(arr.removeFirst());
        System.out.println(arr.removeFirst());
        System.out.println(arr.removeFirst());
        System.out.println(arr.removeFirst());
        arr.printDeque();
    }
}
