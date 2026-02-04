package NotificationFiltering;
import java.util.function.Predicate;
public class AlertFilter {
    public static Predicate<Alert> criticalOnly() {
        return alert -> alert.getType().equalsIgnoreCase("CRITICAL");
    }
    public static Predicate<Alert> highPriorityOnly() {
        return alert -> alert.getPriority() == 1;
    }
    public static Predicate<Alert> medicationOnly() {
        return alert -> alert.getType().equalsIgnoreCase("MEDICATION");
    }
}