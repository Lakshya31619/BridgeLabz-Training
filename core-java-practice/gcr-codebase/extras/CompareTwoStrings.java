import java.util.Scanner;
public class CompareTwoStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input two Strings
        String s1 = sc.next();
        String s2 = sc.next();
        //Calling method checkLexico
        String [] dic = checkLexico(s1, s2);
        //Output
        if(dic[0].equals(dic[1])){
            System.out.println("Both strings are equal");
        }else{
            System.out.println(dic[0]+" comes before "+dic[1]+" in lexicographical order");
        }
    }
    //Method to compare two strings in lexicographical order
    public static String [] checkLexico(String s1, String s2){
        int i=0;
        String ls1 = s1.toLowerCase();
        String ls2 = s2.toLowerCase();
        while(i<ls1.length() && i<ls2.length()){
            if(ls1.charAt(i)<ls2.charAt(i)){
                return new String[]{s1, s2};
            }else if(ls1.charAt(i)>ls2.charAt(i)){
                return new String[]{s2, s1};
            }else{
                i++;
            }
        }
        return new String[]{s1, s2};
    }
}