import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DateFormatting {
    public static void main(String[] args) {
        //Current date using LocalDate
        LocalDate date = LocalDate.now();
        //Formatting date using DateTimeFormatter
        DateTimeFormatter d1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter d2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter d3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");
        //Output
        System.out.println("Format 1 : " + date.format(d1));
        System.out.println("Format 2 : " + date.format(d2));
        System.out.println("Format 3 : " + date.format(d3));
    }
}