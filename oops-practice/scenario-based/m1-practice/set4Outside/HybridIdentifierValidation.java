import java.util.*;

public class HybridIdentifierValidation {

    static boolean valid(String s){
        String regex = "^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}::([0-9A-F]{2}:){5}[0-9A-F]{2}$";
        return s.matches(regex);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());

        while(n-- >0){
            System.out.println(valid(sc.nextLine()) ?
                    "AUTHENTIC DEVICE" : "REJECTED DEVICE");
        }
    }
}