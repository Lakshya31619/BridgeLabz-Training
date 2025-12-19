import java.util.Scanner;
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        boolean isPrime = true;
        if(number<=1) {
            isPrime = false; //return false when number is less than 2
        }else{
            for(int i=2; i<number; i++){
                if(number%i==0){
                    isPrime = false; //break the loop if factor of number found
                    break;
                }
            }
        }
        if(isPrime){
            System.out.println(number + " is a Prime Number.");
        }else{
            System.out.println(number + " is not a Prime Number.");
        }
    }
}