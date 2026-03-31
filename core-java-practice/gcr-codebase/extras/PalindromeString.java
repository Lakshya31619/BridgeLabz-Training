import java.util.Scanner;
public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input string
        String s = sc.nextLine();
        //Method checkPalindrome
        boolean flag = checkPalindrome(s);
        //Output
        if(flag){
            System.out.println("Palindrome string");
        }else{
            System.out.println("Not a Palindrome String");
        }
    }
    //Method to check palindrome
    public static boolean checkPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}