public class Cat implements Comparable<Cat> {
    public String name;
    private int size;

    public Cat(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public int compareTo(Cat o) {
        return this.size - o.size;
    }

    public void meaw() {
        System.out.println(this.name + " says: meaw");
    }
}
