public class SmartDeviceControlMain {
    public static void main(String[] args) {
        SmartDevice[] devices = {
                new Light(),
                new AirConditioner(),
                new Television()
        };
        for (SmartDevice device : devices) {
            device.turnOn();
        }
        for (SmartDevice device : devices) {
            device.turnOff();
        }
    }
}