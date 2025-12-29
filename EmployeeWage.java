public class EmployeeWage {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        EmployeePresentCheck();
        EmployeeDailyWage();
    }
    //Use Case 1
    public static void EmployeePresentCheck(){
        int pick = (int)(Math.random()*2);
        if(pick==0){
            System.out.println("Present");
        }else{
            System.out.println("Absent");
        }
    }
    //Use Case 2
    public static void EmployeeDailyWage(){
        int hour = 8;
        int wagePerHour = 20;
        System.out.println("Wage per day : "+hour*wagePerHour);
    }
}