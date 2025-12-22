import java.util.Scanner;
public class IllegalArgument {
    //Generate IllegalArgumentException
    public static void generateException(String s, int start, int end) {
        if(start>end){
            throw new IllegalArgumentException("Start index is greater than end index");
        }
        System.out.println(s.substring(start, end));
    }
    //Handle IllegalArgumentException
    public static void handleException(String text, int start, int end) {
        try {
            if(start>end) {
                throw new IllegalArgumentException("Start index is greater than end index");
            }
            System.out.println(text.substring(start, end));
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Exception caught: IllegalArgumentException");
            System.out.println("Reason: " + e.getMessage());
        } 
        catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input
        String s = sc.next();
        int start = 5;
        int end = 2;
        //Generate exception
        try {
            generateException(s, start, end);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException occurred in generateException()");
        }
        //Handle exception
        handleException(s, start, end);
    }
}