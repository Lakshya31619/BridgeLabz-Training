import java.util.Scanner;
public class FactorsOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if(number>0){
            for(int i=1; i<=number; i++){
                if(number%i==0){
                    System.out.println(i); //Factors of number
                }
            }
        }else{
            System.out.println("Not a positive number.");
        }
    }
}