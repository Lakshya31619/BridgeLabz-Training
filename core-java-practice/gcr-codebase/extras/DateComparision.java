import java.time.LocalDate;
import java.util.Scanner;
public class DateComparision {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input two dates in format YYYY-MM-DD
        LocalDate date1 = LocalDate.parse(sc.nextLine());
        LocalDate date2 = LocalDate.parse(sc.nextLine());
        //Comparision
        if(date1.isBefore(date2)){
            System.out.println("The first date is before the second date");
        }else if(date1.isAfter(date2)){
            System.out.println("The first date is after the second date");
        }else if(date1.equals(date2)){
            System.out.println("Both dates are same");
        }
    }
}