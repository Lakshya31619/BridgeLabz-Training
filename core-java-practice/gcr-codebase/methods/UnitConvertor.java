import java.util.Scanner;
public class UnitConvertor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input value in kilometers
        double km = sc.nextDouble();
        //Calling method convertKmToMiles
        double miles = convertKmToMiles(km);
        //Output
        System.out.println(km + " kilometers = " + miles + " miles");
        //Input value in miles
        double mi = sc.nextDouble();
        //Calling method convertMilesToKm
        double kilometers = convertMilesToKm(mi);
        //Output
        System.out.println(mi + " miles = " + kilometers + " kilometers");
        //Input value in meters
        double meters = sc.nextDouble();
        //Calling method convertMetersToFeet
        double feet = convertMetersToFeet(meters);
        //Output
        System.out.println(meters + " meters = " + feet + " feet");
        //Input value in feet
        double ft = sc.nextDouble();
        //Calling method convertFeetToMeters
        double mtrs = convertFeetToMeters(ft);
        //Output
        System.out.println(ft + " feet = " + mtrs + " meters");
    }
    //Method to convert kilometers to miles
    public static double convertKmToMiles(double km){
        double km2miles = 0.621371;
        return km * km2miles;
    }
    //Method to convert miles to kilometers
    public static double convertMilesToKm(double miles){
        double miles2km = 1.60934;
        return miles * miles2km;
    }
    //Method to convert meters to feet
    public static double convertMetersToFeet(double meters){
        double meters2feet = 3.28084;
        return meters * meters2feet;
    }
    //Method to convert feet to meters
    public static double convertFeetToMeters(double feet){
        double feet2meters = 0.3048;
        return feet * feet2meters;
    }
}