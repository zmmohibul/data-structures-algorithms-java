import java.util.ArrayList;
import java.util.List;

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

    public void print() {
        for (PriorityNode item : items) {
            System.out.print(item.item + ", ");
        }
        System.out.println();
    }

    private void swim(int n) {
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




    }
}
