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
    private int size;

    public SLList(int x) {
        this.size = 1;
        this.first = new IntNode(x, null);
    }

    public void addFirst(int x) {
        IntNode n = new IntNode(x, this.first);
        this.first = n;

        this.size += 1;
    }

    public void addLast(int x) {
        IntNode n = new IntNode(x, null);

        IntNode p = first;
        for (p = first; p.next != null; p = p.next) {}
        p.next = n;

        this.size += 1;
    }

    public void addLastRecursive(int x) {
        addLastRecursive(x, this.first);

        this.size += 1;
    }

    private void addLastRecursive(int x, IntNode p) {
        if (p.next == null) {
            p.next = new IntNode(x, null);
            return;
        }

        addLastRecursive(x, p.next);
    }

    public int sizeIterative() {
        int size = 0;
        for (IntNode p = first; p != null; p = p.next) {
            size += 1;
        }
        return size;
    }

    public int sizeRecursive() {
        return sizeRecursive(this.first);
    }

    private int sizeRecursive(IntNode p) {
        if (p.next == null) {
            return 1;
        }

        return 1 + sizeRecursive(p.next);
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        SLList L = new SLList(10);
        L.addFirst(5);
        L.addLast(15);
        L.addLastRecursive(20);
        System.out.println(L.sizeIterative());
        System.out.println(L.sizeRecursive());
        System.out.println(L.size());
    }
}
