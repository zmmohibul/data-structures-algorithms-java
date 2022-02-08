public class SLList {
    private IntNode first;
    private IntNode sentinal;
    private int size;

    private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    public SLList() {
        this.sentinal = new IntNode(11, null);
        this.size = 0;
    }

    public SLList(int x) {
        this.size += 1;
        this.sentinal = new IntNode(11, null);
        this.sentinal.next = new IntNode(x, null);
    }

    public void addFirst(int x) {
        this.size += 1;
        IntNode n = new IntNode(x, first);
        this.sentinal.next = n;
    }

    public int getFirst() {
        return this.sentinal.next.item;
    }

    public void addLast(int x) {
        this.size += 1;
        addLast(x, sentinal.next);
    }

    private void addLast(int x, IntNode p) {
        if (p.next == null) {
            IntNode n = new IntNode(x, null);
            p.next = n;
            return;
        }

        addLast(x, p.next);
    }

    public int size() {
        return this.size;
    }

    /* public int size() {
        return size(this.sentinal.next);
    }

    private int size(IntNode p) {
        if (p.next == null) {
            return 1;
        }

        return 1 + size(p.next);
    } */

    public static void main(String[] args) {
        SLList L = new SLList(10);
        L.addFirst(5);
        L.addLast(15);
        System.out.println(L.getFirst());
        System.out.println(L.size());
    }
}
