import java.util.Scanner;
public class TrigonometricFunctions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input angle in degrees
        double angle = sc.nextDouble();
        //Calling method findTrigonometry
        double [] trigono = findTrigonometry(angle);
        //Output
        System.out.println("Sine Function : "+trigono[0]);
        System.out.println("Cosine Function : "+trigono[1]);
        System.out.println("Tangent Function : "+trigono[2]);
    }
    //Method for calculating sine, cose and tangent
    public static double [] findTrigonometry(double angle){
        double radian = (Math.PI*angle)/180.0;
        double sine = Math.sin(radian);
        double cose = Math.cos(radian);
        double tangent = Math.tan(radian);
        return new double[]{sine, cose, tangent};
    }
}