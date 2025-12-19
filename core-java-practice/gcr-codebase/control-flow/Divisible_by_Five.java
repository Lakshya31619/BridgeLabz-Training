import java.util.Scanner;
public class Divisible_by_Five {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String ans = "";
        if(n%5==0){
            ans = "Yes";
        }else{
            ans = "No";
        }
        System.out.println("Is the number "+n+" divisible by 5 ? "+ans);
    }
}