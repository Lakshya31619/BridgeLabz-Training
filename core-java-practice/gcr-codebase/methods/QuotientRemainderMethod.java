import java.util.Scanner;
public class QuotientRemainderMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input two numbers
        int a = sc.nextInt();
        int b = sc.nextInt();
        //Calling method checkQuoRem
        int [] qr = findQuoRem(a, b);
        //Output
        System.out.println("Remainder : "+qr[0]);
        System.out.println("Quotient : "+qr[1]);
    } 
    //Method to find Quotient and remainder
    public static int[] findQuoRem(int a, int b){
        int q = a/b;
        int r = a%b;
        return new int[]{q, r};
    }
}