import java.util.Scanner;
public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input String
        String s = sc.nextLine();
        //Calling method reverse
        String rev = reverse(s);
        //Output
        System.out.println("Reversed String : "+rev);
    }
    //Method to reverse a string
    public static String reverse(String s){
        String rev = "";
        for(int i=s.length()-1; i>=0; i--){
            rev += s.charAt(i);
        }
        return rev;
    }
}