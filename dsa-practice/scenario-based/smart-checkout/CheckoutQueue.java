import java.util.LinkedList;
import java.util.Queue;
public class CheckoutQueue {
    private Queue<Customer> queue = new LinkedList<>();
    public void addCustomer(Customer customer) {
        queue.offer(customer);
        System.out.println("Customer " + customer.customerId + " added to billing queue.");
    }
    public void processCustomer(Inventory inventory) {
        if (queue.isEmpty()) {
            System.out.println("No customers in queue.");
            return;
        }
        Customer customer = queue.poll();
        int totalBill = 0;
        System.out.println("Processing Customer " + customer.customerId);
        for (String item : customer.items.keySet()) {
            int qty = customer.items.get(item);
            int price = inventory.getPrice(item);
            if (inventory.updateStock(item, qty)) {
                totalBill += price * qty;
                System.out.println(item + " x " + qty + " = " + (price * qty));
            } else {
                System.out.println(item + " is out of stock!");
            }
        }
        System.out.println("Total Bill: ₹" + totalBill);
    }
}