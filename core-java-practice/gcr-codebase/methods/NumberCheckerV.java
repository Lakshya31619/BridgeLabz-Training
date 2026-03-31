import java.util.Scanner;
public class NumberCheckerV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input number
        int number = sc.nextInt();
        //Calling method isPerfectNumber
        boolean perfect = isPerfectNumber(number);
        if(perfect){
            System.out.println("The number is a perfect number");
        }else{
            System.out.println("The number is not a perfect number");
        }
        //Calling method isAbundantNumber
        boolean abundant = isAbundantNumber(number);
        if(abundant){
            System.out.println("The number is an abundant number");
        }else{
            System.out.println("The number is not an abundant number");
        }
        //Calling method isDeficientNumber
        boolean deficient = isDeficientNumber(number);
        if(deficient){
            System.out.println("The number is a deficient number");
        }else{
            System.out.println("The number is not a deficient number");
        }
        //Calling method isStrongNumber
        boolean strong = isStrongNumber(number);
        if(strong){
            System.out.println("The number is a strong number");
        }else{
            System.out.println("The number is not a strong number");
        }
    }
    //Method to check perfect number
    public static boolean isPerfectNumber(int number){
        if(number <= 0){
            return false;
        }
        int sum = 0;
        for(int i = 1; i <= number / 2; i++){
            if(number % i == 0){
                sum = sum + i;
            }
        }
        if(sum == number){
            return true;
        }
        return false;
    }
    //Method to check abundant number
    public static boolean isAbundantNumber(int number){
        if(number <= 0){
            return false;
        }
        int sum = 0;
        for(int i = 1; i <= number / 2; i++){
            if(number % i == 0){
                sum = sum + i;
            }
        }
        if(sum > number){
            return true;
        }
        return false;
    }
    //Method to check deficient number
    public static boolean isDeficientNumber(int number){
        if(number <= 0){
            return false;
        }
        int sum = 0;
        for(int i = 1; i <= number / 2; i++){
            if(number % i == 0){
                sum = sum + i;
            }
        }
        if(sum < number){
            return true;
        }
        return false;
    }
    //Method to check strong number
    public static boolean isStrongNumber(int number){
        int temp = number;
        int sum = 0;
        while(temp != 0){
            int digit = temp % 10;
            sum = sum + factorial(digit);
            temp = temp / 10;
        }
        if(sum == number){
            return true;
        }
        return false;
    }
    //Method to find factorial of a digit
    public static int factorial(int digit){
        int fact = 1;
        for(int i = 1; i <= digit; i++){
            fact = fact * i;
        }
        return fact;
    }
}