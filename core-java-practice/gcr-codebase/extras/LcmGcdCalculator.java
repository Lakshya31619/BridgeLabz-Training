import java.util.Scanner;
public class LcmGcdCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input two numbers
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Calling findGCD
        int gcd = findGCD(a, b);  
        // Calling findLCM
        int lcm = findLCM(a, b, gcd);
        // Output
        System.out.println("GCD of " + a + " and " + b + " is " + gcd);
        System.out.println("LCM of " + a + " and " + b + " is " + lcm);
    }
    // Method to calculate GCD
    public static int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }
    // Method to calculate LCM
    public static int findLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
}