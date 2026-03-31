import java.util.Scanner;
public class Double_Opt {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       double a = sc.nextInt(); //Input 1
       double b = sc.nextInt(); //Input 2
       double c = sc.nextInt(); //Input 3
       double op1 = a+b*c; //Operation 1
       double op2 = a*b+c; //Operation 2
       double op3 = c+a/b; //Operation 3
       double op4 = a%b+c; //Operation 4
       System.out.println("Operation 1 : "+op1);
       System.out.println("Operation 2 : "+op2);
       System.out.println("Operation 3 : "+op3);
       System.out.println("Operation 4 : "+op4);
    }
}