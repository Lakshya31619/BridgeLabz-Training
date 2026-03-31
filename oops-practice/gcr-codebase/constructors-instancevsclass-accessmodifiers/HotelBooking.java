public class HotelBooking {
    // Attributes
    private String guestName;
    private String roomType;
    private int nights;
    // Default constructor
    public HotelBooking() {
        this.guestName = "Guest";
        this.roomType = "Standard";
        this.nights = 1;
    }
    // Parameterized constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }
    // Copy constructor
    public HotelBooking(HotelBooking other) {
        if (other != null) {
            this.guestName = other.guestName;
            this.roomType = other.roomType;
            this.nights = other.nights;
        }
    }
    // Getters
    public String getGuestName() {
        return guestName;
    }
    public String getRoomType() {
        return roomType;
    }
    public int getNights() {
        return nights;
    }
    public static void main(String[] args) {
        // Using default constructor
        HotelBooking booking1 = new HotelBooking();
        System.out.println("Booking 1:");
        System.out.println(booking1.getGuestName() + ", " +booking1.getRoomType() + ", " +booking1.getNights() + " night(s)");
        System.out.println();
        // Using parameterized constructor
        HotelBooking booking2 = new HotelBooking("Ansh Gaur", "Shack", 3);
        System.out.println("Booking 2:");
        System.out.println(booking2.getGuestName() + ", " +booking2.getRoomType() + ", " +booking2.getNights() + " night(s)");
        System.out.println();
        // Using copy constructor
        HotelBooking booking3 = new HotelBooking(booking2);
        System.out.println("Booking 3 (Copied from Booking 2):");
        System.out.println(booking3.getGuestName() + ", " +booking3.getRoomType() + ", " +booking3.getNights() + " night(s)");
    }
}