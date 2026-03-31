import java.time.LocalDate;
import java.util.*;
public class PolicyManager {
    private Set<Policy> hashSet = new HashSet<>();
    private Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private Set<Policy> treeSet = new TreeSet<>(
            Comparator.comparing(Policy::getExpiryDate).thenComparing(Policy::getPolicyNumber)
    );
    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }
    public Set<Policy> getAllPolicies() {
        return hashSet;
    }
    public Set<Policy> getInsertionOrderPolicies() {
        return linkedHashSet;
    }
    public Set<Policy> getSortedByExpiryPolicies() {
        return treeSet;
    }
    // Policies expiring within next 30 days
    public List<Policy> getExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(30);
        List<Policy> result = new ArrayList<>();
        for (Policy policy : hashSet) {
            if (!policy.getExpiryDate().isBefore(today) &&
                !policy.getExpiryDate().isAfter(limit)) {
                result.add(policy);
            }
        }
        return result;
    }
    // Policies by coverage type
    public List<Policy> getByCoverageType(String coverageType) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : hashSet) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                result.add(policy);
            }
        }
        return result;
    }
    // Find duplicate policy numbers
    public static Set<String> findDuplicatePolicyNumbers(List<Policy> policies) {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();
        for (Policy policy : policies) {
            if (!seen.add(policy.getPolicyNumber())) {
                duplicates.add(policy.getPolicyNumber());
            }
        }
        return duplicates;
    }
}