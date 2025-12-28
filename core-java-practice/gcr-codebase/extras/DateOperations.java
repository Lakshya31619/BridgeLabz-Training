import java.util.Scanner;
import java.time.LocalDate;
public class DateOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input in format YYYY-MM-DD
        String input = sc.nextLine();
        LocalDate date = LocalDate.parse(input);
        //Operations
        LocalDate newDate = date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3);
        //Output
        System.out.println("New Date : "+newDate);
    }
}