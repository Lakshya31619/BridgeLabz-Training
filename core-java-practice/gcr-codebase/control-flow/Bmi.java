import java.util.Scanner;
public class Bmi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weight = sc.nextDouble(); //Weight in kg
        double height = sc.nextInt(); //Height in centimeter
        double height_m = height/100; //Convert height to meters
        double bmi = weight/(height_m*height_m); //Formula to generate BMI
        if(bmi<=18.4){
            System.out.println("Underweight");
        }else if(bmi>=18.5 && bmi<=24.9){
            System.out.println("Normal");
        }else if(bmi>=25.0 && bmi<=39.9){
            System.out.println("Overweight");
        }else if(bmi>=40.0){
            System.out.println("Obese");
        }
    }
}