public class SmartVehicleDashboardMain {
    public static void main(String[] args) {
        Vehicle normalCar = new Car();
        Vehicle evCar = new ElectricCar();
        normalCar.displaySpeed();
        normalCar.displayBatteryPercentage();
        System.out.println();
        evCar.displaySpeed();
        evCar.displayBatteryPercentage();
    }
}