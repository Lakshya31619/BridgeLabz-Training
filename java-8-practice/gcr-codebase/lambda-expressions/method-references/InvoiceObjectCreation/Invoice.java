package InvoiceObjectCreation;
public class Invoice {
    private String transactionId;
    public Invoice(String transactionId) {
        this.transactionId = transactionId;
    }
    public String getTransactionId() {
        return transactionId;
    }
    @Override
    public String toString() {
        return "Invoice created for Transaction ID: " + transactionId;
    }
}