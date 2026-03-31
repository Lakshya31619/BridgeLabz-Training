import java.util.Scanner;
public class ArrayElementsOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //Number of elements
        int [] nums = new int[n]; //Initialize array of size n
        for(int i=0; i<n; i++){
            nums[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            //Positive/Negative/Zero Check
            if(nums[i]==0){
                System.out.println("Zero");
            }else if(nums[i]<0){
                System.out.println("Negative");
            }else{
                System.out.println("Positive");
                //Even/Odd Check
                if(nums[i]%2==0){
                    System.out.println("Even Number");
                }else{
                    System.out.println("Odd Number");
                }
            }
        }
        //Comparision between first and last element
        if(nums[0]>nums[n-1]){
            System.out.println(nums[0]+ " is greater than" +nums[n-1]);
        }else if(nums[0]==nums[n-1]){
            System.out.println("Both numbers are equal");
        }else{
            System.out.println(nums[0]+ " is less than " +nums[n-1]);
        }
    }
}