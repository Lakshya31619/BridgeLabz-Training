import java.util.Scanner;
public class StudentScorecardMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take input for number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        // Generate PCM scores
        int[][] pcmScores = generatePCMScores(n);
        // Calculate total, average, percentage
        double[][] results = calculateResults(pcmScores);
        // Display scorecard
        displayScoreCard(pcmScores, results);
    }
    // Method to generate random 2-digit PCM scores
    public static int[][] generatePCMScores(int students) {
        int[][] scores = new int[students][3]; // 0-Physics, 1-Chemistry, 2-Maths
        for (int i = 0; i < students; i++) {
            scores[i][0] = 10 + (int)(Math.random() * 90);
            scores[i][1] = 10 + (int)(Math.random() * 90);
            scores[i][2] = 10 + (int)(Math.random() * 90);
        }
        return scores;
    }
    // Method to calculate total, average, percentage
    public static double[][] calculateResults(int[][] pcm) {
        int students = pcm.length;
        double[][] result = new double[students][3]; // total, average, percentage
        for (int i = 0; i < students; i++) {
            int total = pcm[i][0] + pcm[i][1] + pcm[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            // Round off to 2 digits
            result[i][0] = total;
            result[i][1] = Math.round(average * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return result;
    }
    // Method to display scorecard
    public static void displayScoreCard(int[][] pcm, double[][] result) {
        System.out.println("\nStudent\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");
        for (int i = 0; i < pcm.length; i++) {
            System.out.println((i + 1) + "\t" +pcm[i][0] + "\t" +pcm[i][1] + "\t\t" +pcm[i][2] + "\t" +(int)result[i][0] + "\t" +result[i][1] + "\t" +result[i][2]);
        }
    }
}