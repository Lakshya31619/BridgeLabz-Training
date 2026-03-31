import java.util.Scanner;
public class CalendarDisplayMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input month and year
        int month = sc.nextInt();
        int year = sc.nextInt();
        //Calling method getMonthName
        String monthName = getMonthName(month);
        //Calling method getDaysInMonth
        int days = getDaysInMonth(month, year);
        //Calling method getFirstDayOfMonth
        int firstDay = getFirstDayOfMonth(month, year);
        //Display month and year
        System.out.println("\n   " + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        //First loop for indentation
        for(int i = 0; i < firstDay; i++){
            System.out.print("    ");
        }
        //Second loop to print days
        for(int day = 1; day <= days; day++){
            System.out.printf("%3d ", day);
            if((day + firstDay) % 7 == 0){
                System.out.println();
            }
        }
    }
    //Method to get month name
    public static String getMonthName(int month){
        String[] months = {
            "January","February","March","April","May","June",
            "July","August","September","October","November","December"
        };
        return months[month - 1];
    }
    //Method to get number of days in a month
    public static int getDaysInMonth(int month, int year){
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        //Check for leap year in February
        if(month == 2 && isLeapYear(year)){
            return 29;
        }
        return days[month - 1];
    }
    //Method to check leap year
    public static boolean isLeapYear(int year){
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            return true;
        }
        return false;
    }
    //Method to get first day of the month using given formula
    public static int getFirstDayOfMonth(int month, int year){
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