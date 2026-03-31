import java.util.ArrayList;
import java.util.List;
//Main Class
public class ECommerce {
    public static void main(String[] args) {
        List<ProductAbs> products = new ArrayList<>();
        products.add(new Electronics(1, "TV", 100000));
        products.add(new Clothing(2, "Jockey", 400));
        products.add(new Groceries(3, "Rice", 200));
        // Polymorphic processing
        for (ProductAbs product : products) {
            calculateFinalPrice(product);
            System.out.println("-------------------------------");
        }
    }
    //Output
    public static void calculateFinalPrice(ProductAbs product) {
        double tax = 0;
        if(product instanceof Taxable) {
            tax = ((Taxable) product).calculateTax();
        }
        double discount = product.calculateDiscount();
        double finalPrice = product.getPrice() + tax - discount;
        System.out.println("Product Name : " + product.getName());
        System.out.println("Base Price  : " + product.getPrice());
        System.out.println("Tax         : " + tax);
        System.out.println("Discount    : " + discount);
        System.out.println("Final Price : " + finalPrice);
    }
}
//Interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}
//Abstract class
abstract class ProductAbs {
    private int productId;
    private String name;
    private double price;
    protected ProductAbs(int productId, String name, double price) {
        setProductId(productId);
        setName(name);
        setPrice(price);
    }
    public abstract double calculateDiscount();
    public int getProductId() {
        return productId;
    }
    private void setProductId(int productId) {
        if (productId <= 0) {
            throw new IllegalArgumentException("Product ID must be positive.");
        }
        this.productId = productId;
    }
    public String getName() {
        return name;
    }
    private void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    protected void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }
}
//Electronics class
class Electronics extends ProductAbs implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }
    @Override
    public double calculateTax() {
        return getPrice() * 0.18;
    }
    @Override
    public String getTaxDetails() {
        return "18% GST on Electronics";
    }
}
//Clothing class
class Clothing extends ProductAbs implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }
    @Override
    public double calculateTax() {
        return getPrice() * 0.12;
    }
    @Override
    public String getTaxDetails() {
        return "12% GST on Clothing";
    }
}
//Groceries Class
class Groceries extends ProductAbs {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}