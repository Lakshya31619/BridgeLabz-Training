import java.time.LocalDate;
class Member {
    private String memberId;
    private String name;
    private LocalDate expiryDate;
    public Member(String memberId, String name, LocalDate expiryDate) {
        this.memberId = memberId;
        this.name = name;
        this.expiryDate = expiryDate;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    @Override
    public String toString() {
        return memberId + " | " + name + " | Expiry: " + expiryDate;
    }
}