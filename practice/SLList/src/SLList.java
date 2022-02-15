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

    public static void main(String[] args) {
        SLList L = new SLList(10);
        L.addFirst(5);
    }

}
