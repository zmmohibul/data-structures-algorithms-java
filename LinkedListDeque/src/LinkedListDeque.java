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
        Node n = new Node(x);
        n.prev = sentinal.prev;
        n.next = sentinal;
        sentinal.prev.next = n;
        sentinal.prev =n;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> ls = new LinkedListDeque<>();
        ls.addFirst(10);
        ls.addFirst(5);
        ls.addLast(15);
    }
}