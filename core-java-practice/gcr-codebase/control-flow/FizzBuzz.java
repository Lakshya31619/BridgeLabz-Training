import java.util.Scanner;
public class FizzBuzz {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n>0){
            for(int i=1; i<=n; i++){
                if(i%3==0 && i%5==0){                           //Multiple of both 3 and 5
                    System.out.println("FizzBuzz");
                }else if(i%3==0){                               //Multiple of 5
                    System.out.println("Fizz");
                }else if(i%5==0){                               //Multiple of both 3 and 5
                    System.out.println("Buzz");
                }else{                                          //Neither multiple of 3 nor 5
                    System.out.println(i);
                }
            }
        }else{
            System.out.println("Not a positive number.");
        }
    }
}