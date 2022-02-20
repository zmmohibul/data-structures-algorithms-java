public class SLList<T> implements TheList<T> {
    private class Node {
        public T item;
        public Node next;

        public Node(T i, Node n) {
            item = i;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private Node sentinel;
    private int size;

    /** Creates an empty SLList. */
    public SLList() {
        sentinel = new Node(null, null);
        size = 0;
    }

    public SLList(T x) {
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
        size = 1;
    }

    /** Inserts the item into the given position in
     *  the list. If position is greater than the
     *  size of the list, inserts at the end instead.
     */
    public void insert(T item, int position) {
        Node p = sentinel;
        while (position > 1 && p.next != null) {
            position--;
            p = p.next;
        }
        Node newNode = new Node(item, p.next);
        p.next = newNode;
    }

    /** Adds x to the front of the list. */
    public void addFirst(T x) {
        sentinel.next = new Node(x, sentinel.next);
        size = size + 1;
    }

    /** Adds x to the end of the list. */
    public void addLast(T x) {
        size = size + 1;

        Node p = sentinel;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }

        p.next = new Node(x, null);
    }

    /** Returns the first item in the list. */
    public T getFirst() {
        return sentinel.next.item;
    }

    /** Returns the back node of our list. */
    private Node getLastNode() {
        Node p = sentinel;

        /* Move p until it reaches the end. */
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    /** Returns last item */
    public T getLast() {
        Node back = getLastNode();
        return back.item;
    }

    /** Returns the ith item in the list. */
    public T get(int i) {
        return get(i, sentinel.next);
    }

    private T get(int i, Node p) {
        if (i == 0) {
            return p.item;
        }
        return get(i - 1, p.next);
    }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    /** Deletes and returns last item. */
    public T removeLast() {
        Node back = getLastNode();
        if (back == sentinel) {
            return null;
        }

        Node p = sentinel;

        while (p.next != back) {
            p = p.next;
        }
        p.next = null;
        return back.item;
    }


    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        SLList L = new SLList();
        L.addLast(20);
        System.out.println(L.size());
    }
}