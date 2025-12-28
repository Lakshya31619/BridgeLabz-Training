import java.util.Scanner;
public class NumberGuesser {
    // Function to generate a random guess
    static int generateGuess(int min, int max) {
        return (int)(Math.random() * (max - min + 1)) + min;
    }
    // Function to get user feedback
    static String getFeedback(Scanner sc) {
        System.out.print("Is the guess high, low, or correct? ");
        return sc.next().toLowerCase();
    }
    // Function to update range based on feedback
    static int[] updateRange(String feedback, int guess, int min, int max) {
        if (feedback.equals("high")) {
            max = guess - 1;
        } else if (feedback.equals("low")) {
            min = guess + 1;
        }
        return new int[]{min, max};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Think of a number between 1 and 100.");
        int min = 1;
        int max = 100;
        int guess;
        int count = 0;
        while (true) {
            guess = generateGuess(min, max);
            count++;
            System.out.println("Computer guesses: " + guess);
            String feedback = getFeedback(sc);
            if (feedback.equals("correct")) {
                System.out.println("Number guessed in " + count + " attempt(s).");
                break;
            } else if (feedback.equals("high") || feedback.equals("low")) {
                int[] range = updateRange(feedback, guess, min, max);
                min = range[0];
                max = range[1];
            } else {
                System.out.println("Invalid input. Please enter high, low, or correct.");
                count--; // don’t count invalid attempt
            }
        }
    }
}