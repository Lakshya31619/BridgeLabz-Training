import java.util.Scanner;
public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int sum = 0;
        int n = number;
        while(n!=0){
            int rem = n%10; //Last digit of the number
            sum += (rem*rem*rem); //Last digit to the power of three
            n /= 10; //Removing the last digit from the number
        }
        if(number==sum){
            System.out.println("Armstrong Number");
        }else{
            System.out.println("Not an Armstrong Number");
        }
    }
}