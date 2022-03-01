
public class ArraySet<T> {
    private T[] items;
    private int size;


    public ArraySet() {
        this.items = (T[]) new Object[100];
        size = 0;
    }

    public boolean contains(T x) {
        if (size == 0) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (items[i] == null) {
                if (x == null) {
                    return true;
                } else {
                    continue;
                }
            }

            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    public void add(T x) {
        if (contains(x)) {
            return;
        }

        items[size] = x;
        size += 1;
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.contains("cat"));
        System.out.println(s.contains(null));
        System.out.println(s.size());
    }
}