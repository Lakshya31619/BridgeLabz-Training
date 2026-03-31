import java.util.Scanner;
public class NumberChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Array to store 5 numbers
        int[] numbers = new int[5];
        //Loop to take input and analyze numbers
        for(int i = 0; i < numbers.length; i++){
            //Input number
            numbers[i] = sc.nextInt();
            //Calling method isPositive
            boolean positive = isPositive(numbers[i]);
            //Check positive or negative
            if(positive){
                //Calling method isEven
                boolean even = isEven(numbers[i]);
                if(even){
                    System.out.println(numbers[i] + " is positive and even");
                }else{
                    System.out.println(numbers[i] + " is positive and odd");
                }
            }else{
                System.out.println(numbers[i] + " is negative");
            }
        }
        //Calling method compare for first and last elements
        int result = compare(numbers[0], numbers[numbers.length - 1]);
        //Output comparison result
        if(result == 1){
            System.out.println("First element is greater than last element");
        }else if(result == 0){
            System.out.println("First element is equal to last element");
        }else{
            System.out.println("First element is less than last element");
        }
    }
    //Method to check positive or negative
    public static boolean isPositive(int number){
        if(number >= 0){
            return true;
        }
        return false;
    }
    //Method to check even or odd
    public static boolean isEven(int number){
        if(number % 2 == 0){
            return true;
        }
        return false;
    }
    //Method to compare two numbers
    public static int compare(int num1, int num2){
        if(num1 > num2){
            return 1;
        }else if(num1 == num2){
            return 0;
        }
        return -1;
    }
}