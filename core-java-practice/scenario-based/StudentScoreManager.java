import java.util.Scanner;
public class StudentScoreManager {
    // Method to process student scores
    public static void analyzeScores(int[] scores) {
        int sum = 0;
        int highest = scores[0];
        int lowest = scores[0];
        for (int score : scores) {
            sum += score;
            if (score > highest) highest = score;
            if (score < lowest) lowest = score;
        }
        double average = (double) sum / scores.length;
        // Output
        System.out.println("Average Score: " + average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
        System.out.println("Scores Above Average:");
        for (int score : scores) {
            if (score > average) {
                System.out.println(score);
            }
        }
    }
    public static void main(String[] args) {
        // Input
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter number of students: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            sc.next();
        }
        n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter score for student " + (i + 1) + ": ");
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Enter a numeric score: ");
                sc.next();
            }
            int score = sc.nextInt();
            if (score < 0) {
                System.out.println("Negative score not allowed. Enter again.");
                i--;
            } else {
                scores[i] = score;
            }
        }
        //Calling analyzeScores
        analyzeScores(scores);
    }
}