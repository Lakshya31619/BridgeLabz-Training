import java.util.Scanner;
public class PrimeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input number
        int n = sc.nextInt();
        //Calling method checkPrime
        boolean flag = checkPrime(n);
        //Output
        if(flag){
            System.out.println("The given number "+n+" is Prime");
        }else{
            System.out.println("The given number "+n+" is not Prime");
        }
    }
    //Method to check prime number
    public static boolean checkPrime(int n){
        if(n<=1){
            return false;
        }
        if(n==2){
            return true;
        }
        if(n%2==0){
            return false;
        }
        for(int i=3; i*i<=n; i+=2){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}