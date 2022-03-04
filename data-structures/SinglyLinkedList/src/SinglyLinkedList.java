public class SinglyLinkedList<T> {
    private class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    public SinglyLinkedList() {
        sentinel = new Node(null, null);
        size = 0;
    }

    public void addFirst(T item) {
        Node n = new Node(item, sentinel.next);
        sentinel.next = n;
    }

    public static void  main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addFirst(11);
        singlyLinkedList.addFirst(9);
        singlyLinkedList.addFirst(6);
        singlyLinkedList.addFirst(3);
    }
}
