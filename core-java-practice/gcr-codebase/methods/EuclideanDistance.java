import java.util.Scanner;
public class EuclideanDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input coordinates of first point
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        //Input coordinates of second point
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        //Calling method to find Euclidean distance
        double distance = findDistance(x1, y1, x2, y2);
        //Output
        System.out.println("Euclidean Distance: " + distance);
        //Calling method to find equation of line
        double[] line = findLineEquation(x1, y1, x2, y2);
        //Output slope and y-intercept
        System.out.println("Slope (m): " + line[0]);
        System.out.println("Y-Intercept (b): " + line[1]);
        System.out.println("Equation of line: y = " + line[0] + "x + " + line[1]);
    }
    //Method to find Euclidean distance between two points
    public static double findDistance(double x1, double y1, double x2, double y2){
        double dx = x2 - x1;
        double dy = y2 - y1;
        double distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        return distance;
    }
    //Method to find equation of line (slope and y-intercept)
    public static double[] findLineEquation(double x1, double y1, double x2, double y2){
        double[] result = new double[2];
        //Calculate slope
        double m = (y2 - y1) / (x2 - x1);
        //Calculate y-intercept
        double b = y1 - m * x1;
        result[0] = m;
        result[1] = b;
        return result;
    }
}