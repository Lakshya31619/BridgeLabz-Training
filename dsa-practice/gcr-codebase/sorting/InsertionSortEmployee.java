import java.util.Scanner;
public class InsertionSortEmployee {
    public static int[] insertionSort(int [] arr){
        for(int i=1; i<arr.length; i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employees : ");
        int n = sc.nextInt();
        int [] arr = new int[n];
        System.out.print("Enter employeeId : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Sorted employeeIds : ");
        int [] sorted = insertionSort(arr);
        for(int i=0; i<n; i++){
            System.out.print(sorted[i]+" ");
        }
    }
}