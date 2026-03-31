import java.util.Scanner;
public class FibonacciGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input number of terms
        int n = sc.nextInt();
        // Calling method printFibonacci
        printFibonacci(n);
    }
    // Method to calculate and print Fibonacci sequence
    public static void printFibonacci(int n) {
        int a = 0, b = 1;
        // Output
        if (n <= 0) {
            System.out.println("Invalid number of terms");
            return;
        }
        System.out.println("Fibonacci Series:");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
    }
}