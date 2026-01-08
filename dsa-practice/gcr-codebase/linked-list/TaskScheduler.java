class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;
    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}
public class TaskScheduler {
    private static TaskNode head = null;
    private static TaskNode tail = null;
    //Add at beginning
    public static void insertAtBeginning(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
    }
    //Add at last
    public static void insertAtEnd(int id, String name, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = head;
            tail.next = newNode;
            tail = newNode;
        }
    }
    //Add at specific position
    public static void insertAtPosition(int id, String name, int priority, String dueDate, int position) {
        if (position <= 0) {
            System.out.println("Invalid position!");
            return;
        }
        if (position == 1) {
            insertAtBeginning(id, name, priority, dueDate);
            return;
        }
        TaskNode temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        if (temp == tail) {
            insertAtEnd(id, name, priority, dueDate);
            return;
        }
        TaskNode newNode = new TaskNode(id, name, priority, dueDate);
        newNode.next = temp.next;
        temp.next = newNode;
    }
    //Remove task by ID
    public static void deleteById(int id) {
        if (head == null) {
            System.out.println("Task list is empty!");
            return;
        }
        if (head == tail && head.taskId == id) {
            head = tail = null;
            return;
        }
        if (head.taskId == id) {
            head = head.next;
            tail.next = head;
            return;
        }
        TaskNode current = head;
        while (current.next != head && current.next.taskId != id) {
            current = current.next;
        }
        if (current.next == head) {
            System.out.println("Task not found!");
            return;
        }
        if (current.next == tail) {
            tail = current;
        }
        current.next = current.next.next;
    }
    //View current task and move next
    public static void viewAndMoveNext() {
        if (head == null) {
            System.out.println("No tasks available!");
            return;
        }
        System.out.println("Current Task:");
        displayTask(head);
        head = head.next;
        tail = tail.next;
    }
    //Display all tasks
    public static void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }
        TaskNode temp = head;
        System.out.println("\nTask List:");
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }
    //Search task by priority
    public static void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks available!");
            return;
        }
        TaskNode temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found)
            System.out.println("No task found with priority: " + priority);
    }
    //Display
    private static void displayTask(TaskNode t) {
        System.out.println("ID: " + t.taskId + ", Name: " + t.taskName + ", Priority: " + t.priority + ", Due Date: " + t.dueDate);
    }
    //Main class
    public static void main(String[] args) {
        insertAtBeginning(1, "Design Module", 1, "2026-01-10");
        insertAtEnd(2, "Implement Code", 2, "2026-01-15");
        insertAtEnd(3, "Testing", 3, "2026-01-20");
        insertAtPosition(4, "Documentation", 2, "2026-01-18", 2);
        displayTasks();
        System.out.println("\nView & Move Next:");
        viewAndMoveNext();
        viewAndMoveNext();
        System.out.println("\nSearch tasks with priority 2:");
        searchByPriority(2);
        System.out.println("\nDeleting task with ID 1:");
        deleteById(1);
        displayTasks();
    }
}