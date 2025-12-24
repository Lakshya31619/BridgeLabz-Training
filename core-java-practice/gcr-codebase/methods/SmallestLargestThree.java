import java.util.Scanner;
public class SmallestLargestThree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input three numbers
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        //Method to find smallest and largest among three numbers
        int [] sl = findSmallestLargest(a, b, c);
        //Output
        System.out.println("Smallest number : "+sl[0]);
        System.out.println("Largest number : "+sl[1]);
    }
    //Method findSmallestLargest
    public static int[] findSmallestLargest(int a, int b, int c){
        int smallest = 0;
        int largest = 0;
        //Find smallest
        if(a<b && a<c){
            smallest = a;
        }else if(b<a && b<c){
            smallest = b;
        }else{
            smallest = c;
        }
        //Find largest
        if(a>b && a>c){
            largest = a;
        }else if(b>a && b>c){
            largest = b;
        }else{
            largest = c;
        }
        return new int[]{smallest, largest};
    }
}