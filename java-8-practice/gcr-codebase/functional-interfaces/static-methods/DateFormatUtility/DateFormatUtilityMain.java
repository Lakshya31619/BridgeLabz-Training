import java.time.LocalDate;
public class DateFormatUtilityMain {
    public static void main(String[] args) {
        LocalDate invoiceDate = LocalDate.now();
        System.out.println("Invoice Date (dd-MM-yyyy): " + DateFormatUtils.format(invoiceDate, "dd-MM-yyyy"));
        System.out.println("Invoice Date (yyyy/MM/dd): " + DateFormatUtils.format(invoiceDate, "yyyy/MM/dd"));
        System.out.println("Invoice Date (MMM dd, yyyy): " + DateFormatUtils.format(invoiceDate, "MMM dd, yyyy"));
    }
}