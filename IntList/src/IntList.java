public class IntList {
    int first;
    IntList rest;

    public static void main(String[] args) {
        IntList L = new IntList();

        L.first = 5;

        L.rest = new IntList();
        L.rest.first = 10;

        L.rest.rest = new IntList();
        L.rest.rest.first = 15;
    }
}
