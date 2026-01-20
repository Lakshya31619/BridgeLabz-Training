public class RecursiveIterativeFibonacci {
    // Recursion
    public static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    // Iteration
    public static int fibonacciIterative(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    public static void main(String[] args) {
        int n = 30;
        long start, end;
        // Recursive Time
        start = System.nanoTime();
        int recResult = fibonacciRecursive(n);
        end = System.nanoTime();
        System.out.println("Recursive Fibonacci(" + n + "): " + recResult);
        System.out.println("Recursive Time: " + (end - start) / 1000000 + " ms");
        // Iterative Time
        start = System.nanoTime();
        int iterResult = fibonacciIterative(n);
        end = System.nanoTime();
        System.out.println("Iterative Fibonacci(" + n + "): " + iterResult);
        System.out.println("Iterative Time: " + (end - start) / 1000000 + " ms");
    }
}