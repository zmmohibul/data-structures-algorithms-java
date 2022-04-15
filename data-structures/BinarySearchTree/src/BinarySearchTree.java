public class BinarySearchTree<T extends Comparable<T>> {

    Node root;

    public BinarySearchTree(T item) {
        root = new Node(item);
    }

    public void insert(T item) {

        Node curr = root;

        while (true) {
            if (curr.item.compareTo(item) < 0) {
                if (curr.right == null) {
                    curr.right = new Node(item);
                    break;
                } else {
                    curr = curr.right;
                }
            }

            if (curr.item.compareTo(item) > 0) {
                if (curr.left == null) {
                    curr.left = new Node(item);
                    break;
                } else {
                    curr = curr.left;
                }
            }
        }

    }

    public void insertRecursive(T item) {
        insert(root, item);
    }

    private Node insert(Node node, T item) {
        if (node == null) {
            return new Node(item);
        }

        if (node.item.compareTo(item) > 0) {
            node.left = insert(node.left, item);
        }

        if (node.item.compareTo(item) < 0) {
            node.right = insert(node.right, item);
        }

        return node;
    }



    private class Node {
        T item;
        Node left;
        Node right;

        public Node(T item) {
            this.item = item;
            this.left = null;
            this.right = null;
        }
    }
}
