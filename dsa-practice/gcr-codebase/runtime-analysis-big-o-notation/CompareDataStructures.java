import java.util.*;
public class CompareDataStructures {
    private static final int N = 100000;
    public static void main(String[] args) {
        int[] array = new int[N];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }
        int target = N - 1;
        long start, end;
        // Array Search Time
        start = System.nanoTime();
        boolean foundArray = linearSearch(array, target);
        end = System.nanoTime();
        System.out.println("Array Search Found: " + foundArray);
        System.out.println("Array Search Time: " + (end - start) / 1000000 + " ms");
        // HashSet Search Time
        start = System.nanoTime();
        boolean foundHashSet = hashSet.contains(target);
        end = System.nanoTime();
        System.out.println("HashSet Search Found: " + foundHashSet);
        System.out.println("HashSet Search Time: " + (end - start) / 1000000 + " ms");
        // TreeSet Search Time
        start = System.nanoTime();
        boolean foundTreeSet = treeSet.contains(target);
        end = System.nanoTime();
        System.out.println("TreeSet Search Found: " + foundTreeSet);
        System.out.println("TreeSet Search Time: " + (end - start) / 1000000 + " ms");
    }
    // Linear search
    private static boolean linearSearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target)
                return true;
        }
        return false;
    }
}