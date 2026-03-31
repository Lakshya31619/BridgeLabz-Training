package InvoiceObjectCreation;
import java.util.*;
import java.util.stream.Collectors;
public class InvoiceGeneratorMain {
    public static void main(String[] args) {
        List<String> transactionIds = List.of("TXN1001", "TXN1002", "TXN1003");
        List<Invoice> invoices = transactionIds.stream()
                .map(Invoice::new)
                .collect(Collectors.toList());
        invoices.forEach(System.out::println);
    }
}