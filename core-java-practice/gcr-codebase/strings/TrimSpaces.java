import java.util.Scanner;
public class TrimSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        //Calling trim functions
        int [] indexes = findIndexes(s);
        String s1 = substring(s, indexes[0], indexes[1]);
        //Built-in trim
        String s2 = s.trim();
        //Compare Strings
        boolean isSame = compare(s1, s2);
        //Output
        System.out.println("Custom Trim Result : " + s1);
        System.out.println("Built-in Trim Result : " + s2);
        System.out.println(isSame);
    }
    public static int[] findIndexes(String s) {
        int st = 0; //Starting index
        int en = s.length()-1; //Ending index
        //Trim leading spaces
        while(st<=en && s.charAt(st)==' '){
            st++;
        }
        //Trim trailing spaces
        while(en>=st && s.charAt(en)==' '){
            en--;
        }
        return new int[]{st, en};
    }
    //Create substring using charAt()
    public static String substring(String s, int st, int en) {
        String str = "";
        for(int i=st; i<=en; i++){
            str += s.charAt(i);
        }
        return str;
    }
    // Method to compare two strings using charAt()
    public static boolean compare(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return false;
            }
        }
        return true;
    }   
}