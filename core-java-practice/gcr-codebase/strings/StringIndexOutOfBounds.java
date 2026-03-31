import java.util.Scanner;
public class StringIndexOutOfBounds {
    //Generate StringIndexOutOfBoundsException
    public static void generateException(String text) {
        System.out.println("Character at invalid index: " + text.charAt(text.length()));
    }
    //Handle StringIndexOutOfBoundsException
    public static void handleException(String text) {
        try {
            System.out.println("Character at invalid index: " + text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught: StringIndexOutOfBoundsException");
            System.out.println("Reason: Index is outside the valid range of the string");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input
        String text = sc.next();
        //Generate exception
        try {
            generateException(text);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException occurred in generateException()");
        }
        //Handle Exception
        handleException(text);
    }
}