import java.util.*;
public class EventAttendeeWelcomeMessage {
    public static void main(String[] args) {
        List<String> attendees = Arrays.asList(
                "Amit",
                "Riya",
                "John",
                "Sara"
        );
        attendees.forEach(attendee ->
                System.out.println("Welcome to the event, " + attendee + "!")
        );
    }
}