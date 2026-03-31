import java.util.Scanner;
public class FirstNonRepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char result = firstNonRepeat(input);
        if (result != '#') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found");
        }
    }
    //Function to find first non-repeating character
    public static char firstNonRepeat(String s) {
        int[] freq = new int[256];
        //Count frequency of each character
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        //First character with frequency = 1
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)] == 1) {
                return s.charAt(i);
            }
        }
        // If no non-repeating character found
        return '#';
    }
}