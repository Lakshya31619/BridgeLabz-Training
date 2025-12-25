import java.util.Scanner;
public class NumberCheckerIII {
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
        //Calling method reverseDigits
        int[] reversedDigits = reverseDigits(digits);
        //Calling method compareArrays
        boolean equal = compareArrays(digits, reversedDigits);
        if(equal){
            System.out.println("Original and reversed arrays are equal");
        }else{
            System.out.println("Original and reversed arrays are not equal");
        }
        //Calling method isPalindrome
        boolean palindrome = isPalindrome(digits, reversedDigits);
        if(palindrome){
            System.out.println("The number is a palindrome");
        }else{
            System.out.println("The number is not a palindrome");
        }
        //Calling method isDuckNumber
        boolean duck = isDuckNumber(digits);
        if(duck){
            System.out.println("The number is a duck number");
        }else{
            System.out.println("The number is not a duck number");
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
    //Method to reverse digits array
    public static int[] reverseDigits(int[] digits){
        int[] reversed = new int[digits.length];
        int index = 0;
        for(int i = digits.length - 1; i >= 0; i--){
            reversed[index] = digits[i];
            index++;
        }
        return reversed;
    }
    //Method to compare two arrays
    public static boolean compareArrays(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length){
            return false;
        }
        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
    //Method to check palindrome number
    public static boolean isPalindrome(int[] digits, int[] reversedDigits){
        return compareArrays(digits, reversedDigits);
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
}