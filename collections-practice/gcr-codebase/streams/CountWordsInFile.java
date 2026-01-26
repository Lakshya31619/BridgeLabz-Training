import java.io.*;
import java.util.*;
public class CountWordsInFile {
    public static void main(String[] args) {
        String fileName = "./collections-practice/gcr-codebase/streams/files/source.txt";
        HashMap<String, Integer> wordCount = new HashMap<>();
        int totalWords = 0;
        // Reading file using FileReader and BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("[^a-zA-Z ]", "").toLowerCase();
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        totalWords++;
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
            return;
        }
        // Sorting words based on frequency
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());
        sortedWords.sort((a, b) -> b.getValue() - a.getValue());
        System.out.println("Total Words: " + totalWords);
        System.out.println("\nTop 5 Most Frequent Words:");
        for (int i = 0; i < Math.min(5, sortedWords.size()); i++) {
            Map.Entry<String, Integer> entry = sortedWords.get(i);
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}