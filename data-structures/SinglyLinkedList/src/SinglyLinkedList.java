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

    public void addLast(T item) {
        Node lastNode = getLastNode();
        lastNode.next = new Node(item, null);
    }

    private Node getLastNode() {
        return getLastNodeRecursive(sentinel.next);
    }

    private Node getLastNodeRecursive(Node ptr) {
        if (ptr.next == null) {
            return ptr;
        }

        return getLastNodeRecursive(ptr.next);
    }

    @Override
    public String toString() {
        Node ptr = sentinel.next;
        StringBuilder sb = new StringBuilder("{ ");

        while (ptr.next != null) {
            sb.append(ptr.item);
            sb.append(" -> ");
            ptr = ptr.next;
        }

        sb.append(ptr.item);
        sb.append(" }");

       return sb.toString();
    }

    public static void  main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addFirst(11);
        singlyLinkedList.addFirst(9);
        singlyLinkedList.addFirst(6);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addLast(14);
        singlyLinkedList.addLast(17);
        singlyLinkedList.addLast(19);
        System.out.println(singlyLinkedList);
    }
}
