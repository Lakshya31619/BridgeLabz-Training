import java.util.ArrayList;
import java.util.List;

//Main class
public class RideHailing {

    public static void main(String[] args) {

        List<BaseRideVehicle> vehicles = new ArrayList<>();

        vehicles.add(new RideCar("C428", "Cody", 15));
        vehicles.add(new RideBike("B511", "LA Knight", 8));
        vehicles.add(new RideAuto("A985", "Charles Robinson", 10));

        double distance = 12.5;

        calculateFareForAll(vehicles, distance);
    }

    //Polymorphism
    public static void calculateFareForAll(List<BaseRideVehicle> vehicles, double distance) {

        for (BaseRideVehicle vehicle : vehicles) {

            double fare = vehicle.calculateFare(distance);

            System.out.println(vehicle.getVehicleDetails());
            System.out.println("Distance : " + distance + " km");
            System.out.println("Fare     : " + fare);

            if (vehicle instanceof GPSService) {
                GPSService gps = (GPSService) vehicle;
                gps.updateLocation("City Center");
                System.out.println("Location : " + gps.getCurrentLocation());
            }

            System.out.println("--------------------------------");
        }
    }
}

//Interface
interface GPSService {

    String getCurrentLocation();

    void updateLocation(String location);
}

//Abstract class
abstract class BaseRideVehicle {

    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    protected BaseRideVehicle(String vehicleId, String driverName, double ratePerKm) {
        setVehicleId(vehicleId);
        setDriverName(driverName);
        setRatePerKm(ratePerKm);
    }

    // Abstract method
    public abstract double calculateFare(double distance);

    // Concrete method
    public String getVehicleDetails() {
        return "Vehicle ID : " + vehicleId +
               ", Driver : " + driverName +
               ", Rate/Km : " + ratePerKm;
    }

    // Encapsulation
    public String getVehicleId() {
        return vehicleId;
    }

    private void setVehicleId(String vehicleId) {
        if (vehicleId == null || vehicleId.isEmpty()) {
            throw new IllegalArgumentException("Vehicle ID cannot be empty.");
        }
        this.vehicleId = vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    private void setDriverName(String driverName) {
        if (driverName == null || driverName.isEmpty()) {
            throw new IllegalArgumentException("Driver name cannot be empty.");
        }
        this.driverName = driverName;
    }

    protected double getRatePerKm() {
        return ratePerKm;
    }

    private void setRatePerKm(double ratePerKm) {
        if (ratePerKm < 0) {
            throw new IllegalArgumentException("Rate cannot be negative.");
        }
        this.ratePerKm = ratePerKm;
    }
}

//Car ride class
class RideCar extends BaseRideVehicle implements GPSService {

    private String currentLocation = "Unknown";

    public RideCar(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50; // base charge
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
    }
}

//Bike ride class
class RideBike extends BaseRideVehicle implements GPSService {

    private String currentLocation = "Unknown";

    public RideBike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
    }
}

//Ride auto class
class RideAuto extends BaseRideVehicle implements GPSService {

    private String currentLocation = "Unknown";

    public RideAuto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return (getRatePerKm() * distance) + 20;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String location) {
        this.currentLocation = location;
    }
}
