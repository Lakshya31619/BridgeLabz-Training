import java.util.Scanner;
public class LeapYearCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input year
        int year = sc.nextInt();
        //Calling method checkYear
        boolean isLeap = checkYear(year);
        //Output
        if(isLeap){
            System.out.println("The year "+year+" is a leap year.");
        }else{
            System.out.println("The year "+year+" is not a leap year.");
        }
    }
    //Method to check leap year
    public static boolean checkYear(int year){
        if(year>=1582){
            if((year%4==0 && year%100!=0) || year%400==0){
                return true;
            }
        }
        return false;
    }
}