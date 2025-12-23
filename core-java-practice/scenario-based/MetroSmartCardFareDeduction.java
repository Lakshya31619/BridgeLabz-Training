import java.util.Scanner;
public class MetroSmartCardFareDeduction {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //Initial balance
        int balance=1000;
        while(true){
            //Input distance  //Press -1 to quit
            int distance=sc.nextInt();
            if(distance==-1){
                break;
            }
            //Calculate fare using ternary operator
            int fare=distance<=5?10:distance<=10?20:30;
            //Check balance
            if(balance>=fare){
                balance=balance-fare;
                System.out.println("Fare deducted: "+fare);
                System.out.println("Remaining balance: "+balance);
            }else{
                System.out.println("Insufficient balance.");
                break;
            }
            System.out.println();
        }
        //Output
        System.out.println("Final balance: "+balance);
    }
}