import java.util.*;
import java.util.stream.Collectors;
class Order {
    private String customerName;
    private double totalAmount;
    public Order(String customerName, double totalAmount) {
        this.customerName = customerName;
        this.totalAmount = totalAmount;
    }
    public String getCustomerName() {
        return customerName;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
}
public class OrderRevenueSummary {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("Ashish", 250.50),
                new Order("Carry", 150.00),
                new Order("Harsh", 300.00),
                new Order("Bhuvam", 200.75),
                new Order("Purav", 400.00)
        );
        Map<String, Double> revenuePerCustomer =
                orders.stream()
                        .collect(Collectors.groupingBy(
                                Order::getCustomerName,
                                Collectors.summingDouble(Order::getTotalAmount)
                        ));
        System.out.println(revenuePerCustomer);
    }
}