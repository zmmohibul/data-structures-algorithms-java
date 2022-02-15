public class SLList {
    private class IntNode {
        private int item;
        private IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }
    private IntNode first;

    public SLList(int x) {
        this.first = new IntNode(x, null);
    }

    public void addFirst(int x) {
        IntNode n = new IntNode(x, this.first);
        this.first = n;
    }

    public void addLast(int x) {
        IntNode n = new IntNode(x, null);
        IntNode p = first;
        for (p = first; p.next != null; p = p.next) {}
        p.next = n;
    }

    public void addLastRecursive(int x) {
        IntNode p = first;
        addLastRecursive(x, p);
    }

    public void addLastRecursive(int x, IntNode p) {
        if (p.next == null) {
            p.next = new IntNode(x, null);
            return;
        }

        addLastRecursive(x, p.next);
    }

    public static void main(String[] args) {
        SLList L = new SLList(10);
        L.addFirst(5);
        L.addLast(15);
        L.addLastRecursive(20);
    }

}
