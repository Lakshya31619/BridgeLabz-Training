import java.util.Scanner;
public class Natural_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if(number>0){
            int sum = number*(number+1)/2; //Sum of n natural numbers
            System.out.println("The sum of "+number+" natual numbers is "+sum);
        }else{
            System.out.println("The number "+number+" is not a natural number");
        }
    }
}
