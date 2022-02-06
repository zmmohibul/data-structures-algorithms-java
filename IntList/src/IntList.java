public class IntList {
    int first;
    IntList rest;

    public IntList(int f, IntList r) {
        this.first = f;
        this.rest = r;
    }

    public int size(IntList curr) {
        if (curr.rest == null) {
            return 1;
        }

        return size(curr.rest) + 1;
    }

    public int size() {
        return this.size(this);
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(10, null);
        L.rest.rest = new IntList(15, null);
        L.rest.rest.rest = new IntList(20, null);
        L.rest.rest.rest.rest = new IntList(25, null);
        System.out.println(L.size());
    }
}
