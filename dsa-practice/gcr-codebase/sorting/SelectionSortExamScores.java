import java.util.Scanner;
public class SelectionSortExamScores{
    public static void selectionSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            int index = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<arr[index]){
                    index = j;
                }
            }
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students : ");
        int n = sc.nextInt();
        int [] arr = new int[n];
        System.out.print("Entere exam scores : ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print("Sorted exam scores : ");
        selectionSort(arr);
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}