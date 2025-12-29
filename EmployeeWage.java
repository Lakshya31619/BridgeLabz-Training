public class EmployeeWage {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        EmployeePresentCheck();
    }
    public static void EmployeePresentCheck(){
        int pick = (int)(Math.random()*2);
        if(pick==0){
            System.out.println("Present");
        }else{
            System.out.println("Absent");
        }
    }
}