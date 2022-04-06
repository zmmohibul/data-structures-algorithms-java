public class Maximizer {
    public static OurCompareable max(OurCompareable[] items) {
        if (items == null || items.length <= 0) {
            return  null;
        }

        OurCompareable maxItem = items[0];

        for (OurCompareable item : items) {
            if (item.compareTo(maxItem) > 0) {
                maxItem = item;
            }
        }

        return maxItem;
    }
}
