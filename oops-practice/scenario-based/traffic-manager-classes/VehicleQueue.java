class VehicleQueue {
    private String[] queue;
    private int front, rear, size, capacity;
    VehicleQueue(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    public boolean isFull() {
        return size == capacity;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void enqueue(String vehicle) {
        if (isFull()) {
            System.out.println("Queue Overflow: Vehicle " + vehicle + " cannot enter");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = vehicle;
        size++;
        System.out.println("Vehicle " + vehicle + " waiting to enter roundabout");
    }
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow: No vehicles waiting");
            return null;
        }
        String vehicle = queue[front];
        front = (front + 1) % capacity;
        size--;
        return vehicle;
    }
}