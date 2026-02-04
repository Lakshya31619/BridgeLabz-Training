package NotificationFiltering;
import java.util.*;
import java.util.function.Predicate;
public class HospitalMain {
    public static void main(String[] args) {
        List<Alert> alerts = List.of(
                new Alert("Heart rate abnormal", "CRITICAL", 1),
                new Alert("Take blood pressure medicine", "MEDICATION", 2),
                new Alert("Visitor hours updated", "GENERAL", 3),
                new Alert("Oxygen level low", "CRITICAL", 1)
        );
        Predicate<Alert> userPreference = AlertFilter.criticalOnly();
        System.out.println("Filtered Alerts:");
        alerts.stream()
              .filter(userPreference)
              .forEach(System.out::println);
    }
}