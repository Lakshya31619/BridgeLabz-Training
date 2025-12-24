import java.util.Scanner;
public class WindChillTemperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input temperature and windspeed
        double temp = sc.nextDouble();
        double windSpeed = sc.nextDouble();
        //Calling method calculateWindChill
        double windChill = calculateWindChill(temp, windSpeed);
        //Output
        System.out.println("Wind chill speed : "+windChill);
    }
    //Method to Calculate wind chill temperature
    public static double calculateWindChill(double temp, double windSpeed){
        double windChill = 35.74 + 0.6215 * temp + (0.4275 * temp - 35.75) * Math.pow(windSpeed, 0.16);
        return windChill;
    }
}