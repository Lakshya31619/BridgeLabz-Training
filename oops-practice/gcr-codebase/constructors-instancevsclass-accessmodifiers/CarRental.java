public class CarRental {
    // Attributes
    private String customerName;
    private String carModel;
    private int rentalDays;
    private static final double RATE_PER_DAY = 1500.0;
    // Default constructor
    public CarRental() {
        this.customerName = "Customer";
        this.carModel = "Standard";
        this.rentalDays = 1;
    }
    // Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }
    // Method to calculate total cost
    public double calculateTotalCost() {
        return rentalDays * RATE_PER_DAY;
    }
    // Getters
    public String getCustomerName() {
        return customerName;
    }
    public String getCarModel() {
        return carModel;
    }
    public int getRentalDays() {
        return rentalDays;
    }
    public static void main(String[] args) {
        // Using default constructor
        CarRental rental1 = new CarRental();
        System.out.println("Rental 1:");
        System.out.println("Customer: " + rental1.getCustomerName());
        System.out.println("Car Model: " + rental1.getCarModel());
        System.out.println("Days: " + rental1.getRentalDays());
        System.out.println("Total Cost: Rs" + rental1.calculateTotalCost());
        System.out.println();
        // Using parameterized constructor
        CarRental rental2 = new CarRental("Devarshi", "Tata Nano", 5);
        System.out.println("Rental 2:");
        System.out.println("Customer: " + rental2.getCustomerName());
        System.out.println("Car Model: " + rental2.getCarModel());
        System.out.println("Days: " + rental2.getRentalDays());
        System.out.println("Total Cost: Rs" + rental2.calculateTotalCost());
    }
}