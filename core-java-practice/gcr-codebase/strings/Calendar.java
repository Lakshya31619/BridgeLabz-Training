import java.util.Scanner;
public class Calendar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input
        int month = sc.nextInt();
        int year = sc.nextInt();
        //Output
        System.out.println();
        System.out.println(getMonth(month) + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        int firstDay = getFirst(month, year);
        int daysInMonth = getDays(month, year);
        for (int i = 0; i < firstDay; i++) {
            System.out.print("    ");
        }
        for (int day = 1; day <= daysInMonth; day++) {
            System.out.printf("%3d ", day);

            if ((day + firstDay) % 7 == 0) {
                System.out.println();
            }
        }
    }
    //Fucntion to get month name
    public static String getMonth(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June","July", "August", "September", "October", "November", "December"};
        return months[month - 1];
    }
    //Function to check leap year
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        } else if (year % 100 == 0) {
            return false;
        } else if (year % 4 == 0) {
            return true;
        }
        return false;
    }
    //Fuunction to get number of days in a month
    public static int getDays(int month, int year) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return days[month - 1];
    }
    //Function to get first day of the month (Gregorian formula)
    public static int getFirst(int month, int year) {
        int d = 1;
        int m = month;
        int y = year;
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        return d0;
    }
}