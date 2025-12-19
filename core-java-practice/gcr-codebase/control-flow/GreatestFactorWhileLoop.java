import java.util.Scanner;
public class GreatestFactorWhileLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int greatestFactor = 1;
        int i = 1;
        while(i!=number-1){
            if(number%i==0){
                greatestFactor = i; //Assigning greatest factor to the variable
            }
            i++;
        }
        System.out.println(greatestFactor);
    }
}
