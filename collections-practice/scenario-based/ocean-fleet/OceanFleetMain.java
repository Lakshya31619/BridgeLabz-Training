import java.util.List;
import java.util.Scanner;
public class OceanFleetMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VesselUtil vesselUtil = new VesselUtil();
        System.out.println("Enter the number of vessels to be added");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("Enter vessel details");
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] data = input.split(":");
            Vessel vessel = new Vessel(
                    data[0],
                    data[1],
                    Double.parseDouble(data[2]),
                    data[3]
            );
            vesselUtil.addVesselPerformance(vessel);
        }
        System.out.println("Enter the Vessel Id to check speed");
        String searchId = sc.nextLine();
        Vessel searchedVessel = vesselUtil.getVesselById(searchId);
        if (searchedVessel != null) {
            System.out.println(searchedVessel.getVesselId() + " | " + searchedVessel.getVesselName() + " | " + searchedVessel.getVesselType() + " | " + searchedVessel.getAverageSpeed() + " knots");
        } else {
            System.out.println("Vessel Id " + searchId + " not found");
        }
        System.out.println("High performance vessels are");
        List<Vessel> highPerformance = vesselUtil.getHighPerformanceVessels();
        for (Vessel vessel : highPerformance) {
            System.out.println(vessel.getVesselId() + " | " + vessel.getVesselName() + " | " + vessel.getVesselType() + " | " +vessel.getAverageSpeed() + " knots");
        }
    }
}