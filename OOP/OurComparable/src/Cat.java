public class Cat implements OurCompareable {
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
    public int compareTo(Object o) {
        Cat c = (Cat) o;
        return this.age - c.age;
    }
}
