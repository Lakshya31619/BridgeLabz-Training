public class VehicleFinal {
    // Static variable
    private static double registrationFee = 150.0;
    // Final variable
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;
    // Constructor using 'this'
    public VehicleFinal(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }
    // Static method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        if (newFee > 0) {
            registrationFee = newFee;
        }
    }
    // Method to display vehicle details using instanceof
    public void displayVehicleDetails() {
        if (this instanceof VehicleFinal) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        } else {
            System.out.println("Invalid vehicle object.");
        }
    }
    public static void main(String[] args) {
        // Create vehicle objects
        VehicleFinal v1 = new VehicleFinal("Honest raj", "Sedan", "ABC123");
        VehicleFinal v2 = new VehicleFinal("Price danish", "SUV", "XYZ789");
        // Display vehicle details
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}