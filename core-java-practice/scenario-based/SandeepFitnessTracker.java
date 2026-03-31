import java.util.Scanner;
public class SandeepFitnessTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] pushups = new int[7];
        //Pushups per day in week
        System.out.println("Enter number of push-ups per day : (Enter 0 for rest day)");
        for(int i=0; i<7; i++){
            pushups[i] = sc.nextInt();
        }
        int total = 0;
        for(int i : pushups){
            if(i==0){
                continue;
            }
            total += i;
        }
        double average = total/7.0;
        System.out.println("Total Pushups : "+total);
        System.out.println("Average Pushups per day : "+average);
    }
}