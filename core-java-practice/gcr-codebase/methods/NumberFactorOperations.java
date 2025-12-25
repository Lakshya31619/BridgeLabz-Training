import java.util.Scanner;
public class NumberFactorOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input number
        int number = sc.nextInt();
        //Calling method findFactors
        int[] factors = findFactors(number);
        //Display factors
        System.out.println("Factors of the number:");
        for(int i = 0; i < factors.length; i++){
            System.out.print(factors[i] + " ");
        }
        System.out.println();
        //Calling method findGreatestFactor
        int greatest = findGreatestFactor(factors);
        System.out.println("Greatest factor: " + greatest);
        //Calling method sumOfFactors
        int sum = sumOfFactors(factors);
        System.out.println("Sum of factors: " + sum);
        //Calling method productOfFactors
        long product = productOfFactors(factors);
        System.out.println("Product of factors: " + product);
        //Calling method productOfCubeOfFactors
        double cubeProduct = productOfCubeOfFactors(factors);
        System.out.println("Product of cube of factors: " + cubeProduct);
    }
    //Method to find factors of a number
    public static int[] findFactors(int number){
        int count = 0;
        //Loop to count factors
        for(int i = 1; i <= number; i++){
            if(number % i == 0){
                count++;
            }
        }
        int[] factors = new int[count];
        int index = 0;
        //Loop to store factors
        for(int i = 1; i <= number; i++){
            if(number % i == 0){
                factors[index] = i;
                index++;
            }
        }
        return factors;
    }
    //Method to find greatest factor
    public static int findGreatestFactor(int[] factors){
        int max = factors[0];
        for(int i = 1; i < factors.length; i++){
            if(factors[i] > max){
                max = factors[i];
            }
        }
        return max;
    }
    //Method to find sum of factors
    public static int sumOfFactors(int[] factors){
        int sum = 0;
        for(int i = 0; i < factors.length; i++){
            sum = sum + factors[i];
        }
        return sum;
    }
    //Method to find product of factors
    public static long productOfFactors(int[] factors){
        long product = 1;
        for(int i = 0; i < factors.length; i++){
            product = product * factors[i];
        }
        return product;
    }
    //Method to find product of cube of factors
    public static double productOfCubeOfFactors(int[] factors){
        double product = 1;
        for(int i = 0; i < factors.length; i++){
            product = product * Math.pow(factors[i], 3);
        }
        return product;
    }
}