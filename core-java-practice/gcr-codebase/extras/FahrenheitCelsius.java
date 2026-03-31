import java.util.Scanner;
public class FahrenheitCelsius {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //1.Fahrenheit to Celsius
        double f = sc.nextDouble();
        //Calling fahrenheitToCelsius
        double c = fahrenheitToCelsius(f);
        System.out.println("Temperature in Celsius: " + c);
        //2.Celsius to Fahrenheit
        c = sc.nextDouble();
        //Calling celsiusToFahrenheit
        f = celsiusToFahrenheit(c);
        System.out.println("Temperature in Fahrenheit: " + f);
    }
    // Method to convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }
    // Method to convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }
}