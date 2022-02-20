public class WordsUtil {
    public static String longest(SLList<String> list) {
        int longestStringIndex = 0;
        for (int i = 1; i < list.size(); i++) {
            String longestString = list.get(longestStringIndex);
            String currentIndexString = list.get(i);
            if (currentIndexString.length() > longestString.length()) {
                longestStringIndex = i;
            }
        }
        return list.get(longestStringIndex);
    }

    public static String longest(AList<String> list) {
        int longestStringIndex = 0;
        for (int i = 1; i < list.size(); i++) {
            String longestString = list.get(longestStringIndex);
            String currentIndexString = list.get(i);
            if (currentIndexString.length() > longestString.length()) {
                longestStringIndex = i;
            }
        }
        return list.get(longestStringIndex);
    }

    public static void main(String[] args) {
        SLList<String> vegetables = new SLList<>();
        vegetables.addFirst("potato");
        vegetables.addFirst("eggplant");
        vegetables.addFirst("drumstick");
        vegetables.addFirst("broccoli");
        vegetables.addFirst("spinach");

        System.out.println(WordsUtil.longest(vegetables));

        AList<String> fruits = new AList<>();
        fruits.addLast("apple");
        fruits.addLast("banana");
        fruits.addLast("grapefruit");
        fruits.addLast("cherry");

        System.out.println(WordsUtil.longest(fruits));
    }
}
