import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
public class QueueStackImplement {
    static class StackUsingQueue {
        private Queue<Integer> q1;
        private Queue<Integer> q2;
        public StackUsingQueue() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }
        public void push(int x) {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }
        public Integer pop() {
            return q1.remove();
        }
        public Integer top() {
            return q1.peek();
        }
        public boolean empty() {
            return q1.isEmpty();
        }
    }
    public static void main(String[] args) {
        StackUsingQueue q = new StackUsingQueue();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of queue elements : ");
        int n = sc.nextInt();
        System.out.print("Enter queue elements : ");
        for(int i=0; i<n; i++){
            q.push(sc.nextInt());
        }
        System.out.println("Pop Operation : "+q.pop());
        System.out.println("Top Operation : "+q.top());
        System.out.println("Empty Operation : "+q.empty());
    }
}