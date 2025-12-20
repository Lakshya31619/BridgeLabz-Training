import java.util.Scanner;
public class AmarAkbarAnthony {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] friends = {"Amar", "Akbar", "Anthony"};
        int [] age = new int[3];
        double [] height = new double[3];
        //Input age and height
        for(int i=0; i<friends.length; i++){
            age[i] = sc.nextInt();
            height[i] = sc.nextDouble();
            //Check correct input
            if (age[i] <= 0 || height[i] <= 0) {
                System.out.println("Invalid input! Please enter valid values.");
                i--;
            }
        }
        int youngestIndex = 0;
        int tallestIndex = 0;
        for(int i=1; i<friends.length; i++) {
            if(age[i]<age[youngestIndex]){
                youngestIndex = i; //Youngest
            }
            if(height[i]>height[tallestIndex]){
                tallestIndex = i; //Tallest
            }
        }
        //Output
        System.out.println("Youngest Friend is "+friends[youngestIndex]+" with age " + age[youngestIndex]);
        System.out.println("Tallest Friend is "+friends[tallestIndex]+" with height " + height[tallestIndex]);
    }
}