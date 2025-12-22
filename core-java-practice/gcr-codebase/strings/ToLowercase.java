import java.util.Scanner;
public class ToLowercase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input
        String s = sc.nextLine();
        String s1 = "";
        //String to Lowercase
        for(int i=0; i<s.length(); i++){
            //If uppercase than convert to lowercase
            if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                s1 += (char)(s.charAt(i)+32);
            //If lowercase then append to ans
            }else{
                s1 += s.charAt(i);
            }
        }
        System.out.println("String using charAt function : "+s1);
        //Built-in method
        String s2 = s.toLowerCase();
        System.out.println("String using built-in method : "+s2);
        //Comparision
        if(s1.equals(s2)){
            System.out.println("Both strings are same");
        }else{
            System.out.println("Both strings are not same");
        }
    }
}