import java.util.Scanner;
public class FactorialRecursion {
    public static void main(String[] args) {
        // Calling method getInput
        int n = getInput();
        // Calling method factorial
        long result = factorial(n);
        // Calling method displayResult
        displayResult(n, result);
    }
    //Method to take input
    public static int getInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    //Method to calculate factorial using recursion
    public static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    //Method to display output
    public static void displayResult(int n, long result) {
        System.out.println("Factorial of " + n + " is " + result);
    }
}