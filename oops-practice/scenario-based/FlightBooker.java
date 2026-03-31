import java.util.ArrayList;
import java.util.List;
//Flight class
class Flight {
    int flightId;
    String source;
    String destination;
    double price;
    public Flight(int flightId, String source, String destination, double price) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }
    public void displayFlight() {
        System.out.println("Flight ID: " + flightId + ", From: " + source + ", To: " + destination + ", Price: " + price);
    }
}
//Booking class
class Booking {
    int bookingId;
    Flight flight;
    String passengerName;
    public Booking(int bookingId, Flight flight, String passengerName) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.passengerName = passengerName;
    }
    public void displayBooking() {
        System.out.println("Booking ID: " + bookingId + ", Passenger: " + passengerName + ", Flight ID: " + flight.flightId + ", Route: " + flight.source + " -> " + flight.destination);
    }
}
//Main class
public class FlightBooker{
    static Flight[] flights = {
            new Flight(101, "Delhi", "Mumbai", 4500),
            new Flight(102, "Delhi", "Chennai", 6000),
            new Flight(103, "Mumbai", "Bangalore", 5000),
            new Flight(104, "Kolkata", "Delhi", 5500)
    };
    static List<Booking> bookings = new ArrayList<>();
    static int bookingCounter = 1;
    //SEARCH
    public static void searchFlights(String source, String destination) {
        boolean found = false;
        for (Flight f : flights) {
            if (f.source.equalsIgnoreCase(source)
                    && f.destination.equalsIgnoreCase(destination)) {
                f.displayFlight();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No flights found.");
        }
    }
    //CREATE
    public static void bookFlight(int flightId, String passengerName) {
        for (Flight f : flights) {
            if (f.flightId == flightId) {
                Booking booking = new Booking(bookingCounter++, f, passengerName);
                bookings.add(booking);
                System.out.println("Flight booked successfully!");
                return;
            }
        }
        System.out.println("Invalid Flight ID.");
    }
    //READ
    public static void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }
        for (Booking b : bookings) {
            b.displayBooking();
        }
    }
    //DELETE
    public static void cancelBooking(int bookingId) {
        bookings.removeIf(b -> b.bookingId == bookingId);
        System.out.println("Booking cancelled (if ID existed).");
    }
    public static void main(String[] args) {
        System.out.println("---- Search Flights (Delhi to Mumbai) ----");
        searchFlights("delhi", "MUMBAI");
        System.out.println("\n---- Booking Flight ----");
        bookFlight(101, "Rahul");
        System.out.println("\n---- View Bookings ----");
        viewBookings();
        System.out.println("\n---- Cancel Booking ----");
        cancelBooking(1);
        System.out.println("\n---- View Bookings After Cancellation ----");
        viewBookings();
    }
}