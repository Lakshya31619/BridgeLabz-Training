import java.util.Scanner;
public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //Check positive number
        if(n<0){
            System.out.println("Please enter a positive number.");
            return;
        }
        if(n==0){
            System.out.println("Reversed number : 0");
            return;
        }
        int temp = n;
        int count = 0;
        //Count digits
        while (temp != 0) {
            count++;
            temp = temp / 10;
        }
        //Reverse Array
        int [] digits = new int[count];
        int index = 0;
        while(n!=0){
            digits[index++] = n%10;
            n /= 10;
        }
        //Output
        System.out.print("Reversed number: ");
        for(int i=0; i<count; i++){
            System.out.print(digits[i]);
        }
    }
}