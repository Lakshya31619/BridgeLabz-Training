import java.util.HashMap;
import java.util.Map;
public class ProductStore {
    private Map<String, Double> products = new HashMap<>();
    public void addProduct(String name, double price) {
        products.put(name, price);
    }
    public Map<String, Double> getProducts() {
        return products;
    }
}