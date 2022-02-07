public class IntList {
    int first;
    IntList rest;

    public IntList() {
    }

    public IntList(int first, IntList rest) {
        this.first = first;
        this.rest = rest;
    }

    public int size() {
        if (rest == null) {
            return 1;
        }

        return 1 + rest.size();
    }

    public int get(int i) {
        if (i == 0) {
            return first;
        }

        return rest.get(i - 1);
    }

    public static IntList decrList(IntList L, int x) {
        IntList listToReturn = L;
        decrementList(L, x);
        return listToReturn;
    }

    private static void decrementList(IntList L, int x) {
        if (L == null) {
            return;
        }

        L.first -= x;
        decrementList(L.rest, x);
    }

    public static IntList incrList(IntList L, int x) {
        IntList listToReturn = new IntList();
        copyList(L, listToReturn);
        incrementList(listToReturn, x);
        return listToReturn;
    }

    private static void copyList(IntList L, IntList CL) {
        if (L.rest == null) {
            CL.first = L.first;
            return;
        }

        CL.first = L.first;
        CL.rest = new IntList();
        copyList(L.rest, CL.rest);
    }

    private static void incrementList(IntList L, int x) {
        if (L == null) {
            return;
        }

        L.first += 3;
        IntList.incrementList(L.rest, x);;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(10, null);
        L.rest.rest = new IntList(15, null);
        L.rest.rest.rest = new IntList(20, null);

//        System.out.println(L.size());
//        System.out.println(L.get(1));
//        System.out.println(L.get(2));

        IntList IL = IntList.incrList(L, 3);
        IntList DL = IntList.decrList(L, 3);
    }
}
