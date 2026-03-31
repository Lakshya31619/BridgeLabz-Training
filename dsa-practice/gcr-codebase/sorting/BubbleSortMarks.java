import java.util.Scanner;
//Bubble sort
public class BubbleSortMarks {
    public static int[] bubbleSort(int [] arr){
        boolean swapped;
        for(int i=0; i<arr.length-1; i++){
            swapped = false;
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of student : ");
        int n = sc.nextInt();
        int [] arr = new int[n];
        System.out.print("Enter marks : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Sorted student marks : ");
        int [] sorted = bubbleSort(arr);
        for(int i=0; i<n; i++){
            System.out.print(sorted[i]+" ");
        }
    }
}