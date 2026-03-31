import java.util.*;
public class EmailNotifications {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList(
                "aman@gmail.com",
                "harshad@gmail.com",
                "lucky@gmail.com"
        );
        emails.forEach(email -> sendEmailNotification(email));
    }
    private static void sendEmailNotification(String email) {
        System.out.println("Notification email sent to: " + email);
    }
}