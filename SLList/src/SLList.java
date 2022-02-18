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

    public void insert(int i, int item) {
        IntNode p = sentinal;
        for (int j = 0; j < i; j++) {
            p = p.next;
        }
        p.next = new IntNode(item, p.next);
    }

    public int size() {
        return this.size;
    }

    public void deleteFirst() {
        this.sentinal.next = this.sentinal.next.next;
        this.size -= 1;
    }

    public void addAdjacentIterative() {
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

    public void addAdjacent() {
        addAdjacent(this.sentinal.next);
    }

    private void addAdjacent(IntNode p) {
        if (p.next == null) {
            return;
        }

        if (p.item == p.next.item) {
            p.item += p.next.item;
            p.next = p.next.next;
            addAdjacent(p);
        } else {
            addAdjacent(p.next);
        }
    }

    public void squareAndInsert(int x) {
        IntNode last = squareAndInsert(this.sentinal.next);
        IntNode n = new IntNode(x, null);
        last.next = n;
    }

    private IntNode squareAndInsert(IntNode p) {
        if (p.next == null) {
            IntNode n = new IntNode(p.item * p.item, null);
            p.next = n;
            return p.next;
        }

        IntNode n = new IntNode(p.item * p.item, p.next);
        p.next = n;
        return squareAndInsert(n.next);
    }

    public void printList() {
        for (IntNode p = sentinal.next; p != null; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    public void printListRecursive() {
        printListRecursive(sentinal.next);
        System.out.println();
    }

    private void printListRecursive(IntNode p) {
        if (p == null) {
            return;
        }
        System.out.print(p.item + " ");
        printListRecursive(p.next);
    }

    public static void main(String[] args) {
//        int arr[] = new int[] {1, 1, 2, 2, 2, 3, 3};
//
//        SLList L = new SLList(arr);
//        L.addAdjacent();

        int arr[] = new int[] {1, 2};
        SLList L = new SLList(arr);
        L.squareAndInsert(5);
        L.squareAndInsert(7);
        L.printList();
        L.insert(1, 22);
        L.printListRecursive();
    }
}
