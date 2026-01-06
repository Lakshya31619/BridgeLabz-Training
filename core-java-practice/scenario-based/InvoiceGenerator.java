import java.util.Scanner;
public class InvoiceGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input invoice description
        System.out.print("Enter invoice details: ");
        String input = sc.nextLine();
        String[] tasks = parseInvoice(input);
        // Calculate total amount
        int totalAmount = getTotalAmount(tasks);
        // Display result
        System.out.println("\nInvoice Summary:");
        for (String task : tasks) {
            System.out.println(task.trim());
        }
        System.out.println("Total Amount: " + totalAmount + " INR");
    }
    // Method to split invoice string into tasks
    public static String[] parseInvoice(String input) {
        return input.split(",");
    }
    // Method to calculate total invoice amount
    public static int getTotalAmount(String[] tasks) {
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
}