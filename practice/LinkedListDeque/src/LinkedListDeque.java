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

    public void addFirst(T item) {
        Node n = new Node(this.sentinel.prev, item, this.sentinel);
        this.sentinel.prev.next = n;
        this.sentinel.prev = n;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(15);
        L.addFirst(10);
        L.addFirst(5);
    }
}
