import java.util.Scanner;

public class MergeSortBookPrices {
    public static int[] mergeSort(int[] arr, int left, int right){
        if(left<right){
            int mid = left+(right-left)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
        return arr;
    }
    public static void merge(int[] arr, int left, int mid, int right){
        int n1 = mid-left+1;
        int n2 = right-mid;
        int [] leftArr = new int[n1];
        int [] rightArr = new int[n2];
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid+1, rightArr, 0, n2);
        int i=0;
        int j=0;
        int k=left;
        while(i<n1 && j<n2){
            if(leftArr[i]<=rightArr[j]){
                arr[k++] = leftArr[i++];
            }else{
                arr[k++] = rightArr[j++];
            }
        }
        while(i<n1){
            arr[k++] = leftArr[i++];
        }
        while(j<n2){
            arr[k++] = rightArr[j++];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of books : ");
        int n = sc.nextInt();
        int [] arr = new int[n];
        System.out.print("Enter book prices : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Sorted book prices : ");
        int [] sorted = mergeSort(arr, 0, arr.length-1);
        for(int i=0; i<n; i++){
            System.out.print(sorted[i]+" ");
        }
    }
}