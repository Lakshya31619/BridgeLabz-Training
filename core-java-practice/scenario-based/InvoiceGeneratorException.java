import java.util.Scanner;
// Custom Exception
class InvalidInvoiceFormatException extends Exception {
    public InvalidInvoiceFormatException(String message) {
        super(message);
    }
}
public class InvoiceGeneratorException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter invoice details: ");
        String input = sc.nextLine();
        try {
            // Parse invoice
            String[] tasks = parseInvoice(input);
            // Calculate total amount
            int totalAmount = getTotalAmount(tasks);
            // Display invoice
            System.out.println("\nInvoice Summary:");
            for (String task : tasks) {
                System.out.println(task.trim());
            }
            System.out.println("Total Amount: " + totalAmount + " INR");
        } catch (InvalidInvoiceFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    // Method to split invoice string
    public static String[] parseInvoice(String input) throws InvalidInvoiceFormatException {
        if (!input.contains("-") || !input.contains(",")) {
            throw new InvalidInvoiceFormatException("Invalid invoice format.");
        }
        return input.split(",");
    }
    // Method to calculate total amount
    public static int getTotalAmount(String[] tasks) throws InvalidInvoiceFormatException {
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
}