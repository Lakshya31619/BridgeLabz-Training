import java.util.Scanner;
public class NumberFormat {
    //Generate NumberFormatException
    public static void generateException(String s) {
        //Exception if test is not numeric
        int number = Integer.parseInt(s);
        System.out.println("Number: " + number);
    }
    // Handle NumberFormatException
    public static void handleException(String text) {
        try {
            int number = Integer.parseInt(text);
            System.out.println("Number: " + number);
        }
        catch (NumberFormatException e) {
            System.out.println("Exception caught: NumberFormatException");
            System.out.println("Reason: Input string is not a valid integer");
        }
        catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input
        String s = sc.next();
        //Generate exception
        try {
            generateException(s);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException occurred in generateException()");
        }
        //Handle exception
        handleException(s);
    }
}