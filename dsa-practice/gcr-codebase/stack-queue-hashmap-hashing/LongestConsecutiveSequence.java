import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int longest = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int currentLength = left + 1 + right;
            map.put(num, currentLength);
            map.put(num - left, currentLength);
            map.put(num + right, currentLength);
            longest = Math.max(longest, currentLength);
        }
        return longest;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in array : ");
        int n = sc.nextInt();
        int [] arr = new int [n];
        System.out.print("Enter array elements : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(longestConsecutive(arr));
    }
}