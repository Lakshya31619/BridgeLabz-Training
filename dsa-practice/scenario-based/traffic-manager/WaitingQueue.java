public class WaitingQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    public WaitingQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = -1;
        rear = -1;
    }
    public boolean isFull() {
        return rear == capacity - 1;
    }
    public boolean isEmpty() {
        return front == -1 || front > rear;
    }
    public void enqueue(int id) {
        if (isFull()) {
            System.out.println("Queue Overflow! Vehicle " + id + " cannot enter.");
            return;
        }
        if (front == -1)
            front = 0;
        queue[++rear] = id;
        System.out.println("Vehicle " + id + " added to waiting queue.");
    }
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! No vehicles waiting.");
            return -1;
        }
        return queue[front++];
    }
}