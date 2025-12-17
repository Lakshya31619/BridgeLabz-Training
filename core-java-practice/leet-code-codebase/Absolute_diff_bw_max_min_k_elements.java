import java.util.Arrays;
import java.util.Scanner;

public class Absolute_diff_bw_max_min_k_elements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int [n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(absDifference(nums,k));
    }
    public static int absDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min_sum = 0;
        int max_sum = 0;
        for(int i=0; i<k; i++){
            min_sum += nums[i];
        }
        for(int i=nums.length-1; i>=nums.length-k; i--){
            max_sum += nums[i];
        }
        return Math.abs(max_sum-min_sum);
    }
}
