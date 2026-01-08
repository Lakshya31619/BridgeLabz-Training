class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    TicketNode next;
    TicketNode(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}
public class TicketReservationSystem {
    private static TicketNode head = null;
    private static TicketNode tail = null;
    //Add Ticket at last
    public static void addTicket(int id, String customer, String movie, String seat, String time) {
        TicketNode newTicket = new TicketNode(id, customer, movie, seat, time);
        if (head == null) {
            head = tail = newTicket;
            newTicket.next = head;
        } else {
            tail.next = newTicket;
            newTicket.next = head;
            tail = newTicket;
        }
    }
    //Remove ticket by ID
    public static void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }
        TicketNode current = head;
        TicketNode previous = tail;
        do {
            if (current.ticketId == ticketId) {
                if (current == head && current == tail) {
                    head = tail = null;
                } else {
                    previous.next = current.next;
                    if (current == head)
                        head = current.next;
                    if (current == tail)
                        tail = previous;
                }
                System.out.println("Ticket " + ticketId + " removed.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);
        System.out.println("Ticket not found.");
    }
    //Display Tickets
    public static void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        System.out.println("\nCurrent Booked Tickets:");
        TicketNode temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }
    //Search Ticket
    public static void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        boolean found = false;
        TicketNode temp = head;
        System.out.println("\nSearch Results:");
        do {
            if (temp.customerName.equalsIgnoreCase(keyword) ||
                temp.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found)
            System.out.println("No matching tickets found.");
    }
    //Count Tickets
    public static void countTickets() {
        if (head == null) {
            System.out.println("Total Booked Tickets: 0");
            return;
        }
        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Total Booked Tickets: " + count);
    }
    //Main class
    public static void main(String[] args) {
        addTicket(101, "Aman", "Incendies", "A1", "10:00 AM");
        addTicket(102, "Baman", "13B", "B3", "11:30 AM");
        addTicket(103, "Chaman", "No Smoking", "C5", "01:00 PM");
        addTicket(104, "Daman", "IT", "D2", "03:15 PM");
        displayTickets();
        countTickets();
        searchTicket("Inception");
        searchTicket("Bob");
        System.out.println("\nRemoving Ticket ID 102");
        removeTicket(102);
        displayTickets();
        countTickets();
    }
}