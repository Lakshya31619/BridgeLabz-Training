import java.util.Scanner;
public class SubStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input string, starting and ending index
        String s = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();
        //Generating substring
        String s1 = "";
        for(int i=start; i<=end; i++){
            s1 += s.charAt(i);
        }
        //Substring using built-in function
        String s2 = s.substring(start, end+1);
        System.out.println("Substring : "+s1);
        System.out.println(compare(s1, s2));
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