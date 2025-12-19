import java.util.Scanner;
public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int factorial = 1;
        if(n>0){
            while(n!=0){
                factorial *= n--;
            }
            System.out.println("Factorial : "+factorial);
        }else{
            System.out.println("Not a positive number");
        }
    }
}