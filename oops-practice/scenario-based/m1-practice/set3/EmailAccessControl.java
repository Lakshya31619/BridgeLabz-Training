import java.util.*;

public class EmailAccessControl {
    static boolean valid(String e){
        return e.matches("[a-z]{3,}\\.[a-z]{3,}\\d{4,}@(sales|marketing|IT|product)\\.company\\.com");
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());

        while(n-- >0){
            String s=sc.nextLine();
            System.out.println(valid(s) ? "Access Granted" : "Access Denied");
        }
    }
}