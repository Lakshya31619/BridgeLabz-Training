import java.util.Scanner;
public class MaximumThreeNumbers {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        //Input three numbers
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        //Calling method checkMax
        int max = checkMax(a, b, c);
        //Output
        System.out.println("Maximum Number : "+max);
    }
    //Method to find maximum amongst three numbers
    public static int checkMax(int a, int b, int c){
        if(a>b && a>c){
            return a;
        }else if(b>a && b>c){
            return b;
        }else{
            return c;
        }
    }
}