import java.util.Scanner;
public class CharacterFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[][] result = findFrequency(input);
        //Output
        for (int i = 0; i < result.length; i++) {
            System.out.println("Character: " + result[i][0] + " | Frequency: " + result[i][1]);
        }
    }
    //Function to find frequency of characters
    public static String[][] findFrequency(String s) {
        int[] freq = new int[256];
        // Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        // Count unique characters
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] != 0) {
                count++;
                freq[s.charAt(i)] = 0; // mark counted
            }
        }
        // Reset frequency array
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        String[][] result = new String[count][2];
        int index = 0;
        // Store character and frequency
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (freq[ch] != 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(freq[ch]);
                index++;
                freq[ch] = 0; // avoid duplicate entry
            }
        }
        return result;
    }
}