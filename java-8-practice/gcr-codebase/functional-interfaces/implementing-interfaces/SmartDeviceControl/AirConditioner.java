public class AirConditioner implements SmartDevice {
    @Override
    public void turnOn() {
        System.out.println("Air Conditioner started cooling");
    }
    @Override
    public void turnOff() {
        System.out.println("Air Conditioner turned OFF");
    }
}