import java.util.*;
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        List <Integer> ls = new ArrayList<>();
        for (int num : nums) {
            ls.add(num);
        }
        for(int i=0; i<nums.length; i++) if(ls.contains(target-nums[i]) && ls.indexOf(target-nums[i])!=i) return new int[]{i, ls.indexOf(target-nums[i])};
        return new int[]{0,0};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int [] ans = twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
    }
}