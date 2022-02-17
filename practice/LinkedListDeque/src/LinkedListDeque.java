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

    public T get(int index) {
        if (index < 0 || index >= size || size == 0) {
            throw new IndexOutOfBoundsException();
        }

        Node p = sentinel.next;

        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p.item;
    }

    public T getRecursive(int index) {
        if (index < 0 || index > size || size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return getRecursive(index, sentinel.next);
    }

    private T getRecursive(int index, Node p) {
        if (index == 0) {
            return p.item;
        }

        return getRecursive(index - 1, p.next);
    }

    public T deleteFirst() {
        Node itemToDelete = sentinel.next;

        sentinel.next.prev = sentinel;
        sentinel.next = sentinel.next.next;

        itemToDelete.prev = itemToDelete.next = null;
        return itemToDelete.item;
    }

    public T deleteLast() {
        Node itemToDelete = sentinel.prev;

        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;

        itemToDelete.prev = itemToDelete.next = null;
        return itemToDelete.item;
    }

    public void printDeque() {
        System.out.print("[ ");

        for (Node p = this.sentinel.next; p != sentinel; p = p.next) {
            System.out.print(p.item + " ");
        }

        System.out.print("]");
        System.out.println();
    }

    public void printDequeRecursive() {
        printDequeRecursive(sentinel.next);
    }

    private void printDequeRecursive(Node p) {
        if (p == sentinel) {
            System.out.println();
            return;
        }

        System.out.print(p.item + " ");
        printDequeRecursive(p.next);
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
        L.printDequeRecursive();
        System.out.println(L.getRecursive(2));
        System.out.println(L.deleteFirst());
        L.printDeque();
        System.out.println(L.deleteLast());
        L.printDeque();
        System.out.println(L.deleteLast());
        L.printDeque();
        System.out.println(L.deleteFirst());
        L.printDeque();
    }
}
