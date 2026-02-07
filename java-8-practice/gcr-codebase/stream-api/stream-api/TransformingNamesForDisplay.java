import java.util.*;
import java.util.stream.Collectors;
public class TransformingNamesForDisplay {
    public static void main(String[] args) {
        List<String> customerNames = Arrays.asList(
                "Aman",
                "bhumansh",
                "Charly",
                "dharman",
                "Eshan"
        );
        List<String> transformedNames = customerNames.stream()
                .map(String::toUpperCase)
                .sorted() 
                .collect(Collectors.toList());
        transformedNames.forEach(System.out::println);
    }
}