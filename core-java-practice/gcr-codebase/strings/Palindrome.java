import java.util.Scanner;
public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean ans1 = isLoop(s);
        boolean ans2 = isRecursive(s, 0, s.length()-1);
        boolean ans3 = isArray(s);
        System.out.println("Palindrome using Loop : " + ans1);
        System.out.println("Palindrome using Recursion : " + ans2);
        System.out.println("Palindrome using Array : " + ans3);
    }
    // Logic 1 : Loop
    public static boolean isLoop(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    // Logic 2 : Recursion
    public static boolean isRecursive(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }
        return isRecursive(s, start + 1, end - 1);
    }
    // Logic 3a: charAt()
    public static char[] reverseString(String s) {
        char[] rev = new char[s.length()];
        int index = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            rev[index++] = s.charAt(i);
        }
        return rev;
    }
    // Logic 3b: Character Arrays
    public static boolean isArray(String s) {
        char[] original = s.toCharArray();
        char[] reverse = reverseString(s);
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reverse[i]) {
                return false;
            }
        }
        return true;
    }
}