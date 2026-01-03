// Superclass
class Device {
    protected String deviceId;
    protected boolean status;
    public Device(String deviceId, boolean status) {
        this.deviceId = deviceId;
        this.status = status;
    }
    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + (status ? "ON" : "OFF"));
    }
}
// Subclass
class Thermostat extends Device {
    private int temperatureSetting;
    public Thermostat(String deviceId, boolean status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }
    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}
public class SmartHomeDevice {
    public static void main(String[] args) {
        Device thermostat = new Thermostat("THERMO-311", true, 21);
        thermostat.displayStatus();
    }
}