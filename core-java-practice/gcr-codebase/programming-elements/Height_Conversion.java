import java.util.Scanner;
public class Height_Conversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double height_cm = sc.nextInt(); //input height in centimeters
        double height_inch = (height_cm/2.54); // height in inches
        double height_feet = (height_inch/12); //height in feet
        System.out.println("Your Height in cm is "+height_cm+" while in feet is "+height_feet+" and inches is "+height_inch);
    }
}
