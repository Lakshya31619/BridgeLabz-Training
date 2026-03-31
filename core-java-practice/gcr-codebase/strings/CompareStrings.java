import java.util.Scanner;
public class CompareStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input Strings
        String s1 = sc.next();
        String s2 = sc.next();
        //Function for comparing strings
        System.out.println(compare(s1, s2));
        //Using built-in method
        System.out.println(s1.equals(s2));
    }
    //Function compare
    public static boolean compare(String s1, String s2){
        //Check lengths are equal
        if(s1.length()==s2.length()){
            for(int i=0; i<s1.length(); i++){
                //If one character mismatch return false
                if(s1.charAt(i)!=s2.charAt(i)){
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }
}