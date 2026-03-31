import java.util.Scanner;
// Exception
class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}
// Class to handle student scores and analysis
class StudentScores {
    private int[] scores;
    // Constructor
    public StudentScores(int[] scores) throws InvalidScoreException {
        this.scores = new int[scores.length];
        // Validate and copy scores
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 0 || scores[i] > 100) {
                throw new InvalidScoreException(
                    "Invalid score entered: " + scores[i]
                );
            }
            this.scores[i] = scores[i];
        }
    }
    // Calculate average
    public double calculateAverage() {
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return (double) sum / scores.length;
    }
    // Find highest score
    public int findMax() {
        int max = scores[0];
        for (int score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }
    // Find lowest score
    public int findMin() {
        int min = scores[0];
        for (int score : scores) {
            if (score < min) {
                min = score;
            }
        }
        return min;
    }
}
public class StudentScoreAnalyzer{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] inputScores = new int[n];
        // Input 
        for (int i = 0; i < n; i++) {
            System.out.print("Enter score for student " + (i + 1) + ": ");
            inputScores[i] = sc.nextInt();
        }
        try {
            // Create StudentScores object
            StudentScores students = new StudentScores(inputScores);
            // Display results
            System.out.println("\nScore Analysis:");
            System.out.println("Average Score: " + students.calculateAverage());
            System.out.println("Highest Score: " + students.findMax());
            System.out.println("Lowest Score: " + students.findMin());
        } catch (InvalidScoreException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}