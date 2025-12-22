import java.util.*;
public class ToUppercase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input
        String s = sc.nextLine();
        String s1 = "";
        //String to Uppercase
        for(int i=0; i<s.length(); i++){
            //If lowercase than convert to uppercase
            if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                s1 += (char)(s.charAt(i)-32);
            //If uppercase then append to ans
            }else{
                s1 += s.charAt(i);
            }
        }
        System.out.println("String using charAt function : "+s1);
        //Built-in method
        String s2 = s.toUpperCase();
        System.out.println("String using built-in method : "+s2);
        //Comparision
        if(s1.equals(s2)){
            System.out.println("Both strings are same");
        }else{
            System.out.println("Both strings are not same");
        }
    }
}