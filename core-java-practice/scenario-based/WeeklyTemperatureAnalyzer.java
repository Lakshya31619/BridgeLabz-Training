import java.util.Random;
public class WeeklyTemperatureAnalyzer {
    // Method to analyze weekly temperature data
    public static void processWeek(float[][] weekTemps) {
        int hottestDayIndex = 0;
        int coldestDayIndex = 0;
        float highestTemp = weekTemps[0][0];
        float lowestTemp = weekTemps[0][0];
        float[] averagePerDay = new float[weekTemps.length];
        for (int day = 0; day < weekTemps.length; day++) {
            float sum = 0;
            for (int hour = 0; hour < weekTemps[day].length; hour++) {
                float temp = weekTemps[day][hour];
                sum += temp;
                if (temp > highestTemp) {
                    highestTemp = temp;
                    hottestDayIndex = day;
                }
                if (temp < lowestTemp) {
                    lowestTemp = temp;
                    coldestDayIndex = day;
                }
            }
            averagePerDay[day] = sum / weekTemps[day].length;
        }
        // Output
        System.out.println("Hottest Day: Day " + (hottestDayIndex + 1));
        System.out.println("Coldest Day: Day " + (coldestDayIndex + 1));
        for (int i = 0; i < averagePerDay.length; i++) {
            System.out.printf("Average temperature for Day %d: %.2f°C%n", (i + 1), averagePerDay[i]);
        }
    }
    // Main method
    public static void main(String[] args) {
        // Input
        float[][] weeklyTemperatures = new float[7][24];
        Random rand = new Random();
        for (int day = 0; day < 7; day++) {
            for (int hour = 0; hour < 24; hour++) {
                weeklyTemperatures[day][hour] = 15 + rand.nextFloat() * 20;
            }
        }
        //Calling processWeek
        processWeek(weeklyTemperatures);
    }
}