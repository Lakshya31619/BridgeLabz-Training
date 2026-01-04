import java.util.Scanner;
public class QuizGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Correct answers
        String[] correctAnswers = {"A", "B", "C", "D", "A", "C", "B", "D", "A", "B"};
        // Student answers
        String[] studentAnswers = new String[10];
        // Input student answers
        for (int i = 0; i < studentAnswers.length; i++) {
            System.out.print("Enter answer for Question " + (i + 1) + ": ");
            studentAnswers[i] = sc.next();
        }
        // Calculate and display results
        int score = calculateScore(correctAnswers, studentAnswers);
        double percentage = (score / 10.0) * 100;
        System.out.println("\nTotal Score: " + score + "/10");
        System.out.println("Percentage: " + percentage + "%");
        if (percentage >= 50) {
            System.out.println("Result: PASS");
        } else {
            System.out.println("Result: FAIL");
        }
    }
    // Method to calculate score and print feedback
    public static int calculateScore(String[] correct, String[] student) {
        int score = 0;
        for (int i = 0; i < correct.length; i++) {
            if (student[i].equalsIgnoreCase(correct[i])) {
                System.out.println("Question " + (i + 1) + ": Correct");
                score++;
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect");
            }
        }
        return score;
    }
}