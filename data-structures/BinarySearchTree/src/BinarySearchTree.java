public class BinarySearchTree<T extends Comparable<T>> {
    private class Node {
        T value;
        Node left;
        Node right;
    }

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }
}
