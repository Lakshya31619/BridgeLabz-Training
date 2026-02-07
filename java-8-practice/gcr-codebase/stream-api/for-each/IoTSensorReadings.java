import java.util.*;
public class IoTSensorReadings {
    public static void main(String[] args) {
        List<Double> sensorReadings = Arrays.asList(
                28.5,
                32.1,
                29.8,
                35.6,
                26.4,
                38.0
        );
        double threshold = 30.0;
        sensorReadings.stream()
                .filter(reading -> reading > threshold)
                .forEach(reading ->
                        System.out.println("High Reading: " + reading)
                );
    }
}