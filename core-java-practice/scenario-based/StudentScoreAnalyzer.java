import java.util.Scanner;
// Custom Exception
class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}
public class StudentScoreAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] scores = new int[n];
        try {
            // Input scores
            for (int i = 0; i < scores.length; i++) {
                System.out.print("Enter score for student " + (i + 1) + ": ");
                scores[i] = sc.nextInt();
                if (scores[i] < 0 || scores[i] > 100) {
                    throw new InvalidScoreException(
                        "Invalid score entered: " + scores[i]
                    );
                }
            }
            // Calculations
            double average = calculateAverage(scores);
            int maxScore = findMax(scores);
            int minScore = findMin(scores);
            // Display results
            System.out.println("\nScore Analysis:");
            System.out.println("Average Score: " + average);
            System.out.println("Highest Score: " + maxScore);
            System.out.println("Lowest Score: " + minScore);
        } catch (InvalidScoreException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    // Method to calculate average score
    public static double calculateAverage(int[] scores) {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }
    // Method to find highest score
    public static int findMax(int[] scores) {
        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }
    // Method to find lowest score
    public static int findMin(int[] scores) {
        int min = scores[0];
        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }
}