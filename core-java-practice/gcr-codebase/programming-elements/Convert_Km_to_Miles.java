import java.util.Scanner;
public class Convert_Km_to_Miles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double km = sc.nextDouble();
        double m = km*0.621371;
        System.out.println("The total miles is "+m+ " mile for the given "+km+" km");
    }
}
