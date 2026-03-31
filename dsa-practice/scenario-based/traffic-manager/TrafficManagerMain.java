public class TrafficManagerMain {
    public static void main(String[] args) {
        Roundabout roundabout = new Roundabout();
        WaitingQueue queue = new WaitingQueue(3);
        // Vehicles arriving
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        // Move vehicles from queue to roundabout
        int vehicle;
        while ((vehicle = queue.dequeue()) != -1) {
            roundabout.addVehicle(vehicle);
        }
        roundabout.printRoundabout();
        // Vehicles exiting
        roundabout.removeVehicle(102);
        roundabout.printRoundabout();
        roundabout.removeVehicle(101);
        roundabout.removeVehicle(103);
        roundabout.printRoundabout();
    }
}