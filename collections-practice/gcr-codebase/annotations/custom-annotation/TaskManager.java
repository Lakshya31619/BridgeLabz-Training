public class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "Lakshya")
    public void completeTask() {
        System.out.println("Task is being completed...");
    }
}
