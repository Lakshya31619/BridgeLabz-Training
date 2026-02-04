import java.util.function.Predicate;
public class TemperatureAlertSystem {
    public static void main(String[] args) {
        Predicate<Double> highTemperatureAlert = temperature -> temperature > 38.0;
        double[] readings = {36.5, 37.2, 38.5, 39.1};
        for (double temp : readings) {
            if (highTemperatureAlert.test(temp)) {
                System.out.println("ALERT! High temperature detected: " + temp + "°C");
            } else {
                System.out.println("Temperature normal: " + temp + "°C");
            }
        }
    }
}