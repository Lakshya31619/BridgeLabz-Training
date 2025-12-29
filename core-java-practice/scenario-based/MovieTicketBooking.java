import java.util.Scanner;
public class MovieTicketBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter movie type(3D/2D) : ");
        String movieType = sc.next();
        System.out.println("Enter seat type(gold/silver) : ");
        String seatType = sc.next();
        System.out.println("Enter snacks(popcorn/colddrink/sandwich) : ");
        String snacks = sc.next();
        int ticketPrice = 0;
        switch(seatType){
            case("gold") : if(movieType.equals("3D")){ticketPrice = 300;} else if(movieType.equals("2D")){ticketPrice = 250;} break;
            case("silver") : if(movieType.equals("3D")){ticketPrice = 200;} else if(movieType.equals("2D")){ticketPrice = 150;} break;
        }
        int snackPrice = 0;
        switch(snacks){
            case("popcorn") : snackPrice = 200; break;
            case("colddrink") : snackPrice = 100; break;
            case("sandwich") : snackPrice = 150; break;
        }
        System.out.println("Ticket Price : "+ticketPrice);
        System.out.println("Snacks Price : "+snackPrice);
        System.out.println("Total Price : "+(ticketPrice+snackPrice));
    }
}