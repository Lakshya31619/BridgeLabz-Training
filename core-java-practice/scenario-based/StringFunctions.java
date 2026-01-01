import java.util.Scanner;
public class StringFunctions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input sentence
        String s = sc.nextLine();
        if (s == null || s.trim().isEmpty()) {
            System.out.println("Paragraph is empty.");
            return;
        }
        // Input
        String wordToReplace = sc.nextLine();
        String replacementWord = sc.nextLine();
        String sTrim = trimString(s);
        int wordCount = countWords(sTrim);
        String longestWord = findLongestWord(sTrim);
        String replacedText = replaceWord(sTrim, wordToReplace, replacementWord);
        System.out.println("Word Count: " + wordCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Updated Paragraph: " + replacedText);
    }
    // Trim extra spaces
    public static String trimString(String s) {
        return s.trim().replaceAll("\\s+", " ");
    }
    // Count number of words
    public static int countWords(String s) {
        if (s.isEmpty()) return 0;
        String[] words = s.split(" ");
        return words.length;
    }
    // Find longest word
    public static String findLongestWord(String s) {
        String[] words = s.split(" ");
        String longest = "";
        for (String word : words) {
            // Remove punctuation
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            if (cleanWord.length() > longest.length()) {
                longest = cleanWord;
            }
        }
        return longest;
    }
    // Replace word
    public static String replaceWord(String s, String oldWord, String newWord) {
        return s.replaceAll("(?i)\\b" + oldWord + "\\b", newWord);
    }
}