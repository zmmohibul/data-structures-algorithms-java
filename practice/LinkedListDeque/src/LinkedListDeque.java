public class LinkedListDeque<T> {
    private class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node(){}

        public Node(Node prev, T item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        this.size = 0;
        this.sentinel = new Node();
        this.sentinel.next = sentinel;
        this.sentinel.prev = sentinel;
    }

    public void addLast(T item) {
        Node n = new Node(this.sentinel.prev, item, this.sentinel);
        this.sentinel.prev.next = n;
        this.sentinel.prev = n;

        this.size += 1;
    }

    public void addFirst(T item) {
        Node n = new Node(this.sentinel, item, this.sentinel.next);
        this.sentinel.next.prev = n;
        this.sentinel.next = n;

        this.size += 1;
    }

    public boolean isEmpty() {
        if (this.size <= 0) {
            return true;
        }

        return false;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        System.out.print("[ ");

        for (Node p = this.sentinel.next; p != sentinel; p = p.next) {
            System.out.print(p.item + " ");
        }

        System.out.print("]");
        System.out.println();
    }

    public T get(int index) {
        Node p = sentinel.next;

        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.item;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addLast(15);
        L.addLast(10);
        L.addLast(5);
        L.addFirst(1);
        System.out.println(L.isEmpty());
        System.out.println(L.size());
        L.printDeque();
        System.out.println(L.get(0));
        System.out.println(L.get(2));
        System.out.println(L.get(3));
    }
}
