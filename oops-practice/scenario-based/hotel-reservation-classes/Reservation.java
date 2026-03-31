public class Reservation {
    private Guest guest;
    private Room room;
    private int days;
    private PricingStrategy pricingStrategy;
    public Reservation(Guest guest, Room room, int days, PricingStrategy pricingStrategy) {
        this.guest = guest;
        this.room = room;
        this.days = days;
        this.pricingStrategy = pricingStrategy;
    }
    public void book() throws RoomNotAvailableException {
        room.bookRoom();
        System.out.println("Room booked for " + guest.getName());
    }
    public void checkOut() {
        room.checkout();
        System.out.println("Checked out successfully");
    }
    public void generateInvoice() {
        double total = pricingStrategy.calculatePrice(room.getPricePerDay(), days);
        System.out.println("\n----- Invoice -----");
        System.out.println("Guest: " + guest.getName());
        System.out.println("Room No: " + room.getRoomNumber());
        System.out.println("Days: " + days);
        System.out.println("Total Amount: ₹" + total);
    }
}