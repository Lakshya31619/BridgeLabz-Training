public class TrafficManager {
    public static void main(String[] args) {
        Roundabout roundabout = new Roundabout();
        VehicleQueue queue = new VehicleQueue(3);
        queue.enqueue("UP81-LA3161");
        queue.enqueue("UP85-TU0293");
        queue.enqueue("UP78-AB6667");
        queue.enqueue("UP80-UI9999");
        roundabout.addVehicle(queue.dequeue());
        roundabout.addVehicle(queue.dequeue());
        roundabout.printRoundabout();
        roundabout.removeVehicle("UP78-AB6667");
        roundabout.printRoundabout();
        roundabout.addVehicle(queue.dequeue());
        roundabout.printRoundabout();
        queue.dequeue();
    }
}