class ProcessNode {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnaroundTime;
    ProcessNode next;
    ProcessNode(int pid, int burstTime, int priority) {
        this.processId = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.next = null;
    }
}
public class RoundRobin {
    private static ProcessNode head = null;
    private static ProcessNode tail = null;
    //Add process at last
    public static void addProcess(int pid, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(pid, burstTime, priority);
        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        }
    }
    //Remove process by ID
    private static void removeProcess(ProcessNode prev, ProcessNode current) {
        if (current == head && current == tail) {
            head = tail = null;
        } else {
            if (current == head) {
                head = head.next;
                tail.next = head;
            } else if (current == tail) {
                tail = prev;
                tail.next = head;
            } else {
                prev.next = current.next;
            }
        }
    }
    //Display Circular Queue
    public static void displayProcesses() {
        if(head == null) {
            System.out.println("No processes remaining.");
            return;
        }
        ProcessNode temp = head;
        System.out.println("Current Process Queue:");
        do {
            System.out.println("PID: " + temp.processId + ", Remaining Time: " + temp.remainingTime);
            temp = temp.next;
        } while (temp != head);
    }
    //Round Robin Scheduling
    public static void roundRobinSchedule(int timeQuantum) {
        if (head == null) return;
        int currentTime = 0;
        int completedProcesses = 0;
        int totalProcesses = countProcesses();
        ProcessNode current = head;
        ProcessNode prev = tail;
        while (completedProcesses < totalProcesses) {
            if (current.remainingTime > 0) {
                int executionTime = Math.min(timeQuantum, current.remainingTime);
                current.remainingTime -= executionTime;
                currentTime += executionTime;
                //Update waiting time
                ProcessNode temp = head;
                do {
                    if (temp != current && temp.remainingTime > 0) {
                        temp.waitingTime += executionTime;
                    }
                    temp = temp.next;
                } while (temp != head);
                if (current.remainingTime == 0) {
                    current.turnaroundTime = currentTime;
                    completedProcesses++;
                    System.out.println("\nProcess " + current.processId + " completed.");
                    removeProcess(prev, current);
                    current = prev.next;
                } else {
                    prev = current;
                    current = current.next;
                }
                displayProcesses();
            }
        }
        calculateAverages();
    }
    //Count processes
    private static int countProcesses() {
        if (head == null) return 0;
        int count = 0;
        ProcessNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
    //Calculate Averages
    private static void calculateAverages() {
        double totalWT = 0, totalTAT = 0;
        System.out.println("\n--- Scheduling Results ---");
        for (int i = 0; i < finishedIndex; i++) {
            ProcessNode p = finishedProcesses[i];
            System.out.println("PID: " + p.processId + ", Waiting Time: " + p.waitingTime + ", Turnaround Time: " + p.turnaroundTime);
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;
        }
        System.out.println("\nAverage Waiting Time: " + (totalWT / finishedIndex));
        System.out.println("Average Turnaround Time: " + (totalTAT / finishedIndex));
    }
    //Storage for completed processes
    private static ProcessNode[] finishedProcesses = new ProcessNode[10];
    private static int finishedIndex = 0;
    //Modified remove to store finish
    private static void removeProcess(ProcessNode prev, ProcessNode current, boolean store) {
        finishedProcesses[finishedIndex++] = current;
        removeProcess(prev, current);
    }
    //Main class
    public static void main(String[] args) {
        addProcess(1, 10, 1);
        addProcess(2, 5, 2);
        addProcess(3, 8, 1);
        addProcess(4, 6, 3);
        System.out.println("Initial Process Queue:");
        displayProcesses();
        int timeQuantum = 3;
        System.out.println("\nStarting Round Robin Scheduling (Time Quantum = " + timeQuantum + ")");
        roundRobinSchedule(timeQuantum);
    }
}