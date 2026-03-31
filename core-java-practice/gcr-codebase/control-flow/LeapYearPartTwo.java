import java.util.Scanner;
public class LeapYearPartTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if(year < 1582){
            System.out.println("Invalid year.");
        }else{
            if((year%4==0 && year%100!=0) || (year%400==0)){
                System.out.println(year+" is a Leap Year");
            }else {
                System.out.println(year+" is not a Leap Year");
            }
        }
    }
}