public class IntList {
    int first;
    IntList rest;

    public IntList(int f, IntList r) {
        this.first = f;
        this.rest = r;
    }

    public int size() {
        if (rest == null) {
            return 1;
        }

        return 1 + rest.size();
    }

//    public int get(int i) {
//        if (i == 0) {
//            return first;
//        }
//
//        return rest.get(i - 1);
//    }

    public int get(int i, IntList l) {
        if (i == 0) {
            return l.first;
        }

        return get(i - 1, l.rest);
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(10, null);
        L.rest.rest = new IntList(15, null);
        L.rest.rest.rest = new IntList(20, null);
        L.rest.rest.rest.rest = new IntList(25, null);
        System.out.println(L.size());
        System.out.println(L.get(3, L));
    }
}
