public class Room {
    protected int roomNumber;
    protected double pricePerDay;
    protected boolean available;
    public Room(int roomNumber, double pricePerDay) {
        this.roomNumber = roomNumber;
        this.pricePerDay = pricePerDay;
        this.available = true;
    }
    public boolean isAvailable() {
        return available;
    }
    public void bookRoom() throws RoomNotAvailableException {
        if (!available) {
            throw new RoomNotAvailableException("Room not available!");
        }
        available = false;
    }
    public void checkout() {
        available = true;
    }
    public double getPricePerDay() {
        return pricePerDay;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
}