public class LinkedListDeque<T> {
    private class Node {
        Node prev;
        T item;
        Node next;

        public Node(T item) {
            this.prev = null;
            this.item = item;
            this.next = null;
        }

        public Node(Node prev, T item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private Node sentinal;
    private int size;

    public LinkedListDeque() {
        size = 0;

        sentinal = new Node(null);
        sentinal.next = sentinal;
        sentinal.prev = sentinal;
    }

    public void addFirst(T x) {
        size += 1;

        Node n = new Node(sentinal, x, sentinal.next);
        sentinal.next.prev = n;
        sentinal.next = n;
    }

    public void addLast(T x) {
        size += 1;

        Node n = new Node(x);
        n.prev = sentinal.prev;
        n.next = sentinal;
        sentinal.prev.next = n;
        sentinal.prev =n;
    }

    public T removeFirst() {
        if (size < 1) {
            return null;
        }

        T value = sentinal.next.item;

        sentinal.next = sentinal.next.next;
        sentinal.next.prev = sentinal;

        return value;
    }

    public T removeLast() {
        if (size < 1) {
            return null;
        }

        T value = sentinal.prev.item;

        sentinal.prev.prev.next = sentinal;
        sentinal.prev.prev = sentinal.prev;

        return value;
    }

    public T get(int i) {
        if (size < 1) {
            return null;
        }

        Node p = sentinal;
        while (i >= 0) {
            p = p.next;
            i -= 1;
        }

        return p.item;
    }

    public T getRecursive(int i) {
        return getRecursiveHelper(sentinal.next, i);
    }

    public T getRecursiveHelper(Node p, int i) {
        if (i == 0) {
            return p.item;
        }

        return getRecursiveHelper(p.next, i -= 1);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        System.out.print("[ ");
        Node p = sentinal;
        while (p.next != sentinal) {
            p = p.next;
            System.out.print(p.item);
            System.out.print(" ");
        }
        System.out.print("]");
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> ls = new LinkedListDeque<>();
        ls.addFirst(10);
        ls.addFirst(5);
        ls.addLast(15);
        System.out.println(ls.size());
        ls.printDeque();
        System.out.println(ls.get(0));
        System.out.println(ls.get(1));
        System.out.println(ls.get(2));
        System.out.println();
        System.out.println(ls.getRecursive(0));
        System.out.println(ls.getRecursive(1));
        System.out.println(ls.getRecursive(2));
        System.out.println(ls.removeFirst());
        ls.printDeque();
        System.out.println(ls.removeLast());
        ls.printDeque();
    }
}
