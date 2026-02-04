public class ElectricCar implements Vehicle {
    @Override
    public void displaySpeed() {
        System.out.println("Electric Car speed: 65 km/h");
    }
    @Override
    public void displayBatteryPercentage() {
        System.out.println("Battery level: 72%");
    }
}