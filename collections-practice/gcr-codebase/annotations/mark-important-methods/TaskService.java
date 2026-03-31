public class TaskService {
    @ImportantMethod
    public void processPayment() {
        System.out.println("Processing payment...");
    }
    @ImportantMethod(level = "MEDIUM")
    public void sendEmail() {
        System.out.println("Sending email...");
    }
    public void generateReport() {
        System.out.println("Generating report...");
    }
}