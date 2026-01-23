import java.util.Scanner;
import java.util.PriorityQueue;
public class QueueHospitalTriage {
    public static void givePriority(String[][] patients){
        PriorityQueue<String[]> pq = new PriorityQueue<>((a, b) -> Integer.parseInt(b[1]) - Integer.parseInt(a[1]));
        for(String[] patient : patients){
            pq.add(patient);
        }
        System.out.println("Order by Priority : ");
        while(!pq.isEmpty()){
            String[] p = pq.poll();
            System.out.print(p[0]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of patients : ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("*Enter patient details*");
        String [][] patients = new String[n][2];
        for(int i=0; i<n; i++){
            System.out.print("Enter name : ");
            patients[i][0] = sc.nextLine();
            System.out.print("Enter patient priority : ");
            patients[i][1] = sc.nextLine();
        }
        givePriority(patients);
    }
}