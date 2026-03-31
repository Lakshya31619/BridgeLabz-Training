public class CabBookingSystem {  
    public static void main(String[] args) {
        User user1 = new User(1, "Naman Gupta");
        Driver driver1 = new Driver(1, "Devarshi Singh");
        Driver driver2 = new Driver(2, "Ansh Gaur");
        Driver [] drivers = {driver1, driver2};
        RideService rideService = new RideService(drivers);
        try{
            //Create
            Ride ride1 = rideService.createRide(user1, 5, new NormalFareCalculator());
            Ride ride2 = rideService.createRide(user1, 10, new PeakFareCalculator());
            //Read
            System.out.println("\nAll Rides:");
            rideService.printAllRides();
            //Update
            rideService.updateRideFare(ride1.getRideID(), 60);
            System.out.println("\nAfter Fare Update:");
            rideService.printRideById(ride1.getRideID());
            //Delete
            rideService.deleteRide(ride2.getRideID());
            System.out.println("\nAfter Ride Deletion:");
            rideService.printAllRides();

        } catch (NoDriverAvailable e) {
            System.out.println(e.getMessage());
        }
    }
}