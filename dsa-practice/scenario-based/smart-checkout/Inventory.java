import java.util.HashMap;
public class Inventory {
    private HashMap<String, Integer> priceMap = new HashMap<>();
    private HashMap<String, Integer> stockMap = new HashMap<>();
    public Inventory() {
        priceMap.put("Milk", 50);
        priceMap.put("Bread", 40);
        priceMap.put("Rice", 60);
        stockMap.put("Milk", 10);
        stockMap.put("Bread", 5);
        stockMap.put("Rice", 8);
    }
    public int getPrice(String item) {
        return priceMap.getOrDefault(item, 0);
    }
    public boolean updateStock(String item, int quantity) {
        int available = stockMap.getOrDefault(item, 0);
        if (available >= quantity) {
            stockMap.put(item, available - quantity);
            return true;
        }
        return false;
    }
    public void printStock() {
        System.out.println("Current Stock: " + stockMap);
    }
}