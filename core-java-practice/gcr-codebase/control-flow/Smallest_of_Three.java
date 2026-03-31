import java.util.Scanner;
public class Smallest_of_Three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int number3 = sc.nextInt();
        String ans = "No";
        if(number1 < number2 && number1 < number3){
            ans = "Yes";
        }
        System.out.println("Is the first number the smallest ? "+ans);
    }    
}
