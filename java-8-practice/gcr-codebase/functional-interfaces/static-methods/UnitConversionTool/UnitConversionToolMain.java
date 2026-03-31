public class UnitConversionToolMain {
    public static void main(String[] args) {
        double distanceKm = 120.0;
        double weightKg = 75.0;
        System.out.println(distanceKm + " km = " + UnitConverter.kmToMiles(distanceKm) + " miles");
        System.out.println(weightKg + " kg = " + UnitConverter.kgToLbs(weightKg) + " lbs");
    }
}