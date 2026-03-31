public class RentalSystemMain {
    public static void main(String[] args) {
        Rentable[] vehicles = {
                new Car(),
                new Bike(),
                new Bus()
        };
        for (Rentable vehicle : vehicles) {
            vehicle.rent();
        }
        System.out.println();
        for (Rentable vehicle : vehicles) {
            vehicle.returnVehicle();
        }
    }
}