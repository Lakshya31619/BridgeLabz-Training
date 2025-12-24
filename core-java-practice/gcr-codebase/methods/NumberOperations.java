import java.util.Scanner;
public class NumberOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input a number
        int n = sc.nextInt();
        //Calling method findFactors
        int [] factors = findFactors(n);
        //Calling method sumFactors
        int sum = sumFactors(factors);
        //Calling method productFactors
        int product = productFactors(factors);
        //Calling method sumSquareFactors
        int sumSquare = sumSquareFactors(factors);
        //Output
        System.out.print("Factors of "+n+" : ");
        for(int i=0; i<factors.length; i++){
            System.out.print(factors[i]+" ");
        }
        System.out.println("\nSum of Factors : "+sum);
        System.out.println("Product of Factors : "+product);
        System.out.println("Sum of Square of Factors : "+sumSquare);
    }
    //Method to find factors of number
    public static int[] findFactors(int n){
        int len = 0;
        for(int i=1; i<=n; i++){
            if(n%i==0){
                len++;
            }
        }
        int [] factors = new int[len];
        int index = 0;
        for(int i=1; i<=n; i++){
            if(n%i==0){
                factors[index++] = i;
            }
        }
        return factors;
    }
    //Method to find sum of Factors
    public static int sumFactors(int [] factors){
        int sum = 0;
        for(int i=0; i<factors.length; i++){
            sum += factors[i];
        }
        return sum;
    }
    //Method to find product of factors
    public static int productFactors(int [] factors){
        int product = 1;
        for(int i=0; i<factors.length; i++){
            product *= factors[i];
        }
        return product;
    }
    //Method to find sum of square factors
    public static int sumSquareFactors(int [] factors){
        int [] squareFactors = new int[factors.length];
        for(int i=0; i<factors.length; i++){
            squareFactors[i] = (int)Math.pow(factors[i], 2);
        }
        int sumSquare = sumFactors(squareFactors);
        return sumSquare;
    }
}