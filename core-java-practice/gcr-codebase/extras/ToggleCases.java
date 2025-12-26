import java.util.Scanner;
public class ToggleCases {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input String
        String s = sc.next();
        //Calling method toggle
        String res = toggle(s);
        //Output
        System.out.println("String after conversion : "+res);
    }
    //Method to toggle uppercase to lowercase and vice-versa
    public static String toggle(String s){
        String res = "";
        for(int i=0; i<s.length(); i++){
            char x = s.charAt(i);
            if(x>='A' && x<='Z'){
                res += (char)(x+32);
            }else if(x>='a' && x<='z'){
                res += (char)(x-32);
            }else{
                res += x;
            }
        }
        return res;
    }
}