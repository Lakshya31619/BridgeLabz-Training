import java.util.Map;
public class Customer {
    int customerId;
    Map<String, Integer> items;
    public Customer(int customerId, Map<String, Integer> items) {
        this.customerId = customerId;
        this.items = items;
    }
}