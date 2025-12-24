import java.util.Scanner;
public class SpringSeasonMethod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Input month and day
        int month = sc.nextInt();
        int day = sc.nextInt();
        //Output
        //Calling method to check spring season
        System.out.println(checkSeason(month, day));
    }
    //Method checkSeason
    public static boolean checkSeason(int month, int day){
        if(month>=3 && month<=6){
            if(month==3 && day<20 || month==6 && day>20){
                return false;
            }
            return true;
        }
        return false;
    }
}