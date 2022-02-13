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
        if (items[nextFirst] == null) {
            items[nextFirst] = item;
            if (nextFirst == 0) {
                nextFirst = size - 1;
            } else {
                nextFirst -= 1;
            }
        }
    }

    public void addLast(T item) {
        if (items[nextLast] == null) {
            items[nextLast] = item;
            if (nextLast == size - 1) {
                nextLast = 0;
            } else {
                nextLast += 1;
            }
        }
    }

    private T[] resize() {
        T[] arr = (T[]) new Object[size * 2];
        int newFirst = size;
        int newLast = size + 1;
        if (items[last] != null) {
            if (nextLast > first && nextLast <= size - 1) {
                System.arraycopy(items, last, arr, newLast, size - last - 1);
                newLast +=  size - last - 1;
            } else {
                System.arraycopy(items, last, arr, newLast, size - last);
                newLast +=  size - last;
            }

            if (nextLast < first) {
                System.arraycopy(items,0, arr, newLast, nextLast);
                newLast += nextLast;
            }
        }

        if (items[first] != null) {
            if (nextFirst < first) {
                int numberOfItemsToCopy = first - nextFirst;
                int startPosition = newFirst - numberOfItemsToCopy + 1;
                System.arraycopy(items, nextFirst + 1, arr, startPosition, numberOfItemsToCopy);
                newFirst -= numberOfItemsToCopy;
            } else {
                int startPosition = newFirst - first;
                System.arraycopy(items, 0, arr, startPosition, first + 1);
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        ad.addFirst(11);
        ad.addFirst(31);
        ad.addFirst(33);
        ad.addFirst(12);
        ad.addFirst(21);
        ad.addLast(44);
        Integer[] a = ad.resize();
    }
}
