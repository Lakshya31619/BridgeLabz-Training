import java.util.*;
import java.util.stream.Collectors;
public class InsuranceClaimAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C101", "Health", 50000),
                new Claim("C102", "Vehicle", 20000),
                new Claim("C103", "Health", 70000),
                new Claim("C104", "Property", 120000),
                new Claim("C105", "Vehicle", 30000),
                new Claim("C106", "Health", 60000)
        );
        Map<String, Double> averageClaimByType =
                claims.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Claim::getClaimType,
                                        Collectors.averagingDouble(Claim::getClaimAmount)
                                )
                        );
        averageClaimByType.forEach((type, avgAmount) ->
                System.out.println(type + " → Average Claim Amount: " + avgAmount)
        );
    }
}