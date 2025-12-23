import java.util.Scanner;
public class Anagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        boolean result = isAnagram(s1, s2);
        if (result) {
            System.out.println("The given strings are anagrams");
        } else {
            System.out.println("The given strings are not anagrams");
        }
    }
    //Function to check if two texts are anagrams
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];
        // Find frequency of characters in first text
        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i)]++;
        }
        // Find frequency of characters in second text
        for (int i = 0; i < s2.length(); i++) {
            freq2[s2.charAt(i)]++;
        }
        // Compare frequencies
        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }
        return true;
    }
}