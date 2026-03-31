import java.util.Scanner;
public class BmiCalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        //Multi-dimensional array
        double[][] personData = new double[n][3];
        String[] weightStatus = new String[n];
        //input for weight and height
        for(int i=0; i<n; i++){
            personData[i][0] = sc.nextDouble();
            personData[i][1] = sc.nextDouble();
            if(personData[i][0] <= 0 || personData[i][1] <= 0) {
                System.out.println("Please enter positive values.");
                i--;
            }
        }
        //Calculate BMI
        for(int i=0; i<n; i++){
            double weight = personData[i][0];
            double height = personData[i][1];
            personData[i][2] = weight / (height * height);
            if(personData[i][2]<=18.4){
                weightStatus[i] = "Underweight";
            }else if(personData[i][2]<=24.9){
                weightStatus[i] = "Normal";
            }else if(personData[i][2]<=39.9){
                weightStatus[i] = "Overweight";
            }else{
                weightStatus[i] = "Obese";
            }
        }
        //output
        for(int i=0; i<n; i++){
            System.out.printf("Person "+(i+1)+" : "+"Height "+personData[i][1]+"| Weight "+personData[i][0]+"| BMI "+personData[i][2]+"| Status "+weightStatus[i]);
        }
    }
}