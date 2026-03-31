import java.util.Scanner;
public class CollinearAreaTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input coordinates of point A
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        //Input coordinates of point B
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        //Input coordinates of point C
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        //Calling method checkCollinearBySlope
        boolean slopeResult = checkCollinearBySlope(x1, y1, x2, y2, x3, y3);
        //Output
        if(slopeResult){
            System.out.println("Points are collinear using slope method");
        }else{
            System.out.println("Points are not collinear using slope method");
        }
        //Calling method checkCollinearByArea
        boolean areaResult = checkCollinearByArea(x1, y1, x2, y2, x3, y3);
        //Output
        if(areaResult){
            System.out.println("Points are collinear using area method");
        }else{
            System.out.println("Points are not collinear using area method");
        }
    }
    //Method to check collinearity using slope formula
    public static boolean checkCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3){
        //Slope AB
        double slopeAB = (double)(y2 - y1) / (x2 - x1);
        //Slope BC
        double slopeBC = (double)(y3 - y2) / (x3 - x2);
        //Slope AC
        double slopeAC = (double)(y3 - y1) / (x3 - x1);
        if(slopeAB == slopeBC && slopeBC == slopeAC){
            return true;
        }
        return false;
    }
    //Method to check collinearity using area of triangle
    public static boolean checkCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3){
        //Area of triangle formula
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));

        if(area == 0){
            return true;
        }
        return false;
    }
}