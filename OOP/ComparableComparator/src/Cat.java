import java.util.Comparator;

public class Cat implements Comparable<Cat> {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Cat maxCat(Cat[] cats) {
        if (cats == null || cats.length <= 0) {
            return  null;
        }

        Cat maxCat = cats[0];

        for (Cat c : cats) {
            if (c.age > maxCat.age) {
                maxCat = c;
            }
        }

        return maxCat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Cat o) {
        return this.age - o.age;
    }

    private static class NameComparator implements Comparator<Cat> {
        @Override
        public int compare(Cat o1, Cat o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    public static Comparator<Cat> getNameComparator() {
        return new NameComparator();
    }
}
