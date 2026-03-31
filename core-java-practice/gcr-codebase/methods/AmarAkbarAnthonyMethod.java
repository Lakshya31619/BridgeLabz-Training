import java.util.Scanner;
public class AmarAkbarAnthonyMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Array to store names of friends
        String[] names = {"Amar", "Akbar", "Anthony"};
        //Array to store ages of friends
        int[] ages = new int[3];
        //Array to store heights of friends
        double[] heights = new double[3];
        //Loop to take input for age and height
        for(int i = 0; i < 3; i++){
            //Input age
            ages[i] = sc.nextInt();
            //Input height
            heights[i] = sc.nextDouble();
        }
        //Calling method findYoungest
        int youngestIndex = findYoungest(ages);
        //Calling method findTallest
        int tallestIndex = findTallest(heights);
        //Output
        System.out.println("Youngest friend is " + names[youngestIndex]);
        System.out.println("Tallest friend is " + names[tallestIndex]);
    }
    //Method to find youngest friend
    public static int findYoungest(int[] ages){
        int minIndex = 0;
        for(int i = 1; i < ages.length; i++){
            if(ages[i] < ages[minIndex]){
                minIndex = i;
            }
        }
        return minIndex;
    }
    //Method to find tallest friend
    public static int findTallest(double[] heights){
        int maxIndex = 0;
        for(int i = 1; i < heights.length; i++){
            if(heights[i] > heights[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}