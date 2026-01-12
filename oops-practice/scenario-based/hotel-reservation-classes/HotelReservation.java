public class HotelReservation {
    public static void main(String[] args) {
        Guest guest = new Guest(1, "Amitabh Bachchan");
        Room room = new DeluxeRoom(101);
        PricingStrategy pricing = new SeasonalPricing();
        Reservation reservation = new Reservation(guest, room, 3, pricing);
        try {
            reservation.book();
            reservation.generateInvoice();
            reservation.checkOut();
        } catch (RoomNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}