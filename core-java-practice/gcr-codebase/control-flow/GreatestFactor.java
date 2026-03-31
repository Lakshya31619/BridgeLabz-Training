import java.util.Scanner;
public class GreatestFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int greatestFactor = 1;
        for(int i=1; i<number; i++){
            if(number%i==0){
                greatestFactor = i; //Assigning greatest factor to the variable
            }
        }
        System.out.println(greatestFactor);
    }
}