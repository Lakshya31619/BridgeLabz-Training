import java.util.Scanner;
public class SumUntilZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0.0;
        double input;
        while((input = sc.nextDouble())!=0){
            sum += input;
            System.out.println("Input Again!");
        }
        System.out.println(sum);
    }
}
