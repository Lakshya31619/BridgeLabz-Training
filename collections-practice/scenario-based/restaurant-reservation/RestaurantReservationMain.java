import java.time.LocalDateTime;
public class RestaurantReservationMain {
    public static void main(String[] args) {
        RestaurantReservationSystem system = new RestaurantReservationSystem();
        system.addTable(new Table(1, 4));
        system.addTable(new Table(2, 6));
        LocalDateTime start = LocalDateTime.of(2026, 1, 30, 18, 0);
        LocalDateTime end = LocalDateTime.of(2026, 1, 30, 20, 0);
        try {
            system.reserveTable(1, start, end);
            system.reserveTable(1, start, end);
        } catch (TableAlreadyReservedException e) {
            System.out.println(e.getMessage());
        }
        system.showAvailableTables(start, end);
    }
}