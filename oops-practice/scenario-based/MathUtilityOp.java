class MathUtility {
    // Method to calculate factorial
    public static long factorial(int n) {
        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
            return -1;
        }
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
    // Method to check if a number is prime
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
    // Method to find GCD of two numbers
    public static int gcd(int a, int b) {
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    // Method to find nth Fibonacci number
    public static long fibonacci(int n) {
        if (n < 0) {
            System.out.println("Fibonacci is not defined for negative numbers.");
            return -1;
        }
        if (n == 0) return 0;
        if (n == 1) return 1;
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
public class MathUtilityOp {
    public static void main(String[] args) {
        // Testing Factorial
        System.out.println("Factorial of 5: " + MathUtility.factorial(5));
        System.out.println("Factorial of 0: " + MathUtility.factorial(0));
        System.out.println("Factorial of -3: " + MathUtility.factorial(-3));
        // Testing Prime Check
        System.out.println("Is 7 prime? " + MathUtility.isPrime(7));
        System.out.println("Is 1 prime? " + MathUtility.isPrime(1));
        System.out.println("Is -5 prime? " + MathUtility.isPrime(-5));
        // Testing GCD
        System.out.println("GCD of 48 and 18: " + MathUtility.gcd(48, 18));
        System.out.println("GCD of -24 and 36: " + MathUtility.gcd(-24, 36));
        System.out.println("GCD of 0 and 5: " + MathUtility.gcd(0, 5));
        // Testing Fibonacci
        System.out.println("Fibonacci of 6: " + MathUtility.fibonacci(6));
        System.out.println("Fibonacci of 0: " + MathUtility.fibonacci(0));
        System.out.println("Fibonacci of -4: " + MathUtility.fibonacci(-4));
    }
}