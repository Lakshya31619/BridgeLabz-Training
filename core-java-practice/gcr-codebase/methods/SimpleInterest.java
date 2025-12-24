import java.util.Scanner;
public class SimpleInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input principal, rate and time(in years)
        int p = sc.nextInt();
        int r = sc.nextInt();
        int t = sc.nextInt();
        //Formula for calculating simple interest
        double si = (p*r*t)/100.0;
        //Output
        System.out.println("The Simple Interest is "+si+" for Principal "+p+", Rate of Interest "+r+" and Time "+t);
    }
}