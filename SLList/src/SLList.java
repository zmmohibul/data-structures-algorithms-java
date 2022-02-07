public class SLList {
    private IntNode first;

    public SLList(int x) {
        this.first = new IntNode(x, null);
    }

    public void addFirst(int x) {
        IntNode n = new IntNode(x, this.first);
        this.first = n;
    }

    public int getFirst() {
        return first.item;
    }

    private IntNode getLastNode(IntNode n) {
        if (n.next == null) {
            return n;
        }

        return getLastNode(n.next);
    }

    public void addLast(int x) {
        if (first.next == null) {
            IntNode n = new IntNode(x, null);
            first.next = n;
            return;
        }

        IntNode lastNode = getLastNode(first);
        IntNode n = new IntNode(x, null);
        lastNode.next = n;

    }

    public int getLast() {
        IntNode n = getLastNode(first);
        return n.item;
    }

    private int getSize(IntNode n) {
        if (n.next == null) {
            return 1;
        }

        return 1 + getSize(n.next);
    }

    public int getSize() {
        IntNode n = first;
        return getSize(n);
    }

    public static void main(String[] args) {
        SLList L = new SLList(10);
//        System.out.println(L.getFirst());
        L.addFirst(15);
//        System.out.println(L.getFirst());
        L.addFirst(20);
//        System.out.println(L.getFirst());
        L.addFirst(25);
        System.out.println(L.getFirst());
        L.addLast(5);
        System.out.println(L.getLast());
        System.out.println(L.getSize());
    }
}
