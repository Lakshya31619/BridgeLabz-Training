import java.util.HashMap;
import java.util.Map;
public class MapFrequencyCounter {
    public static void main(String[] args) {
        String input = "Hello world, hello Java!";
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = input.toLowerCase().split("\\W+");
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        System.out.println(wordCount);
    }
}