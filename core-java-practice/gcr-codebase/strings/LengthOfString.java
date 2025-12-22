import java.util.Scanner;
public class LengthOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input
        String s = sc.next();
        int count = 0; //Counter variable for length
        //try-catch to break at StringIndexOutofBoundsException
        try{
            while(true){
                s.charAt(count);
                count++;
            }
        }catch(StringIndexOutOfBoundsException e){}
        //Output
        System.out.println(count);
    }
}