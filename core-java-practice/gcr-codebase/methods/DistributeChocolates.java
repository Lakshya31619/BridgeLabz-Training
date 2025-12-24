import java.util.Scanner;
public class DistributeChocolates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input chocolates and children
        int n = sc.nextInt();
        int m = sc.nextInt();
        //Calling method calcualteChocolates
        int [] cr = calculateChocolates(n, m);
        //Output
        System.out.println("Chocolates per children : "+cr[0]);
        System.out.println("Remaining Chocolates : "+cr[1]);
    }
    //Method to find Distributed and remaining chocolates
    public static int[] calculateChocolates(int n, int m){
        int c = n/m;
        int r = n%m;
        return new int[]{c, r};
    }
}