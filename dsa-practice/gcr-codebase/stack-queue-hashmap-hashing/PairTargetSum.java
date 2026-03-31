import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class PairTargetSum {
    public static boolean findPair(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            int cmp = target-arr[i];
            if(map.containsKey(cmp)){
                return true;
            }
            map.put(arr[i], i);
        }
        return false;
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
        System.out.print("Enter target sum : ");
        int target = sc.nextInt();
        System.out.println(findPair(arr, target));
    }
}
