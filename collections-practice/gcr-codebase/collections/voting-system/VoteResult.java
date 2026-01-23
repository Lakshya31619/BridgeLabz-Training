import java.util.Map;
import java.util.TreeMap;
public class VoteResult {
    public void displaySorted(Map<String, Integer> votes) {
        TreeMap<String, Integer> sorted = new TreeMap<>(votes);
        System.out.println(sorted);
    }
}