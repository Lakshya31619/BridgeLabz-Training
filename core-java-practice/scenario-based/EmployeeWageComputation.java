public class EmployeeWageComputation {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        int hour = 8;
        int partTimeHour = 8;
        int wagePerHour = 20;
        int pick = EmployeePresentCheck();
        if(pick==0){
            System.out.println("Present");
        }else{
            System.out.println("Absent");
        }
        EmployeeDailyWage(hour, wagePerHour);
        EmployeePartTime(partTimeHour, wagePerHour);
        System.out.println("Using Switch-Case : ");
        int [] wageData = EmployeeSwitchCase(pick, hour,partTimeHour, wagePerHour);
        System.out.println("Daily wage : "+wageData[0]);
        System.out.println("Part Time wage : "+wageData[1]);
        EmployeeMonthlyWage(hour, wagePerHour);
        EmployeeWageLimit(hour, wagePerHour);
    }
    //Use Case 1
    public static int EmployeePresentCheck(){
        int pick = (int)(Math.random()*2);
        return pick;
    }
    //Use Case 2
    public static void EmployeeDailyWage(int hour, int wagePerHour){
        System.out.println("Wage per day : "+hour*wagePerHour);
    }
    //Use Case 3
    public static void EmployeePartTime(int partTimeHour, int wagePerHour){
        System.out.println("Part time wage : "+partTimeHour*wagePerHour);
    }
    //Use Case 4
    public static int[] EmployeeSwitchCase(int pick, int hour, int partTimeHour, int wagePerHour){
        int partTimeWage = 0;
        int dailyWage = 0;
        switch(pick){
            case(0) : dailyWage = hour*wagePerHour;
                      partTimeWage = partTimeHour*wagePerHour;
                      break;
            case(1) : dailyWage = 0;
                      partTimeWage = 0;
                      break;
        }
        return new int[]{dailyWage, partTimeWage};
    }
    //Use Case 5
    public static void EmployeeMonthlyWage(int hours, int wagePerHour){
        System.out.println("Monthly wage : "+hours*wagePerHour*20);
    }
    //Use Case 6
    public static void EmployeeWageLimit(int hours, int wagePerHour){
        int hourLimit = 100;
        int daysLimit = 20;
        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;
        while(totalDays<daysLimit && totalHours<hourLimit){
            totalDays++;
            totalHours += hours;
            totalWage += hours*wagePerHour;
            if(totalHours+hours>=hourLimit){
                break;
            }
        }
        System.out.println("Total Wage : "+totalWage);
    }
}