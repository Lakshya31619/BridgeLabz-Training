import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
public class CircularTour {
    public static int findStartingPoint(int[] petrol, int[] distance, int n) {
        Queue<Integer> q = new LinkedList<>();
        int currPetrol = 0;
        int i = 0;
        while (i < 2 * n) {
            int idx = i % n;
            q.offer(idx);
            currPetrol += petrol[idx] - distance[idx];
            while (!q.isEmpty() && currPetrol < 0) {
                int removed = q.poll();
                currPetrol -= petrol[removed] - distance[removed];
            }
            if (q.size() == n) {
                return q.peek();
            }
            i++;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of petrol pumps: ");
        int n = sc.nextInt();
        int[] petrol = new int[n];
        int[] distance = new int[n];
        System.out.println("Enter petrol at each pump:");
        for (int i = 0; i < n; i++) {
            petrol[i] = sc.nextInt();
        }
        System.out.println("Enter distance to next pump:");
        for (int i = 0; i < n; i++) {
            distance[i] = sc.nextInt();
        }
        int start = findStartingPoint(petrol, distance, n);
        if (start == -1) {
            System.out.println("No circular tour possible");
        } else {
            System.out.println("Start at petrol pump index: " + start);
        }
    }
}