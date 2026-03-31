public interface UnitConverter {
    static double kmToMiles(double km) {
        return km * 0.621371;
    }
    static double milesToKm(double miles) {
        return miles * 1.60934;
    }
    static double kgToLbs(double kg) {
        return kg * 2.20462;
    }
    static double lbsToKg(double lbs) {
        return lbs * 0.453592;
    }
}