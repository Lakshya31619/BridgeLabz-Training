import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class InvertMapExample {
    public static void main(String[] args) {
        Map<String, Integer> input = new HashMap<>();
        input.put("A", 1);
        input.put("B", 2);
        input.put("C", 1);
        Map<Integer, List<String>> inverted = new HashMap<>();
        for (Map.Entry<String, Integer> entry : input.entrySet()) {
            inverted.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        System.out.println(inverted);
    }
}