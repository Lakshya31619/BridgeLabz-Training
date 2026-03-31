import java.util.Scanner;
public class Side_Square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int perimeter = sc.nextInt(); //Perimeter of sqaure
        double side = perimeter/4; //Side of sqaure
        System.out.println("The length of the side is "+side+" whose perimeter is "+perimeter);
    }
}