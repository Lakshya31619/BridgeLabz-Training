import java.util.Scanner;
public class MultiplicationSixNine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int [] multiplication = new int [4]; //Initialize array of size 4(6-9)
        int index = 0; //For multiplication index pointer
        for(int i=6; i<=9; i++){
            multiplication[index++] = number*i;
        }
        index = 0;
        for(int i=6; i<=9; i++){
            System.out.println(number+" * "+i+" = "+multiplication[index++]);
        }
    }
}