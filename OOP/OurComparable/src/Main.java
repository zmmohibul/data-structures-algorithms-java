public class Main {

    public static void main(String[] args) {
        Cat biral = new Cat("biral", 5);
        Cat brishty = new Cat("brishty", 1);
        Cat tapur = new Cat("tapur", 3);
        Cat tupur = new Cat("tupur", 2);

        Cat[] cats = new Cat[] { biral, brishty, tapur, tupur };
//        Cat maxCat = Cat.maxCat(cats);

        Cat maxCat = (Cat) Maximizer.max(cats);
        System.out.println(maxCat);



    }
}
