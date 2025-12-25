import java.util.Scanner;
public class UnitConvertorIII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input temperature in fahrenheit
        double farhenheit = sc.nextDouble();
        //Calling method convertFarhenheitToCelsius
        double celsius = convertFarhenheitToCelsius(farhenheit);
        //Output
        System.out.println(farhenheit + " fahrenheit = " + celsius + " celsius");
        //Input temperature in celsius
        double cel = sc.nextDouble();
        //Calling method convertCelsiusToFarhenheit
        double far = convertCelsiusToFarhenheit(cel);
        //Output
        System.out.println(cel + " celsius = " + far + " fahrenheit");
        //Input value in pounds
        double pounds = sc.nextDouble();
        //Calling method convertPoundsToKilograms
        double kilograms = convertPoundsToKilograms(pounds);
        //Output
        System.out.println(pounds + " pounds = " + kilograms + " kilograms");
        //Input value in kilograms
        double kg = sc.nextDouble();
        //Calling method convertKilogramsToPounds
        double lbs = convertKilogramsToPounds(kg);
        //Output
        System.out.println(kg + " kilograms = " + lbs + " pounds");
        //Input value in gallons
        double gallons = sc.nextDouble();
        //Calling method convertGallonsToLiters
        double liters = convertGallonsToLiters(gallons);
        //Output
        System.out.println(gallons + " gallons = " + liters + " liters");
        //Input value in liters
        double ltrs = sc.nextDouble();
        //Calling method convertLitersToGallons
        double gals = convertLitersToGallons(ltrs);
        //Output
        System.out.println(ltrs + " liters = " + gals + " gallons");
    }
    //Method to convert fahrenheit to celsius
    public static double convertFarhenheitToCelsius(double farhenheit){
        double farhenheit2celsius = (farhenheit - 32) * 5 / 9;
        return farhenheit2celsius;
    }
    //Method to convert celsius to fahrenheit
    public static double convertCelsiusToFarhenheit(double celsius){
        double celsius2farhenheit = (celsius * 9 / 5) + 32;
        return celsius2farhenheit;
    }
    //Method to convert pounds to kilograms
    public static double convertPoundsToKilograms(double pounds){
        double pounds2kilograms = 0.453592;
        return pounds * pounds2kilograms;
    }
    //Method to convert kilograms to pounds
    public static double convertKilogramsToPounds(double kilograms){
        double kilograms2pounds = 2.20462;
        return kilograms * kilograms2pounds;
    }
    //Method to convert gallons to liters
    public static double convertGallonsToLiters(double gallons){
        double gallons2liters = 3.78541;
        return gallons * gallons2liters;
    }
    //Method to convert liters to gallons
    public static double convertLitersToGallons(double liters){
        double liters2gallons = 0.264172;
        return liters * liters2gallons;
    }
}