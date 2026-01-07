class RideService {
    private Driver[] drivers;
    private Ride[] rides = new Ride[10];
    private int rideCount = 0;
    public RideService(Driver[] drivers) {
        this.drivers = drivers;
    }
    //Create
    public Ride createRide(User user, double distance, FareCalculator calculator) throws NoDriverAvailable {
        Driver assignedDriver = null;
        for (Driver d : drivers) {
            if (d.isAvailable()) {
                assignedDriver = d;
                break;
            }
        }
        if (assignedDriver == null) {
            throw new NoDriverAvailable("No drivers available!");
        }
        assignedDriver.assignRide();
        double fare = calculator.calculateFare(distance);
        Ride ride = new Ride(user, assignedDriver, distance, fare);
        rides[rideCount++] = ride;

        return ride;
    }
    //Read
    public void printAllRides() {
        for (int i = 0; i < rideCount; i++) {
            System.out.println(rides[i]);
        }
    }
    public void printRideById(int rideId) {
        for (int i = 0; i < rideCount; i++) {
            if (rides[i].getRideID() == rideId) {
                System.out.println(rides[i]);
                return;
            }
        }
        System.out.println("Ride not found");
    }
    //Update
    public void updateRideFare(int rideId, double newFare) {
        for (int i = 0; i < rideCount; i++) {
            if (rides[i].getRideID() == rideId) {
                rides[i].setFare(newFare);
                return;
            }
        }
    }
    //Delete
    public void deleteRide(int rideId) {
        for (int i = 0; i < rideCount; i++) {
            if (rides[i].getRideID() == rideId) {
                rides[i].getDriver().completeRide();
                // Shift array left
                for (int j = i; j < rideCount - 1; j++) {
                    rides[j] = rides[j + 1];
                }
                rides[--rideCount] = null;
                return;
            }
        }
    }
}