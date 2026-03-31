public class Vehicle {
    // Instance variables
    private String ownerName;
    private String vehicleType;
    // Class variable
    private static double registrationFee = 5000.0;
    // Constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
    // Instance method
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: Rs." + registrationFee);
    }
    // Class method
    public static void updateRegistrationFee(double newFee) {
        if (newFee > 0) {
            registrationFee = newFee;
        }
    }
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Naman", "Car");
        Vehicle v2 = new Vehicle("Baman", "Motorcycle");
        System.out.println("Vehicle 1 Details:");
        v1.displayVehicleDetails();
        System.out.println();
        System.out.println("Vehicle 2 Details:");
        v2.displayVehicleDetails();
        System.out.println("\nUpdating Registration Fee : \n");
        // Update class variable using class method
        Vehicle.updateRegistrationFee(6000.0);
        System.out.println("Vehicle Details After Fee Update:");
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
    }
}