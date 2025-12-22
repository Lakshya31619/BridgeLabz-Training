import java.util.Scanner;
public class CharAtArray {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        //Input
        String s = sc.next();
        //Convert to character array and store in character array
        char [] chars = s.toCharArray();
        //Print char array
        System.out.print("Character array : ");
        for(int i=0; i<chars.length; i++){
            System.out.print(chars[i]+" ");
        }
        System.out.println();
        //Compare array[] with charAt()
        System.out.println(compare(s, chars));
    }
    //Function compare
    public static boolean compare(String s, char [] chars){
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=chars[i]){
                return false;
            }
        }
        return true;
    }
}