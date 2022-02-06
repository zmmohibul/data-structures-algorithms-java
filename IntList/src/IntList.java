public class IntList {
    int first;
    IntList rest;

    public IntList(int f, IntList r) {
        this.first = f;
        this.rest = r;
    }

    private int size(IntList curr) {
        if (curr.rest == null) {
            return 1;
        }

        return size(curr.rest) + 1;
    }

    public int size() {
        return this.size(this);
    }

    public int getItr(int i) {
        IntList curr = this;
        for (int c = 0; c < i; c++) {
            curr = curr.rest;
        }

        return curr.first;
    }

    public int get(int i, int c, IntList curr) {
        if (c == i) {
            return curr.first;
        }

        return get(i, c+1, curr.rest);
    }

    public int get(int i) {
        return get(i, 0, this);
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(10, null);
        L.rest.rest = new IntList(15, null);
        L.rest.rest.rest = new IntList(20, null);
        L.rest.rest.rest.rest = new IntList(25, null);
        System.out.println(L.size());
        System.out.println(L.getItr(2));
        System.out.println(L.get(3));
    }
}
