import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Cat biral = new Cat("biral", 5);
        Cat brishty = new Cat("brishty", 1);
        Cat tapur = new Cat("tapur", 3);
        Cat tupur = new Cat("tupur", 2);

        Cat[] cats = new Cat[] { biral, brishty, tapur, tupur };
//        Cat maxCat = Cat.maxCat(cats);

        Arrays.sort(cats, Cat.getNameComparator());

        for (Cat cat : cats) {
            System.out.println(cat);
        }
    }
}
