import java.util.Scanner;
public class FactorialForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int factorial = 1;
        if(n>0){
            for(int i=n; i>=1; i--){
                factorial *= i;
            }
            System.out.println("Factorial : "+factorial);
        }else{
            System.out.println("Not a positive number");
        }
    }
}
