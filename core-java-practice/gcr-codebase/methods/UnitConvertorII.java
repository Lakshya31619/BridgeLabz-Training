import java.util.Scanner;
public class UnitConvertorII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input value in yards
        double yards = sc.nextDouble();
        //Calling method convertYardsToFeet
        double feet = convertYardsToFeet(yards);
        //Output
        System.out.println(yards + " yards = " + feet + " feet");
        //Input value in feet
        double ft = sc.nextDouble();
        //Calling method convertFeetToYards
        double yds = convertFeetToYards(ft);
        //Output
        System.out.println(ft + " feet = " + yds + " yards");
        //Input value in meters
        double meters = sc.nextDouble();
        //Calling method convertMetersToInches
        double inches = convertMetersToInches(meters);
        //Output
        System.out.println(meters + " meters = " + inches + " inches");
        //Input value in inches
        double in = sc.nextDouble();
        //Calling method convertInchesToMeters
        double mtrs = convertInchesToMeters(in);
        //Output
        System.out.println(in + " inches = " + mtrs + " meters");
        //Input value in inches
        double inch = sc.nextDouble();
        //Calling method convertInchesToCentimeters
        double cm = convertInchesToCentimeters(inch);
        //Output
        System.out.println(inch + " inches = " + cm + " centimeters");
    }
    //Method to convert yards to feet
    public static double convertYardsToFeet(double yards){
        double yards2feet = 3;
        return yards * yards2feet;
    }
    //Method to convert feet to yards
    public static double convertFeetToYards(double feet){
        double feet2yards = 0.333333;
        return feet * feet2yards;
    }
    //Method to convert meters to inches
    public static double convertMetersToInches(double meters){
        double meters2inches = 39.3701;
        return meters * meters2inches;
    }
    //Method to convert inches to meters
    public static double convertInchesToMeters(double inches){
        double inches2meters = 0.0254;
        return inches * inches2meters;
    }
    //Method to convert inches to centimeters
    public static double convertInchesToCentimeters(double inches){
        double inches2cm = 2.54;
        return inches * inches2cm;
    }
}