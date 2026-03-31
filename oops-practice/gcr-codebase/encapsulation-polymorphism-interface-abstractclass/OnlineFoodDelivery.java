import java.util.ArrayList;
import java.util.List;
//Main class
public class OnlineFoodDelivery {
    public static void main(String[] args) {
        List<BaseFoodItem> orderItems = new ArrayList<>();
        orderItems.add(new VegFoodItem("Daal Makhni", 250, 2));
        orderItems.add(new NonVegFoodItem("Butter Chicken", 350, 1));
        processOrder(orderItems);
    }
    //Polymorphism
    public static void processOrder(List<BaseFoodItem> items) {
        double grandTotal = 0;
        for (BaseFoodItem item : items) {
            double itemTotal = item.calculateTotalPrice();
            double discount = 0;
            if (item instanceof DiscountableItem) {
                discount = ((DiscountableItem) item).applyDiscount();
            }
            System.out.println(item.getItemDetails());
            System.out.println("Item Total : " + itemTotal);
            System.out.println("Discount   : " + discount);
            System.out.println("Final Price: " + (itemTotal - discount));
            System.out.println("--------------------------------");
            grandTotal += (itemTotal - discount);
        }
        System.out.println("Grand Total: " + grandTotal);
    }
}
//Interface
interface DiscountableItem {
    double applyDiscount();
    String getDiscountDetails();
}
//Abstract class
abstract class BaseFoodItem {
    private String itemName;
    private double price;
    private int quantity;
    protected BaseFoodItem(String itemName, double price, int quantity) {
        setItemName(itemName);
        setPrice(price);
        setQuantity(quantity);
    }
    // Abstract method
    public abstract double calculateTotalPrice();
    // Concrete method
    public String getItemDetails() {
        return "Item : " + itemName +", Price : " + price +", Quantity : " + quantity;
    }
    // Encapsulation
    public String getItemName() {
        return itemName;
    }
    private void setItemName(String itemName) {
        if (itemName == null || itemName.isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be empty.");
        }
        this.itemName = itemName;
    }
    protected double getPrice() {
        return price;
    }
    private void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        this.price = price;
    }
    protected int getQuantity() {
        return quantity;
    }
    private void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        this.quantity = quantity;
    }
}
//Veg class
class VegFoodItem extends BaseFoodItem implements DiscountableItem {
    public VegFoodItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.10;
    }
    @Override
    public String getDiscountDetails() {
        return "10% Veg Discount";
    }
}
//NonVeg class
class NonVegFoodItem extends BaseFoodItem implements DiscountableItem {
    private static final double NON_VEG_CHARGE = 50;
    public NonVegFoodItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + NON_VEG_CHARGE;
    }
    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05;
    }
    @Override
    public String getDiscountDetails() {
        return "5% Non-Veg Discount";
    }
}