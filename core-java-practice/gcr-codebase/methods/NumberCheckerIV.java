import java.util.Scanner;
public class NumberCheckerIV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input number
        int number = sc.nextInt();
        //Calling method isPrime
        boolean prime = isPrime(number);
        if(prime){
            System.out.println("The number is a prime number");
        }else{
            System.out.println("The number is not a prime number");
        }
        //Calling method isNeonNumber
        boolean neon = isNeonNumber(number);
        if(neon){
            System.out.println("The number is a neon number");
        }else{
            System.out.println("The number is not a neon number");
        }
        //Calling method isSpyNumber
        boolean spy = isSpyNumber(number);
        if(spy){
            System.out.println("The number is a spy number");
        }else{
            System.out.println("The number is not a spy number");
        }
        //Calling method isAutomorphicNumber
        boolean automorphic = isAutomorphicNumber(number);
        if(automorphic){
            System.out.println("The number is an automorphic number");
        }else{
            System.out.println("The number is not an automorphic number");
        }
        //Calling method isBuzzNumber
        boolean buzz = isBuzzNumber(number);
        if(buzz){
            System.out.println("The number is a buzz number");
        }else{
            System.out.println("The number is not a buzz number");
        }
    }
    //Method to check prime number
    public static boolean isPrime(int number){
        if(number <= 1){
            return false;
        }
        for(int i = 2; i <= number / 2; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
    //Method to check neon number
    public static boolean isNeonNumber(int number){
        int square = number * number;
        int sum = 0;
        while(square != 0){
            sum = sum + (square % 10);
            square = square / 10;
        }
        if(sum == number){
            return true;
        }
        return false;
    }
    //Method to check spy number
    public static boolean isSpyNumber(int number){
        int sum = 0;
        int product = 1;
        int temp = number;
        while(temp != 0){
            int digit = temp % 10;
            sum = sum + digit;
            product = product * digit;
            temp = temp / 10;
        }
        if(sum == product){
            return true;
        }
        return false;
    }
    //Method to check automorphic number
    public static boolean isAutomorphicNumber(int number){
        int square = number * number;
        int temp = number;
        while(temp != 0){
            if(temp % 10 != square % 10){
                return false;
            }
            temp = temp / 10;
            square = square / 10;
        }
        return true;
    }
    //Method to check buzz number
    public static boolean isBuzzNumber(int number){
        if(number % 7 == 0 || number % 10 == 7){
            return true;
        }
        return false;
    }
}