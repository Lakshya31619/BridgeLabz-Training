import java.util.*;
public class SlidingWindow {
    public static void printMaxInWindow(int[] arr, int n, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        for (int i = k; i < n; i++) {
            System.out.print(arr[dq.peekFirst()] + " ");
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        System.out.print(arr[dq.peekFirst()]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter window size k: ");
        int k = sc.nextInt();
        if (k > n || k <= 0) {
            System.out.println("Invalid window size");
            return;
        }
        System.out.println("Maximum elements in each sliding window:");
        printMaxInWindow(arr, n, k);
    }
}