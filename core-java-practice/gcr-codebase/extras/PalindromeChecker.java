import java.util.Scanner;
public class PalindromeChecker {
    public static void main(String[] args) {
        // Calling method getInput
        String s = getInput();
        // Calling method to checkPalindrome
        boolean flag = checkPalindrome(s);
        // Calling method to displayResult
        displayResult(s, flag);
    }
    // Method to take string input
    public static String getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    // Method to check palindrome
    public static boolean checkPalindrome(String str) {
        int high = 0;
        int low = str.length()-1;
        while (high<low) {
            if (str.charAt(high++) != str.charAt(low--)) {
                return false;
            }
        }
        return true;
    }
    // Method to display result
    public static void displayResult(String str, boolean flag) {
        if (flag) {
            System.out.println("The given string " + str + " is a Palindrome");
        } else {
            System.out.println("The given string " + str + " is not a Palindrome");
        }
    }
}