import java.util.Scanner;
// Custom Exception
class InvalidInvoiceFormatException extends Exception {
    public InvalidInvoiceFormatException(String message) {
        super(message);
    }
}
// Invoice class handles parsing, validation, and calculation
class Invoice {
    private String[] tasks;
    // Constructor parses invoice input
    public Invoice(String input) throws InvalidInvoiceFormatException {
        this.tasks = parseInvoice(input);
    }
    // Parse invoice input
    private String[] parseInvoice(String input) throws InvalidInvoiceFormatException {
        if (!input.contains("-") || !input.contains(",")) {
            throw new InvalidInvoiceFormatException("Invalid invoice format.");
        }
        return input.split(",");
    }
    // Calculate total amount
    public int getTotalAmount() throws InvalidInvoiceFormatException {
        int total = 0;
        for (String task : tasks) {
            String[] parts = task.split("-");
            if (parts.length != 2) {
                throw new InvalidInvoiceFormatException("Missing '-' in task: " + task);
            }
            try {
                String amountPart = parts[1].trim();
                String amountString = amountPart.split(" ")[0];
                int amount = Integer.parseInt(amountString);
                total += amount;
            } catch (Exception e) {
                throw new InvalidInvoiceFormatException("Invalid amount in task: " + task);
            }
        }
        return total;
    }
    // Print invoice summary
    public void printInvoice() throws InvalidInvoiceFormatException {
        System.out.println("\nInvoice Summary:");
        for (String task : tasks) {
            System.out.println(task.trim());
        }
        System.out.println("Total Amount: " + getTotalAmount() + " INR");
    }
}
public class InvoiceGeneratorException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter invoice details: ");
        String input = sc.nextLine();
        try {
            //Create object
            Invoice invoice = new Invoice(input);
            //Output
            invoice.printInvoice();
        } catch (InvalidInvoiceFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}