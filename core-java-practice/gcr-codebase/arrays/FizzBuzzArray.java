import java.util.Scanner;
public class FizzBuzzArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //Check positive
        if(n<=0){
            System.out.println("The number is not positive.");
            return;
        }
        String[] results = new String[n+1];
        //Fizz/Buzz Check
        for(int i=0; i<=n; i++){
            if(i==0){
                results[i] = "0";
            }else if(i%3==0 && i%5==0){
                results[i] = "FizzBuzz";
            }else if(i%3==0){
                results[i] = "Fizz";
            }else if(i%5==0){
                results[i] = "Buzz";
            }else{
                results[i] = String.valueOf(i);
            }
        }
        for(int i=0; i<=n; i++){
            System.out.println("Position "+i+" = "+results[i]);
        }
    }
}