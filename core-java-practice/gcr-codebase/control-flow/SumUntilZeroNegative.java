import java.util.Scanner;
public class SumUntilZeroNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double number;
        double sum = 0;
        while(true){
            number = sc.nextDouble();
            if(number<=0){
                break;
            }
            sum += number;
        }
        System.out.println(sum);
    }
}