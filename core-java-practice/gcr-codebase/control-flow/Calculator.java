import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double first = sc.nextDouble();
        double second = sc.nextDouble();
        String op = sc.next();
        if(!op.equals("+") && !op.equals("-") && !op.equals("*") && !op.equals("/")){
            System.out.println("Invalid operator");
        }else{
            switch(op){
                case("+") : System.out.println(first+second); 
                            break;
                case("-") : System.out.println(first-second);
                            break;
                case("*") : System.out.println(first*second);
                            break;
                case("/") : System.out.println(first/second);
                            break;
            }
        }
    }
}