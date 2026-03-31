import java.util.*;
import java.util.stream.Collectors;
public class NameUppercasing {
    public static void main(String[] args) {
        List<String> employeeNames = List.of("Aryan", "bhanu", "Chirag", "dharam");
        List<String> upperCaseNames = employeeNames.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        upperCaseNames.forEach(System.out::println);
    }
}