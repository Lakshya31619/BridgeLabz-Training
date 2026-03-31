public class EventManagerApp {
    public static void main(String[] args) {
        Ticket[] tickets = {
            new Ticket(1500),
            new Ticket(500),
            new Ticket(2500),
            new Ticket(1000),
            new Ticket(200),
            new Ticket(3000)
        };
        System.out.println("Before Sorting:");
        printTickets(tickets);
        QuickSort.quickSort(tickets, 0, tickets.length - 1);
        System.out.println("\nAfter Sorting (by Price):");
        printTickets(tickets);
        System.out.println("\nTop 3 Cheapest Tickets:");
        for (int i = 0; i < 3; i++) {
            System.out.println("₹" + tickets[i].price);
        }
        System.out.println("\nTop 3 Most Expensive Tickets:");
        for (int i = tickets.length - 1; i >= tickets.length - 3; i--) {
            System.out.println("₹" + tickets[i].price);
        }
    }
    private static void printTickets(Ticket[] tickets) {
        for (int i = 0; i < tickets.length; i++) {
            System.out.print("₹" + tickets[i].price + " ");
        }
        System.out.println();
    }
}