// Superclass
class Vehicle {
    protected int maxSpeed;
    protected String model;
    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
}
// Interface
interface Refuelable {
    void refuel();
}
// Subclass ElectricVehicle
class ElectricVehicle extends Vehicle {
    public ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }
    public void charge() {
        System.out.println("Electric vehicle is charging.");
    }
}
// Subclass PetrolVehicle
class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }
    @Override
    public void refuel() {
        System.out.println("Petrol vehicle is refueling.");
    }
}
public class VehicleManagerHybrid {
    public static void main(String[] args) {
        Vehicle electricCar = new ElectricVehicle(40, "Tejas Tirri");
        Vehicle petrolCar = new PetrolVehicle(60, "Tata Nano");
        ((ElectricVehicle) electricCar).charge();
        ((PetrolVehicle) petrolCar).refuel();
    }
}