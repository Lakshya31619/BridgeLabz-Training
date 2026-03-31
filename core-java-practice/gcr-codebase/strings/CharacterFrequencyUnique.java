import java.util.Scanner;
public class CharacterFrequencyUnique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[][] result = findFrequency(input);
        //Output
        for (int i = 0; i < result.length; i++) {
            System.out.println("Character : " + result[i][0] +" | Frequency : " + result[i][1]);
        }
    }
    //Function to find unique characters using nested loops
    public static char[] uniqueCharacters(String s) {
        int len = s.length();
        char[] temp = new char[len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) == ch) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                temp[count++] = ch;
            }
        }
        // Create array of exact size
        char[] unique = new char[count];
        for (int i = 0; i < count; i++) {
            unique[i] = temp[i];
        }
        return unique;
    }
    //Function to find frequency using unique characters
    public static String[][] findFrequency(String s) {
        int[] freq = new int[256];
        // Count frequency of characters
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        // Get unique characters
        char[] unique = uniqueCharacters(s);
        String[][] result = new String[unique.length][2];
        // Store character and frequency
        for (int i = 0; i < unique.length; i++) {
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(freq[unique[i]]);
        }
        return result;
    }
}