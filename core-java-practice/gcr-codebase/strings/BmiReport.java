import java.util.Scanner;
public class BmiReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int persons = sc.nextInt();
        double [][] data = input(persons);
        String [][] bmiReport = calculate(data);
        displayReport(bmiReport);
    }
    //Input data
    public static double[][] input(int persons) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[persons][2];
        for (int i = 0; i < persons; i++) {
            //Enter weight (in kilograms)
            data[i][0] = sc.nextDouble();
            //Enter height (in centimeters)
            data[i][1] = sc.nextDouble();
        }
        return data;
    }
    //Calculate BMI and status, return 2D String array
    public static String[][] calculate(double[][] data) {
        String[][] result = new String[data.length][4];
        for(int i=0; i<data.length; i++){
            double weight = data[i][0];
            double height_cm = data[i][1];
            double height_m = height_cm / 100;
            double bmi = weight / (height_m * height_m);
            bmi = Math.round(bmi * 100.0) / 100.0;
            String status;
            if (bmi <= 18.4)
                status = "Underweight";
            else if (bmi <= 24.9)
                status = "Normal";
            else if (bmi <= 39.9)
                status = "Overweight";
            else
                status = "Obese";

            result[i][0] = String.valueOf(height_cm);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.valueOf(bmi);
            result[i][3] = status;
        }
        return result;
    }
    //Output
    public static void displayReport(String[][] report) {
        for (int i = 0; i < report.length; i++) {
            System.out.println("Person : " + (i + 1) +" | Height : " + report[i][0] +" | Weight : " + report[i][1] +" | BMI : " + report[i][2] +" | Status : " + report[i][3]);
        }
    } 
}