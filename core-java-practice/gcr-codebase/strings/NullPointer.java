public class NullPointer {
    public static void generateException() {
        String text = null;
        System.out.println("Length of text: " + text.length());
    }
    // Method to handle NullPointerException using try-catch
    public static void handleException() {
        String text = null; 
        try {
            System.out.println("Length of text: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Exception caught: NullPointerException");
            System.out.println("Reason: Tried to access a method on a null object");
        }
    }
    public static void main(String[] args) {
        // generating the exception
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException occurred in generateException()");
        }
        // handling the exception
        handleException();
    }
}