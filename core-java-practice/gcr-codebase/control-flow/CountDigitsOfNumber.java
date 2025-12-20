import java.util.Scanner;
public class CountDigitsOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int count = 0;
        int n = number;
        while(n!=0){
            count++;
            n /= 10;
        }
        System.out.println(count);
    }
}