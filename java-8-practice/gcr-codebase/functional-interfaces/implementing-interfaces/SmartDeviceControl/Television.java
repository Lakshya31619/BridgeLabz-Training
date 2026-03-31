public class Television implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("Television turned ON");
    }
    @Override
    public void turnOff() {
        System.out.println("Television turned OFF");
    }
}