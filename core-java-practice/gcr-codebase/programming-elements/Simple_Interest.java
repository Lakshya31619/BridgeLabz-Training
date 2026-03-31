import java.util.*;
public class Simple_Interest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int r = sc.nextInt();
        int t = sc.nextInt();
        System.out.println((p*r*t)/100);
    }
}
