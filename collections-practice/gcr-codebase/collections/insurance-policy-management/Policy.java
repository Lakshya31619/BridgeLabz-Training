import java.time.LocalDate;
import java.util.Objects;
public class Policy {
    private final String policyNumber;
    private final String policyHolderName;
    private final LocalDate expiryDate;
    private final String coverageType;
    private final double premiumAmount;
    public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    public String getPolicyNumber() {
        return policyNumber;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    public String getCoverageType() {
        return coverageType;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy policy = (Policy) o;
        return policyNumber.equals(policy.policyNumber);
    }
    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }
    @Override
    public String toString() {
        return policyNumber + " | " + policyHolderName + " | " + expiryDate + " | " + coverageType + " | $" + premiumAmount;
    }
}