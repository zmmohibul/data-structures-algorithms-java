public class VengefulSLList<T> extends SLList<T> {
    SLList<T> deletedItems;

    public VengefulSLList(T item) {
        super(item);
        deletedItems = new SLList<T>();
    }

    @Override
    public T removeLast() {
        T lastItem = super.removeLast();
        this.deletedItems.addLast(lastItem);
        return lastItem;
    }

    public void printLostItem() {
        deletedItems.print();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vengefulSLList = new VengefulSLList<>(9);
        vengefulSLList.addLast(10);
        vengefulSLList.addLast(11);
        vengefulSLList.addLast(12);
        vengefulSLList.addLast(13);
        vengefulSLList.addLast(114);
        vengefulSLList.addLast(22);
        vengefulSLList.addLast(445);

        vengefulSLList.removeLast();
        vengefulSLList.removeLast();
        vengefulSLList.removeLast();


        vengefulSLList.print();
        vengefulSLList.printLostItem();
    }
}
