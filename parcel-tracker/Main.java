public class Main {
    public static void main(String[] args) {
        Parcel tracker = new Parcel();
        tracker.trackParcel();
        tracker.addCheckpoint("Shipped", "Flipkart");
        tracker.trackParcel();
    }
}