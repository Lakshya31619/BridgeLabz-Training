import java.util.Scanner;
public class CountingSortStudentAges {
    public static int[] countingSort(int[] arr){
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        int [] freq = new int[max+1];
        for(int i=0; i<max+1; i++){
            freq[i] = 0;
        }
        for(int i=0; i<arr.length; i++){
            freq[arr[i]]++;
        }
        for(int i=1; i<=max; i++){
            freq[i] += freq[i-1];
        }
        int [] ans = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){
            ans[freq[arr[i]]-1] = arr[i];
            freq[arr[i]]--;
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of student : ");
        int n = sc.nextInt();
        int [] arr = new int[n];
        System.out.print("Enter student ages : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Sorted student ages : ");
        int [] sorted = countingSort(arr);
        for(int i=0; i<n; i++){
            System.out.print(sorted[i]+" ");
        }
    }
}