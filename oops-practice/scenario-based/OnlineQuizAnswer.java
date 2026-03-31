import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Exception
class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}
// Quiz Processor class
class QuizProcessor {
    private String[] correctAnswers;
    private List<Integer> allScores = new ArrayList<>();
    // Constructor
    public QuizProcessor(String[] correctAnswers) {
        this.correctAnswers = correctAnswers;
    }
    // Compare answers and calculate score
    public int calculateScore(String[] userAnswers)
            throws InvalidQuizSubmissionException {
        if (userAnswers.length != correctAnswers.length) {
            throw new InvalidQuizSubmissionException(
                "Answer count does not match number of questions."
            );
        }
        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (userAnswers[i].equalsIgnoreCase(correctAnswers[i])) {
                score++;
            }
        }
        allScores.add(score);
        return score;
    }
    // Return grade based on score
    public String getGrade(int score) {
        double percentage = (score * 100.0) / correctAnswers.length;
        if (percentage >= 80) return "A";
        else if (percentage >= 60) return "B";
        else if (percentage >= 40) return "C";
        else return "F";
    }
    // Get all user scores
    public List<Integer> getAllScores() {
        return allScores;
    }
}
public class OnlineQuizAnswer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] correctAnswers = {"A", "B", "C", "D", "A"};
        QuizProcessor quiz = new QuizProcessor(correctAnswers);
        try {
            String[] userAnswers = new String[correctAnswers.length];
            for (int i = 0; i < userAnswers.length; i++) {
                System.out.print("Enter answer for Q" + (i + 1) + ": ");
                userAnswers[i] = sc.next();
            }
            int score = quiz.calculateScore(userAnswers);
            String grade = quiz.getGrade(score);
            // Display result
            System.out.println("\nScore: " + score + "/" + correctAnswers.length);
            System.out.println("Grade: " + grade);
            // Display all users' scores
            System.out.println("All User Scores: " + quiz.getAllScores());
        } catch (InvalidQuizSubmissionException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}