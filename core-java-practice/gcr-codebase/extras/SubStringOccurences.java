import java.util.Scanner;
public class SubStringOccurences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input string and substring
        String s = sc.next();
        String sub = sc.next();
        //Calling method findOccurence
        int occ = findOccurence(s, sub);
        //Output
        System.out.println("Substring "+sub+" occurs "+occ+" times in String "+s);
    }
    public static int findOccurence(String s, String sub){
        int occ = 0;
        for(int i=0; i<=s.length()-sub.length(); i++){
            if(s.substring(i, i+sub.length()).equals(sub)){
                occ++;
            }
        }
        return occ;
    }
}