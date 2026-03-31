import java.util.*;
public class Celsius_to_Fahrenheit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        System.out.println((c * 9.0/5.0) + 32);
    }
}