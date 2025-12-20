import java.util.Scanner;
public class LargestSecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //Check positive number
        if(n<0){
            System.out.println("Error: Please enter a positive number.");
            return;
        }
        int maxDigit = 10;
        int [] digits = new int[maxDigit];
        int index = 0;
        //Put all digits of number in array
        while(n!=0 && index<maxDigit) {
            digits[index] = n%10;
            n = n/10;
            index++;
        }
        if(index<2){
            System.out.println("Not enough digits to find second largest.");
            return;
        }
        int largest = 0;
        int secondLargest = 0;
        //Check largest and second largest
        for(int i=0; i<index; i++){
            if(digits[i]>largest){
                secondLargest = largest;
                largest = digits[i];
            }else if(digits[i]>secondLargest && digits[i]!=largest){
                secondLargest = digits[i];
            }
        }
        System.out.println("Largest digit is " + largest);
        System.out.println("Second largest digit is " + secondLargest);
    }
}