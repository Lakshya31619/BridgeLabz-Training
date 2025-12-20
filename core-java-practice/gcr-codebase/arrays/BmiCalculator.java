import java.util.Scanner;
public class BmiCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //Number of person
        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];
        //Input
        for(int i=0; i<n; i++){
            weight[i] = sc.nextDouble();
            height[i] = sc.nextDouble();
        }
        //BMI Calculation
        for(int i=0; i<n; i++){
            bmi[i] = weight[i]/(height[i]*height[i]);
            if(bmi[i]<=18.4){
                status[i] = "Underweight";
            }else if(bmi[i]<=24.9){
                status[i] = "Normal";
            }else if(bmi[i]<=39.9){
                status[i] = "Overweight";
            }else{
                status[i] = "Obese";
            }
        }
        //Output
        for(int i=0; i<n; i++){
            System.out.printf("Person "+(i+1)+" : "+"Height "+height[i]+"| Weight "+weight[i]+"| BMI "+bmi[i]+"| Status "+status[i]);
        }
    }
}