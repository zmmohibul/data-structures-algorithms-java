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

    public int get(int i) {
        if (i == 0) {
            return first;
        }

        return rest.get(i - 1);
    }

    public static IntList incrList(IntList L, int x) {
        IntList Q = new IntList(0, null);
        incrementAndCopyValues(L, Q, x);
        return Q;
    }

    private static void incrementAndCopyValues(IntList listToCopyFrom, IntList listToCopyTo, int x) {
        listToCopyTo.first = listToCopyFrom.first + x;

        if (listToCopyFrom.rest == null) {
            return;
        }

        listToCopyTo.rest = new IntList(0, null);

        incrementAndCopyValues(listToCopyFrom.rest, listToCopyTo.rest, x);
    }

    public static IntList dincrList(IntList L, int x) {
        decrementList(L, x);
        return L;
    }

    private static void decrementList(IntList L, int x) {
        if (L == null) {
            return;
        }

        L.first -= x;
        decrementList(L.rest, x);
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(10, null);
        L.rest.rest = new IntList(15, null);
        L.rest.rest.rest = new IntList(20, null);
        System.out.println(L.size());
        System.out.println(L.sizeIterative());
        IntList IL = IntList.incrList(L, 3);
        IntList DL = IntList.dincrList(L, 3);
    }
}
