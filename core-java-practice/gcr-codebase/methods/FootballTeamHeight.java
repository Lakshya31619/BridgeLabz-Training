import java.util.Random;
public class FootballTeamHeight {
    public static void main(String[] args) {
        //Array to store heights of 11 players
        int[] heights = new int[11];
        Random rand = new Random();
        //Generate random heights between 150 and 250 cms
        for(int i = 0; i < heights.length; i++){
            heights[i] = rand.nextInt(101) + 150;
        }
        //Calling method to find sum of heights
        int sum = findSum(heights);
        //Calling method to find mean height
        double mean = findMean(heights);
        //Calling method to find shortest height
        int shortest = findShortest(heights);
        //Calling method to find tallest height
        int tallest = findTallest(heights);
        //Final Output
        System.out.println("Sum of heights: " + sum);
        System.out.println("Mean height: " + mean);
        System.out.println("Shortest height: " + shortest);
        System.out.println("Tallest height: " + tallest);
    }
    //Method to find sum of all elements
    public static int findSum(int[] heights){
        int sum = 0;
        for(int i = 0; i < heights.length; i++){
            sum = sum + heights[i];
        }
        return sum;
    }
    //Method to find mean height
    public static double findMean(int[] heights){
        int sum = findSum(heights);
        return (double) sum / heights.length;
    }
    //Method to find shortest height
    public static int findShortest(int[] heights){
        int min = heights[0];
        for(int i = 1; i < heights.length; i++){
            if(heights[i] < min){
                min = heights[i];
            }
        }
        return min;
    }
    //Method to find tallest height
    public static int findTallest(int[] heights){
        int max = heights[0];
        for(int i = 1; i < heights.length; i++){
            if(heights[i] > max){
                max = heights[i];
            }
        }
        return max;
    }
}