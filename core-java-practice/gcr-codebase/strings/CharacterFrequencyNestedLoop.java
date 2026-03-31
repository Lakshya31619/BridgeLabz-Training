import java.util.Scanner;
public class CharacterFrequencyNestedLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] result = findFrequency(input);
        // Output
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
    //Function to find frequency using nested loops
    public static String[] findFrequency(String s) {
        char[] ch = s.toCharArray();
        int[] freq = new int[ch.length];
        // Initialize frequency array
        for (int i = 0; i < freq.length; i++) {
            freq[i] = 1;
        }
        // Nested loops to find frequency
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '0')
                continue;
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j]) {
                    freq[i]++;
                    ch[j] = '0'; // mark duplicate
                }
            }
        }
        // Count unique characters
        int count = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '0') {
                count++;
            }
        }
        // Store result in 1D String array
        String[] result = new String[count];
        int index = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != '0') {
                result[index++] = "Character : " + ch[i] + " | Frequency : " + freq[i];
            }
        }
        return result;
    }
}