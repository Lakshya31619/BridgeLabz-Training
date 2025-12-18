import java.util.Scanner;
public class Area_Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int base_cm = sc.nextInt(); //Base in centimeters
        int height_cm = sc.nextInt(); //Height in centimeters
        double base_inches = base_cm/2.54; //Base in inches
        double height_inches = height_cm/2.54; //Height in inches
        double area_cm = (base_cm*height_cm)/2; //Area in sqaure centimeters
        double area_inches = (base_inches*height_inches)/2; //Area in sqaure inches
        System.out.println("Area of Triangle in square centimeters is "+area_cm+" and square inches is "+area_inches);
    }
}
