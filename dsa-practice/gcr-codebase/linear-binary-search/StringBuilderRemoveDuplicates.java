import java.util.Scanner;
import java.util.HashSet;
public class StringBuilderRemoveDuplicates{
    public static void main(String[] args) {
        System.out.print("Input String : ");
        Scanner sc = new Scanner(System.in);
        //Input String
        String s = sc.nextLine();
        //Remove Duplicates from String
        String res = removeDuplicates(s);
        System.out.println("String after removing duplicates : "+res);
    }
    public static String removeDuplicates(String s){
        //HashSet
        HashSet<Character> hs = new HashSet<>();
        //StringBuilder
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(!hs.contains(s.charAt(i))){
                sb.append(s.charAt(i));
            }
            hs.add(s.charAt(i));
        }
        //Convert StringBuilder to String
        String res = sb.toString();
        return res;
    }
}