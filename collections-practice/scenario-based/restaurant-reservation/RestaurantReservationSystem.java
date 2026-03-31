import java.time.LocalDateTime;
import java.util.*;
public class RestaurantReservationSystem {
    private Map<Integer, Table> tables = new HashMap<>();
    private List<Reservation> reservations = new ArrayList<>();
    // Add table to system
    public void addTable(Table table) {
        tables.put(table.getTableNumber(), table);
    }
    // Reserve table
    public void reserveTable(int tableNumber, LocalDateTime start, LocalDateTime end) throws TableAlreadyReservedException {
        for (Reservation r : reservations) {
            if (r.getTableNumber() == tableNumber &&
                start.isBefore(r.getEndTime()) &&
                end.isAfter(r.getStartTime())) {
                throw new TableAlreadyReservedException("Table " + tableNumber + " is already reserved for this time slot.");
            }
        }
        reservations.add(new Reservation(tableNumber, start, end));
        System.out.println("Table " + tableNumber + " reserved successfully.");
    }
    // Cancel reservation
    public void cancelReservation(int tableNumber, LocalDateTime start) {
        reservations.removeIf(r ->
                r.getTableNumber() == tableNumber &&
                r.getStartTime().equals(start)
        );
        System.out.println("Reservation cancelled for table " + tableNumber);
    }
    // Show available tables
    public void showAvailableTables(LocalDateTime start, LocalDateTime end) {
        System.out.println("Available tables:");
        for (Integer tableNumber : tables.keySet()) {
            boolean isAvailable = true;
            for (Reservation r : reservations) {
                if (r.getTableNumber() == tableNumber &&
                    start.isBefore(r.getEndTime()) &&
                    end.isAfter(r.getStartTime())) {
                    isAvailable = false;
                    break;
                }
            }
            if (isAvailable) {
                System.out.println("Table " + tableNumber);
            }
        }
    }
}