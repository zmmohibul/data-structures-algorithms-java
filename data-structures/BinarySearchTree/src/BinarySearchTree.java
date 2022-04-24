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

    private boolean delete(Node node, T item) {
        if (node.item.equals(item)) {
            return true;
        }

        if (node.item.compareTo(item) > 0) {
            boolean shouldDelete = delete(node.left, item);
            if (shouldDelete) {
                if (nodeHasTwoChildren(node.left)) {
                    Node pred = findPred(node);
                    Node tempPred = new Node(pred.item);
                    tempPred.left = pred.left;
                    tempPred.right = pred.right;
                    node.left = tempPred;
                    delete(pred.left, item);
                    return false;
                } else if (nodeHasOneChild(node.left)) {
                    
                }

            } else {
                return false;
            }
        }
    }

    private boolean nodeHasOneChild(Node n) {
        return n.left != null || n.right != null;
    }

    private boolean nodeHasTwoChildren(Node n) {
        return n.left != null && n.right != null;
    }

    private boolean nodeHasNoChildren(Node node) {
        return node.left == null && node.right == null;
    }

    private Node findPred(Node node) {
        return findPredHelper(node.left)
    }
    private Node findPredHelper(Node node) {
        if (node.right != null) {
            return findPredHelper(node.right);
        } else {
            return node;
        }
    }

    private Node getChild(Node node) {
        if (node.left != null) {
            return node.left;
        } else if (node.right != null){
            return node.right;
        } else {
            return null;
        }
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
