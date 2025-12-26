import java.util.Scanner;
public class RouteDistanceTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Total distance covered
        int total = 0;
        boolean continueJourney = true;
        //While loop for bus stops
        while(continueJourney){
            int distance = sc.nextInt();
            total += distance;
            System.out.println("Do you want to get off? (yes/no)");
            String choice = sc.next();
            if(choice.equalsIgnoreCase("yes")){
                continueJourney = false;
            }
        }
        System.out.println("Total distance travelled : " + total + " km");
    }
}