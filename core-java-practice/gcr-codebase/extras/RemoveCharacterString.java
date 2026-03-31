import java.util.Scanner;
public class RemoveCharacterString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input String and string to be removed
        String s = sc.nextLine();
        String r = sc.next();
        char ch = r.charAt(0);
        //Calling method remove
        String rem = remove(s, ch);
        //Output
        System.out.println("Modified String : "+rem);
    }
    //Method to remove character from String
    public static String remove(String s, char ch){
        String rem = "";
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!=ch){
                rem += s.charAt(i);
            }
        }
        return rem;
    }
}