public class CustomerAccount implements SensitiveData {
    private String accountNumber;
    private String ssn;
    public CustomerAccount(String accountNumber, String ssn) {
        this.accountNumber = accountNumber;
        this.ssn = ssn;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getSsn() {
        return ssn;
    }
}