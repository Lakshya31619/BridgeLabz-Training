import java.time.LocalDate;
import java.util.*;
public class PerformanceTest {
    public static void main(String[] args) {
        Policy policy = new Policy("P999", "Test User", LocalDate.now().plusDays(100), "Health", 4000);
        Set<Policy> hashSet = new HashSet<>();
        Set<Policy> linkedHashSet = new LinkedHashSet<>();
        Set<Policy> treeSet = new TreeSet<>(
            Comparator.comparing(Policy::getExpiryDate)
        );
        testOperation("HashSet Add", () -> hashSet.add(policy));
        testOperation("LinkedHashSet Add", () -> linkedHashSet.add(policy));
        testOperation("TreeSet Add", () -> treeSet.add(policy));
        testOperation("HashSet Search", () -> hashSet.contains(policy));
        testOperation("LinkedHashSet Search", () -> linkedHashSet.contains(policy));
        testOperation("TreeSet Search", () -> treeSet.contains(policy));
        testOperation("HashSet Remove", () -> hashSet.remove(policy));
        testOperation("LinkedHashSet Remove", () -> linkedHashSet.remove(policy));
        testOperation("TreeSet Remove", () -> treeSet.remove(policy));
    }
    private static void testOperation(String name, Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        System.out.println(name + " : " + (end - start) + " ns");
    }
}