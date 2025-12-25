import java.util.Scanner;
public class NumberCheckerII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input number
        int number = sc.nextInt();
        //Calling method countDigits
        int count = countDigits(number);
        //Output
        System.out.println("Number of digits: " + count);
        //Calling method storeDigits
        int[] digits = storeDigits(number, count);
        //Calling method sumOfDigits
        int sum = sumOfDigits(digits);
        //Output
        System.out.println("Sum of digits: " + sum);
        //Calling method sumOfSquaresOfDigits
        int squareSum = sumOfSquaresOfDigits(digits);
        //Output
        System.out.println("Sum of squares of digits: " + squareSum);
        //Calling method isHarshadNumber
        boolean harshad = isHarshadNumber(number, digits);
        if(harshad){
            System.out.println("The number is a Harshad number");
        }else{
            System.out.println("The number is not a Harshad number");
        }
        //Calling method digitFrequency
        int[][] frequency = digitFrequency(digits);
        //Output digit frequency
        System.out.println("Digit Frequency:");
        for(int i = 0; i < frequency.length; i++){
            if(frequency[i][1] > 0){
                System.out.println("Digit " + frequency[i][0] + " occurs " + frequency[i][1] + " times");
            }
        }
    }
    //Method to count digits in a number
    public static int countDigits(int number){
        int count = 0;
        int temp = number;
        while(temp != 0){
            count++;
            temp = temp / 10;
        }
        return count;
    }
    //Method to store digits in array
    public static int[] storeDigits(int number, int count){
        int[] digits = new int[count];
        int temp = number;
        for(int i = count - 1; i >= 0; i--){
            digits[i] = temp % 10;
            temp = temp / 10;
        }
        return digits;
    }
    //Method to find sum of digits
    public static int sumOfDigits(int[] digits){
        int sum = 0;
        for(int i = 0; i < digits.length; i++){
            sum = sum + digits[i];
        }
        return sum;
    }
    //Method to find sum of squares of digits
    public static int sumOfSquaresOfDigits(int[] digits){
        int sum = 0;
        for(int i = 0; i < digits.length; i++){
            sum = sum + (int)Math.pow(digits[i], 2);
        }
        return sum;
    }
    //Method to check Harshad number
    public static boolean isHarshadNumber(int number, int[] digits){
        int sum = sumOfDigits(digits);
        if(sum != 0 && number % sum == 0){
            return true;
        }
        return false;
    }
    //Method to find frequency of each digit
    public static int[][] digitFrequency(int[] digits){
        int[][] freq = new int[10][2];
        //Initialize digits column
        for(int i = 0; i < 10; i++){
            freq[i][0] = i;
            freq[i][1] = 0;
        }
        //Count frequency
        for(int i = 0; i < digits.length; i++){
            freq[digits[i]][1]++;
        }
        return freq;
    }
}