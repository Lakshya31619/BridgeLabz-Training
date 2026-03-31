import java.util.Scanner;
public class Convert_Km_to_Miles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double km = sc.nextDouble(); //Distance in kilometers
        double m = km*0.621371; //Distance in miles
        System.out.println("The total miles is "+m+ " mile for the given "+km+" km");
    }
}
