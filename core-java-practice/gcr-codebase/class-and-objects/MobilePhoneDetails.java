public class MobilePhoneDetails {
    // MobilePhone Class
    static class MobilePhone {
        // Attributes
        private String brand;
        private String model;
        private double price;
        // Constructor
        public MobilePhone(String brand, String model, double price) {
            this.brand = brand;
            this.model = model;
            this.price = price;
        }
        // Method to display mobile phone details
        public void displayDetails() {
            System.out.println("Brand of mobile: " + brand);
            System.out.println("Model of mobile: " + model);
            System.out.println("Price of mobile: " + price);
            System.out.println("------------------------------");
        }
    }
    public static void main(String[] args) {
        // Create MobilePhone objects
        MobilePhone phone1 = new MobilePhone("VIVO", "VIVO V29", 15999.0);
        MobilePhone phone2 = new MobilePhone("ONE PLUS", "ONE PLUS nord4", 39999.0);
        MobilePhone phone3 = new MobilePhone("APPLE", "iphone pro16", 79999.0);
        // Display mobile phone details
        phone1.displayDetails();
        phone2.displayDetails();
        phone3.displayDetails();
    }
}