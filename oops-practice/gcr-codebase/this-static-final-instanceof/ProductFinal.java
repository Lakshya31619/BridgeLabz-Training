public class ProductFinal {
    // Static variable
    private static double discount = 0.0; // percentage
    // Final variable
    private final String productID;
    private String productName;
    private double price;
    private int quantity;
    // Constructor using 'this'
    public ProductFinal(String productID, String productName, double price, int quantity) {
        this.productID = productID;      // final variable assigned once
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }
    // Static method
    public static void updateDiscount(double newDiscount) {
        if (newDiscount >= 0) {
            discount = newDiscount;
        }
    }
    // Method to display product details using instanceof
    public void displayProductDetails() {
        if (this instanceof ProductFinal) {
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            double discountedPrice = price - (price * discount / 100);
            System.out.println("Price after Discount: $" + discountedPrice);
        } else {
            System.out.println("Invalid product object.");
        }
    }
    public static void main(String[] args) {
        // Update discount for all products
        ProductFinal.updateDiscount(10.0);
        // Create a product
        ProductFinal product1 = new ProductFinal("P001", "Laptop", 1200.0, 5);
        // Display product details
        product1.displayProductDetails();
    }
}