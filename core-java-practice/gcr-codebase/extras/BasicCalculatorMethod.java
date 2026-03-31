import java.util.Scanner;
public class BasicCalculatorMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double first = sc.nextDouble();
        double second = sc.nextDouble();
        String op = sc.next();
        //Calling method calculate
        double res = calculate(first, second, op);
        //Output
        displayResult(res);
    }
    public static double calculate(double first, double second, String op){
        double res = 0.0;
        if(!op.equals("+") && !op.equals("-") && !op.equals("*") && !op.equals("/")){
            System.out.println("Invalid operator");
        }else{
            if(op.equals("+")){
                res = first+second;
            }else if(op.equals("-")){
                res = first-second;
            }else if(op.equals("*")){
                res = first*second;
            }else{
                res = first/second;
            }
        }
        return res;
    }
    public static void displayResult(double res){
        System.out.println("Output : "+res);
    }
}