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
        Node n = new Node(this.sentinel, item, this.sentinel.next);
        this.sentinel.next.prev = n;
        this.sentinel.next = n;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(10);
        L.addFirst(5);
    }
}
