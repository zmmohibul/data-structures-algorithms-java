public class LinkedListDeque<T> {
    private class Node {
        Node prev;
        T item;
        Node next;

        public Node() {
        }

        public Node(Node prev, T item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private Node sentinal;

    public LinkedListDeque() {
        sentinal = new Node();
        sentinal.next = sentinal;
        sentinal.prev = sentinal;
    }

    public void addFirst(T x) {
        Node n = new Node(sentinal, x, sentinal.next);
        sentinal.next.prev = n;
        sentinal.next = n;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> ls = new LinkedListDeque<>();
        ls.addFirst(5);
        ls.addFirst(10);
    }
}
