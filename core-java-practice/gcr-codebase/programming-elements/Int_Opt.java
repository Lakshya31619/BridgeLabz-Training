import java.util.Scanner;
public class Int_Opt {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int a = sc.nextInt(); //Input 1
       int b = sc.nextInt(); //Input 2
       int c = sc.nextInt(); //Input 3
       int op1 = a+b*c; //Operation 1
       int op2 = a*b+c; //Operation 2
       int op3 = c+a/b; //Operation 3
       int op4 = a%b+c; //Operation 4
       System.out.println("Operation 1 : "+op1);
       System.out.println("Operation 2 : "+op2);
       System.out.println("Operation 3 : "+op3);
       System.out.println("Operation 4 : "+op4);
    }
}
