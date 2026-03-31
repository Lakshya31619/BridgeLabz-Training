import java.util.Scanner;
public class NumberCheckerI {
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
        //Calling method isDuckNumber
        boolean duck = isDuckNumber(digits);
        if(duck){
            System.out.println("The number is a duck number");
        }else{
            System.out.println("The number is not a duck number");
        }
        //Calling method isArmstrongNumber
        boolean armstrong = isArmstrongNumber(digits, count);
        if(armstrong){
            System.out.println("The number is an armstrong number");
        }else{
            System.out.println("The number is not an armstrong number");
        }
        //Calling method findLargestAndSecondLargest
        findLargestAndSecondLargest(digits);
        //Calling method findSmallestAndSecondSmallest
        findSmallestAndSecondSmallest(digits);
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
    //Method to store digits of number in array
    public static int[] storeDigits(int number, int count){
        int[] digits = new int[count];
        int temp = number;
        for(int i = count - 1; i >= 0; i--){
            digits[i] = temp % 10;
            temp = temp / 10;
        }
        return digits;
    }
    //Method to check duck number
    public static boolean isDuckNumber(int[] digits){
        for(int i = 0; i < digits.length; i++){
            if(digits[i] != 0){
                return true;
            }
        }
        return false;
    }
    //Method to check armstrong number
    public static boolean isArmstrongNumber(int[] digits, int count){
        int sum = 0;
        for(int i = 0; i < digits.length; i++){
            sum = sum + (int)Math.pow(digits[i], count);
        }
        int original = 0;
        for(int i = 0; i < digits.length; i++){
            original = original * 10 + digits[i];
        }
        if(sum == original){
            return true;
        }
        return false;
    }
    //Method to find largest and second largest digits
    public static void findLargestAndSecondLargest(int[] digits){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i = 0; i < digits.length; i++){
            if(digits[i] > largest){
                secondLargest = largest;
                largest = digits[i];
            }else if(digits[i] > secondLargest && digits[i] != largest){
                secondLargest = digits[i];
            }
        }
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
    }
    //Method to find smallest and second smallest digits
    public static void findSmallestAndSecondSmallest(int[] digits){
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for(int i = 0; i < digits.length; i++){
            if(digits[i] < smallest){
                secondSmallest = smallest;
                smallest = digits[i];
            }else if(digits[i] < secondSmallest && digits[i] != smallest){
                secondSmallest = digits[i];
            }
        }
        System.out.println("Smallest digit: " + smallest);
        System.out.println("Second smallest digit: " + secondSmallest);
    }
}