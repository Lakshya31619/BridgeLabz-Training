import java.util.Scanner;
public class NaturalSumRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input number
        int n = sc.nextInt();
        //Calling method checkNatural
        if(checkNatural(n)){
            //Calling method sumRecursion
            int sum_rec = sumRecursion(n);
            //Calling method sumFormulae
            int sum_for = sumFormulae(n);
            //Calling method compare
            boolean com = compare(sum_rec, sum_for);
            //Output
            System.out.println("Sum using recursion : "+sum_rec);
            System.out.println("Sum using formulae : "+sum_for);
            if(com){
                System.out.println("Both are equal");
            }else{
                System.out.println("Both are not equal");
            }
        }else{
            System.out.println("Not a natural number");
        }
    }
    //Method to check natural number
    public static boolean checkNatural(int n) {
        return n>0;
    }
    //Method to find sum using recursion
    public static int sumRecursion(int n){
        if(n<=0){
            return 0;
        }
        return n + sumRecursion(n-1);
    }
    //Method to find sum using recursion
    public static int sumFormulae(int n){
        int sum_for = (n*(n+1))/2;
        return sum_for;
    }
    //Method to compare sum
    public static boolean compare(int sum_rec, int sum_for){
        return sum_for==sum_rec;
    }
}