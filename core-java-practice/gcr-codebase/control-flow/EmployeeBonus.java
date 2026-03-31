import java.util.Scanner;
public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int salary = sc.nextInt();
        int year = sc.nextInt();
        if(year>=5){
            System.out.println("Bonus is INR "+salary*0.05);
        }else{
            System.out.println("No Bonus");
        }
    }
}