public class EmployeeWage {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        int hour = 8;
        int wagePerHour = 20;
        int pick = EmployeePresentCheck();
        if(pick==0){
            System.out.println("Present");
        }else{
            System.out.println("Absent");
        }
        EmployeeDailyWage(hour, wagePerHour);
        EmployeePartTime(hour, wagePerHour);
        System.out.println(EmployeeSwitchCase(pick, hour, wagePerHour));
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
    public static void EmployeePartTime(int hour, int wagePerHour){
        System.out.println("Part time wage : "+hour*wagePerHour);
    }
    //Use Case 4
    public static int EmployeeSwitchCase(int pick, int hour, int wagePerHour){
        int partTimeWage = 0;
        switch(pick){
            case(0) : partTimeWage += hour*wagePerHour;
            case(1) : partTimeWage += 0;
        }
        return partTimeWage;
    }
}