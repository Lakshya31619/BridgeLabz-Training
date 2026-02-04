@FunctionalInterface
interface LightAction {
    void execute();
}
public class SmartHomeLighting {
    public static void main(String[] args) {
        LightAction motionDetected = () -> System.out.println("Motion detected → Turning on hallway lights at full brightness.");
        LightAction eveningMode = () -> System.out.println("It's evening → Setting living room lights to warm dim mode.");
        LightAction voiceCommand = () -> System.out.println("Voice command received → Turning off all lights.");
        triggerLight(motionDetected);
        triggerLight(eveningMode);
        triggerLight(voiceCommand);
    }
    public static void triggerLight(LightAction action) {
        action.execute();
    }
}