import java.util.Scanner;
public class StringBuilderReverse{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String input
        String s = sc.nextLine();
        String rev = reverseString(s);
        System.out.println("Reversed String : "+rev);
    }
    public static String reverseString(String s){
        StringBuilder sb = new StringBuilder();
        //Append
        sb.append(s);
        //Reverse
        sb = sb.reverse();
        //Convert StringBuilder to String
        String rev = sb.toString();
        return rev;
    }
}