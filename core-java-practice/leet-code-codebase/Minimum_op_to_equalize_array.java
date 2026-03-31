import java.util.*;
public class Minimum_op_to_equalize_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(minOperations(nums));
    }
    public static int minOperations(int[] nums) {
        for(int i=1; i<nums.length; i++){
            if(nums[i]!=nums[0]) return 1;
        }
        return 0;
    }
}
