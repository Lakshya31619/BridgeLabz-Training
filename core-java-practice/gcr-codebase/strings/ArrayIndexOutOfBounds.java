import java.util.Scanner;
public class ArrayIndexOutOfBounds {
    //Generate ArrayIndexOutOfBoundsException
    public static void generateException(String [] names) {
        // Accessing index beyond array length
        System.out.println("Name at invalid index: " + names[names.length]);
    }
    //Handle ArrayIndexOutOfBoundsException
    public static void handleException(String[] names) {
        try {
            System.out.println("Name at invalid index: " + names[names.length]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: ArrayIndexOutOfBoundsException");
            System.out.println("Reason: Index is greater than array size");
        }
        catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input
        int n = sc.nextInt();
        String [] names = new String[n];
        for(int i=0; i<n; i++){
            names[i] = sc.next();
        }
        //Generate exception
        try {
            generateException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException occurred in generateException()");
        }
        //Handle exception
        System.out.println("\nCalling method to handle exception:");
        handleException(names);
    }
}