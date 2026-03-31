import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class QueueGenerateBinary {
    public static Queue<String> generateBinary(int n){
        Queue<String> queue = new LinkedList<>();
        for(int i=1; i<=n; i++){
            queue.add(Integer.toBinaryString(i));
        }
        return queue;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in queue : ");
        int n = sc.nextInt();
        System.out.println("Binary String Queue upto "+n+" digits : "+generateBinary(n));
    }
}