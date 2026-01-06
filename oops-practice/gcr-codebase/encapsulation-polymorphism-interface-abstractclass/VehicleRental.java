import java.util.ArrayList;
import java.util.List;

// Main class
public class VehicleRental {

    public static void main(String[] args) {

        List<BaseVehicle> vehicles = new ArrayList<>();

        vehicles.add(new RentalCar("CAR100", 5000.0));
        vehicles.add(new RentalBike("BIKE200", 1000.0));
        vehicles.add(new RentalTruck("TRUCK300", 10000.0));

        int rentalDays = 5;

        // Polymorphic processing
        for (BaseVehicle vehicle : vehicles) {

            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            double insuranceCost = 0;

            if (vehicle instanceof InsuranceApplicable) {
                insuranceCost = ((InsuranceApplicable) vehicle).calculateInsurance();
            }

            System.out.println("Vehicle Number : " + vehicle.getVehicleNumber());
            System.out.println("Vehicle Type   : " + vehicle.getType());
            System.out.println("Rental Cost   : " + rentalCost);
            System.out.println("Insurance Cost: " + insuranceCost);
            System.out.println("Total Cost    : " + (rentalCost + insuranceCost));
            System.out.println("----------------------------------");
        }
    }
}

// Interface
interface InsuranceApplicable {

    double calculateInsurance();

    String getInsuranceDetails();
}

// Abstract class
abstract class BaseVehicle {

    private String vehicleNumber;
    private String type;
    private double rentalRate;

    protected BaseVehicle(String vehicleNumber, String type, double rentalRate) {
        setVehicleNumber(vehicleNumber);
        setType(type);
        setRentalRate(rentalRate);
    }

    public abstract double calculateRentalCost(int days);

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    private void setVehicleNumber(String vehicleNumber) {
        if (vehicleNumber == null || vehicleNumber.isEmpty()) {
            throw new IllegalArgumentException("Vehicle number cannot be empty.");
        }
        this.vehicleNumber = vehicleNumber;
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    protected double getRentalRate() {
        return rentalRate;
    }

    protected void setRentalRate(double rentalRate) {
        if (rentalRate < 0) {
            throw new IllegalArgumentException("Rental rate cannot be negative.");
        }
        this.rentalRate = rentalRate;
    }
}

// Car class
class RentalCar extends BaseVehicle implements InsuranceApplicable {

    private final String insurancePolicyNumber = "CAR-INS-961";

    public RentalCar(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 500;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy";
    }
}

// Bike class
class RentalBike extends BaseVehicle implements InsuranceApplicable {

    private final String insurancePolicyNumber = "BIKE-INS-316";

    public RentalBike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 200;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy";
    }
}

// Truck class
class RentalTruck extends BaseVehicle implements InsuranceApplicable {

    private final String insurancePolicyNumber = "TRUCK-INS-619";

    public RentalTruck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 1000;
    }

    @Override
    public double calculateInsurance() {
        return 1500;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy";
    }
}