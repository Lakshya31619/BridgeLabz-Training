import java.util.Scanner;
public class LargestSecondLargestDynamic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //Check positive number
        if(n<0) {
            System.out.println("Please enter a positive number.");
            return;
        }
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        while (n!= 0) {
            //Increase array size
            if (index == maxDigit) {
                maxDigit = maxDigit + 10;
                int[] temp = new int[maxDigit];
                //Copy existing digits
                for(int i=0; i<digits.length; i++){
                    temp[i] = digits[i];
                }
                digits = temp;
            }
            digits[index] = n%10;
            n = n/10;
            index++;
        }
        if(index<2) {
            System.out.println("Not enough digits to find second largest.");
            return;
        }
        int largest = 0;
        int secondLargest = 0;
        for(int i=0; i<index; i++){
            if(digits[i]>largest) {
                secondLargest = largest;
                largest = digits[i];
            }else if(digits[i]>secondLargest && digits[i]!=largest){
                secondLargest = digits[i];
            }
        }
        //Output
        System.out.println("Largest digit is " + largest);
        System.out.println("Second largest digit is " + secondLargest);
    }
}