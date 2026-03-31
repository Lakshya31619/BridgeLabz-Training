import java.util.Map;
import java.util.TreeMap;
public class BalanceSortedView {
    public void displaySorted(Map<Integer, Double> accounts) {
        TreeMap<Double, Integer> sorted = new TreeMap<>();
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            sorted.put(entry.getValue(), entry.getKey());
        }
        System.out.println(sorted);
    }
}