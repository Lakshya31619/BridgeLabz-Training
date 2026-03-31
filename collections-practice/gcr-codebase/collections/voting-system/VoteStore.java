import java.util.HashMap;
import java.util.Map;
public class VoteStore {
    private Map<String, Integer> votes = new HashMap<>();
    public void addVote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
    }
    public Map<String, Integer> getVotes() {
        return votes;
    }
}