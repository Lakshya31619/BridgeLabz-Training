import java.util.LinkedHashMap;
import java.util.Map;
public class VoteOrder {
    private Map<String, Integer> order = new LinkedHashMap<>();
    public void record(String candidate, int count) {
        order.put(candidate, count);
    }
    public void display() {
        System.out.println(order);
    }
}