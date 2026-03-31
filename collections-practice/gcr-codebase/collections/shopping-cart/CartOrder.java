import java.util.LinkedHashMap;
import java.util.Map;
public class CartOrder {
    private Map<String, Double> cart = new LinkedHashMap<>();
    public void addItem(String product, double price) {
        cart.put(product, price);
    }
    public Map<String, Double> getCart() {
        return cart;
    }
    public void display() {
        System.out.println(cart);
    }
}