public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size() {
        if (rest == null) {
            return 1;
        }

        return 1 + rest.size();
    }

    public int sizeIterative() {
        int size = 0;
        for (IntList p = this; p != null; p = p.rest) {
            size += 1;
        }
        return size;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(10, null);
        L.rest.rest = new IntList(15, null);
        System.out.println(L.size());
        System.out.println(L.sizeIterative());
    }
}
