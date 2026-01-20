public class ParcelTrackerMain {
    public static void main(String[] args) {
        ParcelTracker tracker = new ParcelTracker();
        tracker.trackParcel();
        tracker.addCheckpoint("Shipped", "Customs Clearance");
        tracker.trackParcel();
        System.out.println("Parcel lost? " + tracker.isParcelLost());
    }
}