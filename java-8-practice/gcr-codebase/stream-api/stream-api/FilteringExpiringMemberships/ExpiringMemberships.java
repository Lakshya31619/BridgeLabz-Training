import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
public class ExpiringMemberships {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
                new Member("M101", "Amit", LocalDate.now().plusDays(10)),
                new Member("M102", "Riya", LocalDate.now().plusDays(45)),
                new Member("M103", "John", LocalDate.now().plusDays(25)),
                new Member("M104", "Sara", LocalDate.now().plusDays(5)),
                new Member("M105", "Rahul", LocalDate.now().plusDays(60))
        );
        LocalDate today = LocalDate.now();
        LocalDate thresholdDate = today.plusDays(30);
        List<Member> expiringSoon = members.stream()
                .filter(member ->
                        !member.getExpiryDate().isBefore(today) &&
                        !member.getExpiryDate().isAfter(thresholdDate)
                )
                .collect(Collectors.toList());
        expiringSoon.forEach(System.out::println);
    }
}