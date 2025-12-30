public class MovieTicketBookingSystem {
    // MovieTicket Class
    static class MovieTicket {
        // Attributes
        private String movieName;
        private String seatNumber;
        private double price;
        private boolean isBooked;
        // Constructor
        public MovieTicket() {
            isBooked = false;
        }
        // Method to book ticket
        public void bookTicket(String movieName, String seatNumber, double price) {
            if (!isBooked) {
                this.movieName = movieName;
                this.seatNumber = seatNumber;
                this.price = price;
                isBooked = true;
                System.out.println("Ticket booked for movie: " + movieName);
                System.out.println("Seat Number: " + seatNumber);
            } else {
                System.out.println("House full!!! sorry..... Ticket already booked");
            }
        }
        // Method to display ticket details
        public void displayTicketDetails() {
            if (!isBooked) {
                System.out.println("Ticket have not booked yet....");
            } else {
                System.out.println("Price: $" + price);
            }
        }
        // Method to show full ticket info
        public void showFinalTicket() {
            if (isBooked) {
                System.out.println("\nTicket booked for movie: " + movieName);
                System.out.println("Seat Number: " + seatNumber);
                System.out.println("Price: $" + price);
            }
        }
    }
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        // Ticket not booked
        ticket.displayTicketDetails();
        // Book ticket
        ticket.bookTicket("Dragon", "A10", 120.0);
        // Try booking again
        ticket.bookTicket("Dragon", "A10", 120.0);
        ticket.bookTicket("Dragon", "A10", 120.0);
        // Display price
        ticket.displayTicketDetails();
        // Final ticket display
        ticket.showFinalTicket();
    }
}