import java.time.LocalDateTime;
public class Reservation {
    private int tableNumber;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    public Reservation(int tableNumber, LocalDateTime startTime, LocalDateTime endTime) {
        this.tableNumber = tableNumber;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public int getTableNumber() {
        return tableNumber;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
}