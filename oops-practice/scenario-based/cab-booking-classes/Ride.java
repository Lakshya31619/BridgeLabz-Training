//Ride class
class Ride{    
    public static int counter = 0;
    private int rideID = 0;
    private User user;
    private Driver driver;
    private double distance;
    private double fare;
    public Ride(User user, Driver driver, double distance, double fare){
        this.rideID = counter++;
        this.user = user;
        this.driver = driver;
        this.distance = distance;
        this.fare = fare;
    }
    public int getRideID(){
        return rideID;
    }
    public Driver getDriver(){
        return driver;
    }
    public void setFare(double fare){
        this.fare = fare;
    }
     @Override
    public String toString() {
        return "RideID: " + rideID + ", User: " + user.getName() + ", Driver: " + driver.getName() + ", Distance: " + distance + ", Fare: " + fare;
    }
}