import java.util.Scanner;
public class CircularTour {
    public static int findStartingPoint(int[] petrol, int[] distance, int n) {
        int start = 0;
        int balance = 0;
        int deficit = 0;
        for (int i = 0; i < n; i++) {
            balance += petrol[i] - distance[i];
            if (balance < 0) {
                deficit += balance;
                start = i + 1;
                balance = 0;
            }
        }
        if (balance + deficit >= 0) {
            return start;
        } else {
            return -1;
        }
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