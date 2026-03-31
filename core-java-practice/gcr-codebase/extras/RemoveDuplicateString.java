import java.util.Scanner;
public class RemoveDuplicateString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input String
        String s = sc.nextLine();
        //Calling method removeDuplicate
        String res = removeDuplicate(s);
        //Output
        System.out.println("String after removing duplicates : "+res);
    }
    //Method to remove duplicate characters from string
    public static String removeDuplicate(String s){
        String res = "";
        for(int i=0; i<s.length(); i++){
            if(res.indexOf(s.charAt(i))==-1){
                res += s.charAt(i);
            }
        }
        return res;
    }
}