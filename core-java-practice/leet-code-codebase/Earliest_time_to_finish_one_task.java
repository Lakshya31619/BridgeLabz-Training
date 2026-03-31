import java.util.Scanner;
public class Earliest_time_to_finish_one_task {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][] tasks = new int[n][2];
        for(int i=0; i<n; i++){
            tasks[i][0] = sc.nextInt();
            tasks[i][1] = sc.nextInt();
        }
        System.out.println(earliestTime(tasks));
    }
    public static int earliestTime(int[][] tasks) {
        int min=200;
        for(int[] nums:tasks){
            min=Math.min(nums[0]+nums[1],min);
        }
        return min;
    }
}
