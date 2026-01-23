import java.util.Map;
import java.util.TreeMap;
public class PriceSortedView {
    public void displaySorted(Map<String, Double> items) {
        TreeMap<Double, String> sorted = new TreeMap<>();
        for (Map.Entry<String, Double> entry : items.entrySet()) {
            sorted.put(entry.getValue(), entry.getKey());
        }
        System.out.println(sorted);
    }
}