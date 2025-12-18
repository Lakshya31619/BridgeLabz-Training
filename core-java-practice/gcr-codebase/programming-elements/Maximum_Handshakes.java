import java.util.Scanner;
public class Maximum_Handshakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfStudents = sc.nextInt(); //Number of Students
        int handshakes = (numberOfStudents*(numberOfStudents-1))/2; //Number of Handshakes
        System.out.println("Possible number of handshakes : "+handshakes);
    }
}
