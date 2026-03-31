import java.util.Scanner;
public class BmiCalculatorMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //2D array to store weight, height and BMI for 10 persons
        double[][] data = new double[10][3];
        //Array to store BMI status of 10 persons
        String[] status = new String[10];
        //Loop to take input for weight and height
        for(int i = 0; i < data.length; i++){
            //Input weight in kg
            data[i][0] = sc.nextDouble();
            //Input height in cm
            data[i][1] = sc.nextDouble();
        }
        //Calling method calculateBMI
        calculateBMI(data);
        //Calling method getBMIStatus
        status = getBMIStatus(data);
        //Output height, weight, BMI and status
        for(int i = 0; i < data.length; i++){
            System.out.println("Person " + (i + 1) +" Weight: " + data[i][0] +" Height: " + data[i][1] +" BMI: " + data[i][2] +" Status: " + status[i]);
        }
    }
    //Method to calculate BMI and populate array
    public static void calculateBMI(double[][] data){
        for(int i = 0; i < data.length; i++){
            //Convert height from cm to meters
            double heightInMeters = data[i][1] / 100;
            //BMI calculation
            data[i][2] = data[i][0] / (heightInMeters * heightInMeters);
        }
    }
    //Method to determine BMI status
    public static String[] getBMIStatus(double[][] data){
        String[] result = new String[data.length];
        for(int i = 0; i < data.length; i++){
            double bmi = data[i][2];
            if(bmi <= 18.4){
                result[i] = "Underweight";
            }else if(bmi >= 18.5 && bmi <= 24.9){
                result[i] = "Normal";
            }else if(bmi >= 25.0 && bmi <= 39.9){
                result[i] = "Overweight";
            }else{
                result[i] = "Obese";
            }
        }
        return result;
    }
}