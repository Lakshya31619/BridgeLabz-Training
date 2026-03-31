import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
public class QueueReverse {
    public static Queue<Integer> reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()){
            stack.push(queue.poll());
        }
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }
        return queue;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in queue : ");
        int n = sc.nextInt();
        Queue <Integer> queue = new LinkedList<>();
        System.out.print("Enter elements in queue : ");
        for(int i=0; i<n; i++){
            queue.offer(sc.nextInt());
        }
        System.out.println("Reversed Queue : "+reverse(queue));
    }
}