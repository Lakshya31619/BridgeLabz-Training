import java.util.HashMap;
public class SmartCheckout {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        CheckoutQueue checkoutQueue = new CheckoutQueue();
        HashMap<String, Integer> items1 = new HashMap<>();
        items1.put("Milk", 2);
        items1.put("Bread", 1);
        HashMap<String, Integer> items2 = new HashMap<>();
        items2.put("Rice", 3);
        items2.put("Milk", 1);
        Customer c1 = new Customer(101, items1);
        Customer c2 = new Customer(102, items2);
        checkoutQueue.addCustomer(c1);
        checkoutQueue.addCustomer(c2);
        checkoutQueue.processCustomer(inventory);
        inventory.printStock();
        checkoutQueue.processCustomer(inventory);
        inventory.printStock();
    }
}