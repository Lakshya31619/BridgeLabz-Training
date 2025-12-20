import java.util.Scanner;
public class FootballTeamHeight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double [] height = new double[11]; //Initialize array of size 11 i.e. no. of players
        for(int i=0; i<11; i++){
            height[i] = sc.nextDouble();
        }
        double sum = 0.0;
        for(int i=0; i<11; i++){
            sum += height[i]; //Sum of heights
        }
        double mean = sum/11.0; //Mean of heights
        System.out.println("Mean height of football team is "+mean);
    }
}