public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;
    private IntNode sentinal;
    private int size;

    public SLList() {
        this.sentinal = new IntNode(11, null);
        this.size = 0;
    }

    public SLList(int x) {
        this.size += 1;
        this.sentinal = new IntNode(11, null);
        this.sentinal.next = new IntNode(x, null);
    }

    public SLList(int[] arr) {
        this.size = 0;
        this.sentinal = new IntNode(11, null);
        IntNode p = this.sentinal;
        for (int i = 0; i < arr.length; i++) {
            this.size += 1;

            IntNode n = new IntNode(arr[i], null);
            p.next = n;
            p = p.next;
        }
    }

    public void addFirst(int x) {
        this.size += 1;
        IntNode n = new IntNode(x, first);
        n.next = this.sentinal.next;
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

    public void deleteFirst() {
        this.sentinal.next = this.sentinal.next.next;
        this.size -= 1;
    }

    public void addAdjacent() {
        IntNode p = this.sentinal.next;
        while (p.next != null) {
            if (p.item == p.next.item) {
                p.item += p.next.item;
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[] {1, 1, 2, 2, 2, 3, 3};

        SLList L = new SLList(arr);
        L.addAdjacent();
    }
}
