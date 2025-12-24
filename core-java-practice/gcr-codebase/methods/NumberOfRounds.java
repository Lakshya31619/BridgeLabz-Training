import java.util.Scanner;
public class NumberOfRounds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input sides of triangle in m
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        //Given distance in m
        int distance = 5000;
        //Formula of perimeter of triangle
        int perimeter = a+b+c;
        //Calling rounds method
        int round = rounds(distance, perimeter);
        //Output
        System.out.println("Number of rounds : "+round);
    }
    //Method to calculate no. of rounds
    public static int rounds(int distance, int perimeter){
        //Calculate number of rounds
        int round = distance/perimeter;
        return round;
    }
}