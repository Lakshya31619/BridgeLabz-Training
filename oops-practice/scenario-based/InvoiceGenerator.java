import java.util.Scanner;
//Invoice class
class Invoice {
    private String[] tasks;
    // Constructor
    public Invoice(String input) {
        this.tasks = parseInvoice(input);
    }
    // Parse invoice input string into tasks
    private String[] parseInvoice(String input) {
        return input.split(",");
    }
    // Calculate total amount
    public int getTotalAmount() {
        int total = 0;
        for (String task : tasks) {
            String[] parts = task.split("-");
            if (parts.length == 2) {
                String amountPart = parts[1].trim();
                String amountString = amountPart.split(" ")[0];
                int amount = Integer.parseInt(amountString);
                total += amount;
            }
        }
        return total;
    }
    // Print invoice summary
    public void printInvoice() {
        System.out.println("\nInvoice Summary:");
        for (String task : tasks) {
            System.out.println(task.trim());
        }
        System.out.println("Total Amount: " + getTotalAmount() + " INR");
    }
}
public class InvoiceGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input invoice description
        System.out.print("Enter invoice details: ");
        String input = sc.nextLine();
        Invoice invoice = new Invoice(input);
        invoice.printInvoice();
    }
}