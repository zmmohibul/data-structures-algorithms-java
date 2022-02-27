public class RotatingSLList<T> extends SLList<T> {
    public void rotateRight() {
        T lastItem = this.removeLast();
        this.addFirst(lastItem);
    }

    public static void main(String[] args) {
        RotatingSLList<Integer> rotatingSLList = new RotatingSLList<>();
        rotatingSLList.addFirst(10);
        rotatingSLList.addFirst(11);
        rotatingSLList.addFirst(12);
        rotatingSLList.addFirst(13);
        rotatingSLList.addFirst(14);
        rotatingSLList.rotateRight();
        rotatingSLList.print();
    }
}
