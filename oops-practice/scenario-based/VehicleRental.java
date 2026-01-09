import java.util.List;
import java.util.ArrayList;
//Interface
interface IRentable {
    double calculateRent(int days);
}
//Abstract class
abstract class Vehicle implements IRentable {
    protected int vehicleId;
    protected String brand;
    protected double ratePerDay;
    public Vehicle(int vehicleId, String brand, double ratePerDay) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.ratePerDay = ratePerDay;
    }
    public abstract void displayInfo();
}
//Bike class
class Bike extends Vehicle {
    public Bike(int vehicleId, String brand, double ratePerDay) {
        super(vehicleId, brand, ratePerDay);
    }
    @Override
    public double calculateRent(int days) {
        return ratePerDay * days;
    }
    @Override
    public void displayInfo() {
        System.out.println("[Bike] ID: " + vehicleId + ", Brand: " + brand + ", Rate/Day: " + ratePerDay);
    }
}
//Car class
class Car extends Vehicle {
    public Car(int vehicleId, String brand, double ratePerDay) {
        super(vehicleId, brand, ratePerDay);
    }
    @Override
    public double calculateRent(int days) {
        return ratePerDay * days + 500;
    }
    @Override
    public void displayInfo() {
        System.out.println("[Car] ID: " + vehicleId + ", Brand: " + brand + ", Rate/Day: " + ratePerDay);
    }
}
//Truck class
class Truck extends Vehicle {
    public Truck(int vehicleId, String brand, double ratePerDay) {
        super(vehicleId, brand, ratePerDay);
    }
    @Override
    public double calculateRent(int days) {
        return ratePerDay * days + 1000;
    }
    @Override
    public void displayInfo() {
        System.out.println("[Truck] ID: " + vehicleId + ", Brand: " + brand + ", Rate/Day: " + ratePerDay);
    }
}
//Customer Class
class Customer {
    private int customerId;
    private String name;
    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }
    public void displayCustomer() {
        System.out.println("Customer ID: " + customerId + ", Name: " + name);
    }
}
//CRUD Operations
class RentalService {
    private List<Vehicle> vehicles = new ArrayList<>();
    // CREATE
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    // READ
    public void viewVehicles() {
        for (Vehicle v : vehicles) {
            v.displayInfo(); // Polymorphism
        }
    }
    // UPDATE
    public void updateRate(int id, double newRate) {
        for (Vehicle v : vehicles) {
            if (v.vehicleId == id) {
                v.ratePerDay = newRate;
                break;
            }
        }
    }
    // DELETE
    public void deleteVehicle(int id) {
        vehicles.removeIf(v -> v.vehicleId == id);
    }
}
//Main class
public class VehicleRental {
    public static void main(String[] args) {
        RentalService service = new RentalService();
        Vehicle b1 = new Bike(1, "Repsol", 300);
        Vehicle c1 = new Car(2, "Ferrari", 1000);
        Vehicle t1 = new Truck(3, "Ashok Leyland", 2000);
        service.addVehicle(b1);
        service.addVehicle(c1);
        service.addVehicle(t1);
        System.out.println("---- Available Vehicles ----");
        service.viewVehicles();
        System.out.println("\nRent for Car (5 days): " + c1.calculateRent(5));
        service.updateRate(1, 350);
        service.deleteVehicle(3);
        System.out.println("\n---- After Update & Delete ----");
        service.viewVehicles();
    }
}