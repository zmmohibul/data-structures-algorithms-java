public class Main {
    public static void main(String[] args) {
        SLList L = new SLList(10);
        L.addFirst(5);
        L.addLast(15);
//        L.deleteFirst();
        System.out.println(L.getFirst());
        System.out.println(L.size());
    }
}
