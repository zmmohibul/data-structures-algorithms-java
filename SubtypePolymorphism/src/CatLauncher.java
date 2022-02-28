public class CatLauncher {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Minu", 15);
        Cat cat2 = new Cat("Brishty", 3);
        Cat cat3 = new Cat("Tapur", 5);
        Cat cat4 = new Cat("Tupur", 4);
        Cat[] cats = new Cat[]{cat1, cat2, cat3, cat4};

        Cat cat = (Cat) Maximizer.max(cats);
        cat.meaw();
    }
}
