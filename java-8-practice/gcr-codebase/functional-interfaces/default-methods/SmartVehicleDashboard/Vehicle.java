public interface Vehicle {
    void displaySpeed();
    default void displayBatteryPercentage() {
        System.out.println("Battery information not available");
    }
}