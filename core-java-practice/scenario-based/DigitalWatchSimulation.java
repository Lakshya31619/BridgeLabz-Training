public class DigitalWatchSimulation {
    public static void main(String[] args) {
        System.out.println("Simulation Started");
        for(int hour = 0 ; hour < 24 ; hour++){
            for(int minute = 0 ; minute < 60 ; minute++){
                System.out.println((hour < 10 ? "0"+hour : hour) + ":" +(minute < 10 ? "0"+minute : minute));
                // Power cut at 13:00
                if(hour == 13 && minute == 0){
                    System.out.println("Power Cut! Watch Stopped.");
                    break;
                }
            }
            if(hour == 13){
                break;
            }
        }
        System.out.println("Simulation Ended");
    }
}