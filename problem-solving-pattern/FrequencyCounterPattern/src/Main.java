import java.util.HashMap;
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

    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println(validAnagram("abcdeaabbddfq", "abcdeaabbddfg"));
    }
}
