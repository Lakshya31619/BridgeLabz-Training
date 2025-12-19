import java.util.Scanner;
public class CompareSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum1 = 0; //For while loop
        int i = n;
        while(i!=0){
            sum1 += i--;
        }
        int sum2 = 0; //For formula
        sum2 = n*(n+1)/2;
        if(sum1==sum2){
            System.out.println("Equal");
        }else{
            System.out.println("Not Equal");
        }
    }
}
