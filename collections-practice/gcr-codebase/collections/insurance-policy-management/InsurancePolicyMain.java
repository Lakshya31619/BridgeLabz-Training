import java.time.LocalDate;
public class InsurancePolicyMain {
    public static void main(String[] args) {
        PolicyManager manager = new PolicyManager();
        manager.addPolicy(new Policy("1", "Naman Gupta", LocalDate.now().plusDays(10), "Health", 5000));
        manager.addPolicy(new Policy("2", "Dheeraj Singh", LocalDate.now().plusDays(40), "Auto", 3000));
        manager.addPolicy(new Policy("3", "Abhishek Sharma", LocalDate.now().plusDays(20), "Home", 4500));
        System.out.println("All Policies:");
        manager.getAllPolicies().forEach(System.out::println);
        System.out.println("\nPolicies Expiring Soon:");
        manager.getExpiringSoon().forEach(System.out::println);
        System.out.println("\nHealth Policies:");
        manager.getByCoverageType("Health").forEach(System.out::println);
        System.out.println("\nPolicies Sorted by Expiry Date:");
        manager.getSortedByExpiryPolicies().forEach(System.out::println);
    }
}