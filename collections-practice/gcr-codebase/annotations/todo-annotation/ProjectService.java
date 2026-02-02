public class ProjectService {
    @Todo(
        task = "Implement user authentication",
        assignedTo = "Alice",
        priority = "HIGH"
    )
    public void loginFeature() {
        System.out.println("Login feature pending...");
    }
    @Todo(
        task = "Add email notification service",
        assignedTo = "Bob"
    )
    public void emailNotification() {
        System.out.println("Email notification pending...");
    }
    @Todo(
        task = "Optimize database queries",
        assignedTo = "Charlie",
        priority = "LOW"
    )
    public void optimizeDB() {
        System.out.println("DB optimization pending...");
    }
}