import java.util.ArrayDeque;
import java.util.Queue;
public class QueueCircularBuffer {
    private Queue<Integer> queue;
    private int capacity;
    public QueueCircularBuffer(int capacity) {
        this.capacity = capacity;
        queue = new ArrayDeque<>(capacity);
    }
    public void insert(int value) {
        if (queue.size() == capacity) {
            queue.poll();
        }
        queue.offer(value); 
    }
    public void display() {
        System.out.println("Buffer: " + queue);
    }
    public static void main(String[] args) {
        QueueCircularBuffer cb = new QueueCircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display(); 
        cb.insert(4);
        cb.display();
    }
}