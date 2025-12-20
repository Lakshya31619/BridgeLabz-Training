import java.util.Scanner;
public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong(); //Input number
        long temp = number;
        int count = 0;
        //Digits to array
        while(temp!=0){
            temp /= 10;
            count++;
        }
        int [] digits = new int[count];
        temp = number;
        for(int i=count-1; i>=0; i--){
            digits[i] = (int)(temp % 10);
            temp /= 10;
        }
        //Calculate frequency
        int [] frequency = new int[10];
        for(int i=0; i<digits.length; i++){
            frequency[digits[i]]++;
        }
        //Output
        for(int i=0; i<10; i++){
            if(frequency[i]>0){
                System.out.println("Digit " + i + " occurs " + frequency[i] + " time(s).");
            }
        }
    }
}