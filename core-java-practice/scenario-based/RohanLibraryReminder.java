import java.time.LocalDate;
import java.util.Scanner;
public class RohanLibraryReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int count = 0; count < 5; count++) {
            System.out.println("Enter dates for book number " + (count + 1));
            System.out.print("Enter issue date (YYYY-MM-DD): ");
            LocalDate issueDate = LocalDate.parse(sc.nextLine());
            System.out.print("Enter due date (YYYY-MM-DD): ");
            LocalDate dueDate = LocalDate.parse(sc.nextLine());
            System.out.print("Enter return date (YYYY-MM-DD): ");
            LocalDate returnDate = LocalDate.parse(sc.nextLine());
            long lateDays = returnDate.toEpochDay() - dueDate.toEpochDay();
            int finePerDay = 5;
            long fine = lateDays > 0 ? lateDays * finePerDay : 0;
            System.out.println("Fine : Rs." + fine);
        }
    }
}