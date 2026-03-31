import java.util.Scanner;
public class FactorsArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<=0){
            System.out.println("The number is not positive.");
            return;
        }
        int maxFactor = 10;
        int [] factors = new int[maxFactor];
        int index = 0;
        //Factors of number
        for(int i=1; i<=n; i++){
            if(n%i==0){
                //Increase size of Array
                if (index == maxFactor) {
                    maxFactor = maxFactor * 2;
                    //Copy data to new array
                    int[] temp = new int[maxFactor];
                    for(int j=0; j<factors.length; j++){
                        temp[j] = factors[j];
                    }
                    factors = temp;
                }
                factors[index++] = i;
            }
        }
        System.out.print("Factors of " + n + " : ");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }
    }
}