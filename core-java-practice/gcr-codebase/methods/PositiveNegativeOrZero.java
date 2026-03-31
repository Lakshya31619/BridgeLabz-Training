import java.util.Scanner;
public class PositiveNegativeOrZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input number
        int n = sc.nextInt();
        //Calling check positive, negative, zero method
        int res = check(n);
        //Output
        System.out.println(res);
    }
    //Method check
    public static int check(int n){
        if(n==0){
            return 0;
        }else if(n>0){
            return 1;
        }else{
            return -1;
        }
    }
}