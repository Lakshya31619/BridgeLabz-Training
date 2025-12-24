import java.util.Scanner;
public class SumNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input number
        int n = sc.nextInt();
        //Method to calculate sum of n natural number
        int sum = sumNatural(n);
        //Output
        System.out.println("Sum of "+n+" natural numbers : "+sum);    
    }
    //Method sumNatural using loop
    public static int sumNatural(int n){
        int sum = 0;
        for(int i=1; i<=n; i++){
            sum += i;
        }
        return sum;
    }
}