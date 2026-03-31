import java.util.Scanner;
public class PowerOfNumberWhileLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int power = sc.nextInt();
        if(number>0 && power>0){
            int result = 1;
            int i = power;
            while(power!=0){
                result *= number;
                power--;
            }
            System.out.println(result);
        }else{
            System.out.println("Either not a positive number or power.");
        }
    }
}