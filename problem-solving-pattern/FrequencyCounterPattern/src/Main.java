import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static boolean validAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        HashMap<Character, Integer> charFreqWord1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> charFreqWord2 = new HashMap<Character, Integer>();

        for (int i = 0; i < word1.length(); i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            if (!charFreqWord1.containsKey(c1)) {
                charFreqWord1.put(c1, 1);
            } else {
                charFreqWord1.put(c1, charFreqWord1.get(c1) + 1);
            }

            if (!charFreqWord2.containsKey(c2)) {
                charFreqWord2.put(c2, 1);
            } else {
                charFreqWord2.put(c2, charFreqWord2.get(c2) + 1);
            }
        }


        for (Map.Entry<Character, Integer> entry : charFreqWord1.entrySet()) {
            if (!charFreqWord2.containsKey(entry.getKey())) {
                return false;
            } else if (charFreqWord1.get(entry.getKey()) != charFreqWord2.get(entry.getKey())) {
                return false;
            }
        }

        return true;
    }

    public static <T> boolean areThereDuplicates(T... items) {
        HashMap<T, Integer> itemFrequency = new HashMap<>();

        for (T item : items) {
            if (itemFrequency.containsKey(item)) {
                return true;
            }

            itemFrequency.put(item, 1);
        }

        return false;
    }

    public static int findLCM(int n1, int n2) {
        HashMap<Integer, Integer> primeFactorizationN1 = new HashMap<>();
        int divisor = 2;
        while (n1 != 1) {
            if (n1 % divisor == 0) {
                if (!primeFactorizationN1.containsKey(divisor)) {
                    primeFactorizationN1.put(divisor, 1);
                } else {
                    primeFactorizationN1.put(divisor, primeFactorizationN1.get(divisor) + 1);
                }
                n1 /= divisor;
            } else {
                divisor += 1;
            }

        }

        divisor = 2;
        HashMap<Integer, Integer> primeFactorizationN2 = new HashMap<>();
        while (n2 != 1) {
            if (n2 % divisor == 0) {
                if (!primeFactorizationN2.containsKey(divisor)) {
                    primeFactorizationN2.put(divisor, 1);
                } else {
                    primeFactorizationN2.put(divisor, primeFactorizationN2.get(divisor) + 1);
                }
                int quotient = n2 / divisor;
                n2 = quotient;
                if (quotient > divisor) {
                    break;
                }
            } else {
                divisor += 1;
            }
        }

        int result = 1;
        for (Map.Entry entry : primeFactorizationN1.entrySet()) {
            Integer k = (Integer) entry.getKey();
            Integer v = (Integer) entry.getValue();
            if (primeFactorizationN2.containsKey(k) && primeFactorizationN2.get(k) > v) {
                result *= Math.pow(k, primeFactorizationN2.get(k));
            } else {
                result *= Math.pow(k, v);
            }
        }

        return result;
    }

    public static int findLCM2(int n1, int n2) {
        int result = 2;
        while (true) {
            if (result % n1 == 0 && result % n2 == 0) {
                return result;
            } else {
                result += 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(validAnagram("abcdeaabbddfq", "abcdeaabbddfg"));
        System.out.println(areThereDuplicates(0, 1, 2, 3, 0, 4, 5));
        System.out.println(areThereDuplicates(0, 1, 2, 3, 4, 5));
        System.out.println(findLCM(12, 18));
        System.out.println(findLCM2(12, 18));

    }
}
