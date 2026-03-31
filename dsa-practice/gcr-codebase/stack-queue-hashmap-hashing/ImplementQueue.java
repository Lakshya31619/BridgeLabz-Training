import java.util.Scanner;
import java.util.Stack;
class Queue{
    private Stack<Integer> in;
    private Stack<Integer> out;
    public Queue(){
        in = new Stack<>();
        out = new Stack<>();
    }
    public void enqueue(int val){
        in.push(val);
    }
    public int dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        if(out.isEmpty()){
            transfer();
        }
        return out.pop();
    }
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        if(out.isEmpty()){
            transfer();
        }
        return out.peek();
    }
    public boolean isEmpty(){
        return in.isEmpty() && out.isEmpty();
    }
    private void transfer(){
        while(!in.isEmpty()){
            out.push(in.pop());
        }
    }
}
public class ImplementQueue{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();
        System.out.print("Number of elements in queue : ");
        int n = sc.nextInt();
        System.out.println("Enter queue elements : ");
        for(int i=0; i<n; i++){
            q.enqueue(sc.nextInt());
        }
        System.out.println(q.dequeue());
        System.out.println(q.peek());
        System.out.println(q.dequeue());
    }
}