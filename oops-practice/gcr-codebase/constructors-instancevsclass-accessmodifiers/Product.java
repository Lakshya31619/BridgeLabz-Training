public class Product {
    // Instance variables
    private String productName;
    private double price;
    // Class variable
    private static int totalProducts = 0;
    // Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }
    // Instance method
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: Rs." + price);
    }
    // Class method
    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 65000);
        Product p2 = new Product("Headphones", 2500);
        System.out.println("Product 1 Details:");
        p1.displayProductDetails();
        System.out.println();
        System.out.println("Product 2 Details:");
        p2.displayProductDetails();
        System.out.println();
        // Calling class method using class name
        Product.displayTotalProducts();
    }
}