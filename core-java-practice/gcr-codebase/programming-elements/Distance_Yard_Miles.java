import java.util.Scanner;
public class Distance_Yard_Miles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int distanceFeet = sc.nextInt();
        double distanceYards = distanceFeet/3.0;
        double distanceMiles = distanceYards/1760.0;
        System.out.println("Distance in yards is "+distanceYards+" and distance in miles is "+distanceMiles);
    }
}
