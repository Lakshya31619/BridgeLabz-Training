import java.util.Scanner;
public class SumUntilBreak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double [] nums = new double[n];
        int i = 0;
        while(true){
            if(i==n || i==10){
                break;
            }
            double val = sc.nextDouble();
            if(val<=0){
                break;
            }
            nums[i++] = val;
        }
        double sum = 0.0;
        for(int j=0; j<n; j++){
            sum += nums[j];
        }
        System.out.println(sum);
    }
}