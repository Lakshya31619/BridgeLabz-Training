import java.util.Scanner;
public class Compute_alternating_sum {
    public static int alternatingSum(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += i%2==0 ? nums[i] : -nums[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(alternatingSum(nums));
    }
}
