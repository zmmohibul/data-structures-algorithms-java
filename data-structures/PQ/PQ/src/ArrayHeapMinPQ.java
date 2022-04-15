import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ArrayHeapMinPQ<T> {

    private List<PriorityNode> items;

    public ArrayHeapMinPQ() {
        items = new ArrayList<>();
    }

    public void add(T item, double priority) {
        PriorityNode n = new PriorityNode(item, priority);
        items.add(n);

        if (items.size() == 1) {
            return;
        }

        swim(items.size() - 1);
    }

    private void swim(int n) {
        if (n == 0) {
            return;
        }

        int p = parent(n);

        PriorityNode node = items.get(n);
        PriorityNode parent = items.get(p);

        if (node.getPriority() < parent.getPriority()) {
            swap(n, p);
            swim(p);
        }

    }

    private void swap(int n, int p) {
        PriorityNode temp = items.get(n);
        items.set(n, items.get(p));
        items.set(p, temp);
    }

    private int parent(int n) {
        return (n - 1) / 2;
    }

    public T getSmallest() {
        if (items.size() == 0) {
            throw new NoSuchElementException();
        }

        return items.get(0).item;
    }

    public void changePriority(T item, Double priority) {

    }

    private PriorityNode find(T item) {
        
    }

    public T removeSmallest() {
        PriorityNode nodeToRemove = items.get(0);

        PriorityNode last = items.remove(items.size() - 1);
        items.set(0, last);
        sink(0);

        return nodeToRemove.item;
    }

    private void sink(int n) {
        int leftChildIndex = n * 2 + 1;
        int rightChildIndex = n * 2 + 2;

        boolean nHasTwoChildren = (leftChildIndex < items.size() - 1) && (rightChildIndex < items.size() - 1);
        boolean nHasNoChildren = (leftChildIndex > items.size() - 1) && (rightChildIndex > items.size() - 1);

        if (nHasNoChildren) {
            return;
        }

        boolean nHasLeftChild = (leftChildIndex < items.size() - 1);
        boolean nHasRightChild = (rightChildIndex < items.size() - 1);

        PriorityNode node = items.get(n);

        if (nHasTwoChildren) {
            double leftCmp = node.compareTo(items.get(leftChildIndex));
            double rightCmp = node.compareTo(items.get(rightChildIndex));

            PriorityNode leftChild = items.get(leftChildIndex);
            PriorityNode rightChild = items.get(rightChildIndex);

            int strongestChildIndex;

            if (leftChild.getPriority() < rightChild.getPriority()) {
                strongestChildIndex = leftChildIndex;
            } else {
                strongestChildIndex = rightChildIndex;
            }

            if (leftCmp > 0 && rightCmp > 0) {
                swap(n, strongestChildIndex);
                sink(strongestChildIndex);
            } else if (leftCmp > 0) {
                swap(n, leftChildIndex);
                sink(leftChildIndex);
            } else if (rightCmp > 0) {
                swap(n, rightChildIndex);
                sink(rightChildIndex);
            }
        } else if (nHasLeftChild) {
            double cmp = node.compareTo(items.get(leftChildIndex));

            if (cmp > 0) {
                swap(n, leftChildIndex);
                sink(leftChildIndex);
            }
        } else if (nHasRightChild) {
            double cmp = node.compareTo(items.get(rightChildIndex));

            if (cmp > 0) {
                swap(n, rightChildIndex);
                sink(rightChildIndex);
            }
        }
    }

    public void print() {
        for (PriorityNode item : items) {
            System.out.print(item.item + ", ");
        }
        System.out.println();
    }

    private class PriorityNode implements Comparable<PriorityNode> {
        private T item;
        private double priority;

        public PriorityNode(T item, double priority) {
            this.item = item;
            this.priority = priority;
        }

        public T getItem() {
            return item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public double getPriority() {
            return priority;
        }

        public void setPriority(double priority) {
            this.priority = priority;
        }

        @Override
        public int compareTo(PriorityNode o) {
            if (o == null) {
                return -1;
            }

            return Double.compare(this.getPriority(), o.getPriority());
        }
    }

    public static void main(String[] args) {
        ArrayHeapMinPQ<Integer> pq = new ArrayHeapMinPQ<>();

        pq.add(1, 1);
        pq.add(5, 5);
        pq.add(1, 1);
        pq.add(6, 6);
        pq.add(5, 5);
        pq.add(6, 6);
        pq.add(3, 3);
        pq.add(7, 7);
        pq.add(7, 7);
        pq.add(8, 8);

        pq.print();

        pq.add(3, 3);
        pq.print();

        System.out.println(pq.getSmallest());
        pq.print();

        System.out.println(pq.removeSmallest());
        pq.print();
    }
}
